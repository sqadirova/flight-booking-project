package DAO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookingDAO implements DAO_B<Booking> {
    private File file;
   // List<Booking> bookings = new ArrayList<>();

    public BookingDAO(String filename) {
        file = new File(filename);
    }

    @Override
    public Optional<Booking> get(int id) {
        return getAll().stream().filter(x->x.idBooking==id).findAny();
    }



    @Override
    public ArrayList<Booking> getAll() {
        try {
            FileInputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            Object readed = ois.readObject();
            ArrayList<Booking> data = (ArrayList<Booking>) readed;
            ois.close();
            is.close();
            return data;
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<Booking>();
        }
    }

    @Override
    public void delete(int id) {
        List<Booking> listBookings = getAll().stream().filter(b -> !(b.idBooking == id)).collect(Collectors.toList());
        write(listBookings);
    }

    @Override
    public void deleteAll() {
        List<Booking> data=getAll();
        data.clear();
        write(data);

    }

    @Override
    public void save(Booking booking) {
        List<Booking> data = getAll();
        data.add(booking);
        write(data);
    }




    private void write(List<Booking> data) {
        try {
            FileOutputStream outputStream=new FileOutputStream(file);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(data);
            objectOutputStream.close();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException("IOException:", e);
        }
    }



}
