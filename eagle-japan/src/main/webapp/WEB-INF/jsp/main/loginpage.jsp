<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv='cache-control' content='no-cache'>
    <meta http-equiv='expires' content='0'>
    <meta http-equiv='pragma' content='no-cache'>

    <title><spring:message code="label.login"/> - <spring:message code="label.app.name"/></title>
    <!-- jQuery -->
    <script src="<c:url value="/static/js/jquery-1.11.1/jquery.min.js"/>"></script>

    <link rel="stylesheet" type="text/css" href="<c:url value="/static/main/css/module.css"/>"/>
    <script type="text/javascript" src="<c:url value="/static/main/js/module.js"/>"></script>
    <script type="text/javascript">
        applicationTitle = "<spring:message code="label.app.name"/>";
    </script>

    <script type="text/javascript">

        function onSubmit() {

            if (!$('#username').val()) {
                <spring:message code="um.label.user.username" var="f"/>
                showWarning("<spring:message code="label.error.required" arguments="${f}"/>", function () {
                    $("#username").focus();
                });
                return false;
            }
            if (!$('#password').val()) {
                <spring:message code="um.label.user.password" var="f"/>
                showWarning("<spring:message code="label.error.required" arguments="${f}"/>", function () {
                    $("#password").focus();
                });
                return false;
            }

            return true;
        }
    </script>
</head>
<body>
<form id="ff" class="data-form" action="<c:url value="/j_spring_security_check"/>" method="post"
      onsubmit="return onSubmit()">

    <c:if test="${not empty param.error}">
        <div id="login-error"
             style="padding-bottom: 10px; color:#FF441C;">
            <spring:message code="um.label.login.invalid.credentials"/>
        </div>
    </c:if>

    <spring:message code="um.label.user.username"/> : <input id="username" name="username" type="text" value=""
           placeholder="<spring:message code="um.label.user.username"/>"
           value="<c:if test='${not empty param.error}'>${SPRING_SECURITY_LAST_USERNAME}</c:if>"/>
    <br>
    <spring:message code="um.label.user.password"/> : <input id="password" name="password" type="password" value=""
           placeholder="<spring:message code="um.label.user.password"/>"/>
    <br>
    <input id="submit1" type="submit" class="button l-btn"
           value="<spring:message code="label.login"/>"/>
    <br>
    <br>
    <a href="?lang=en"><spring:message code="label.language.english"/></a>
    <a href="?lang=th"><spring:message code="label.language.sinhala"/></a>
</form>
</body>
</html>
