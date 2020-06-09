<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<!DOCTYPE html>

<html>

<head>
    <link rel="stylesheet" href="webjars/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>Listing_TODOS</title>

    <!-- reference our style sheet -->

    <link type="text/css"
          rel="stylesheet"
          href="css/style.css" />
    <style type="text/css">
        table,th,td {
            border-style: double;
            width: 10%;



        }
        span{
            display:inline-block;
            width: 200px;
            text-align: left;
        }
        button
        {
            margin: 10px;
            padding:10px;

        }


        /* visited link */
        a:visited {
            color: green;

        }
        a:link, a:visited {
            background-color: black;
            color: white;
            padding: 14px 25px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
        }
    </style>

</head>

<body>

<div id="wrapper">
    <div id="header" align="center">
        <h2>TODO MANAGEMENT APP</h2>
    </div>
</div>
<div id="container">
    <div id="content">
        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Todo Name</th>
                <th scope="col">Target Date</th>
                <th scope="col">Function</th>

            </tr>

            <c:forEach var="tempTodo" items="${todo}">
            <c:url var="updateLink" value="/todo/showFormForUpdate">
                <c:param name="todoId" value="${tempTodo.id}" />
            </c:url>
            <c:url var="deleteLink" value="/todo/delete">
                <c:param name="todoId" value="${tempTodo.id}" />
            </c:url>
            <tr>
                <td> ${tempTodo.todoName} </td>
                <td> ${tempTodo.todoDate} </td>
                <td>
                    <a href="${updateLink}">Update</a>
                    <a href="${deleteLink}">Delete</a>
                </td>

            </tr>

            </c:forEach>

        </table>

    </div>

</div>

<%@ include file="common/footer.jspf"%>
</body>

</html>







