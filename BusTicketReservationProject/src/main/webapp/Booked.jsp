<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome page</title>
</head>
<style>
.container {
    margin: auto;
	background-color: rgba(240, 255, 255, 0.511);
	width: 600px;
	height: 600px;
	font-weight: 40px;

}
h1,h2,h3{
text-align: center;
}
h1{
padding-top: 40px ;
color: red;
}
body {
	background-image: url('img/bus.png');
	background-size: cover;
	background-repeat: no-repeat;
	background-position: center;
}
table {
	margin: auto;
	width: 500px;
	padding: 5px;
	margin-top: 20px;
	padding-top: 20px;
	font-size: 18px;
}

td {
	padding: 5px;
}
</style>

<body>
	<div class="container">
		<h1>WELCOME</h1>
		<br>
		<h2>Your Booking Is Confirmed</h2>
		<br>
		<div class="tab">
			<h3>YOUR BOOKING DETAIL'S</h3>
			<table>
				<tr>
					<td><b>Booking Id :</b></td>
					<td>${Bookingid}</td>
				</tr>
				<tr>
					<td><b>Passanger Name :</b></td>
					<td>${pasname}</td>
				</tr>
				<tr>
					<td><b>Mobile Number :</b></td>
					<td>${mobileno}</td>
				</tr>
				<tr>
					<td><b>From Destination :</b></td>
					<td>${fromdest}</td>
				</tr>
				<tr>
					<td><b>To Destination :</b></td>
					<td>${pasdest}</td>
				</tr>
				<tr>
					<td><b>Date Of Travel:</b></td>
					<td>${pasdate}</td>
				</tr>
				<tr>
					<td><b>Bus Id :</b></td>
					<td>${busid}</td>
				</tr>
				<tr>
					<td><td>
					<td><button><a href="index.html" style="text-decoration: none;">home</a></button></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>