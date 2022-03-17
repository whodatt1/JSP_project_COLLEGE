<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>
<jsp:include page="../nav.jsp"/>
<div class="container" style="margin-top: 100px; margin-bottom: 100px;">
		<div class="row animate-box">
			<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
				<h2>Subject Register</h2>
			</div>
		</div>
		<div>
		<form action="/subjCtrl/insert" method="post" enctype="multipart/form-data">
			<input type="hidden" name="id" value="${ses.email }">
  			<div class="form-group col-md-12">
    			<label for="title">Title</label>
    			<input type="text" class="form-control" id="title" placeholder="Title" name="title" required>
  			</div>
  			<div class="form-group col-md-12">
    			<label for="writer">Writer</label>
    			<input type="text" class="form-control" id="writer" placeholder="Writer" name="writer" value="${ses.userName }" readonly>
  			</div>
  			<div class="form-group col-md-12">
    			<label for="major">Major</label>
    			<input type="text" class="form-control" id="major" name="major" value="${ses.major }" readonly>
  			</div>
  			<div class="form-group col-md-12">
    			<label for="description">Description</label>
    			<textarea class="form-control" id="description" placeholder="Description" name="description" style="height: 150px;"></textarea>
  			</div>
  			<div class="form-group col-md-12">
    			<label for="imageFile">Image File</label>
    			<input type="file" class="form-control" id="imageFile" placeholder="User Name" name="imageFile" required>
  			</div>
  			<div class="form-group col-md-12">
    			<label for="classLimit">Class Limit</label>
    			<input type="number" class="form-control" id="classLimit" placeholder="Class Limit" name="classLimit" required>
  			</div>
  			<div class="form-group col-md-12">
    			<label for="startAt">Start At</label>
    			<input type="date" class="form-control" id="startAt" placeholder="Start At" name="startAt" required>
  			</div>
  			<div class="form-group col-md-12">
    			<label for="endAt">End At</label>
    			<input type="date" class="form-control" id="endAt" placeholder="End At" name="endAt" required>
  			</div>
  			<div class="form-group col-md-12" style="margin-top: 15px;">
			<button type="submit" class="btn" style="border-radius: 25% 10%; color:white; background : #F7F0C6;">강의 등록</button>
			</div>
		</form>
		</div>
</div>

<jsp:include page="../footer.jsp"/>
