document.addEventListener("load", getPosts());
document.addEventListener("load", getReplies());

function getPosts(){
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			//TODO: have each post create its own div			
			document.getElementById("defaultpost").innerHTML += xhr.responseText;
		}
	}
	
	xhr.open('GET', '/testwebapp/DashboardServlet');
	xhr.send();	
}

function getReplies(){
	let xhr = new XMLHttpRequest();
	console.log("in getReplies");
	xhr.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			document.getElementById("defaultreply").innerHTML += xhr.responseText;
			
		}
	}
	
	xhr.open('GET', '/testwebapp/DashboardServlet2');
	xhr.send();
}

document.querySelector('body').addEventListener('click', function(e){
	if(e.target.tagName.toLowerCase() === 'div'){
		//TODO: forward to Post with replies
		console.log('clicked');
	}
});