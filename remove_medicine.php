<?php
	require "conn.php";
	$medicine_name = $_POST["medicine_name"];
	$shop_username = $_POST["shop_username"];
	$availability = "0";
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
		echo "medicine unavailable!!";
	}
	$conn->close();
?>