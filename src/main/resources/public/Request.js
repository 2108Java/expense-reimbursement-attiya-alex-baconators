
let addRequestListener = document.getElementById("add");

addRequestListener.addEventListener('click', addRedirect);

function addRedirect(){
    window.location.replace("http://localhost:9000/newExpense.html");
}

let removeRequestListener = document.getElementById("remove");

removeRequestListener.addEventListener('click', removeRedirect);

function removeRedirect(){

    window.location.replace("http://localhost:9000/removeRequest.html");  
      
}

let getRequestListener = document.getElementById("getRequest");

getRequestListener.addEventListener('click', getRedirect);

function getRedirect(){
    window.location.replace("http://localhost:9000/getRequest.html");
}

let logoutRequestListener = document.getElementById("logout");

logoutRequestListener.addEventListener('click', logoutRedirect);

function logoutRedirect(){

    window.location.replace("http://localhost:9000/logout");
}