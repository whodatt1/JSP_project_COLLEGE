<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>
<jsp:include page="../nav.jsp"/>
<div class="container" style="margin-top: 100px; margin-bottom: 100px;">
<div class="row animate-box">
	<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
		<h2>글 상세보기</h2>
	</div>
</div>
<input type="hidden" name="grade" value="${ses.grade }">
<c:choose>
<c:when test="${ses.email eq null || ses.email eq '' }">
<input type="hidden" name="email" value="익명">
</c:when>
<c:otherwise>
<input type="hidden" name="email" value="${ses.email }">
</c:otherwise>
</c:choose>
 <table class="table table-condensed">
	<thead>
		<tr align="center">
			<th width="10%">제목</th>
			<th width="60%">${cvo.title }<span style="float: right;">조회수 : ${cvo.readCount }</span></th>
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
			<td>내용</td>
			<td>
			<img src="${pageContext.request.contextPath}/_fileUpload_comm/${cvo.imageFile }">
			<p>${cvo.content }</p>
			</td>
		</tr>
	</tbody>
</table>
<form action="/commCtrl/remove" method="post" id="delForm" style="display: none">
	<input type="hidden" name="cno" value="${cvo.cno }">
	<input type="hidden" name="imageFile" value="${cvo.imageFile }">	
</form>
<c:if test="${ses.email eq cvo.id || ses.grade gt 100}">
<div class="text-right">
<button type="button" class="btn" style="border-radius: 25% 10%; color:white; background : #F7F0C6;"><a href="/commCtrl/modify?cno=${cvo.cno }" style="text-decoration: none; color: white;">수정</a></button>
<button type="button" class="btn" id="delBtn" style="border-radius: 25% 10%; color:white; background : #C2C4B6;">삭제</button>
<button type="button" class="btn" style="border-radius: 25% 10%; color:white; background : #F7F0C6;"><a href="/commCtrl/list" style="text-decoration: none; color: white;">글 목록</a></button>
</div>
</c:if>
<hr>
<div style="margin-bottom: 15px;">
		<span id="rpWriter">
		<c:choose>
			<c:when test="${ses.userName eq null || ses.userName eq '' }">
				익명
			</c:when>
			<c:otherwise>
				${ses.userName }
			</c:otherwise>
		</c:choose>
		</span>
	</div>
	<input type="hidden" id="rpId" value="${cvo.id }">
    <textarea class="form-control" style="height: 150px" id="rpContent" placeholder="댓글 내용을 입력하세요"></textarea>
    <div class="text-right">
      <button class="btn" style="margin-top: 15px;border-radius: 25% 10%; color:white; background : #F7F0C6;" id="rpPostBtn">댓글 작성</button>
    </div>
    <hr>
    <ul class="media-body" id="rpListArea" style="list-style: none;">
	</ul>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header"">
        <h5 class="modal-title" id="exampleModalLabel">
        	
        </h5>
      </div>
      <div class="modal-body">
        <textarea class="form-control" id="rpContentMod" style="height: 150px;"></textarea>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn-warning" id="rpModBtn">수정</button>
        <button type="button" class="btn-danger" id="rpCloseBtn" data-dismiss="modal">닫기</button>
      </div>
    </div>
  </div>
</div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/community.detail.js"></script>
<jsp:include page="../footer.jsp"/>
