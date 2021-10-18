/**
 * 
 */
let getAllRequestListener = document.getElementById("getAll");

getAllRequestListener.addEventListener('click', getAllRedirect);

function getAllRedirect(){
    window.location.replace("http://localhost:9000/getAllRequests.html");
}

let getAllStatusRequestListener = document.getElementById("getAllStatus");

getAllStatusRequestListener.addEventListener('click', getAllStatusRedirect);

function getAllStatusRedirect(){
    window.location.replace("http://localhost:9000/getRequestsByStatus.html");
}

let logoutRequestListener = document.getElementById("logout");

logoutRequestListener.addEventListener('click', logoutRedirect);

function logoutRedirect(){
    window.location.replace("http://localhost:9000/preLogin.html");
}