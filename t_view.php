<?php
require "conn.php";
$id_t = "1";//$_POST["id"];
$mysql_qry4 = "select * from transaction";
$result4 = mysqli_query($conn, $mysql_qry4);
while($obj4 = $result4->fetch_object()) {
    $mysql_qry3 = "select * from transaction where id_t = '$obj4->id_t';";
    $result3 = mysqli_query($conn, $mysql_qry3);
    $obj3 = $result3->fetch_object();


    $mysql_qry1 = "select * from access_table where id = '$obj3->id_user1';";
    $mysql_qry2 = "select * from access_table where id = '$obj3->id_user2';";

    $result1 = mysqli_query($conn, $mysql_qry1);
    $result2 = mysqli_query($conn, $mysql_qry2);

    if ((mysqli_num_rows($result1) > 0) && (mysqli_num_rows($result2) > 0)) {
    
    // $rows = $result->fetch_all(MYSQLI_ASSOC);
    // print JSON_encode($rows);

        $obj1 = $result1->fetch_object();
        $obj2 = $result2->fetch_object();
        echo $obj1->name.' '.$obj1->surname.' | '.$obj2->name.' '.$obj2->surname.' | '.$obj3->cash."\n";
    }   
    else {
        echo "Error";
    }
}

?>