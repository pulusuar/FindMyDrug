<?php
require "conn.php";
$shopname="";
$address="";
$phone="";
$username="";
$password="";
$conpwd="";
$latitude="";
$longitude="";
$city="";
$homeDelivery=$_POST["delivery"];
$birthPlace="";
$favDish="";
if($_SERVER["REQUEST_METHOD"]=="POST"){
	if(empty($_POST["shopname"])){
		$inputErr = "Shopname is required";
	}
	else{
		$shopname = $_POST["shopname"];
	}
	if(empty($_POST["address"])){
		$addressErr = "Address is required";
	}
	else{
		$address = $_POST["address"];
	}
	if(empty($_POST["phone"])){
		$phoneErr = "Phone is required";
	}
	else{
		$phone = $_POST["phone"];
	}
	if(empty($_POST["username"])){
		$usernameErr = "Username is required";
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
	if(empty($_POST["confirmPassword"])){
		$conpwdErr = "Confirm Password is required";
	}
	else{
		$conpwd = $_POST["confirmPassword"];
	}
	if(empty($_POST["latitude"])){
		$latitudeErr = "Latitude is required";
	}
	else{
		$latitude = $_POST["latitude"];
	}
	if(empty($_POST["longitude"])){
		$longitudeErr = "Longitude is required";
	}
	else{
		$longitude = $_POST["longitude"];
	}
	if(empty($_POST["city"])){
		$cityErr = "City is required";
	}
	else{
		$city = $_POST["city"];
	}
	if(empty($_POST["birthPlace"])){
		$birthErr = "Place of Birth is required";
	}
	else{
		$birthPlace = $_POST["city"];
	}
	if(empty($_POST["favDish"])){
		$dishErr = "Favourite Dish is required";
	}
	else{
		$favDish = $_POST["favDish"];
	}
}

$mysql_qry1 = "select * from shop_login where username like '$username';";
$result1 = mysqli_query($conn, $mysql_qry1);
if(mysqli_num_rows($result1)<1){
	if($password == $conpwd && strlen($password)>8){
		$mysql_qry = "insert into shop_login(shopname, address, phone, username, password, latitude, longitude, city, homeDelivery,birth_place,fav_dish) values('$shopname', '$address', '$phone', '$username', '$password', '$latitude', '$longitude', '$city', '$homeDelivery','$birthPlace','$favDish');";
		$result = mysqli_query($conn, $mysql_qry);
		if($result === TRUE){
			$mysql_qry2 = "delete from shop_request where username like '$username';";
			$result2 = mysqli_query($conn, $mysql_qry2);
			echo "New Store Added Successfully!!!";
		}
		else{
			echo "Failed to add store";
		}
	}
	else{
		echo "Two passwords must match..Password must be atleast 8 characters";
	}
}
else{
	echo "Username already exists";
}
$conn->close();
?>