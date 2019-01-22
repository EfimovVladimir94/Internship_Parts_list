<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
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
            color: #cc7100;
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
            border-color: #cc8100;
            color: #f8ff34;
            background-color: #000000;
        }

        .tg .tg-4eph {
            background-color: #cc841c
        }
    </style>
</head>

<body>
<c:if test="${allList.size() != currentList.size()}">
    <a href="<c:url value='/redirect'/>">Back to main catalogs</a>
</c:if>

<br/>
<br/>

<h1>Каталог комплектующих</h1>
<c:if test="${!empty listParts}">
    <table class="tg">
        <tr>
            <th width="80">Наименование</th>
            <th width="80">Необходимо</th>
            <th width="120">Количество</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listParts}" var="part">
            <tr>
                <td>${part.parts}</td>
                <td><c:choose>
                    <c:when test="${part.need !=1}">Нет</c:when>
                    <c:otherwise>Да</c:otherwise>
                </c:choose>
                </td>
                <td>${part.quantity}</td>
                <td><a href="<c:url value='/edit/${part.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${part.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>

    <br/>
    <br/>

    <c:if test="${listParts.size() < currentList.size()}">
        <table>
            <tr>
                <td><a href="<c:url value='/previous'/>"><— previous page </a></td>
                <td width="60"></td>
                <td><a href="<c:url value='/next'/>">  next page —></a></td>
            </tr>
        </table>
    </c:if>

    <br/>

    <table class="tg">
        <tr>
            <td width="200">Можно собрать компьютеров</td>
            <td width="30">${quantityComputer}</td>
        </tr>
    </table>

</c:if>

<br/>

<table>
    <tr>
        <td><a href="<c:url value='/parts/selectNeed'/>">Необходимо</a></td>
        &nbsp;&nbsp;&nbsp;
        <td><a href="<c:url value='/parts/selectNoNeed'/>">Доп.Комплект</a></td>
    </tr>
</table>

<br/>

<h1>Позиции для изменения или добавления</h1>

<c:url var="addAction" value="/parts/add"/>
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
                    <spring:message text="Необходимость для сборки"/>
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

                <input type="submit" value="<spring:message text="Добавить/Изменить"/>"/>
            </td>
        </tr>
    </table>
</form:form>

<h1>Поиск позиции</h1>
<c:url var="searchAction" value="/parts/search"/>

<form:form action="${searchAction}" commandName="part">
    <table>
        <tr>
            <td>
                <form:label path="parts">
                    <spring:message text="Название позиции"/>
                </form:label>
            </td>
            <td>
                <form:input path="parts"/>
            </td>

        </tr>
        <tr>
            <td colspan="2">

                <input type="submit" value="<spring:message text="Найти"/>"/>

            </td>
        </tr>

    </table>
</form:form>

</body>
</html>