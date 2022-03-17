<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>
<jsp:include page="../nav.jsp"/>
<div class="container" style="margin-top: 100px; margin-bottom: 100px;">
<div class="row animate-box">
			<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
				<h2>User Detail</h2>
			</div>
		</div>
<form action="/userCtrl/modify" method="post" id="modForm">
<input type="hidden" name="email" value="${uvo.email }"/>

<ul class="list-group list-group-flush">
  <li class="list-group-item">Email : ${uvo.email }</li>
  <li class="list-group-item">Password : <input type="text" value="${uvo.pwd }" name="pwd" required></li>
  <li class="list-group-item">User Name : <input type="text" value="${uvo.userName }" name="userName" required></li>
  <li class="list-group-item">Reg At : ${uvo.regAt }</li>
  <li class="list-group-item">Last Login : ${uvo.lastLogin }</li>
  <li class="list-group-item">Major : 
  <select name="major" required>
  	<c:choose>
  		<c:when test="${uvo.major == '인문계열'}">
  		<option value="인문계열" selected>인문계열</option>
  		<option value="사회계열">사회계열</option>
    	<option value="교육계열">교육계열</option>
    	<option value="공학계열">공학계열</option>
    	<option value="자연계열">자연계열</option>
    	<option value="의약계열">의약계열</option>
    	<option value="예체능계열">예체능계열</option>
    	</c:when>
  		<c:when test="${uvo.major == '사회계열'}">
  		<option value="인문계열">인문계열</option>
  		<option value="사회계열" selected>사회계열</option>
    	<option value="교육계열">교육계열</option>
    	<option value="공학계열">공학계열</option>
    	<option value="자연계열">자연계열</option>
    	<option value="의약계열">의약계열</option>
    	<option value="예체능계열">예체능계열</option>
    	</c:when>
  		<c:when test="${uvo.major == '교육계열'}">
  		<option value="인문계열">인문계열</option>
  		<option value="사회계열">사회계열</option>
    	<option value="교육계열" selected>교육계열</option>
    	<option value="공학계열">공학계열</option>
    	<option value="자연계열">자연계열</option>
    	<option value="의약계열">의약계열</option>
    	<option value="예체능계열">예체능계열</option>
    	</c:when>
  		<c:when test="${uvo.major == '공학계열'}">
  		<option value="인문계열">인문계열</option>
  		<option value="사회계열">사회계열</option>
    	<option value="교육계열">교육계열</option>
    	<option value="공학계열" selected>공학계열</option>
    	<option value="자연계열">자연계열</option>
    	<option value="의약계열">의약계열</option>
    	<option value="예체능계열">예체능계열</option>
    	</c:when>
  		<c:when test="${uvo.major == '자연계열'}">
  		<option value="인문계열">인문계열</option>
  		<option value="사회계열">사회계열</option>
    	<option value="교육계열">교육계열</option>
    	<option value="공학계열">공학계열</option>
    	<option value="자연계열" selected>자연계열</option>
    	<option value="의약계열">의약계열</option>
    	<option value="예체능계열">예체능계열</option>
    	</c:when>
  		<c:when test="${uvo.major == '의약계열'}">
  		<option value="인문계열">인문계열</option>
  		<option value="사회계열">사회계열</option>
    	<option value="교육계열">교육계열</option>
    	<option value="공학계열">공학계열</option>
    	<option value="자연계열">자연계열</option>
    	<option value="의약계열" selected>의약계열</option>
    	<option value="예체능계열">예체능계열</option>
    	</c:when>
    	<c:otherwise>
    	<option value="인문계열">인문계열</option>
  		<option value="사회계열">사회계열</option>
    	<option value="교육계열">교육계열</option>
    	<option value="공학계열">공학계열</option>
    	<option value="자연계열">자연계열</option>
    	<option value="의약계열">의약계열</option>
    	<option value="예체능계열" selected>예체능계열</option>
    	</c:otherwise>
    </c:choose>
  </select>
  </li>
  <li class="list-group-item">Grade : ${uvo.grade > 49 ? '교수' : '학생'}</li>
</ul>
<button type="submit" class="btn" style="border-radius: 25% 10%; color:white; background : #F7F0C6;">수정하기</button>
<button type="submit" class="btn" id="resignBtn" style="border-radius: 25% 10%; color:white; background : #C2C4B6;">탈퇴하기</button>
</form>
</div>
<script src="../resources/js/user.detail.js"></script>
<jsp:include page="../footer.jsp"/>
