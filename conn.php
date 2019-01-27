<?php
$db_name = "findMyDrug";
$user_name = "root";
$password = "";
$server_name = "localhost";
//setting api key
define('API_KEY','AIzaSyAQ-jMy7RFavmImjYXHy4gox5LMtk2Yx1Y');
$conn = mysqli_connect($server_name, $user_name, $password, $db_name) or die("could not connect to the server");
?>