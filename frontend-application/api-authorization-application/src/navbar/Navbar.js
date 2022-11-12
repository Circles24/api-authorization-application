import React from 'react'
import { Navbar, Container, Nav } from 'react-bootstrap'
import logo from '../assets/logo.svg'
import "./Navbar.css"

export default () => (
<Navbar bg="dark" variant="dark">
    <Container>
        <Navbar.Brand href="#home">
                <img
                    src={logo}
                    width="30"
                    height="30"
                    className="d-inline-block align-top"
                    alt="React Bootstrap logo"
                />
                <Navbar.Text>
                    Api Authorization Application
                </Navbar.Text>
        </Navbar.Brand>
        <Nav className="me-auto">
            <Nav.Link href="#applications">Applications</Nav.Link>
            <Nav.Link href="#features">Help</Nav.Link>
            <Nav.Link href="#pricing">Pricing</Nav.Link>
        </Nav>
        <Navbar.Toggle />
        <Navbar.Collapse className="justify-content-end">
            <Navbar.Text>
                User: <a href="#login">John Doe</a>
            </Navbar.Text>
        </Navbar.Collapse>
    </Container>
</Navbar>
)
