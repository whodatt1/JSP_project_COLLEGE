<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="fh5co-loader"></div>
	<div id="page">
	<nav class="fh5co-nav" role="navigation">
		<div class="top-menu">
			<div class="container">
				<div class="row">
 					<div class="col-xs-2">
							<div id="fh5co-logo"><a href="/"><img src="../resources/img/hk.png" style="height: 50px;"></a></div>
					</div>
 					<div class="col-xs-10 text-right menu-1">
						<ul>
							<li class="active myLi"><a href="/" class="myA">홈</a></li>
							<li class="myLi"><a href="/subjCtrl/list" class="myA">강의 목록</a></li>
							<li class="myLi"><a href="/commCtrl/list" class="myA">자유 게시판</a></li>
							<c:choose>
								<c:when test="${ses.grade < 49 }">
									<li class="myLi"><a href="/courCtrl/list_stu?email=${ses.email }" class="myA">수강 목록</a></li>
								</c:when>
								<c:when test="${ses.grade > 49 && ses.grade < 100 }">
									<li class="myLi"><a href="/courCtrl/list_pro?professorId=${ses.email }" class="myA">수강 신청자 목록</a></li>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${ses.email ne '' && ses.email ne null }">
									<c:choose>
										<c:when test="${ses.grade > 100 }">
											<li class="btn-cta"><a href="/userCtrl/list"><span>${ses.userName } ${ses.grade == 101 ? '관리자' : ''} (${ses.email })</span></a></li>
										</c:when>
										<c:otherwise>
											<li class="btn-cta"><a href="/userCtrl/detail?email=${ses.email }"><span>${ses.userName } ${ses.grade > 49 ? '교수' : '학생' } (${ses.email }) ${ses.major }</span></a></li>
										</c:otherwise>
									</c:choose>
									<li class="btn-cta"><a href="/userCtrl/logout"><span>로그아웃</span></a></li>
								</c:when>
								<c:otherwise>
									<li class="btn-cta"><a href="/user/login.jsp"><span>로그인</span></a></li>
									<li class="btn-cta"><a href="/userCtrl/register"><span>회원가입</span></a></li>
								</c:otherwise>
							</c:choose>
						</ul>
					</div>
				</div>
				
			</div>
		</div>
	</nav>
	
	<aside id="fh5co-hero">
		<div class="flexslider">
			<ul class="slides">
		   	<li style="background-image: url(../resources/img/banner2.jpg);">
		   		<div class="overlay-gradient"></div>
		   		<div class="container">
		   			<div class="row">
			   			<div class="col-md-8 col-md-offset-2 text-center slider-text">
			   				<div class="slider-text-inner">
			   					<h1>The Roots of Education are Bitter, But the Fruit is Sweet</h1>
			   				</div>
			   			</div>
			   		</div>
		   		</div>
		   	</li>
		  	</ul>
	  	</div>
	</aside>

<!-- <div class="container"> -->