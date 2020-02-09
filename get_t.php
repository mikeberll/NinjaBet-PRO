<?php
require "conn.php";
$mysql_qry1 = "select * from access_table";

$result1 = mysqli_query($conn, $mysql_qry1);

if ((mysqli_num_rows($result1) > 0)) {
    
    // $rows = $result->fetch_all(MYSQLI_ASSOC);
    // print JSON_encode($rows);

    while($obj1 = $result1->fetch_object())
        echo $obj1->id."\n";
}
else {
    echo "Error";
}

?>