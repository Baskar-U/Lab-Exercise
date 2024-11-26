<?php
$servername = "localhost";
$username = "root";
$password = "password";
$dbname = "yourDB";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Fetch data from a table (e.g., bookings)
$sql = "SELECT id, destination, adults, children FROM bookings";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // Output data of each row
    while($row = $result->fetch_assoc()) {
        echo "id: " . $row["id"]. " - Destination: " . $row["destination"]. " - Adults: " . $row["adults"]. " - Children: " . $row["children"]. "<br>";
    }
} else {
    echo "0 results";
}
$conn->close();
?>
