<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
   <head>
      <title>Applications</title>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="../static/css/style.css" type="text/css" media="all">
      <link rel="stylesheet" href="../static/css/bootstrap.css" type="text/css" media="all" />
   </head>
   <body style="background-color:#E2F2F8;">
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

      <div class="container-login100" style="background-image: url('images/bg-01.jpg');">
      <div class="wrap-login100 p-l-55 p-r-55 p-t-80 p-b-30">

      <table class="table table-bordered table-colored-header">
         <thead>
             <tr class="text-center">
               <th>JOB ID</th>
               <th>CANDIDATE NAME</th>
               <th>APPLICATION STATUS</th>
               <th>REFFERED BY</th>
               <th>REFFERED DATE</th>

            </tr>
         </thead>
                <c:forEach items="${listOfCandidateApplication}" var="application" varStatus="ctr">
                     <tr>
                        <td>${application.job.id}</td>
                        <td>${application.candidate.name}</td>
                        <td>${application.applicationStatus}</td>
                        <td>${application.user.name}(${application.user.employeeId}) </td>
                        <td>
                           ${application.createDate}
                        </td>

                     </tr>
                  </c:forEach>

      </table>

      </div>
      </div>
   </body>
</html>