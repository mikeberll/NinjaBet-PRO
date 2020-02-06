<?php
require "conn.php";
$name = $_POST["name"];
$surname = $_POST["surname"];
$user_name = $_POST["user_name"];
$user_pass = $_POST["password"];
$mysql_qry = "insert into access_table(name, surname, username, password) values ('$name', '$surname', '$user_name', '$user_pass')";
if ($conn->query($mysql_qry) == TRUE) {
    echo "SUCCESS";
}
else {
    echo "Error :" . $mysql_qry . "<br>" . $conn->error;
}
$conn->close();
?>