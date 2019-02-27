
var reader = new FileReader();

function avatarReload(){
	getLocation();
	var e = sessionStorage.getItem('event');
	$('#avatarBtn').css('background','url('+e+')');
}

function avatarReset(){
	sessionStorage.removeItem('event');
	getLocation();
}

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
	GeolocationAjax.retrieveGeolocationFromOpenStreetMap(position.coords.latitude,position.coords.longitude,language,
			{
				errorHandler: function(errorString,exception) {
					alert(exception);
				}
			});
}

/*
 * FUNZIONI UTILIZZATE PER L'UPLOAD DI UN AVATAR E LA CONTEMPORANEA VISUALIZZAZIONE NEL DIV. 
 */

$(function () {
    $(":file").change(function () {
        if (this.files && this.files[0]) {            
            reader.onload = imageIsLoaded;
            reader.readAsDataURL(this.files[0]);
        }
    });
});

function imageIsLoaded(e) {
	$('#avatarBtn').css('background','url('+e.target.result+')');
	$('#avatarBtn').css('background-size','200px 250px');
	$('#avatarBtn').css('background-repeat','no-repeat');
	sessionStorage.setItem('event', JSON.stringify(e.target.result));
}

/*
 * FUNZIONI AUTOCOMPLETAMENTO LOCALIZATION
 */

$(function() {	
    $('#location').keyup(function() { 
        GeolocationAjax.manualGeolocation(function(str){
           $('#location').autocomplete({
        	   source: str,
        	   minLenght: 1
           });
        });
    });

});