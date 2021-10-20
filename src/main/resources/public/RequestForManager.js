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

let approveRequestListener = document.getElementById("approveRequest");

approveRequestListener.addEventListener('click', approveRedirect);

function approveRedirect(){
    window.location.replace("http://localhost:9000/approveRequest.html");
}

let rejectRequestListener = document.getElementById("rejectRequest");

rejectRequestListener.addEventListener('click', rejectRedirect);

function rejectRedirect(){
    window.location.replace("http://localhost:9000/rejectRequest.html");
}

let logoutRequestListener = document.getElementById("logout");

logoutRequestListener.addEventListener('click', logoutRedirect);

function logoutRedirect(){
    window.location.replace("http://localhost:9000/logout");
}