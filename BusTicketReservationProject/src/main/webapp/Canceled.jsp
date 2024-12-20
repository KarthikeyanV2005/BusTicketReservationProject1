<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Canceled Page</title>
<style type="text/css">
.container{
text-align: center;
font-size: 18px;

}
table{
margin: auto;
}
</style>
</head>
<body>
<div class="container">

<h2>YOUR BOOKING IS SUCCESSFULLY CANCEL</h2> <br><br>

Dear ${name},<br><br><br>

We hope this message finds you well.<br><br>

We are writing to confirm that your bus booking has been successfully canceled. Below are the details of your canceled booking:<br><br>

<table>
<tr>
<td><b>Booking Reference Number:</b></td>
<td>${bookingid}</td>
</tr>

<tr>
<td><b>Passanger Name:</b></td>
<td> ${name} </td>
</tr>

<tr>
<td><b>Mobile Number:</b></td>
<td>${mobileno } </td>
</tr>

</table><br><br>


<b>Refund Information:</b>  <br><br>
Your refund of Amount will be processed within 2 business days to your original payment method.<br>

We apologize for any inconvenience this may have caused and hope to serve you again in the future.<br>



</div>
</body>
</html>