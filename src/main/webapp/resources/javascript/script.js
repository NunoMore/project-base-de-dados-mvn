//switch display
$("#mainMenu").hide();
mainHided = true;

$("#startBtn").click( function(){
	if (mainHided) {
		$("#mainMenu").show();
		$("#welcome").hide();
		mainHided = false;
	} else if (!mainHided) {
		$("#mainMenu").hide();
		$("#welcome").show();
		mainHided = true;
	}
});
