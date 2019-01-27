<?php
	require "conn.php";
	$medicine_name = $_POST["medicineName"];
	$shop_username = $_POST["shopUsername"];
	$availability = "1";
	$mysql_qry = "select * from medicines where medicine_name like '$medicine_name' and shop_username like '$shop_username';";
	$result = mysqli_query($conn, $mysql_qry);
	if(mysqli_num_rows($result)>0){
		$mysql_qry1 = "update medicines set availability='$availability' where medicine_name like '$medicine_name' and shop_username like '$shop_username';";
		$result1 = mysqli_query($conn, $mysql_qry1);
		if($result1){
			echo "Medicine Data Updated!!";
		}
	}
	else{
		$mysql_qry2 = "insert into medicines(medicine_name, availability, shop_username) values('$medicine_name','$availability','$shop_username');";
		$result2 = mysqli_query($conn, $mysql_qry2);
		if(!$result2){
			echo "Failed to add medicine!!";
		}
		else{
			echo "New medicine added";
		}
	}
	$conn->close();
?>