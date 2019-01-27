<?php
require "conn.php";
$username="";
if($_SERVER["REQUEST_METHOD"]=="POST"){
	if(empty($_POST["username"])){
		$userErr = "Enter username";
	}
	else{
		$username = $_POST["username"];
	}
}
$mysql_qry = "select * from shop_login where username like '$username';";
$result = mysqli_query($conn, $mysql_qry);
if(mysqli_num_rows($result)>0){
	$mysql_qry2 = "DELETE from medicines where shop_username like '$username';";
	mysqli_query($conn, $mysql_qry2);
	$mysql_qry1 = "DELETE from shop_login where username like '$username';";
	mysqli_query($conn, $mysql_qry1);
	$mysql_qry3 = "DELETE from registrationid where shop_username like '$username';";
	mysqli_query($conn, $mysql_qry3);
	echo "Store removed";
}
else{
	echo "Store not available!!";
}
$conn->close();
?>