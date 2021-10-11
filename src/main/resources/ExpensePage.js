function addRow(pending){
	
	let tableBody = document.getElementById("expenseTable");
	
	let tableRow = document.createElement("tr");
	
	let columnID = documnet.createElement("td");
	let columnFirstname = document.createElement("td");
	let columnLastname = document.createElement("td");
	let columnExpense = document.createElement("td");
	
	columnID.innerText = pending.id;
	columnFirstname.innerText = pending.first;
	columnLastname.innerText = pending.last;
	columnExpense.innerText = pending.newExpense;
	
	tableRow.appendChild(columnID);
	tableRow.appendChild(columnFirstname);
	tableRow.appendChild(columnLastname);
	tableRow.appendChild(columnExpense);
	
	tableBody.appendChild(tableRow);
}

let submitExpense = document.getElementById("submitExpense");
submitExpense.addEventListener('click',addRow(pending));