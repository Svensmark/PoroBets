import React, { useState } from 'react';
import { Link } from "react-router-dom";
import URLSettings from '../settings';

export default function Login(props) {
    const [state, setState] = useState();

    const onSubmit = (evt) => {
        evt.preventDefault();
        props.login(state.username, state.password);
    }

    const onChange = (evt) => {
        setState({ ...state, [evt.target.id]: evt.target.value });
    }

    return (
        <div className="wrapper fadeInDown">
            <div id="formContent">
                <div className="fadeIn first">
                    <p className="login-form-header"> Login</p>
                </div>
                <form onSubmit={onSubmit} onChange={onChange}>
                    <input type="text" id="username" class="fadeIn second" name="login" placeholder="Username"></input>
                    <input type="password" id="password" class="fadeIn third" name="login" placeholder="Password"></input>
                    <p>{props.error}</p>
                    <input type="submit" class="fadeIn fourth login-form-btn" value="Log In"></input>
                    <Link to={URLSettings.getURL("Create")}><input type="button" class="fadeIn fourth login-form-btn" value="New account"></input></Link>                    
                </form>
            </div>
        </div>
    )
}