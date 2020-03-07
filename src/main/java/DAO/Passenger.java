package DAO;

import java.util.Objects;

public class Passenger {

    String name;
    String lastname;
    int passportId;
    int pass_ID;

    private static int count = 0;

    {
        this.pass_ID = ++count;
    }


    public String displayPassengerInfo(){
        return String.format("| %-8d |%-12s |%-15s |%-10s |", pass_ID,name,lastname,passportId);

    }

    public Passenger(int pass_ID,String name, String lastname,int passportId) {
        this.name = name;
        this.lastname = lastname;
       this.pass_ID=pass_ID;
        this.passportId=passportId;

    }
    public static Passenger parse(String text) {
        String[] content = text.split("|");
        return new Passenger(
                Integer.parseInt(content[0]),
                content[1],
                content[2],
                Integer.parseInt(content[3])

        );
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return passportId == passenger.passportId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(passportId);
    }
}
