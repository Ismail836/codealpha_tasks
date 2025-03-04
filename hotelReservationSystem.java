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

}
