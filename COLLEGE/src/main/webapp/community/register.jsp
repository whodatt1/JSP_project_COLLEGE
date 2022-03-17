<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>
<jsp:include page="../nav.jsp"/>
<div class="container" style="margin-top: 100px; margin-bottom: 100px;">
		<form action="/commCtrl/insert" method="post" enctype="multipart/form-data">
			<input type="hidden" name="id" value="${ses.email }">
  			<div class="form-group col-md-12">
    			<label for="title">Title</label>
    			<input type="text" class="form-control" id="title" placeholder="Title" name="title" required>
  			</div>
  			<div class="form-group col-md-12">
    			<label for="writer">Writer</label>
    			<c:choose>
    				<c:when test="${ses.email ne null && ses.email ne '' }">
    					<input type="text" class="form-control" id="writer" name="writer" value="${ses.userName }" readonly>
    				</c:when>
    				<c:otherwise>
    					<input type="text" class="form-control" id="writer" name="writer" value="익명" readonly>
    				</c:otherwise>
    			</c:choose>
  			</div>
  			<div class="form-group col-md-12">
    			<label for="description">Content</label>
    			<textarea class="form-control" id="content" placeholder="Content" name="content" style="height: 150px;"></textarea>
  			</div>
  			<div class="form-group col-md-12">
    			<label for="imageFile">Image File</label>
    			<input type="file" class="form-control" id="imageFile" name="imageFile">
  			</div>
  			<div class="form-group col-md-12" style="margin-top: 15px;">
			<button type="submit" class="btn" style="border-radius: 25% 10%; color:white; background : #F7F0C6;">글 등록</button>
			</div>
		</form>
</div>

<script>
let msg_email = '<c:out value="${msg_email }"/>';

if (msg_email.length > 0) {
	alert('중복된 이메일입니다! 다른 이메일을 이용해주시기 바랍니다');
}
</script>
<jsp:include page="../footer.jsp"/>
