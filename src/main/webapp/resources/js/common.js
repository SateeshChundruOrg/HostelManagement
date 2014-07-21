function loadDateTime(hiddenFiled, dateField, timeFiled){
	var dateTimeRaw = document.getElementById(hiddenFiled).value;
	if(dateTimeRaw.length > 0){
		var dateTime = dateTimeRaw.trim().split(" ");
		var time = null;
		
		if(dateTime.length > 1){
			time = dateTime[1].trim().split(":");
		}
		
		var dateText = dateTime[0].trim();
		var timeText = null;
		
		if(time != null){
			timeText = time[0].trim() + ":" + time[1].trim();
		}
		
		if(dateField != null){
			document.getElementById(dateField).value = dateText;
		}
		if(timeFiled != null && time != null){
			document.getElementById(timeFiled).value = timeText;
		}
	}
}

function compileDateTime(hiddenFiled, dateField, timeFiled){
	var date = null;
	var time = null;
	
	date = document.getElementById(dateField).value;

	if(timeFiled != null){
		time = document.getElementById(timeFiled).value;
	}

	if(date.length > 0){
		if(timeFiled != null){
			document.getElementById(hiddenFiled).value = date + " " + time + ":00";
		} else {
			document.getElementById(hiddenFiled).value = date + " 00:00:00";
		}
	} else {
		document.getElementById(hiddenFiled).value = "";
	}
}

function encodeNewLinesAndQuotes(string){
	string = replaceAll(string, "\n", "&-nl-n;");
	string = replaceAll(string, "\r", "&-nl-r;");
	string = replaceAll(string, "'", "&-sq;");
	string = replaceAll(string, "\"", "&-dq;");
	return string;
}

function decodeNewLinesAndQuotes(string){
	string = replaceAll(string, "&-nl-n;", "\n");
	string = replaceAll(string, "&-nl-r;", "\r");
	string = replaceAll(string, "&-sq;", "'");
	string = replaceAll(string, "&-dq;", "\"");
	return string;
}

function replaceAll(source, stringToFind, stringToReplace){
	var temp = source;
	var index = temp.indexOf(stringToFind);
	while(index != -1){
		temp = temp.replace(stringToFind,stringToReplace);
		index = temp.indexOf(stringToFind);
	}
	return temp;
}