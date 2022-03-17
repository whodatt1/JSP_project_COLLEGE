<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>
<jsp:include page="../nav.jsp"/>
<div class="container" style="margin-top: 100px; margin-bottom: 100px;">
<div class="row animate-box">
			<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
				<h2>User List</h2>
			</div>
		</div>
<table class="table table-dark table-hover">
	<thead>
      <tr>
        <th>Email</th>
        <th>User Name</th>
        <th>Reg At</th>
        <th>Last Login</th>
        <th>Major</th>
        <th>Grade</th>
      </tr>
    </thead>
    <tbody id="userList">
    <c:forEach var="uvo" items="${list }">
      <tr>
        <td id="email">
        ${uvo.email }
        </td>
        <td>${uvo.userName }</td>
        <td>${uvo.regAt }</td>
        <td>${uvo.lastLogin }</td>
        <td>${uvo.major }</td>
        <td>
        <select style="width:70px;" id="grade">
        	<c:choose>
        		<c:when test="${uvo.grade eq '101' }">
        			<option value="101" selected>관리자</option>
        		</c:when>
        		<c:when test="${uvo.grade eq '50' }">
        			<option value="50" selected>교수</option>
        			<option value="10">학생</option>
        		</c:when>
        		<c:when test="${uvo.grade eq '10' }">
        			<option value="50">교수</option>
        			<option value="10" selected>학생</option>
        		</c:when>
        	</c:choose>
        </select>
        	&nbsp;<button type="submit" class="btn mod" style="border-radius: 25% 10%; color:white; background : #F7F0C6;">조정</button>
        </td>
      </tr>
    </c:forEach>
    </tbody> 
</table>
</div>
<script src="${pageContext.request.contextPath}/resources/js/user.list.js"></script>
<jsp:include page="../footer.jsp"/>
