import React from 'react';
import '../style/App.css';

export default function Accountinfo2(props) {
    return (
        <div class="card fadeIn">
            <div class="card-body">
                <img class="card-img-top" src="poro-coin2.png" alt="Card image cap"></img>
                <h5 class="card-title">Coins: {props.balance}</h5>
            </div>
        </div>
    )
}

