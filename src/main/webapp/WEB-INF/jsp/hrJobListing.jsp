<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
   <head>
      <title>Login V9</title>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="../static/css/style.css" type="text/css" media="all">
      <link rel="stylesheet" href="../static/css/bootstrap.css" type="text/css"	media="all" />
   </head>
   <body style="background-color:#E2F2F8;">
        <div style="align-center:center;" width="80%" >
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
                     <jsp:include page="hrmenu.jsp" />
                  </td>
            </table>
            <br/>
             <div align="right">
                        <h4 align="right">
                                     	<font color="blue"> <span> Hi </span> ${user}</font>
                                     </h4> </div>

      <div class="container-login100" style="background-image: url('images/bg-01.jpg');">
      <div class="wrap-login100 p-l-55 p-r-55 p-t-80 p-b-30">
	 <c:if test="${not empty msg}">
     <h4 align="center">
				<font color="red">${msg}</font></h4>
      </c:if>
      <c:if test="${empty msg}">
     <h4 align="center">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h4>
      </c:if>
      <div>
      </div>
      <div align="right">

      </div>
      <div class="container-login100" style="background-image: url('images/bg-01.jpg');">
      <div class="wrap-login100 p-l-55 p-r-55 p-t-80 p-b-30">
      <%--<form method="GET" action="./candRegistation" class="login100-form validate-form">--%>
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

                  <form method="GET" action="./viewAllApplications">
                     <input type="hidden" name="jobId" value="${job.id}" />
                     <button class="login100-form-btn">
                     View All Applications
                     </button>
                  </form>
               </td>
            </tr>
         </c:forEach>
      </table>
      <%--</form>--%>
      <div>
      </div>
   </body>
</html>