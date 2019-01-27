<?php
	require "conn.php";
	$username = "";
	$password = "";
	if($_SERVER["REQUEST_METHOD"]=="POST"){
		if(empty($_POST["username"])){
			$userErr = "Username is required";
		}
		else{
			$username = $_POST["username"];
		}
		
		if(empty($_POST["password"])){
			$passwordErr = "Password is required";
		}
		else{
			$password = $_POST["password"];
		}
	}
	$mysql_qry = "select * from user_login where username='$username';";
	$result = mysqli_query($conn, $mysql_qry);
	if(mysqli_num_rows($result)>0){
		while($row = mysqli_fetch_assoc($result)){
			$username1 = $row["username"];
			$password1 = $row["password"];
		}
		if($username1==$username && $password1==$password){
			echo "Login success!!";
		}
		else{
			echo "Login failure!! Try again :)";
		}
	}
	
	else{
		echo "Login failure!! Try again :)";
	}
	$conn->close();
?>