<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="kor">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>리뷰 게시판</title>

<!-- Bootstrap Core CSS -->
<link href="../resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="../resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

<!-- DataTables CSS -->
<link href="../resources/vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link href="../resources/vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="../resources/dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="../resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

</head>

<body>
	<!-- /.panel-heading -->
	<div class="panel-body">
		<table width="100%"
			class="table table-striped table-bordered table-hover"
			id="dataTables-example">
			<thead>
				<tr>
					<th>작성자</th>
					<th>내용</th>
					<th>작성일</th>
					<th>수정일</th>
				</tr>
			</thead>
			<c:forEach items="${list }" var="comments">
				<tr>
					<td><c:out value="${comments.id }"/></td>
					<td><c:out value="${comments.content }"/></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${comments.replyDate }"/></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${comments.updateDate }"/></td>
				</tr>
			</c:forEach>
		</table>



		</tbody>

	</div>

	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="../resources/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="../resources/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="../resources/vendor/metisMenu/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->
	<script src="../resources/vendor/datatables/js/jquery.dataTables.min.js"></script>
	<script src="../resources/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
	<script src="../resources/vendor/datatables-responsive/dataTables.responsive.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="../resources/dist/js/sb-admin-2.js"></script>

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>

</body>

</html>

