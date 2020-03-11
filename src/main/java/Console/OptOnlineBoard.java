package Console;

import Controller.FlightController;

public class OptOnlineBoard implements Option {
    final String DASHES = new String(new char[82]).replace("\0", "-");
    @Override
    public int optNumber() {
        return 1;
    }

    @Override
    public String text() {
        return "Online-board";
    }

    @Override
    public void execution() {
        System.out.println("ONLINE-BOARD");
        System.out.println(DASHES);
        System.out.println(String.format("| %-10s | %-8s | %-15s | %-28s | %-5s |", "FlightID", "Date", "Destination", "Airline", "Seats"));
        System.out.println(DASHES);
        fc.displayAllFlights();
    }
}