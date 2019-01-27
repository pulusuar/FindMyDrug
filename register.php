<?php
require "conn.php";
$name = $_POST["name"];
$username = $_POST["username"];
$password = $_POST["password"];
$phone = $_POST["phone"];
$birthPlace = $_POST["birthPlace"];
$favDish = $_POST["favDish"];
$mysql_qry1 = "select * from user_login where username='$username';";
$result = mysqli_query($conn, $mysql_qry1);
if(mysqli_num_rows($result)>0){
	echo "Username already exists!!";
}
else{
	$mysql_qry = "insert into user_login(name, username, password, phone, birth_place, fav_dish) values('$name','$username','$password','$phone','$birthPlace','$favDish');";
	$result1 = mysqli_query($conn, $mysql_qry);
	if(!$result1){
		echo "Failed to register";
	}
	else{
		echo "Registration Success!!";
	}
}
$conn->close();
?>