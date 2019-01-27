<?php
session_start();
require "conn.php";
$user_name = "";
$password = "";
if(isset($_POST['submit'])){
if($_SERVER["REQUEST_METHOD"]=="POST"){
	if(empty($_POST["user_name"])){
		$userErr = "Username is required";
	}
	else{
		$user_name = $_POST["user_name"];
	}
	
	if(empty($_POST["password"])){
		$passwordErr = "Password is required";
	}
	else{
		$password = $_POST["password"];
	}
}

	$mysql_qry = "select * from admin_login where username like '$user_name';";
	$result = mysqli_query($conn, $mysql_qry);
	if(mysqli_num_rows($result) == 1){
		while($row = mysqli_fetch_assoc($result)){
			$username1 = $row["username"];
			$password1 = $row["password"];
		}
		if($username1==$user_name && $password1==$password){
			$_SESSION["user_name"]=$user_name;
			header("Location:admin_home.php");
		}
		else{
			header("Location:admin_login.html");
		}
	}
	else{
		header("Location:admin_login.html");
	}
}
$conn->close();
?>
