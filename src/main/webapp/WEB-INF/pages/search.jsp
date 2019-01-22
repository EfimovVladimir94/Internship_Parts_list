<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>Parts list</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #cc841c;
        }

        .tg td {
            font-family: Arial MS, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #cc0800;
            color: #cc841c;
            background-color: #000000;
        }

        .tg th {
            font-family: Arial MS, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #cc841c;
            color: #f8ff34;
            background-color: #000000;
        }

        .tg .tg-4eph {
            background-color: #cc841c
        }
    </style>
</head>
<body>
<a href="<c:url value='/redirect'/>">Back to main catalog</a>
<h1>Результат поиска детали</h1>

<table class="tg">
    <tr>
        <th width="80">Наименование</th>
        <th width="120">Необходимо</th>
        <th width="120">Количество</th>
        <th width="60">Delete</th>
    </tr>

    <tr>
        <td>${part.parts}</td>
        <td><c:choose>
            <c:when test="${part.need !=1}">Нет</c:when>
            <c:otherwise>Да</c:otherwise>
        </c:choose>
        </td>
        <td>${part.quantity}</td>
        <td><a href="<c:url value='/remove/${part.id}'/>">Delete</a></td>
    </tr>
</table>

<c:url var="addAction" value="/parts/update"/>
<form:form action="${addAction}" commandName="part">
    <table>
        <c:if test="${!empty part.parts}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="parts">
                    <spring:message text="Наименование"/>
                </form:label>
            </td>
            <td>
                <form:input path="parts"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="need">
                    <spring:message text="Необходимо"/>
                </form:label>
            </td>
            <td>
                <form:input path="need"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="quantity">
                    <spring:message text="Количество"/>
                </form:label>
            </td>
            <td>
                <form:input path="quantity"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">

                <input type="submit" value="<spring:message text="Edit"/>"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>