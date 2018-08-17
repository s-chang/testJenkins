document.addEventListener('load', getReplies());

function getReplies(){
	let xhr =  new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(this.ready == 4 && this.status == 200){
			document.getElementById('replies').innerHTML += xhr.responseText;
			console.log(xhr.responseText);
		}
	}
	
	
	xhr.open('GET', '/testwebapp/DashboardAdminServlet');
	xhr.send();
}