import React from 'react'
import { createBrowserRouter, RouterProvider } from 'react-router-dom'
import RoutesData from './RoutesData'

const router = createBrowserRouter(RoutesData)

export default () => (
    <RouterProvider router={router} />
)

