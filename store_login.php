<?php
	require "conn.php";
	$username = "";
	$password = "";
	$reg_Id = "";
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
		
		if(empty($_POST["regId"])){
			$regIdError = "Registration id is required";
		}
		else{
			$reg_Id = $_POST["regId"];
		}
	}
	$mysql_qry = "select * from shop_login where username like '$username' and password like '$password';";
	$result = mysqli_query($conn, $mysql_qry);
	if(mysqli_num_rows($result)>0){
		while($row = mysqli_fetch_assoc($result)){
			$username1 = $row["username"];
			$password1 = $row["password"];
		}
		if($username1==$username && $password1==$password){
			$mysql_qry2 = "select * from registrationId where shop_username like '$username';";
			$result2 = mysqli_query($conn, $mysql_qry2);
			if(mysqli_num_rows($result2)>0){
				$mysql_qry3 = "update registrationId set regId='$reg_Id' where shop_username like '$username';";
				$result3 = mysqli_query($conn, $mysql_qry3);
			}
			else{
				$mysql_qry1 = "insert into registrationId(shop_username, regId) values('$username','$reg_Id');";
				$result1 = mysqli_query($conn, $mysql_qry1);
			}
			echo "Store Logged in!!";
		}
		else{
			echo "Store Login failure!! Try again :)";
		}
	}
	else{
		echo "Store Login failure!! Try again :)";
	}
	$conn->close();
?>