<?php
$db_name = "ninjabet";
$mysql_username = "root";
$mysql_password = "password";
$server_name = "localhost";

// Create connection
$conn = mysqli_connect($server_name, $mysql_username, $mysql_password, $db_name);

// Check connection
if (mysqli_connect_error()) {
    die("Database connection failed: " . mysqli_connect_error());
}
echo "<br> Connected successfully <br>";
?>
