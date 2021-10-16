//trying to populate table for SubmitOrDeleteExpense.html page

let fullURL = "http://localhost:9000/submitRequest";
let submitExpense = document.getElementById("submitExpense");

let xhttp = new XMLHttpRequest();

xhttp.onreadystatechange = function(){
	if(this.readyState == 4 && this.status == 200){
		let pending = this.responseText;//JSON.parse is not needed here because
		//I'm sending a JSON string to Java already
		console.log(pending);
		submitExpense.addEventListener('click',addRow(pending));
	} 
}

function addRow(pending){
	
	let tableBody = document.getElementById("expenseTable");
	
	let tableRow = document.createElement("tr");
	
	let columnID = documnet.createElement("td");
	let columnFirstname = document.createElement("td");
	let columnLastname = document.createElement("td");
	let columnDescription = document.createElement("td");
	let columnExpense = document.createElement("td");
	let columnStatus = document.createElement("td");
	
	columnID.innerText = pending.id;
	columnFirstname.innerText = pending.first;
	columnLastname.innerText = pending.last;
	columnDescription.innerText = pending.description;
	columnExpense.innerText = pending.amount;
	columnStatus.innerText = pending.pending;
	
	tableRow.appendChild(columnID);
	tableRow.appendChild(columnFirstname);
	tableRow.appendChild(columnLastname);
	tableRow.appendChild(columnDescription);
	tableRow.appendChild(columnExpense);
	tableRow.appendChild(columnStatus);
	
	tableBody.appendChild(tableRow);
}

