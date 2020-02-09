<?php
require "conn.php";
$user1_1 = $_POST["user1_1"];
$user1_2 = $_POST["user1_2"];
$user2_1 = $_POST["user2_1"];
$user2_2 = $_POST["user2_2"];
$cash = $_POST["cash"];
$mysql_qry1 = "select * from access_table where name = '$user1_1' AND surname = '$user1_2';";
$mysql_qry2 = "select * from access_table where name = '$user2_1' AND surname = '$user2_2';";
$result1 = mysqli_query($conn, $mysql_qry1);
$result2 = mysqli_query($conn, $mysql_qry2);
$obj1 = $result1->fetch_object();
$obj2 = $result2->fetch_object();

$mysql_qry = "insert into transaction(id_user1, id_user2, cash) values ('$obj1->id', '$obj2->id', '$cash');";
if ($conn->query($mysql_qry) == TRUE) {
    echo "SUCCESS";
}
else {
    echo "Error :" . $mysql_qry . "<br>" . $conn->error;
}
$conn->close();
?>