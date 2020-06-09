 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ include file="common/header.jspf"%>
 <%@ include file="common/navigation.jspf"%>
<!DOCTYPE html>
<html>

<head>
    <title>Save Todo</title>


    <link type="text/css"
          rel="stylesheet"
          href="css/style.css">

    <link type="text/css"
          rel="stylesheet"
          href="css/add-customer-style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <style type="text/css">

        form {
            margin-top: 20px;
            width: 400px;
            height: 300px;
        }

        form-group {
            margin-top: 20px;
        }

        span{
            width: 50%;
            display:inline-block;
            width: 200px;
            text-align: left;
        }

        input[type=submit] {
            background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            align-self: auto;
        }
        a:link, a:visited {
            background-color: black;
            color: white;
            padding: 14px 25px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
        }
        }


        }
    </style>


</head>

<body>


<div id="wrapper" >
    <div id="header" align="center">
        <h2>TODO MANAGER</h2>
    </div>
</div>

<div id="container" align="center" >
    <h3>ADD NEW TODO</h3>

    <form:form action="saveTodo" modelAttribute="todo" method="POST" cssStyle="border-style: solid">
        <form:hidden path="id" />
        <div class="form-group">
            <label style="margin-top: 20px">Description:  </label>
            <form:input path="todoName"/>
            <form:errors path="todoName" cssClass="error" />

        </div>
        <br/>
        <div class="form-group">
            <label>Target Date:</label>
            <form:input type ="date" path="todoDate"/>
            <form:errors path="todoDate" cssClass="error" />
        </div>
        <br/>
        <input type="submit" value="Save" class="save"/>
        <p style="margin-top: 20px">
            <a href="${pageContext.request.contextPath}/todo/listTodo">Back to List</a>
        </p>
    </form:form>



</div>
<%@ include file="common/footer.jspf"%>

</body>

</html>








