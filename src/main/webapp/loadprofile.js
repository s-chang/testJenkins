document.getElementById("fname").addEventListener("load", getFName());
document.getElementById("lname").addEventListener("load", getLName());
document.getElementById("bdate").addEventListener("load", getBDate());
document.getElementById("uname").addEventListener("load", getUName());
document.getElementById("email").addEventListener("load", getEmail());

function getFName(){
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			document.getElementById("fname").innerHTML = xhr.responseText;
		}
	}
	
	xhr.open('GET', '/testwebapp/ProfilePageServlet');
	xhr.send();
};

function getLName(){
	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			document.getElementById("lname").innerHTML = xhr.responseText;
			console.log(xhr.responseText);
		}
	}
	
	xhr.open('GET', '/testwebapp/ProfilePageServlet2');
	xhr.send();
};

function getBDate(){
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			document.getElementById("bdate").innerHTML = xhr.responseText;
		}
	}
	
	xhr.open('GET', '/testwebapp/ProfilePageServlet3');
	xhr.send();
};

function getUName(){
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			document.getElementById("uname").innerHTML = xhr.responseText;
		}
	}
					
	xhr.open('GET', '/testwebapp/ProfilePageServlet4');
	xhr.send();
};

function getEmail(){
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			document.getElementById("email").innerHTML = xhr.responseText;
		}
	}
	
	xhr.open('GET', '/testwebapp/ProfilePageServlet5');
	xhr.send();
};

function updatePass(){
	let xhr = new XMLHttpRequest();
	let newPass = document.getElementById('pass').value;
	let pass = { p_password : newPass };
	
	xhr.open('POST', '/testwebapp/ChangePassServlet');
	xhr.send(JSON.stringify(pass));
}
