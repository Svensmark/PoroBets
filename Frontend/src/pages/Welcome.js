import React, { useState } from 'react';
import Facade from '../login/ApiFacade';
import Login from '../login/Login';

import LoggedIn from '../login/LoggedIn';

export default function Welcome() {

    const [loggedIn, setLoggedIn] = useState(false);
    const [error, setError] = useState();
    const [state, setState] = useState();

    const login = (user, pass) => {
        setError("Logging in ..")
        Facade.login(user, pass)
            .then(res => { setLoggedIn(true); setError("") })
            .catch(e => setError("Wrong username or password"));

    }

    const logout = () => {
        Facade.logout();
        setLoggedIn(false);
    }


    return (
        <div className="container-fluid">
            {!loggedIn ? (
                <div className="">
                    <div className="row">
                        <div className="col welcome-col-1">
                            <img className="welcome-img-1 fadeIn" src="Rift-3.jpg"></img>
                        </div>
                        <div className="col welcome-col-2">
                            <Login login={login} error={error} state={state} />
                        </div>
                    </div>
                    <div className="row">
                        <div class="col align-self-center">
                            <h1 className="welcome-header-1 fadeIn">Poro Bets</h1>
                        </div>
                    </div>
                </div >) : (
                    <div className="container-fluid logged-in-div">
                        <LoggedIn logout={logout} state={state}/>
                    </div>
                )}
        </div >
    )
}