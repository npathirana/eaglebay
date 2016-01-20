<%@ taglib uri="http://htmlcompressor.googlecode.com/taglib/compressor" prefix="compress" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<div style="padding: 10px;">
    menu :
    <a href="<c:url value="${springRootUrl}/main/home/" />">Home</a>
    <sec:authorize access="hasRole('${ROLE_USERS_LIST}')">
        <a href="<c:url value="${springRootUrl}/user/users/" />">User list</a>
    </sec:authorize>
</div>