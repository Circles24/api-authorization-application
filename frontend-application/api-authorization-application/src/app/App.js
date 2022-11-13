import React from "react";
import Router from "../router/Router";
import Navbar from "../navbar/Navbar";
import "./App.css";
import Sidebar from "../sidebar/Sidebar";
import axios from "axios";

import {
  APPLICATION_JSON,
  CONTENT_TYPE_HEADER_KEY,
  BACKEND_BASE_URL,
} from "../constant/constant";

axios.defaults.baseURL = BACKEND_BASE_URL;
axios.defaults.headers.post[CONTENT_TYPE_HEADER_KEY] = APPLICATION_JSON;

export default () => (
  <div className="App">
    <Navbar />
    <div className="row flex-xl-nowrap">
      <Sidebar />
      <Router />
    </div>
  </div>
);
