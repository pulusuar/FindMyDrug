<!DOCTYPE html>
<html>
<head>
<title>Notify Stores</title>
<style>
.wrapper{
	text-align:center;
}
.button{
	background-color: #0000ff;
	border:none;
	color:white;
	padding:15px 32px;
	text-align:center;
	text-decoration:none;
	display:inline-block;
	font-size:16px;
	margin:4px 2px;
	cursor:pointer;
}
input[type=text],input[type=telephone]{
	width:40%;
	padding:12px 20px;
	margin:8px 0;
	display:inline-block;
	border:1px solid #ccc;
	border-radius:4px;
	box-sizing: border-box;
}
</style>
</head>
<body>
<h4 style="text-align:center;">New Drug Details</h4>
<form method="post" action="send.php">
<div class="wrapper">
<input type="text" name="drugname" placeholder="Enter drug name" id="drugname" /><br /><br />
<input type="text" name="company" placeholder="Enter company name" id="company" /><br /><br />
<input type="telephone" name="phone" placeholder="Enter phone number" id="phone" /><br /><br />
</div>
<div class="wrapper">
<button class="button" type="submit">Notify all Stores</button>
</div>
</form>
<p>
 <?php
 //if success request came displaying success message 
 if(isset($_REQUEST['success'])){
 echo "<strong>Cool!</strong> Notification sent successfully....";
 }
 //if failure request came displaying failure message 
 if(isset($_REQUEST['failure'])){
 echo "<strong>Oops!</strong> Could not send message check API Key and Token...";
 }
 ?>
 </p>
</body>

</html>