<?php
$xml = simplexml_load_file("data.xml") or die("Error: Cannot create object");

foreach($xml->children() as $booking) {
    echo "ID: " . $booking->id . "<br>";
    echo "Destination: " . $booking->destination . "<br>";
    echo "Adults: " . $booking->adults . "<br>";
    echo "Children: " . $booking->children . "<br><br>";
}
?>
