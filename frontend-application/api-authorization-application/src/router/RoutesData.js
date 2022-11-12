import React from 'react'
import Api from '../api/Api'
import Applications from '../applications/Applications'
import Application from '../application/Application'
import { Navigate } from 'react-router-dom'
import ErrorComponent from '../error/ErrorComponent'

export default [
    {
        id: "applications-route",
        path: "/applications",
        index: true,
        element: <Applications />,
        loader: (params) => params,
        errorElement: <ErrorComponent />
    },
    {
        id: "application-route",
        path: "/application/:application_id",
        element: <Application />,
        loader: (params) => params,
        errorElement: <ErrorComponent />
    },
    {
        id: "api-route",
        path: "/api/:api_id",
        element: <Api />,
        loader: (params) => params,
        errorElement: <ErrorComponent />
    },
    {
        id: "default-route",
        path: "/*",
        element: <Navigate to="/applications" />,
        errorElement: <div>default error code</div>
    },
]
