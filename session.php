<?php

// Establishing Connection with Server
require "conn.php";
// Starting Session
session_start();
// Storing Session
$user_check=$_SESSION["user_name"];

// SQL Query To Fetch Complete Information Of User
$mysql_qry = "select * from admin_login where username='$user_check'";
$result = mysqli_query($conn,$mysql_qry);

if($row=mysqli_fetch_assoc($result)){
	$user = $row['username'];
}
if(!isset($user)){
	$conn->close();
	header('Location: admin_login.html');
}
?>