import React, { useState, useEffect } from 'react';
import NavBar from '../components/NavBar';
import ApiFacade from '../login/ApiFacade'
import Header from '../components/Header'


export default function LoggedIn(props) {

  const [upcomingMatch, setUpcomingMatches] = useState([])

  useEffect(() => {
    ApiFacade.fetchUpcoming().then(result => {
      setUpcomingMatches(result)
    });
  }, [])

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

              <div class="row justify-content-around upcoming-match-row2">
                <h2 className="upcoming-match-header-4">{data.scheduled_at}  - Best of {data.number_of_games}</h2>
                <a className="link-tag-specific-match" href="facenook.com">
                  <h1 className="upcoming-match-header-4">View match</h1>
                </a>
              </div>
            </div>
          );
        })}


      </div>
    </div >
  )
}