<?php
require "conn.php";
$name = $_POST["name"];
$surname = $_POST["surname"];
$user_name = $_POST["user_name"];
$user_pass = $_POST["password"];
$mysql_qry = "insert into access_table(name, surname, username, password) values ('$name', '$surname', '$user_name', '$user_pass');";
// Check connection
if ($conn->connect_error) {
   die("<br> Connection failed: " . $conn->connect_error . "<br>");
}
print "<br> Connected successfully <br>";
if ($conn->query($mysql_qry) == TRUE) {
    echo "<br> SUCCESS <br>";
}
else {
    echo "<br> Error :" . $mysql_qry . "<br>" . $conn->error . "<br>";
}
$conn->close();
?>
