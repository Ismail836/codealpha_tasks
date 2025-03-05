import java.util.*;

class Stock {
    String symbol;
    double price;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }
}

class Portfolio {
    private Map<String, Integer> stocks; // {symbol: quantity}
    private double balance;

    public Portfolio() {
        this.stocks = new HashMap<>();
        this.balance = 10000; // Starting balance
    }
}
