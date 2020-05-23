<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="../static/css/class.css" type="text/css">
   <link rel="stylesheet" href="../static/css/style.css" type="text/css">
  <link rel="stylesheet" href="../static/css/jquery-ui.css">
  <link rel="stylesheet" href="../static/css/bootstrap.min3.4.css">
  <link rel="stylesheet" href="../static/css/bootstrap.css" type="text/css"	media="all" />

</head>
<body style="background-color:#E2F2F8;">
<div align="center" width="80%" >
<table  width="100%" >
 <tr  >
 <td >
 <div >
<img src="../static/image/banner1.png" height="70px" width="30%"  />
</div>
</td></tr>

<tr><td width="100%">
<jsp:include page="hrmenu.jsp" />
</td>
</table>

  <div align="center">
     <form action="./jobForm"  enctype = "multipart/form-data" method="post">
         			<table class="table" style="width:30%;">
         				<tr>
         					<td>Job Title</td>
         					<td><input type="text" name="jobTitle" /></td>
         				</tr>

         				<tr>
         					<td>Department</td>
         					<td> <select name="department">
                                  <option value="1">Tech</option>
                                  <option value="2">HR</option>
                                  <option value="4">Analytics</option>
                                  <option value="3">CS</option>
                                </select> </td>

         				<tr>
         					<td>Experience</td>
         					<td><input type="number" name="experience" /></td>
         				</tr>
         				<tr>
         					<td>Job Description</td>
         					<td><input type="text" name="jobDescription" /></td>
         				</tr>
                     	<tr>
                            <td>JD Upload</td>
                 			<td><input type="file" name="jd_upload" /></td>
                        </tr>
         				</table>
         			<input type="submit" value="Submit" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         			<input type="reset" value="Reset" />

         			</form>
  </div>


</div>
</body>
</html>