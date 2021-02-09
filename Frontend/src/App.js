import React from 'react';
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import URLSettings from './settings'

//Css
import './style/App.css';
import './style/LoginForm.css';

//Imports
//Components

//Pages
import Welcome from './pages/Welcome'
import Create from './pages/CreateUser';



function App() {


  return (
    <div className="App">
      <Router>
        <Switch>
          <Route exact path={URLSettings.getURL("Home")}> <Welcome /> </Route>
          <Route path={URLSettings.getURL("Create")}> <Create /> </Route>

          <Route path={URLSettings.getURL("About")}> <About /> </Route>
          <Route path={URLSettings.getURL("NoMatch")}> <NoMatch /> </Route>
        </Switch>
      </Router>
    </div>
  )
}


const About = () => <div>About</div>

const NoMatch = () => <div>No match!</div>

//If Welcome function reaches about 10 lines of code place the function in separate file.


export default App;