
let returnAllRequestListener = document.getElementById("returnAll");

returnAllRequestListener.addEventListener('click', returnAllRedirect);

function returnAllRedirect(){
    window.location.replace("http://localhost:9000/RequestsMenuManager.html");
}