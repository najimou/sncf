

function manageTransport(type, id){
	
	var xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange=function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    	{
			location.reload(true);
	    	}
	}
	xmlhttp.open("GET", "/DAR_UPMC/manageTransport?type="+type+"&id="+id, true);
	xmlhttp.send();
}


