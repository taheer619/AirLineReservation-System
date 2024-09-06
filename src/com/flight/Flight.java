package com.flight;
public class Flight {
    private String flightNumber;
    private String destination;
    private int capacity;
    private int seatsAvailable;

    public Flight(String flightNumber, String destination, int capacity) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.capacity = capacity;
        this.seatsAvailable = capacity;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public boolean reserveSeat() {
        if (seatsAvailable > 0) {
            seatsAvailable--;
            return true;
        }
        return false;
    }

    public void cancelSeat() {
        if (seatsAvailable < capacity) {
            seatsAvailable++;
        }
    }

    @Override
    public String toString() {
        return "Flight " + flightNumber + " to " + destination + " (" + seatsAvailable + "/" + capacity + " available)";
    }
}
