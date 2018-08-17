function submitPost(){
	let xhr = new XMLHttpRequest();
	
	let topic = document.getElementById('topicarea').value;
	let msg = document.getElementById('messagearea').value;
	
	console.log(topic);
	console.log(msg);
	
	let poster = {
			po_title : topic,
			po_post : msg
	};
	
	console.log(poster.po_title);
	console.log(poster.po_post);
	
	xhr.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			//redirect to home
			window.location.href = xhr.responseText;			
		}
	};
	
	xhr.open('POST', '/testwebapp/PostSubmitServlet');
	//xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	xhr.send(JSON.stringify(poster));	
	
}