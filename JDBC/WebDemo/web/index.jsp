<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : index
    Created on : Jul 16, 2016, 11:38:36 PM
    Author     : nhanvo
--%>
<sql:query var="subjects" dataSource="jdbc/WEBDEMO">
    SELECT subject_id, name FROM Subject
</sql:query>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Index</title>
    </head>
    <body>
        <h2>Welcome to <strong>WebDemo</strong>, the International Former
            Professional Wrestlers' Association for Counseling and Development!
        </h2>
        <table border="0">
            <thead>
                <tr>
                    <th>WebDemo offers expert counseling in a wide range of fields.</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>To view the contact details of an WebDemo certified former
                professional wrestler in your area, select a subject below:</td>
                </tr>
                <tr>
                    <td>
                        <form action="response.jsp">
                            <strong>Select a subject:</strong>
                            <select name="subject_id">
                                <c:forEach var="row" items="${subjects.rows}">
                                    <option value="${row.subject_id}"> ${row.name}</option>
                                </c:forEach>
                            </select>
                            <input type="submit" value="submit" name="submit"/>
                        </form>
                    </td>
                </tr>
            </tbody>
        </table>

    </body>
</html>
