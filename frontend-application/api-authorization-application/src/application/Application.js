import React from "react";
import Apis from "../apis/Apis";
import ApplicationView from "./ApplicationView";
import { PATH_SEPERATOR } from "../constant/constant";
import { useLocation } from "react-router-dom";

const getApplicationIdFromPath = (path) => {
  var pathSplits = path.split(PATH_SEPERATOR);
  return pathSplits[2];
};

export default () => {
  const location = useLocation();
  const applicationId = getApplicationIdFromPath(location.pathname);

  return (
    <div>
      Application page
      <ApplicationView applicationId={applicationId} />
      <Apis applicationId={applicationId} />
    </div>
  );
};
