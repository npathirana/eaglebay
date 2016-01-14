<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp"/>
<style type="text/css">
    .error-head {
        font-weight: bold;
        font-size: 18px;
        vertical-align: bottom;
        color: #990000;
        padding-bottom: 3px;
        text-shadow: 0px 0px 10px white;
        border-bottom: 1px solid #cccccc;
    }

    .error-text {
        text-shadow: 0px 0px 10px white;
    }

    .error-bg {
        padding: 10px;
        background-image: url('<c:url value="/static/main/img/bg.gif" />');
    }

    .error-container {
        padding: 10px;
        border: 1px solid #ff9999;
        border-radius: 5px;
        background-color: #ffeeee
    }
</style>
<script type="text/javascript">
    function home() {
        parent.location.href = "<spring:url value="${springRootUrl}/home"/>";
    }
</script>

<div region="center" class="error-bg" border="false">
    <div class="error-container">
        <table width="100%">
            <tr>
                <td width="35px">
                    <img src="<c:url value="/static/main/img/warning.gif" />" alt="warning-image">
                </td>
                <td class="error-head">
                    <spring:message code="${title}"/>
                </td>
            </tr>
            <tr>
                <td>&nbsp;
                </td>
                <td class="error-text">
                    <spring:message code="${text}"/>
                </td>
            </tr>
        </table>
    </div>
</div>
<jsp:include page="footer.jsp"/>