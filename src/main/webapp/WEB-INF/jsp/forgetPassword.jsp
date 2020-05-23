<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="/static/css/class.css" type="text/css">
    <link rel="stylesheet" href="/static/css/style.css" type="text/css">
    <link rel="stylesheet" href="/static/css/jquery-ui.css">
    <link rel="stylesheet" href="/static/css/bootstrap.min3.4.css">
    <link rel="stylesheet" href="/static/css/bootstrap.css" type="text/css" media="all" />
    <%@ page import="com.hk.EmployeeReferral.utility.EnumDepartment" %>
        <style type="text/css">
            .navbar li a {
                color: #2A086E;
                font-size: 12px;
                ! important
            }
        </style>
</head>

<body style="background-color:#E2F2F8;">
    <div align="center" width="80%">

        <br/>
        <div align="center">
            <h3>Please Reset Your Password</h3>
        </div>

        <div style="width:700px; margin:0 auto;">
            <form action="./forgetPasswordSubmit" enctype="multipart/form-data" method="post">
                <table class="table">

                    <tr>
                        <td>Email ID</td>
                        <td>:</td>
                        <td>
                            <input type="text" name="email" />
                        </td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td>:</td>
                        <td>
                            <input type="password" name="password" />
                        </td>
                    </tr>
                    <tr>
                        <td>Confirm Password</td>
                        <td>:</td>
                        <td>
                            <input type="password" name="confirmPassowrd" />
                        </td>
                    </tr>

                        <tr></tr>
                        </br>
                        </br>

                </table>
                <input type="submit" value="Submit" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset" value="Reset" />
            </form>
        </div>

    </div>
</body>

</html>