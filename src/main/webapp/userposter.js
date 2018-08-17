document.addEventListener('load', loadUsers());

function loadUsers(){
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			//TODO: have each post create its own div
			document.getElementById("posts").innerHTML = xhr.responseText;
			console.log(xhr.responseText);
		}
	}
	
	
	xhr.open('POST', '/testwebapp/UserListAdminServlet');
	xhr.send();
	
}