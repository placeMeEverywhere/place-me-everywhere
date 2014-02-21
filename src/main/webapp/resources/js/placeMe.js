function getLocation(){
	if(navigator.geolocation){
		navigator.geolocation.getCurrentPosition(showPosition);
	}
	else{
		alert("Geolocation is not supported by this browser.");
	}
}

function showPosition(position){
	var language = document.getElementsByTagName("html")[0].getAttribute("lang");
	GeolocationAjax.retrieveGeolocation(position.coords.latitude,position.coords.longitude,language,
			{
				errorHandler: function(errorString,exception) {
					alert(errorString);
				}
			});
}

function getFile(){
    document.getElementById("j_idt47:avatar").click();
}  