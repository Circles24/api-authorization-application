import React, { useState } from "react";
import endpoints from "../endpoints/endpoints.json";
import axios from "axios";
import {
  PENDING_STATE,
  SUCCESSFUL_STATE,
  FAILED_STATE,
  PATH,
  METHOD,
} from "../constant/constant";
import { Link } from "react-router-dom";

const makeApplicationsApiCall = (state, updateState) => {
  const getApplicationsRequest = endpoints["get_applications_request"];
  const url = getApplicationsRequest[PATH];
  const method = getApplicationsRequest[METHOD];
  axios({ method: method, url: url })
    .then((response) =>
      updateState({
        ...state,
        apiState: SUCCESSFUL_STATE,
        applications: response.data,
      })
    )
    .catch((error) =>
      updateState({
        ...state,
        apiState: FAILED_STATE,
        applications: [],
        apiError: error.response,
      })
    );
};

const triggerStateTransition = (state, updateState) => {
  switch (state["apiState"]) {
    case PENDING_STATE:
      makeApplicationsApiCall(state, updateState);
      break;
    default:
      break;
  }
};

export default () => {
  const [state, updateState] = useState({
    apiState: PENDING_STATE,
    applications: [],
    apiError: null,
  });

  triggerStateTransition(state, updateState);

  switch (state.apiState) {
    case PENDING_STATE:
      return <div>loading data</div>;
    case FAILED_STATE:
      return <div className="align-self">api call failed</div>;
    case SUCCESSFUL_STATE:
      return (
        <div>
          <div>Applications list</div>
          {state.applications.map((application) => (
            <Link to={`/application/${application.id}`} key={application.id}>
              <div>{application.name}</div>
              <div>{application.description}</div>
            </Link>
          ))}
        </div>
      );
    default:
      return <>default component</>;
  }
};
