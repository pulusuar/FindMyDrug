<?php
 include_once "conn.php";
 include_once "sendMessage.php";
//Checking http request we are using post here 
if($_SERVER["REQUEST_METHOD"]=="POST"){
 
 //Getting the message 
 $drug_name = $_POST['drugname'];
 $manufacturer = $_POST['company'];
 $contact = $_POST['phone'];
 $message1 = "Drug Name- " . $drug_name . " ::::  Manufacturer- " . $manufacturer . " ::::  Contact No.- " . $contact; 
 
 //Creating a message array 
 $msg = array
 (
 'message' => $message1
 );
 $notification = new Notification();
 //Getting registration token from database and storing it as array 
 $mysql_qry = "select regId from registrationid";
 $reg_token = mysqli_query($conn, $mysql_qry);
 $registrationIds = array();
 //To create an array of device tokenId's 
 while($row = $reg_token->fetch_assoc()){
	 array_push($registrationIds,$row['regId']);
 }
 //$message = json_encode($msg);
 $noti = $notification->send_notification($registrationIds, array($msg));
 //Decoding json from result 
 $res = json_decode($noti);
 //Getting value from success 
 $flag = $res->success;
 
 //if success is 1 means message is sent 
 if($flag >=1){
 //Redirecting back to our form with a request success 
	header('Location: notify.php?success');
 }else{
 //Redirecting back to our form with a request failure 
	header('Location: notify.php?failure');
 }
}
$conn->close();
?>