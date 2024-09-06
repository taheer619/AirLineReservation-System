package com.main;

import com.Flight;
import models.Passenger;
import models.Reservation;
import services.ReservationService;
import database.Database;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        ReservationService reservationService = new ReservationService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Airline Reservation System!");
        while (true) {
            System.out.println("\n1. View available flights");
            System.out.println("2. Make a reservation");
            System.out.println("3. Cancel a reservation");
            System.out.println("4. View all reservations");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Available Flights:");
                    for (Flight flight : database.getFlights()) {
                        System.out.println(flight);
                    }
                    break;
                case 2:
                    System.out.print("Enter flight number: ");
                    String flightNumber = scanner.nextLine();
                    Flight flight = database.findFlightByNumber(flightNumber);
                    if (flight != null) {
                        System.out.print("Enter passenger name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter passport number: ");
                        String passportNumber = scanner.nextLine();
                        Passenger passenger = new Passenger(name, passportNumber);
                        reservationService.makeReservation(passenger, flight);
                    } else {
                        System.out.println("Flight not found.");
                    }
                    break;
                case 3:
                    System.out.println("Feature to cancel reservations not implemented yet.");
                    break;
                case 4:
                    System.out.println("All Reservations:");
                    for (Reservation reservation : reservationService.getAllReservations()) {
                        System.out.println(reservation);
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
