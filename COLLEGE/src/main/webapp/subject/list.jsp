<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>
<jsp:include page="../nav.jsp"/>
<div class="container" style="margin-top: 100px; margin-bottom: 100px;">
			<div class="row animate-box">
				<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
					<h2>강의 목록</h2>
				</div>
			</div>
			<div class="text-center" style="margin-bottom: 50px;">
				<ul style="list-style: none;">
					<li class="myLi2"><a class="myA all">전체</a></li>
					<li class="myLi2"><a class="myA hu">인문계열</a></li>
					<li class="myLi2"><a class="myA so">사회계열</a></li>
					<li class="myLi2"><a class="myA ed">교육계열</a></li>
					<li class="myLi2"><a class="myA en">공학계열</a></li>
					<li class="myLi2"><a class="myA na">자연계열</a></li>
					<li class="myLi2"><a class="myA me">의약계열</a></li>
					<li class="myLi2"><a class="myA ar">예체능계열</a></li>
				</ul>
			</div>
			
			<div class="row">
		<c:forEach var="svo" items="${list }">
			<c:choose>
				<c:when test="${svo.major eq '인문계열' }">
					<div class="col-lg-4 col-md-4 human">
				</c:when>
				<c:when test="${svo.major eq '사회계열' }">
					<div class="col-lg-4 col-md-4 social">
				</c:when>
				<c:when test="${svo.major eq '교육계열' }">
					<div class="col-lg-4 col-md-4 edu">
				</c:when>
				<c:when test="${svo.major eq '공학계열' }">
					<div class="col-lg-4 col-md-4 engine">
				</c:when>
				<c:when test="${svo.major eq '자연계열' }">
					<div class="col-lg-4 col-md-4 nature">
				</c:when>
				<c:when test="${svo.major eq '의약계열' }">
					<div class="col-lg-4 col-md-4 medi">
				</c:when>
				<c:when test="${svo.major eq '예체능계열' }">
					<div class="col-lg-4 col-md-4 art">
				</c:when>
			</c:choose>
					<div class="fh5co-blog animate-box">
						<a href="/subjCtrl/detail?sno=${svo.sno }&email=${ses.email }" class="blog-img-holder" style="background-image:url('../_fileUpload/${svo.imageFile }');"></a>
						<div class="blog-text">
							<h3>${svo.title }</h3>
							<h5 class="text-right">${svo.major }</h5>
							<span class="posted_on">${svo.startAt } ~ ${svo.endAt }</span>
							<span class="comment">${svo.attends }/${svo.classLimit }&nbsp<i class="far fa-user"></i></span>
							<div class="text-right">${svo.writer } 교수</div>
						</div> 
					</div>
				</div>
		</c:forEach>
			</div>
		<c:choose>
			<c:when test="${ses.grade > 49 }">
				<a href="/subjCtrl/register" class="btn" style="margin-top: 30px; border-radius: 25% 10%; color:white; background : #F7F0C6;">강의 등록</a>
			</c:when>
		</c:choose>
</div>
<script src="${pageContext.request.contextPath}/resources/js/subject.list.js"></script>
<jsp:include page="../footer.jsp"/>
