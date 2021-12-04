<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Survey-HW</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/surveyResults" method="POST">
    <fieldset>
        Who is "Oyabun" in japanese yakuza hierarchy ?<br>
        <input type="radio" id="first" name = "0" value="Patriarch">
        <label for="first">Patriarch</label><br>
        <input type="radio" id="second" name = "1" value = "Accountant">
        <label for="second">Accountant</label><br>
        <input type="radio" id="third" name = "2" value = "Soldier">
        <label for="third">Soldier</label><br>
    </fieldset>
    <fieldset>
        What is "bonsai" ?<br>
        <input type="radio" id="fourth" name = "3" value = "Tree">
        <label for="fourth">Tree</label><br>
        <input type="radio" id="fifth" name = "4" value = "Form of art">
        <label for="fifth">Form of art</label><br>
        <input type="radio" id="sixth" name = "5" value = "Name">
        <label for="sixth">Name</label><br>
    </fieldset>
    <input type="reset">
    <input type="submit">
</form>
</body>
</html>