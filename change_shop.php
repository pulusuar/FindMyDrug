<?php
	require "conn.php";
	$username = $_POST["username"];
	$password = $_POST["password"];
	$mysql_qry = "select * from shop_login where username='$username';";
	$result = mysqli_query($conn, $mysql_qry);
	if(mysqli_num_rows($result)>0){
		$mysql_qry2 = "update shop_login set password='$password' where username like '$username';";
		$result1 = mysqli_query($conn, $mysql_qry2);
		if($result1){
			echo "Password Changed Successfully!";
		}
	}
	else{
		echo "Password Failure";
	}
	$conn->close();
?>