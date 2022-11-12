import React from 'react'
import Router from '../router/Router'
import Navbar from '../navbar/Navbar'
import './App.css';
import Sidebar from '../sidebar/Sidebar';
import { Row } from 'react-bootstrap';

export default () => (
  <div className="App">
    <Navbar />
    <div className="row flex-xl-nowrap">
      <Sidebar />
      <Router />
    </div>
  </div>
)

