/**
 * Redirected from preLogin.html
 */

function EmployeeLogin(){
//	let id = document.getElementById("id").value;
	
//	if (id.equals("emp")){
//		loginPage_emp.html;
//	}else{
//		loginPage_mgr.html;
//	}

	let btn = document.createElement("button"); 
	btn.onclick = function(){
		let id = document.getElementById("id").value;
		if (id.equals("emp")){
			loginPage_emp.html;
		}else{
			loginPage_mgr.html;
	}
}