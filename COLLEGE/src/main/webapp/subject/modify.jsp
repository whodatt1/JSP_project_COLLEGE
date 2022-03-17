<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>
<jsp:include page="../nav.jsp"/>
<div class="container" style="margin-top: 100px; margin-bottom: 100px;">
<div class="row animate-box">
	<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
		<h2>강의 수정</h2>
	</div>
</div>
<form action="/subjCtrl/update" method="post" enctype="multipart/form-data">
<input type="hidden" name="sno" value="${svo.sno }">
<table class="table table-condensed">
	<thead>
		<tr align="center">
			<th width="10%">제목</th>
			<th width="60%"><input type="text" class="form-control" style="width : 100%;" value="${svo.title }" name="title" required></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<th>전공계열</th>
			<td>
			<select name="major" class="form-control">
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
			</td>
		</tr>
		<tr>
			<th>강의 기간</th>
			<td><input type="date" value="${svo.startAt }" name="startAt" class="form-control" style="width : 20%; display: inline-block;" required> ~ <input type="date" value="${svo.endAt }" name="endAt" class="form-control" style="width : 20%; display: inline-block;" required>
				<span style='float:right'>
    				<input type="number" id="classLimit" class="form-control" style="display: inline-block;" placeholder="수강최대인원" name="classLimit" value="${svo.classLimit }" required>
				</span>
			</td>
		</tr>
		<tr>
			<td>이미지 파일</td>
			<td>${svo.imageFile }
			<input type="hidden" name="imageFile" value="${svo.imageFile }">
			</td>
		</tr>
		<tr>
			<td>이미지 첨부</td>
			<td>
				<input type="file" name="new_imageFile" class="form-control">
			</td>
		</tr>
		<tr>
			<td>설명</td>
			<td>
			<p><textarea name="description" class="form-control" style="width : 100%; height : 500px;">${svo.description }</textarea></p>
			</td>
		</tr>
	</tbody>
</table>
<hr>
<div class="text-right">
<button type="submit" class="btn" style="border-radius: 25% 10%; color:white; background : #F7F0C6;">수정</button>
</div>
</form>
</div>
<jsp:include page="../footer.jsp"/>
