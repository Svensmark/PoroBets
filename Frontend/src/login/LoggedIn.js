import React, { useState, useEffect } from 'react';
import NavBar from '../components/NavBar';
import ApiFacade from './ApiFacade'
import Header from '../components/Header'
import { Link } from "react-router-dom";
import URLSettings from '../settings';


export default function LoggedIn(props) {

  const [upcomingMatch, setUpcomingMatches] = useState([])
  const [lastExpanded, setLastExpanding] = useState(-1)

  const [amount, setAmount] = useState("");
  const [chosenTeam, setChosenTeam] = useState("Choose a team");

  const [status, setStatus] = useState("");

  useEffect(() => {
    ApiFacade.fetchUpcoming().then(result => {
      setUpcomingMatches(result)
    });


  }, [])

  const handleAmountChange = (e) => {
    const value = e.target.value;
    if (value.charAt(0) === "0" || value.charAt(1) === "0" && value.charAt(0) === "0") {
      const delVal = value.slice(-1)
      if (value.slice(-1) === "0" || value.slice(-1) === "1" || value.slice(-1) === "2" || value.slice(-1) === "3" || value.slice(-1) === "4" || value.slice(-1) === "5" || value.slice(-1) === "6" || value.slice(-1) === "7" || value.slice(-1) === "8" || value.slice(-1) === "9") {
        setAmount(delVal)
      }
    }
    else if (value.slice(-1) === "0" || value.slice(-1) === "1" || value.slice(-1) === "2" || value.slice(-1) === "3" || value.slice(-1) === "4" || value.slice(-1) === "5" || value.slice(-1) === "6" || value.slice(-1) === "7" || value.slice(-1) === "8" || value.slice(-1) === "9") {
      setAmount(value)
    } if (value.length == 0) {
      setAmount(0)
    }
  };

  return (
    <div class="row">

      <div class="col-sm-2 logged-in-left-menu logged-in-col">
        <NavBar logout={props.logout} />
      </div>
      <div class="col col-lg-10 logged-in-right-menu logged-in-col">

        <Header />

        {upcomingMatch.map((data, i) => {
          return (
            <div class="container upcoming-match-container">
              <div class="row justify-content-around upcoming-match-row">
                <div className="col upcoming-match-col">
                  <h1 className="upcoming-match-header-3">{data.team1.acronym}</h1>
                </div>
                <div className="col upcoming-match-col">
                  <img className="upcoming-match-img" src={data.team1.image_url} />
                </div>
                <div className="col upcoming-match-col upcoming-match-col-vs">
                  <h1 className="upcoming-match-header-3"> Vs.</h1>
                </div>
                <div className="col upcoming-match-col u-m-i-1">
                  <img className="upcoming-match-img u-m-i-1" src={data.team2.image_url} />
                </div>
                <div className="col upcoming-match-col">
                  <h1 className="upcoming-match-header-3">{data.team2.acronym}</h1>
                </div>
                <div className="col upcoming-match-col u-m-i-2">
                  <img className="upcoming-match-img u-m-i-2" src={data.team2.image_url} />
                </div>
              </div>

              <div class="row justify-content-between upcoming-match-row2">
                <div class="col upcoming-match-col-2">
                  <h2 className="upcoming-match-header-4">{data.scheduled_at}  - Best of {data.number_of_games}</h2>
                </div>
                <div class="col upcoming-match-col-2">
                  <input id={"collapsebtn" + i} className="link-tag-specific-match" value="View Match" type="button" data-bs-toggle="collapse" data-bs-target={"#collapseExample" + i} aria-expanded="false" aria-controls={"collapseExample" + i} onClick={() => {
                    if (document.getElementById("collapsebtn" + lastExpanded) != null) {
                      document.getElementById("collapsebtn" + lastExpanded).click()
                      setChosenTeam("Choose a team")
                      setAmount(0)
                    } if (lastExpanded == i) {
                      setLastExpanding(-1);
                      setChosenTeam("Choose a team")
                      setAmount(0)
                    } else {
                      setLastExpanding(i);
                      setChosenTeam("Choose a team")
                      setAmount(0)
                    }
                  }}></input>
                </div>
              </div>
              <div class="collapse" id={"collapseExample" + i}>
                <div class="card card-body">
                  <div class="row justify-content-around">

                    <div class="col upcoming-match-col-2 drop-down-menu-col">
                      <div class="dropdown show">
                        <a id class="btn btn-select-match dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">{chosenTeam}</a>
                        <div class="dropdown-menu">
                          <input class="dropdown-item" onClick={e => setChosenTeam(data.team1.acronym)} value={data.team1.name}></input>
                          <input class="dropdown-item" onClick={e => setChosenTeam(data.team2.acronym)} value={data.team2.name}></input>
                        </div>
                      </div>
                    </div>

                    <div class="col upcoming-match-col-2">
                      <div class="input-group mb-3">
                        <input type="text" class="form-control" placeholder="Amount of coins" aria-label="Username" aria-describedby="basic-addon1" name="amount" value={amount} onChange={e => handleAmountChange(e)} />
                      </div>
                    </div>
                  </div>

                  <div class="row upcoming-match-row-2 justify-content-around">
                    <div class="col upcoming-match-col-2">Team: {chosenTeam} - Coins: {amount}</div>
                  </div>

                  <div class="row upcoming-match-row-2 justify-content-around">
                    <div class="col upcoming-match-col-2">{status}</div>
                  </div>

                  <div class="row upcoming-match-row-2 justify-content-around">
                    <div class="col upcoming-match-col-2"><button type="button" class="btn btn-place-bet">Place bet</button></div>
                  </div>
                </div>
              </div>
            </div>



          );
        })}


      </div>
    </div >
  )
}