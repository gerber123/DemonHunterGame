<%--
  Created by IntelliJ IDEA.
  User: gerber
  Date: 30.10.2018
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Registration Page</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/form-page.css"/>
    <link href="https://fonts.googleapis.com/css?family=Cinzel" rel="stylesheet">
</head>
<body>

        <div class="box">


            <img src="${pageContext.request.contextPath}/resources/images/avatar.jpg" class="avatar">
            <h1>Welcome<span style="color:red"> Young</span> Killer!</h1>



            <form:form action="${pageContext.request.contextPath}/creatingProcess/createCharacter"
                       modelAttribute="character"
                       class="form-horizontal">

                <p>Your ancient NickName:
                <form:input path="nick_name" placeholder="Nick (*)" class="form-control" />

                <input type="submit" value="Next Step" onclick=""/>
                <a href="${pageContext.request.contextPath}/homepage">Back to HomePage</a>


                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}" />
            </form:form>

        </div>
</body>
</html>
