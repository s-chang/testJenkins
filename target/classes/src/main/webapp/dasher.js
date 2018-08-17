function toDash(){
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			window.location.href = xhr.responseText;
		}
	}
	
	xhr.open('GET', 'testwebapp/GoToDashServlet');
	xhr.send();
}