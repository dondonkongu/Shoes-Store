<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>edit san pham</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
		<div class="modal-content">
			<form method="post" action="update">
				<div class="modal-header">						
					<h4 class="modal-title">Edit product</h4>
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">			
					<div class="form-group " >
						<input value="${p.id}" name="id" type="hidden" class="form-control" >
					</div>		
					<div class="form-group">
						<label>Name</label>
						<input value="${p.name}" name="name" type="text" class="form-control" required>
					</div>
					<div class="form-group">
						<label>Link image</label>
						<input value="${p.image}" name="image" type="text" class="form-control" required>
					</div>
					<div class="form-group">
						<label>Price</label>
						<input value="${p.price}" name="price" type="number" class="form-control" required>
					</div>	
					<div class="form-group">
						<label>Title</label>
						<input value="${p.title}" name="title" type="text" class="form-control" required>
					</div>
					<div class="form-group">
						<label>Description</label>
						<input value="${p.description}" name="description" type="text" class="form-control" required>
					</div>
					<div class="form-group">
						<label>Link image 1</label>
						<input value="${p.image1}" name="image1" type="text" class="form-control" required>
					</div>
					<div class="form-group">
						<label>Link image 2</label>
						<input value="${p.image2}" name="image2" type="text" class="form-control" >
					</div>			
					<div class="form-group">
						<label>Link image 3</label>
						<input value="${p.image3}" name="image3" type="text" class="form-control" >
					</div>	
					<div class="form-group">
						<label>Link image 4</label>
						<input value="${p.image4}" name="image4" type="text" class="form-control" >
					</div>	
					<div>
					<p> loai san pham</p>
					<select class="form-control" aria-label="Default select example" name="cateId">
						<c:forEach items="${listC}" var="c">
						 <option value="${c.cid }">${c.cname}</option>
						 </c:forEach>

					</select>
					</div>	
				</div>
				<div class="modal-footer">
					<a href="manage"><input type="button" class="btn btn-default" value="Cancel"></a>
					<input type="submit" class="btn btn-success" value="Update">
				</div>
			</form>
		</div>
</div>
</body>
</html>