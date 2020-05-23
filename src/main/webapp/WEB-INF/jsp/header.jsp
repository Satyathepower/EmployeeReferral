<!DOCTYPE html>
<html>
<head>

</head>
<body>
Welcome <br> <strong> ${user} </strong>
<span>
<strong	style="float: right;" id="divCurrDate">
</strong></span>
</body>
<script type="text/javascript">
	var mydate = new Date();
	var year = mydate.getYear();
	if (year < 1000)
		year += 1900;
	var day = mydate.getDay();
	var month = mydate.getMonth();
	var daym = mydate.getDate();
	if (daym < 10)
		daym = "0" + daym;
	var dayarray = new Array("Sunday", "Monday", "Tuesday", "Wednesday",
			"Thursday", "Friday", "Saturday");
	var montharray = new Array("January", "February", "March", "April", "May",
			"June", "July", "August", "September", "October", "November",
			"December");

	function show() {
		var Digital = new Date();
		var hours = Digital.getHours();
		var minutes = Digital.getMinutes();
		var seconds = Digital.getSeconds();
		var dn = "AM";

		if (hours >= 12) {
			dn = "PM";
			hours = hours - 12;
		}
		if (hours == 0)
			hours = 12;
		if (minutes <= 9)
			minutes = "0" + minutes;
		if (seconds <= 9)
			seconds = "0" + seconds;
		document.getElementById("divCurrDate").innerHTML = dayarray[day] + ", "
				+ montharray[month] + " " + daym + ", " + year + "@" + hours
				+ ":" + minutes + " " + dn;

		setTimeout("show()", 1000);
	}
	show();
</script>
</html>