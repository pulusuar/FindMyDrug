<?php
session_start();

if(session_destroy()) // Destroying All Sessions
{
header("Location: admin_login.html"); // Redirecting To Home Page
}
?>