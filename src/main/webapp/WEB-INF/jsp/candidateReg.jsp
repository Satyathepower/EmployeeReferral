

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" href="../static/css/class.css" type="text/css">
      <link rel="stylesheet" href="../static/css/style.css" type="text/css">
      <link rel="stylesheet" href="../static/css/jquery-ui.css">
      <link rel="stylesheet" href="../static/css/bootstrap.min3.4.css">
      <link rel="stylesheet" href="../static/css/bootstrap.css" type="text/css" media="all" />

   </head>
    <body style="background-color:#E2F2F8;">
      <div align="center" width="80%" >
         <table  width="100%" >
            <tr  >
               <td >
                  <div >
                     <img src="../static/image/banner1.png" height="70px" width="30%"  />
                  </div>
               </td>

            </tr>
            <tr>
               <td width="100%">
                  <jsp:include page="empmenu.jsp" />
               </td>
         </table>
         <br/>
            <c:if test="${not empty msg}">
                       <h4 align="center">
                  				<font color="green">${msg}</font></h4>
                        </c:if>
                        <c:if test="${empty msg}">
                       <h4 align="center">
                  				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h4>
                        </c:if>

         <div style="width:700px; margin:0 auto;">
            <form action="./candRegistationForm" enctype = "multipart/form-data" method="post">
               <table class="table">
                  <tr>
                     <td>Emp ID</td>
                     <td><input type="text" name="empId" value=${empId} /></td>
                  </tr>
                  <tr>
                    <td>Apply For Job</td>
                    <td><input type="number" name="jobid" value=${refJobId} /></td>
                  </tr>
                  <tr>
                     <td>Candidate Name</td>
                     <td><input type="text" name="name" /></td>
                  </tr>
                  <tr>
                     <td>Email</td>
                     <td><input type="text" name="email" /></td>
                  <tr>
                     <td>Current Designation</td>
                     <td><input type="text" name="currentDes" /></td>
                  </tr>
                  <tr>
                     <td>Contact No</td>
                     <td><input type="text" name="contact" /></td>
                  </tr>
                  <tr>
                     <td>Total Exp</td>
                     <td><input type="number" name="totalExpYr" />Years</td>
                  </tr>
                  <tr>
                  <td></td>
                  <td><input type="number" name="totalExpMont" />Months</td>
                  </tr>
                  <tr>
                  </tr>

                  <tr>
                     <td>Resume upload</td>
                     <td><input type="file" name="cv_upload" /></td>
                  </tr>
               </table>
               <input type="submit" value="Submit" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               <input type="reset" value="Reset" />
            </form>
         </div>

      </div>
   </body>
</html>

