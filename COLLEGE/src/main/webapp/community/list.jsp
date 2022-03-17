<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>
<jsp:include page="../nav.jsp"/>
<div class="container" style="margin-top: 100px; margin-bottom: 100px;">
<div class="row animate-box">
			<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
				<h2>자유 게시판</h2>
			</div>
		</div>

<table class="table table-dark table-hover">
	<thead>
      <tr>
        <th>#</th>
        <th>작성자</th>
        <th>제목</th>
        <th>수정된 날짜</th>
        <th>조회수</th>
        <th>썸네일</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="cvo" items="${list }">
      <tr>
        <td>${cvo.cno }</td>
        <td>${cvo.writer }</td>
        <td><a href="/commCtrl/detail?cno=${cvo.cno }">${cvo.title }</a></td>
        <td>${cvo.modAt }</td>
        <td>${cvo.readCount }</td>
        <td><img src="../_fileUpload_comm/th_${cvo.imageFile }"></td>
        <td></td>
      </tr>
    </c:forEach>
    </tbody> 
</table>
<a href="/commCtrl/register" class="btn" style="border-radius: 25% 10%; color:white; background : #F7F0C6;">글쓰기</a>
</div>
<jsp:include page="../footer.jsp"/>
