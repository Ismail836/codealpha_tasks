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

    public void buyStock(String symbol, int quantity, double price) {
        double cost = quantity * price;
        if (cost > balance) {
            System.out.println("Insufficient funds!");
            return;
        }
        balance -= cost;
        stocks.put(symbol, stocks.getOrDefault(symbol, 0) + quantity);
        System.out.printf("Bought %d shares of %s at $%.2f per share.\n", quantity, symbol, price);
    }

}
