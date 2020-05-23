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

    <div align="center" width="80%">
        <table width="100%">
            <tr>
                <td>
                    <div>
                        <img src="../static/image/banner1.png" height="70px" width="30%" />
                    </div>
                </td>

            </tr>
            <tr>
                <td width="100%">
                    <jsp:include page="empmenu.jsp" />
                </td>
        </table>
        <br/>
        <br/>
        <div align="center">
            <form action=".././app/feedbackApplication" method="post">
                <table class="table table-bordered">
                    <input type="hidden" name="applicationId" value="${applicationId}" />
                    <tr>
                        <td>Application ID</td>
                        <td>${applicationId}</td>
                    </tr>
                    <tr>
                        <td>Applicant Name</td>
                        <td>${candidateName}</td>
                    </tr>
                    <tr>
                        <td>Experience</td>
                        <td>${experience}</td>
                    </tr>
                    <tr>
                        <td>Job Description</td>
                        <td>${jobDesc}</td>
                    </tr>
                    <tr>
                        <td>Assignee </td>
                        <td>
                            <select name="assigneeTo">
                                <option value="1">Madhu</option>
                                <option value="2">Bijoy</option>
                                <option value="3">Anurag</option>
                                <!--  <c:forEach items="${userList}" var="user" varStatus="ctr">
                                                 <option>mad</option>
                                             </c:forEach> -->
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td>Status</td>
                        <td>
                            <select name="status">
                                <option value="0">Select</option>

                                <option value="3">Rejected</option>
                                <option value="4">Select</option>

                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Comments/Feedback</td>
                        <td>
                            <textarea rows="5" cols="40" name="comments" value=${comments}> </textarea>
                        </td>
                    </tr>
                    </tr>
                </table>

                <input type="submit" value="Save Details" />
            </form>

        </div </body>

</html>