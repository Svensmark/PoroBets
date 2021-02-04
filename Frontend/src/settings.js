const URLs = {
    "Home": "/",
    "Login": "/login",
    "Create": "/create",

    "Products": "/products",
    "ProductId": "/poroduct/:id",
    "Contact": "/contact",
    "About": "/about",
    "FAQ": "/faq",
    "NoMatch": "*"
}

function URLSettings() {
    const getURL = (key) => { return URLs[key] }

    return {
        getURL
    }
}
export default URLSettings();


