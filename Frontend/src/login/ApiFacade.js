const URL = "http://192.168.0.103:8080/securitystarter/api/";

function handleHttpErrors(res) {
    if (!res.ok) {
        return Promise.reject({ status: res.status, fullError: res.json() })
    }
    return res.json();
}

function ApiFacade() {
    //Insert utility-methods from a latter step (d) here
    const setToken = (token) => {
        localStorage.setItem('jwtToken', token)
    }
    const getToken = () => {
        return localStorage.getItem('jwtToken')
    }
    const loggedIn = () => {
        const loggedIn = getToken() != null;
        return loggedIn;
    }
    const logout = () => {
        localStorage.removeItem("jwtToken");
    }

    const makeOptions = (method, addToken, body) => {
        var opts = {
            method: method,
            headers: {
                "Content-type": "application/json",
                'Accept': 'application/json',
            }
        }
        if (addToken && loggedIn()) {
            opts.headers["x-access-token"] = getToken();
        }
        if (body) {
            opts.body = JSON.stringify(body);
        }
        return opts;
    }

    //User
    const login = (user, pass) => {
        const options = makeOptions("POST", true,
            {
                username: user,
                password: pass
            });
        return fetch(URL + "login", options)
            .then(handleHttpErrors)
            .then(res => { setToken(res.token) })
    }
    const create = (user, pass) => {
        const options = makeOptions("POST", true,
            {
                username: user,
                password: pass
            });
        return fetch(URL + "login/create", options)
            .then(handleHttpErrors)
            .then(res => { setToken(res.token) })
    }


    const fetchUser = () => {
        const options = makeOptions("GET", true); //True add's the token
        return fetch(URL + "info/user", options).then(handleHttpErrors);
    }

    const fetchUpcoming = () => {
        return fetch(URL + "gamematch/upcoming", makeOptions("GET")).then(handleHttpErrors);
    }

    const fetchUpdate = () => {
        return fetch(URL + "gamematch/update", makeOptions("GET")).then(handleHttpErrors);
    }

    const fetchTeamByAcronym = (acronym) => {
        return fetch(URL + "team/acronym/" + acronym, makeOptions("GET")).then(handleHttpErrors);
    }

    return {
        login,
        logout,
        fetchUser,
        create,
        fetchUpcoming,
        fetchTeamByAcronym,
        fetchUpdate
    }

}

export default ApiFacade();