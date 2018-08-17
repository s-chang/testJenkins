function trySubmit(){
	console.log("submit success");
	let xhr = new XMLHttpRequest();
	let fname = document.getElementById('firstname').value;
	let lname = document.getElementById('lastname').value;
	let pass = document.getElementById('password').value;
	let cPass = document.getElementById('confirmpassword').value;
	let email = document.getElementById('email').value;
	let bday = document.getElementById('birthday').value;
	let user = document.getElementById('username').value;
	
	console.log(fname);
	console.log(lname);
	console.log(pass);
	console.log(cPass);
	console.log(email);
	console.log(bday);
	console.log(user);
	
	let person = {p_firstName: fname,
				  p_lastName: lname,
				  p_password: pass,
				  p_email: email,
				  p_bday: bday,
				  p_username: user};
	
	if(!isNull(fname, lname, pass, cPass, email, bday, user)){
		if(pass != cPass){
			xhr.onreadystatechange = function(){
				if(this.readyState == 4 && this.status == 200){
					document.getElementById("error").innerHTML = "Passwords do not match.";
				}
			}
		}else{
			xhr.onreadystatechange = function(){
				if(this.readyState == 4 && this.status == 200){
					//TODO: redirect to login
					window.location.href = xhr.responseText;
				}
			}
		}
	}else{
		xhr.onreadystatechange = function(){
			if(this.readyState == 4 && this.status == 200){
				document.getElementById("error").innerHTML = "Fill out all fields.";
			}
		}
	} 
	
	xhr.open('POST', '/testwebapp/SignupServlet');
	xhr.send(JSON.stringify(person));
}

function isNull(fname, lname, pass, cPass, email, bday, user){
	return ((fname == null) ||
		(lname == null) ||
		(pass == null) ||
		(cPass == null) ||
		(email == null) ||
		(bday == null) ||
		(user == null)
	); 
}

function tryCancel(){
	let xhr =new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			window.location.href = xhr.responseText;					
		}
	}
	
	xhr.open('POST', '/testwebapp/SignupCancelServlet');
	xhr.send();
}