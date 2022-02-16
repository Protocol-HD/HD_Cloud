import React from 'react';
import Title from "./Title";
import {Link} from "react-router-dom";

function Main() {
    return (
        <div className="container">
            <Title src={"./images/Xbox_one_logo.svg"} title={"Welcome HD Cloud"}/>

            <div id="mainBanner">
                <div className="mainBannerCard">
                    <Link to="/add">
                        <img src="./images/Add_client.svg" alt="user"/>
                        <p>CLIENT</p>
                    </Link>
                </div>
                <div className="mainBannerCard">
                    <Link to="/list">
                        <img src="./images/List_client.svg" alt="user"/>
                        <p>LIST</p>
                    </Link>
                </div>
                <div className="mainBannerCard">
                    <Link to="/fileManagement">
                        <img src="./images/upload.svg" alt="user"/>
                        <p>STORAGE</p>
                    </Link>
                </div>
            </div>
        </div>
    );
}

export default Main;