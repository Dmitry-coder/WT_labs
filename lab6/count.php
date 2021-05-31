<?php
$visit_count = 1;
$mysql = new mysqli("localhost", "mysql", "mysql", "datashow");
$mysql->query("SET NAMES 'utf8'");

if (isset($_COOKIE["visit_count"])) {
    $visit_count = $_COOKIE["visit_count"] + 1;
}
//echo date("Ymd");
setcookie("visit_count", $visit_count, /*time() + 2*/strtotime("+30 days"));

//$_COOKIE["visit_count"] = 0;s
print("Количество посещений: " . $visit_count);
$mysql->query("INSERT INTO `data` (`data`, `number`) VALUES (CURRENT_DATE(), '$visit_count')");
$res = mysqli_query($mysql, "SELECT * FROM `data`");
$tabl = '<table border="8">';
while ($row = mysqli_fetch_array($res))
    {
		$tabl .= '<tr>
			     <td style="border: 1px solid silver;">' . $row['data'] . '</td>
			     <td style="border: 1px solid silver;">' . $row['number'] . '</td>		     
			 </tr>';
	}
$tabl .= '</table>';
echo $tabl;
?>

