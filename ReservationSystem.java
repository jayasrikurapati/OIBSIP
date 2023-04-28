HTML CODE

<!DOCTYPE html>
<html>
<head>
	<title>Student Result Management System</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div class="container">
		<h1>Student Result Management System</h1>
		<form action="process.php" method="POST">
			<label for="name">Student Name:</label>
			<input type="text" id="name" name="name" required>
			<br>
			<label for="roll">Roll Number:</label>
			<input type="text" id="roll" name="roll" required>
			<br>
			<label for="maths">Maths:</label>
			<input type="number" id="maths" name="maths" min="0" max="100" required>
			<br>
			<label for="science">Science:</label>
			<input type="number" id="science" name="science" min="0" max="100" required>
			<br>
			<label for="english">English:</label>
			<input type="number" id="english" name="english" min="0" max="100" required>
			<br>
			<input type="submit" value="Submit">
		</form>
	</div>

	<script src="script.js"></script>
</body>
</html>

STYLE.CSS

.container {
	max-width: 500px;
	margin: 0 auto;
}

h1 {
	text-align: center;
}

form {
	display: flex;
	flex-direction: column;
	align-items: center;
}

label {
	margin-bottom: 10px;
}

input[type="text"],
input[type="number"],
input[type="submit"] {
	padding: 5px;
	margin-bottom: 10px;
	width: 100%;
	box-sizing: border-box;
}

input[type="submit"] {
	background-color: #4CAF50;
	color: white;
	border: none;
	cursor: pointer;
}

SCRIPT.JS

// Prevent form submission if any input is invalid
const form = document.querySelector('form');
form.addEventListener('submit', (event) => {
    const inputs = event.target.querySelectorAll('input');
    let isFormValid = true;
    for (const input of inputs) {
        if (!input.checkValidity()) {
            isFormValid = false;
            break;
        }
    }
    if (!isFormValid) {
        event.preventDefault();
    }
});

// Show message after form submission
const urlParams = new URLSearchParams(window.location.search);
if (urlParams.get('result') === 'success') {
    const message = document.createElement('p');
    message.textContent = 'Result submitted successfully.';
    message.style.color = 'green';
    form.appendChild(message);
}
else if (urlParams.get('result') === 'error') {
    const message = document.createElement('p');
    message.textContent = 'There was an error submitting the result.';
    message.style.color = 'red';
    form.appendChild(message);
}

PROCESS.PHP

<?php
// Retrieve form data
$name = $_POST['name'];
$roll = $_POST['roll'];
$maths = $_POST['maths'];
$science = $_POST['science'];
$english = $_POST['english'];

// Calculate total and percentage
$total = $maths + $science + $english;
$percentage = round($total / 3, 2);

// Connect to database
$servername = "localhost";
$username = "username";




import java.util.ArrayList;
import java.util.Scanner;

public class ReservationSystem {
    private static ArrayList<String> reservations = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {
            System.out.println("Please choose an option:");
            System.out.println("1. Reserve a seat");
            System.out.println("2. Cancel a reservation");
            System.out.println("3. View reservations");
            System.out.println("4. Quit");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    reserveSeat();
                    break;
                case 2:
                    cancelReservation();
                    break;
                case 3:
                    viewReservations();
                    break;
                case 4:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }

        scanner.close();
    }

    private static void reserveSeat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name:");
        String name = scanner.nextLine();
        System.out.println("Please enter the seat number you want to reserve:");
        int seatNumber = scanner.nextInt();

        String reservation = name + " reserved seat " + seatNumber;

        if (reservations.contains(reservation)) {
            System.out.println("That seat is already reserved.");
        } else {
            reservations.add(reservation);
            System.out.println("Seat " + seatNumber + " reserved successfully.");
        }

        scanner.close();
    }

    private static void cancelReservation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name:");
        String name = scanner.nextLine();
        System.out.println("Please enter the seat number you want to cancel the reservation for:");
        int seatNumber = scanner.nextInt();

        String reservation = name + " reserved seat " + seatNumber;

        if (!reservations.contains(reservation)) {
            System.out.println("That reservation doesn't exist.");
        } else {
            reservations.remove(reservation);
            System.out.println("Reservation for seat " + seatNumber + " cancelled successfully.");
        }

        scanner.close();
    }

    private static void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("There are no reservations.");
        } else {
            System.out.println("Current reservations:");
            for (String reservation : reservations) {
                System.out.println(reservation);
            }
        }
    }
}
