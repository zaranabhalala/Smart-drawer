<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="function" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="list" value="${sessionScope.list}"></c:set>
<c:set var="len" value="${function:length(list)}"></c:set>
[<c:forEach var="i" items="${sessionScope.list}" varStatus="j">
    {"batchno":"i"}
    <c:if test="${len ne j.count }">,</c:if>
</c:forEach>]