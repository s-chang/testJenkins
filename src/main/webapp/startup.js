function tryLogin(){
	let xhr =new XMLHttpRequest();
	let uname = document.getElementById('userName').value;
	let pword = document.getElementById('password').value;
	
	let dummyPerson = {p_username: uname, p_password: pword};	
	
	xhr.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			if((xhr.responseText != "admin") && (xhr.responseText != "user")){
			//TODO: depending on info, either print out error or redirect to
				console.log(xhr.responseText != "admin");
				console.log(xhr.responseText != "user");
				document.getElementById("found").innerHTML = xhr.responseText;
			}else{
				if(xhr.responseText == "admin")
					window.location.href = "homeadmin.html";
				if(xhr.responseText == "user")
					window.location.href = "home.html";
			}
			console.log(xhr.responseText);
		}
	}
	
	xhr.open('POST', '/testwebapp/LoginServlet');
	xhr.send(JSON.stringify(dummyPerson));
	
}

function forwardSignUp(){
	//window.location.href="signup.html";
	let xhr =new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			window.location.href = xhr.responseText;
			
			console.log(xhr.responseText);
			
		}
	}
	
	xhr.open('GET', '/testwebapp/LoginServlet');
	xhr.send();
}