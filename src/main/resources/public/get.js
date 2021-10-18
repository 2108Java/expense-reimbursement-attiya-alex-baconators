let returnRequestListener = document.getElementById("return");

returnRequestListener.addEventListener('click', returnRedirect);

function returnRedirect(){
    window.location.replace("http://localhost:9000/RequestsMenu.html");
}