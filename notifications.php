<?php
	require "conn.php";
?>
<!DOCTYPE html>
<html>
<head>
<title>Notifications</title>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
</head>
<body>
<h3 style="text-align:center;">Notifications</h3>
<?php 
	$mysql_qry = "select * from shop_request;";
	$result = mysqli_query($conn, $mysql_qry);
?>
<table>
	<thead>
		<tr>
			<th>Shop Name</th>
			<th>Address</th>
			<th>City</th>
			<th>Username</th>
			<th>Phone</th>
			<th>Birth Place</th>
			<th>Favourite Dish</th>
			<th>Home Delivery</th>
		</tr>
	</thead>
	<tbody>
		<?php while($row=mysqli_fetch_array($result)) { ?>
		<tr>
			<td><?php echo $row["shopname"] ?></td>
			<td><?php echo $row["address"] ?></td>
			<td><?php echo $row["city"] ?></td>
			<td><?php echo $row["username"] ?></td>
			<td><?php echo $row["phone"] ?></td>
			<td><?php echo $row["birth_place"] ?></td>
			<td><?php echo $row["fav_dish"] ?></td>
			<td><?php echo $row["homeDelivery"] ?></td>
		</tr>
		<?php } ?>
	</tbody>
</table>
<?php $conn->close(); ?>
</body>
</html>