<?php
	require "conn.php";
	$username = "";
	$birthPlace = "";
	$favDish = "";
	if($_SERVER["REQUEST_METHOD"]=="POST"){
		if(empty($_POST["username"])){
			$userErr = "Username is required";
		}
		else{
			$username = $_POST["username"];
		}
		if(empty($_POST["birthPlace"])){
			$birthErr = "Answer1 is required";
		}
		else{
			$birthPlace = $_POST["birthPlace"];
		}
		
		if(empty($_POST["favDish"])){
			$favDishErr = "Answer2 is required";
		}
		else{
			$favDish = $_POST["favDish"];
		}
	}
	$mysql_qry = "select * from user_login where username='$username';";
	$result = mysqli_query($conn, $mysql_qry);
	if(mysqli_num_rows($result)>0){
		while($row = mysqli_fetch_assoc($result)){
			$birth1 = $row["birth_place"];
			$fav1 = $row["fav_dish"];
		}
		if($birth1===$birthPlace && $fav1===$favDish){
			echo "Success";
		}
		else{
			echo "Failed";
		}
	}
	
	else{
		echo "Failed";
	}
	$conn->close();
?>