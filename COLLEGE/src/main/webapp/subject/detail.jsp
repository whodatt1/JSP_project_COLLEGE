<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="../header.jsp"/>
<jsp:include page="../nav.jsp"/>
<div class="container" style="margin-top: 100px; margin-bottom: 100px;">
<div class="row animate-box">
	<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
		<h2>강의 상세보기</h2>
	</div>
</div>
<input type="hidden" name="grade" value="${ses.grade }">
<input type="hidden" name="email" value="${ses.email }">
<table class="table table-condensed">
	<thead>
		<tr align="center">
			<th width="10%">제목
			</th>
			<th width="60%">${svo.title }</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<th>전공계열</th>
			<td>${svo.major }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${svo.modAt }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${svo.writer } (${svo.id }) 교수 <span style='float:right'>평균 리뷰 점수 : <span id="rvAvg">0</span> / 5&nbsp<i class="far fa-star"></i></span></td>
		</tr>
		<tr>
			<th>강의 기간</th>
			<td>${svo.startAt } ~ ${svo.endAt } <span style='float:right'>${svo.attends } / ${svo.classLimit }&nbsp<i class="far fa-user"></i></span></td>
		</tr>
		<tr>
			<td></td>
			<td>
			<img src="${pageContext.request.contextPath}/_fileUpload/${svo.imageFile }">
			<p>${svo.description }</p>
			</td>
		</tr>
	</tbody>
</table>
<form action="/subjCtrl/remove" method="post" id="delForm" style="display: none">
	<input type="hidden" name="sno" value="${svo.sno }">
	<input type="hidden" name="imageFile" value="${svo.imageFile }">	
</form>
<c:if test="${ses.email eq svo.id && ses.grade gt 49 || ses.grade gt 100 }">
<div class="text-right">
<button type="button" class="btn" style="border-radius: 25% 10%; color:white; background : #F7F0C6;"><a href="/subjCtrl/modify?sno=${svo.sno }" style="text-decoration: none; color: white;">수정</a></button>
<button type="button" class="btn" id="delBtn" style="border-radius: 25% 10%; color:white; background : #C2C4B6;">삭제</button>
<button type="button" class="btn" style="border-radius: 25% 10%; color:white; background : #F7F0C6;"><a href="/subjCtrl/list" style="text-decoration: none; color: white;">강의 목록</a></button>
</div>
</c:if>


<c:choose>
<c:when test="${ses.email ne '' && ses.email ne null }">
<div class="text-center">
	<form action="/courCtrl/insert" method="post">
	<input type="hidden" name="csSno" value="${svo.sno }">
	<input type="hidden" name="csEmail" value="${ses.email }">
	<input type="hidden" name="csUserName" value="${ses.userName }">
	<input type="hidden" name="csName" value="${svo.title }">
	<input type="hidden" name="csProId" value="${svo.writer }">
	<input type="hidden" name="csProName" value="${svo.id }">
	<input type="hidden" name="csMajor" value="${svo.major }">
	<input type="hidden" name="csStartAt" value="${svo.startAt }">
	<input type="hidden" name="csEndAt" value="${svo.endAt }">
	<c:choose>
		<c:when test="${ses.grade < 49 }">
			<c:choose>
				<c:when test="${svo.attends eq svo.classLimit }">
				<c:forEach var="lcs" items="${listCs }">
					<c:set var = "lcs" value = "${listCs }"/>
					<c:set var = "email" value = "${ses.email }"/>
					<c:if test="${fn:contains(lcs, email) }">
						<a href="/courCtrl/list_stu?email=${ses.email }" class="btn" style="border-radius: 25% 10%; color:white; background : #C2C4B6;">수강 철회</a>
					</c:if>
					<c:if test="${!fn:contains(lcs, email) }">
						<button type="submit" class="btn" id="courReg" style="border-radius: 25% 10%; color:white; background : #F7F0C6;" disabled>수강 신청</button>
					</c:if>
				</c:forEach>
				</c:when>
				<c:otherwise>
				<c:set var = "lcs" value = "${listCs }"/>
				<c:set var = "email" value = "${ses.email }"/>
					<c:if test="${fn:contains(lcs, email) }">
						<a href="/courCtrl/list_stu?email=${ses.email }" class="btn" style="border-radius: 25% 10%; color:white; background : #C2C4B6;">수강 철회</a>
					</c:if>
					<c:if test="${!fn:contains(lcs, email) }">
						<button type="submit" class="btn" id="courReg" style="border-radius: 25% 10%; color:white; background : #F7F0C6;">수강 신청</button>
					</c:if>
				</c:otherwise>
			</c:choose>
		</c:when>
	</c:choose>
	</form>
</div>
</c:when>
</c:choose>
<hr>
<c:choose>
	<c:when test="${ses.email ne '' && svo.id ne null && ses.grade lt 49 }">
	<div style="margin-bottom: 15px;">
		<span id="rvWriter">${ses.userName }</span>
		<span style='float:right'>
		리뷰 점수 :
			<select name="score" id="rvScore">
				<option value="" selected>점수 선택</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</select>
		</span>
	</div>
	<input type="hidden" id="rvId" value="${svo.id }">
    <input class="form-control" id="rvTitle" style="margin-bottom: 15px;" placeholder="리뷰의 제목을 입력하세요">
    <textarea class="form-control" style="height: 150px" id="rvContent" placeholder="${ses.userName }님의 소중한 리뷰를 남겨주세요!"></textarea>
    <div class="text-right">
      <button class="btn" style="margin-top: 15px; border-radius: 25% 10%; color:white; background : #F7F0C6;" id="rvPostBtn">리뷰 작성</button>
    </div>
    <hr>
    </c:when>
</c:choose>
<ul class="media-body" id="rvListArea" style="list-style: none;">
</ul>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header"">
        <h5 class="modal-title" style="margin-bottom: 15px; id="exampleModalLabel">
        	${ses.userName }
        	<span style="float: right;">
        		리뷰 점수 : <select id="rvScoreMod">
        			<option value="1">1</option>
        			<option value="2">2</option>
        			<option value="3">3</option>
        			<option value="4">4</option>
        			<option value="5">5</option>
        		</select>
        	</span>
        </h5>
        <input type="text" class="form-control" id="rvTitleMod">
      </div>
      <div class="modal-body">
        <textarea class="form-control" id="rvContentMod" style="height: 150px;"></textarea>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn" id="rvModBtn" style="border-radius: 25% 10%; color:white; background : #F7F0C6;">수정</button>
        <button type="button" class="btn" id="rvCloseBtn" data-dismiss="modal" style="border-radius: 25% 10%; color:white; background : #C2C4B6;">닫기</button>
      </div>
    </div>
  </div>
</div>
</div>
<script>
let msg_reg = '<c:out value="${msg_reg}"/>'

if (msg_reg.length > 0) {
	alert("수강신청에 " + (parseInt(msg_reg) > 0 ? "성공하였습니다" : "실패하였습니다"));
}
</script>
<script src="${pageContext.request.contextPath}/resources/js/subject.detail.js"></script>
<jsp:include page="../footer.jsp"/>
