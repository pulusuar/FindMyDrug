<?php
	require "conn.php";
	$shopname = $_POST["shopname"];
	$address = $_POST["address"];
	$city = $_POST["city"];
	$username = $_POST["username"];
	$phone = $_POST["phone"];
	$birth_place = $_POST["birthPlace"];
	$fav_dish = $_POST["favDish"];
	$homeDelivery = $_POST["homeDelivery"];
	
	$mysql_qry = "select * from shop_request where username='$username';";
	$result = mysqli_query($conn, $mysql_qry);
	$mysql_qry1 = "select * from shop_login where username='$username';";
	$result1 = mysqli_query($conn, $mysql_qry1);
	
	if(mysqli_num_rows($result)>0 || mysqli_num_rows($result1)>0){
		echo "Username already exists!!!";
	}
	else{
		$mysql_qry2 = "insert into shop_request(shopname,address,city,username,phone,birth_place,fav_dish,homeDelivery) values('$shopname','$address','$city','$username','$phone','$birth_place','$fav_dish','$homeDelivery');";
		$result2 = mysqli_query($conn, $mysql_qry2);
		if(!$result2){
			echo "Failed to request!";
		}
		else{
			echo "Requested Successfully!!";
		}
	}
	$conn->close();
?>