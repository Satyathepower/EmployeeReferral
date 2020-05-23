<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
   <head>
      <title>Job List</title>
        <meta http-equiv="Content-Type" content="text/html ; charset=ISO-8859-1"
      	name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="stylesheet" href="../static/css/style.css" type="text/css" media="all">
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
                  </td>

               </tr>
               <tr>
                  <td width="100%">
                     <jsp:include page="empmenu.jsp" />
                  </td>
            </table>
            <br/>
            <div align="right">
            <h4 align="right">
                         	<font color="blue"> <span> Hi </span> ${user}</font>
                         </h4>
             <h4 align="right">
             	<font color="red"> <span> Reward Points: </span> ${creditPoint}</font>
             </h4>
          </br>
         </div>
         <table class="table table-bordered table-colored-header">
            <thead>
               <tr class="text-center">
                  <th>JOB ID</th>
                  <th>JOB TITLE</th>
                  <th>JOB EXPERIENCE</th>
                  <th>JOB DEPARTMENT NAME</th>
                  <th>JOB POST DATE</th>
                  <th>ACTIONS</th>
               </tr>
            </thead>
            <c:forEach items="${jobs}" var="job" varStatus="ctr">
               <tr>
                  <td>${job.id}</td>
                  <td>${job.jobTitle}</td>
                  <td>${job.experience}</td>
                  <td>${job.department.name}</td>
                  <td>
                     ${job.createDate}
                  </td>
                  <td>
                   <form method="GET" action="./candRegistation" >
                    <input type="hidden" name="jobId" value="${job.id}" />
                                        <button type="submit" class="login100-form-btn">
                                         Refer
                                        </button>
                    </form>

                  </td>
               </tr>
            </c:forEach>
         </table>

   </body>
</html>