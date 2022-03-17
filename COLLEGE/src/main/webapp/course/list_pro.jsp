<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>
<jsp:include page="../nav.jsp"/>
<div class="container" style="margin-top: 100px; margin-bottom: 100px;">
<div class="row animate-box">
			<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
				<h2>수강 목록</h2>
			</div>
		</div>

<table class="table table-dark table-hover">
	<thead>
      <tr>
        <th>#</th>
        <th>강의 제목</th>
        <th>수강자</th>
        <th>개강 일자</th>
        <th>종강 일자</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="csvo" items="${list }">
      <tr>
        <td>${csvo.csno }</td>
        <td><a href="/subjCtrl/detail?sno=${csvo.sno }">${csvo.courseName }</a></td>
        <td>${csvo.userName } (${csvo.email })</td>
        <td>${csvo.startAt }</td>
        <td>${csvo.endAt }<a href="/courCtrl/remove?csno=${csvo.csno }&email=${csvo.email }&sno=${csvo.sno }" class="btn" style="float: right; border-radius: 25% 10%; color:white; background : #C2C4B6;">수강 철회</a></td>
      </tr>
    </c:forEach>
    </tbody> 
</table>
</div>
<jsp:include page="../footer.jsp"/>
