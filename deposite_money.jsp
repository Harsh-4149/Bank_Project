 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="Dashboard_Sidebar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="content-wrap">
		<div class="main">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-6">
					   <form action="Bank_enterAmount" method="post">
					      <h3>Deposite Money Here</h3>
					      <label> Full Name :</label>
					      <input type="text" name="fullname">
					      <label> Amount :</label>
					      <input type="text" name="amount">
					       <a href="sucessfullydeposite.jsp"> <button>Deposite</button> </a><br><br>
					       
					   </form>
					</div>
				</div>
			</div>
		</div>
	</div>

<script >
    function updateAleret() {
		 alert(" Deposite Amount...!! Are You Sure ");

		 }


</script>

</body>
</html>