<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>
<jsp:include page="../nav.jsp"/>
<div class="container" style="margin-top: 100px; margin-bottom: 100px;">
<div class="row animate-box">
	<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
		<h2>글 수정하기</h2>
	</div>
</div>
<form action="/commCtrl/update" method="post" enctype="multipart/form-data">
<input type="hidden" name="cno" value="${cvo.cno }">
 <table class="table table-condensed">
	<thead>
		<tr align="center">
			<th width="10%">제목</th>
			<th width="60%"><input class="form-control" type="text" name="title" value="${cvo.title }" required></span></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<th>작성자</th>
			<td>${cvo.writer }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${cvo.modAt }</td>
		</tr>
		<tr>
			<th>이미지 파일</th>
			<td>${cvo.imageFile }<input type="hidden" name="imageFile" value="${cvo.imageFile }"></td>
		</tr>
		<tr>
			<th>이미지 첨부</th>
			<td><input type="file" class="form-control" name="new_imageFile"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td>
			<textarea class="form-control" style="height: 150px;" name="content">${cvo.content }</textarea>
			</td>
		</tr>
	</tbody>
</table>
<div class="text-right">
<button type="submit" class="btn" style="border-radius: 25% 10%; color:white; background : #F7F0C6;">수정</button>
</div>
</form>
</div>
<jsp:include page="../footer.jsp"/>
