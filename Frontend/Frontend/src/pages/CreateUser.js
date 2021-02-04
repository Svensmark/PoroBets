import React, { useState } from 'react';
import Facade from '../login/ApiFacade';
import { Link } from "react-router-dom";
import URLSettings from '../settings';

export default function Create() {

    const [state, setState] = useState([]);
    const [status, setStatus] = useState([""]);

    const onSubmit = (evt) => {
        evt.preventDefault();
        setStatus("Account created!")
        Facade.create(state.username, state.password);
    }

    const onChange = (evt) => {
        setState({ ...state, [evt.target.id]: evt.target.value });
    }

    return (
        <div>
            <div className="wrapper fadeInDown">
                <div id="formContent">
                    <div className="fadeIn first">
                        <p className="login-form-header"> New account</p>
                    </div>
                    <form onSubmit={onSubmit} onChange={onChange}>
                        <input type="text" placeholder="Username" id="username" />
                        <input type="text" placeholder="Password" id="password" />
                        <p>{status}</p>
                        <input type="submit" value="Create account" className="btn btn-primary fadeIn fourth login-form-btn" /></form>
                    <Link to={URLSettings.getURL("Home")}><input type="button" class="fadeIn fourth login-form-btn" value="Go back"></input></Link>
                </div>
            </div>
        </div>
    )
}