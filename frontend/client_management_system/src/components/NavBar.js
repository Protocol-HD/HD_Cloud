import React from 'react';
import {Link} from "react-router-dom";

function NavBar() {
    return (
        <div id="nav">
            <div className="container">
                <Link to={"/"}>
                    <img src="./images/Xbox_one_logo.svg" alt="Xbox Logo" id="logo"/>
                    <span id="logoText">
                        HD CLOUD
                    </span>
                </Link>
                <ul id="menu">
                    <Link to={"/add"}>
                        <li className="menuItem">Add Client</li>
                    </Link>
                    <Link to={"/list"}>
                        <li className="menuItem">Client List</li>
                    </Link>
                    <Link to={"/fileManagement"}>
                        <li className="menuItem">File Storage</li>
                    </Link>
                </ul>
            </div>
        </div>

    )
        ;
}

export default NavBar;