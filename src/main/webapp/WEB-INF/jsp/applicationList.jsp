<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
   <head>
      <title>Applications</title>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="../static/css/style.css" type="text/css" media="all">
      <link rel="stylesheet" href="../static/css/bootstrap.css" type="text/css"	media="all" />
   </head>
  <body style="background-color:#E2F2F8;">
      <div class="container-login100" style="background-image: url('images/bg-01.jpg');">
      <div class="wrap-login100 p-l-55 p-r-55 p-t-80 p-b-30">
      <span class="login100-form-title p-b-37">
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

      </span>
      <div>
      </div>

      <div class="container-login100" style="background-image: url('images/bg-01.jpg');">
      <div class="wrap-login100 p-l-55 p-r-55 p-t-80 p-b-30">
      <%--<form method="GET" action="./candRegistation" class="login100-form validate-form">--%>
       <table class="table table-bordered table-colored-header">
         <thead>
           <tr class="text-center">
               <th>APPLICATION ID</th>
               <th>CANDIDATE NAME</th>
               <th>APPLICATION STATUS</th>
               <th>REFERRED BY</th>
               <th>APPLICATION POST DATE</th>
               <th>ACTIONS</th>
            </tr>
         </thead>
         <c:forEach items="${candidateApplicationList}" var="application" varStatus="ctr">
            <tr>
               <td>${application.id}</td>
               <td>${application.candidate.name}</td>
               <td>${application.applicationStatus}</td>
               <td>${application.user.name}(${application.user.employeeId}) </td>
               <td>
                  ${application.createDate}
               </td>
               <td>
                  <form method="GET" action="">
                     <button class="login100-form-btn">
                     <a href="https://s3-ap-southeast-1.amazonaws.com/healthkartdev/51569_1573649730662.xls"><b>Download CV</b> </a>
                     </button>
                  </form>
                  <form method="POST" action="./accepted">
                     <input type="hidden" name="applicationId" value="${application.id}" />
                     <button class="login100-form-btn">
                     Accepted
                     </button>
                  </form>
                  <form method="POST" action="./rejected">
                                       <input type="hidden" name="applicationId" value="${application.id}" />
                                       <button class="login100-form-btn">
                                       Rejected
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