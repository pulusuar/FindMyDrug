<?php
	require "conn.php";
	$medicine_name = $_POST["medicine_name"];
	$mysql_qry = "select shopname,address,phone,latitude,longitude,city,homeDelivery from shop_login JOIN medicines ON shop_login.username=medicines.shop_username where medicine_name like '$medicine_name' and availability=1;";
	$result = mysqli_query($conn, $mysql_qry) or die($conn->error);
	$output = array();
	while($row = mysqli_fetch_assoc($result)){
		$output[] = $row;
		$json = json_encode($output);
	}
	echo $json;
	if(mysqli_num_rows($result)>0){
		echo "Search success";
	}
	else{
		echo "No results found";
	}
	$conn->close();
?>