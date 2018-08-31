<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <script src='https://www.google.com/recaptcha/api.js'></script>
</head>
<body>
<h1>REGISTRATION</h1>
<form:form action="/registration" method="post" modelAttribute="name">
    <label for="name" class="label">Name</label>
    <form:input path="name"/>
    <input type="submit" id = "submitForm" value="Submit" /><!--disabled = "disabled"-->
    <script>
        function enableSubmit() {
            document.getElementById("submitForm").disabled = false;
        }
    </script>
</form:form>
</body>

</html>
