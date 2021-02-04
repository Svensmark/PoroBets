import React from 'react';
import '../style/App.css';

export default function Accountinfo1(props) {
    return (
        <div class="card fadeIn">
            <div class="card-body">
                <img class="card-img-top" src="user-profile-pic.jpg" alt="Card image cap"></img>
                <h5 class="card-title">{props.username}</h5>
            </div>
        </div>
    )
}

