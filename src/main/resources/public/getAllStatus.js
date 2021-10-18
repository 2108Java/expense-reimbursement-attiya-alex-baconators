let returnAllStatusRequestListener = document.getElementById("returnAllStatus");

returnAllStatusRequestListener.addEventListener('click', returnAllStatusRedirect);

function returnAllStatusRedirect(){
    window.location.replace("http://localhost:9000/RequestsMenuManager.html");
}