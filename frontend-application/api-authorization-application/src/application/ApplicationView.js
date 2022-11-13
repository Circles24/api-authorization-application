import React, { useState } from "react";
import endpoints from "../endpoints/endpoints.json";
import axios from "axios";
import {
  PENDING_STATE,
  SUCCESSFUL_STATE,
  FAILED_STATE,
} from "../constant/constant";

const getApplicationInfo = (state, updateState, applicationId) => {
  const apiCallInfo = endpoints.get_application_by_id_request;
  const method = apiCallInfo.method;
  const url = apiCallInfo.path + applicationId;
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

const triggerStateTransition = (state, updateState, applicationId) => {
  console.log("app state", state, applicationId);
  switch (state.apiState) {
    case PENDING_STATE:
      getApplicationInfo(state, updateState, applicationId);
      break;
    default:
      break;
  }
};

export default (props) => {
  const applicationId = props["applicationId"];
  const [state, updateState] = useState({
    apiState: PENDING_STATE,
    data: null,
    error: null,
  });

  triggerStateTransition(state, updateState, applicationId);

  switch (state.apiState) {
    case PENDING_STATE:
      return <div>loading info</div>;
    case FAILED_STATE:
      return <div>failed state</div>;
    case SUCCESSFUL_STATE:
      return (
        <div>
          {Object.keys(state.data).map((key) => (
            <div key={key} className="d-inline">
              <div>
                {key} : {state.data[key]}
              </div>
            </div>
          ))}
        </div>
      );
    default:
      return <div>something went wrong</div>;
  }
};
