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
