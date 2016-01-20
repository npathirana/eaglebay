<%@ taglib uri="http://htmlcompressor.googlecode.com/taglib/compressor" prefix="compress" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<spring:message code="label.home" var="title" scope="page"/>
<jsp:include page="../../main/header.jsp">
    <jsp:param name="pageTitle" value="${title}"/>
</jsp:include>
<div style="padding: 40px;">
    My user list
</div>
<jsp:include page="../../main/menu.jsp"/>

<jsp:include page="../../main/footer.jsp"/>
