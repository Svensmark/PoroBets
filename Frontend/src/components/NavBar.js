import React, { useState, useEffect } from 'react';
import '../style/App.css';
import Facade from '../login/ApiFacade'
import Accountinfo1 from '../components/Accountinfo1';
import Accountinfo2 from '../components/Accountinfo2';


export default function NavBar(props) {
    const [username, setUsername] = useState();
    const [balance, setBalance] = useState();
    const [role, setRole] = useState();
    const [status, setStatus] = useState("");

    const updateDB = () => {
        Facade.fetchUpdate().then(res => { setStatus("Updated - please refresh!"); }).catch(e => setStatus("Something went wrong. Please try again later."));;
    }

    useEffect(() => {
        Facade.fetchUser().then(res => { setUsername(res.userName); setBalance(res.balance); setRole(res.roleList) }).catch(e => console.log(e));
    }, [])

    return (
        <div className="nav">
            <div className="row left-menu-row justify-content-md-center"><div className="col align-self-center justify-content-md-center"><Accountinfo1 username={username} /></div></div>
            <div className="row left-menu-row justify-content-md-center"><div className="col align-self-center justify-content-md-center"><Accountinfo2 balance={balance} /></div></div>
            <div className="row justify-content-md-center logout-btn-row nav-status-effect"><h2>{status}</h2></div>
            <div className="row justify-content-md-center logout-btn-row"><input type="submit" class="fadeIn fourth logout-btn-1" onClick={updateDB} value="Update"></input></div>
            <div className="row justify-content-md-center logout-btn-row"><input type="submit" class="fadeIn fourth logout-btn-1" onClick={props.logout} value="Log Out"></input></div>
        </div>
    )
}