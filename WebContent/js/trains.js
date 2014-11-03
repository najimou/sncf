/**
 * 
 */
function send2(depart, arrivee){
		var script = document.createElement("script");
		script.setAttribute("src", "/DAR_UPMC/getTrains?depart="+depart+"&arrivee="+arrivee+"&callback=mycallback");
		document.body.appendChild(script);
	}	
function send(depart, arrivee){
	
	var xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange=function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    	{
			document.getElementById('trains').append(data);
	    	}
	}
	xmlhttp.open("GET", "/DAR_UPMC/getTrains?depart="+depart+"&arrivee="+arrivee+"&callback=mycallback");
	xmlhttp.send();
}


function mycallback(data){
	document.getElementById('trains').innerHTML = data;
}