document.addEventListener('load', getPosts());

function getPosts(){
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			//TODO: have each post create its own div
			document.getElementById("posts").innerHTML = xhr.responseText;
			console.log(xhr.responseText);
		}
	}
	
	xhr.open('GET', '/testwebapp/FlaggedAdminServlet');
	xhr.send();	
}


document.querySelector('body').addEventListener('click', function(e){
	if(e.target.tagName.toLowerCase() === 'div'){
		//TODO: forward to Post with replies
		console.log('clicked');
	}
});