import React, { useState } from "react";
import endpoints from "../endpoints/endpoints.json";
import axios from "axios";
import { Link } from "react-router-dom";
import {
  PENDING_STATE,
  SUCCESSFUL_STATE,
  FAILED_STATE,
} from "../constant/constant";

const getApisInfo = (state, updateState, applicationId) => {
  const apiCallInfo = endpoints.get_apis_by_application_id_request;
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
  console.log("apis state", state);
  switch (state.apiState) {
    case PENDING_STATE:
      getApisInfo(state, updateState, applicationId);
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
          <div>Api Details</div>
          <div>
            {state.data.map((api) => (
              <div key={api.id}>
                <Link to={`/api/${api.id}`}>
                  <div> id : {api.id} </div>
                  <div> name : {api.name} </div>
                  <div> status : {api.status} </div>
                </Link>
              </div>
            ))}
          </div>
        </div>
      );
    default:
      return <div>something went wrong</div>;
  }
};
