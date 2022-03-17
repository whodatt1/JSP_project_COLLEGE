<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp"/>
<jsp:include page="nav.jsp"/>
<div id="fh5co-course-categories">
		<div class="container">
			<div class="row animate-box">
				<div class="col-md-6 col-md-offset-3 text-center fh5co-heading">
					<h2>COLLEGE는 혁신적인 강의를 주도합니다.</h2>
					<p>다른 강의와 차별화 된 퀄리티를 지양하는 COLLEGE와 함께 여러분들의 미래를 그려나가세요.</p>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3 col-sm-6 text-center animate-box">
					<div class="services">
						<span class="icon">
							<i class="far fa-compass"></i>
						</span>
						<div class="desc">
							<h3>목표 설정</h3>
							<p>측정가능하고 구체적인 또한 현실적으로 달성 가능한 목표를 제시하여 성공적인 결과를 도출해냅니다.</p>
						</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-6 text-center animate-box">
					<div class="services">
						<span class="icon">
							<i class="far fa-eye"></i>
						</span>
						<div class="desc">
							<h3>비전 제시</h3>
							<p>획기적인 비전을 제시하여 강의 참여자로 하여금 의지 고양에 도움을 줍니다.</p>
						</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-6 text-center animate-box">
					<div class="services">
						<span class="icon">
							<i class="fas fa-chalkboard-teacher"></i>
						</span>
						<div class="desc">
							<h3><a href="#">체계적인 내용</a></h3>
							<p>물흐르듯 자연스럽게 흘러가는 체계적인 강의 내용을 구축하여 참여자로 하여금 복잡한 주제의 이해를 돕습니다.</p>
						</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-6 text-center animate-box">
					<div class="services">
						<span class="icon">
							<i class="fas fa-people-arrows"></i>
						</span>
						<div class="desc">
							<h3>원활한 소통</h3>
							<p>교수와 학생의 원활한 소통으로 집중도를 높이고 강의의 만족도를 높입니다</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
			
		<div id="fh5co-gallery" class="fh5co-bg-section">
		<div class="row text-center">
			<h2><span>College Gallery</span></h2>
		</div>
		<div class="row">
			<div class="col-md-3 col-padded">
				<a class="gallery" style="background-image: url(../resources/img/1.jpg);"></a>
			</div>
			<div class="col-md-3 col-padded">
				<a class="gallery" style="background-image: url(../resources/img/2.jpg);"></a>
			</div>
			<div class="col-md-3 col-padded">
				<a class="gallery" style="background-image: url(../resources/img/3.jpg);"></a>
			</div>
			<div class="col-md-3 col-padded">
				<a class="gallery" style="background-image: url(../resources/img/4.jpg);"></a>
			</div>
		</div>
	</div>
	
	
<script>
	let msg_reg = '<c:out value="${msg_reg }"/>';
	let msg_login = '<c:out value="${msg_login }"/>';
	let msg_logout = '<c:out value="${msg_logout }"/>';
	let msg_resign = '<c:out value="${msg_resign }"/>';
	let msg_mod = '<c:out value="${msg_mod }"/>';
	
	if(msg_reg.length > 0){
		alert("회원가입이 " + (parseInt(msg_reg) > 0 ? "완료되었습니다" : "실패하였습니다"));		
	} else if (msg_login.length > 0) {
		alert("로그인에 성공하였습니다");
	} else if (msg_logout.length > 0) {
		alert("로그아웃에 성공하였습니다");
	} else if (msg_resign.length > 0) {
		alert("회원 탈퇴에 성공하였습니다")
	} else if (msg_mod.length > 0) {
		alert("다시 로그인 해주세요")
	}
</script>
<jsp:include page="footer.jsp"/>
