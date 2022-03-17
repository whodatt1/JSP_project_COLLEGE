<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>
<jsp:include page="../nav.jsp"/>
<div class="container" style="margin-top: 100px; margin-bottom: 100px;">
		<div class="row animate-box">
			<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
				<h2>로그인</h2>
			</div>
		</div>
		<div>
		<form action="/userCtrl/login" method="post">
  			<div class="form-group col-md-12">
    			<label for="email">이메일</label>
    			<input type="email" class="form-control" id="email" placeholder="이메일을 입력하세요" name="email" required>
  			</div>
  			<div class="form-group col-md-12">
    			<label for="pwd">비밀번호</label>
    			<input type="password" class="form-control" id="pwd" placeholder="비밀번호를 입력하세요" name="pwd" required>
  			</div>
  			<div class="form-group col-md-12" style="margin-top: 30px;">
			<button type="submit" class="btn" style="border-radius: 25% 10%; color:white; background : #F7F0C6;">로그인</button>
			</div>
		</form>
		</div>
		</div>
<script>
let msg_email = '<c:out value="${msg_email }"/>';
let msg_pwd = '<c:out value="${msg_pwd }"/>';

if (msg_email.length > 0) {
	alert('이메일이 존재하지 않습니다');
} else if (msg_pwd.length > 0) {
	alert('패스워드가 일치하지 않습니다');
}
</script>
<jsp:include page="../footer.jsp"/>
