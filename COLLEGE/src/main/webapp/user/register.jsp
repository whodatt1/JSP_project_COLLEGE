<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>
<jsp:include page="../nav.jsp"/>
<div class="container" style="margin-top: 100px; margin-bottom: 100px;">
		<div class="row animate-box">
			<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
				<h2>회원가입</h2>
			</div>
		</div>
		<div>
		<form action="/userCtrl/insert" method="post">
  			<div class="form-row">
    			<div class="form-group col-md-6">
      				<label for="email">이메일</label>
      				<input type="email" class="form-control" id="email" placeholder="이메일을 입력하세요" name="email" required>
    			</div>
    			<div class="form-group col-md-6">
      				<label for="pwd">비밀번호</label>
      				<input type="password" class="form-control" id="pwd" placeholder="비밀번호를 입력하세요" name="pwd" required>
    			</div>
  			</div>
  			<div class="form-group col-md-12">
    			<label for="userName">이름</label>
    			<input type="text" class="form-control" id="userName" placeholder="이름을 입력하세요" name="userName" required>
  			</div>
 			<div class="form-row col-md-12">
    			<div class="form-group">
      				<label for="grade">직급</label>
      				<select id="grade" class="form-control" name="grade" size="1" required>
        				<option value="" selected>직급을 선택하세요</option>
        				<option value="10">학생</option>
        				<option value="50">교수</option>
      				</select>
    			</div>
  			</div>
 			<div class="form-row col-md-12">
    			<div class="form-group">
      				<label for="major">전공계열</label>
      				<select id="major" class="form-control" name="major" size="1" required>
        				<option value="" selected>전공계열을 선택하세요</option>
        				<option value="인문계열">인문계열</option>
        				<option value="사회계열">사회계열</option>
        				<option value="교육계열">교육계열</option>
        				<option value="공학계열">공학계열</option>
        				<option value="자연계열">자연계열</option>
        				<option value="의약계열">의약계열</option>
        				<option value="예체능계열">예체능계열</option>
      				</select>
    			</div>
  			</div>
  			<div class="form-group col-md-12" style="margin-top: 30px;">
			<button type="submit" class="btn" style="border-radius: 25% 10%; color:white; background : #F7F0C6;">회원가입</button>
			</div>
		</form>
		</div>
		</div>
		
<script>
let msg_email = '<c:out value="${msg_email }"/>';

if (msg_email.length > 0) {
	alert(msg_email > 0 ? "사용 가능한 이메일입니다" : "다른 이메일을 사용해주세요");
}
</script>
<jsp:include page="../footer.jsp"/>
