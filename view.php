<?php
require "conn.php";
$mysql_qry = "select * from access_table";
$result = mysqli_query($conn, $mysql_qry);
if (mysqli_num_rows($result) > 0) {
    
    // $rows = $result->fetch_all(MYSQLI_ASSOC);
    // print JSON_encode($rows);

    while ($obj = $result->fetch_object()) {
        echo $obj->username.' '.$obj->password."\n";
    }
}
else {
    echo "Error";
}

?>