import React, { useState } from "react";
import { useLocation } from "react-router-dom";
import endpoints from "../endpoints/endpoints.json";
import axios from "axios";
import {
  PENDING_STATE,
  SUCCESSFUL_STATE,
  FAILED_STATE,
  PATH_SEPERATOR,
} from "../constant/constant";

const getApiIdFromPath = (path) => {
  const pathSplits = path.split(PATH_SEPERATOR);
  return pathSplits[2];
};

const getApisInfo = (state, updateState, apiId) => {
  const apiCallInfo = endpoints.get_api_by_id_request;
  const method = apiCallInfo.method;
  const url = apiCallInfo.path + apiId;
  axios({ method: method, url: url })
    .then((response) =>
      updateState({
        ...state,
        apiState: SUCCESSFUL_STATE,
        data: response.data,
      })
    )
    .catch((error) =>
      updateState({
        ...state,
        apiState: FAILED_STATE,
        error: error.response,
      })
    );
};

const triggerStateTransition = (state, updateState, apiId) => {
  console.log("api state", state);
  switch (state.apiState) {
    case PENDING_STATE:
      getApisInfo(state, updateState, apiId);
      break;
    default:
      break;
  }
};

export default () => {
  const path = useLocation().pathname;
  const apiId = getApiIdFromPath(path);
  const [state, updateState] = useState({
    apiState: PENDING_STATE,
    data: null,
    error: null,
  });

  triggerStateTransition(state, updateState, apiId);

  switch (state.apiState) {
    case PENDING_STATE:
      return <div>loading info</div>;
    case FAILED_STATE:
      return <div>failed state</div>;
    case SUCCESSFUL_STATE:
      return (
        <div>
          <div>Api Details</div>
          <div>
            {Object.keys(state.data).map((key) => (
              <div key={key} className="d-inline">
                <div>
                  {key} : {state.data[key]}
                </div>
              </div>
            ))}
          </div>
        </div>
      );
    default:
      return <div>something went wrong</div>;
  }
};
