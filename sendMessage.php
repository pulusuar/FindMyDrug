<?php
include_once 'conn.php';
class Notification{
function send_notification($regId, $msg){
 //Creating a new array fileds and adding the msg array and registration token array here 
 $fields = array
 (
 'registration_ids' => $regId,
 'data' => array('message' => $msg)
 );
 //Adding the api key in one more array header 
 $headers = array
 (
 'Authorization: key=' . API_KEY,
 'Content-Type: application/json'
 ); 
 //Using curl to perform http request 
 $ch = curl_init();
 
 curl_setopt( $ch,CURLOPT_URL, 'https://android.googleapis.com/gcm/send' );
 curl_setopt( $ch,CURLOPT_POST, true );
 curl_setopt( $ch,CURLOPT_HTTPHEADER, $headers );
 curl_setopt( $ch,CURLOPT_RETURNTRANSFER, true );
 curl_setopt( $ch,CURLOPT_SSL_VERIFYPEER, false );
 curl_setopt( $ch,CURLOPT_POSTFIELDS, json_encode( $fields ) );
 //Getting the result 
 $result = curl_exec($ch );
 curl_close( $ch );
 return $result;
 }
}
?>