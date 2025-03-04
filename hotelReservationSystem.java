import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

class Room {
    String number, type;   
    double price;
    boolean available;
    int capacity;

    public Room(String number, String type, double price, int capacity) {
        this.number = number;
        this.type = type;
        this.price = price;
        this.available = true;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Room " + number + " (" + type + "), Price: $" + price + ", Available: " + available;
    }
}

class Reservation {
    int id;
    Room room;
    LocalDate in, out;
    String name, email, status;
    double total;

    public Reservation(int id, Room room, LocalDate in, LocalDate out, String name, String email) {
        this.id = id;
        this.room = room;
        this.in = in;
        this.out = out;
        this.name = name;
        this.email = email;
        this.status = "Pending";
        this.total = room.price * ChronoUnit.DAYS.between(in, out);
    }

    @Override
    public String toString() {
        return "Reservation ID: " + id + ", Room: " + room.number + ", Total: $" + total + ", Payment: " + status;
    }
}

public class hotelReservationSystem {

    public static void main(String[] args) {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room("101", "Single", 100, 1));
        rooms.add(new Room("102", "Double", 150, 2));
        rooms.add(new Room("201", "Suite", 300, 4));

        LocalDate in = LocalDate.of(2024, 10, 26);
        LocalDate out = LocalDate.of(2024, 10, 28);

        List<Room> available = search(rooms, in, out, "Double", 2);
        System.out.println("Available Rooms:\n" + available);

        if (!available.isEmpty()) {
            Room selected = available.get(0);
            Reservation res = new Reservation(1, selected, in, out, "John Doe", "john.doe@example.com");
            System.out.println("\nReservation:\n" + res);
            selected.available = false;
            System.out.println("\nDouble room availability after reservation:\n"+ search(rooms,in,out,"Double",2));
        }
    }

