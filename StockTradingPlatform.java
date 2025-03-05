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

    public void sellStock(String symbol, int quantity) {
        if (!stocks.containsKey(symbol) || stocks.get(symbol) < quantity) {
            System.out.println("Not enough shares to sell!");
            return;
        }
        double price = getStockPrice(symbol);
        double earnings = quantity * price;
        balance += earnings;
        stocks.put(symbol, stocks.get(symbol) - quantity);
        if (stocks.get(symbol) == 0) {
            stocks.remove(symbol);
        }
        System.out.printf("Sold %d shares of %s at $%.2f per share.\n", quantity, symbol, price);
    }

    public void trackPortfolio(Map<String, Double> marketData) {
        System.out.println("\nPortfolio Summary:");
        System.out.printf("Balance: $%.2f\n", balance);
        double totalValue = balance;
        for (Map.Entry<String, Integer> entry : stocks.entrySet()) {
            String symbol = entry.getKey();
            int quantity = entry.getValue();
            double currentPrice = marketData.getOrDefault(symbol, 0.0);
            double value = quantity * currentPrice;
            totalValue += value;
            System.out.printf("%s: %d shares | Current Price: $%.2f | Value: $%.2f\n",
                    symbol, quantity, currentPrice, value);
        }
        System.out.printf("Total Portfolio Value: $%.2f\n", totalValue);
    }

    private double getStockPrice(String symbol) {
        // Simulate fetching the current price (for simplicity, assume it's fixed)
        Map<String, Double> prices = new HashMap<>();
        prices.put("AAPL", 150.0);
        prices.put("GOOGL", 2800.0);
        prices.put("AMZN", 3400.0);
        prices.put("TSLA", 700.0);
        prices.put("MSFT", 300.0);
        return prices.getOrDefault(symbol, 0.0);
    }
}

public class StockTradingPlatform {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Portfolio portfolio = new Portfolio();

        while (true) {
            System.out.println("\n--- Simple Stock Trading Platform ---");
            System.out.println("1. Buy Stocks");
            System.out.println("2. Sell Stocks");
            System.out.println("3. Track Portfolio");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter stock symbol: ");
                    String buySymbol = scanner.nextLine().toUpperCase();
                    System.out.print("Enter quantity to buy: ");
                    int buyQuantity = scanner.nextInt();
                    if (buyQuantity <= 0) {
                        System.out.println("Quantity must be positive!");
                        break;
                    }
                    double buyPrice = portfolio.getStockPrice(buySymbol);
                    if (buyPrice == 0.0) {
                        System.out.println("Invalid stock symbol!");
                        break;
                    }
                    portfolio.buyStock(buySymbol, buyQuantity, buyPrice);
                    break;

                case 2:
                    System.out.print("Enter stock symbol: ");
                    String sellSymbol = scanner.nextLine().toUpperCase();
                    System.out.print("Enter quantity to sell: ");
                    int sellQuantity = scanner.nextInt();
                    if (sellQuantity <= 0) {
                        System.out.println("Quantity must be positive!");
                        break;
                    }
                    portfolio.sellStock(sellSymbol, sellQuantity);
                    break;

                case 3:
                    portfolio.trackPortfolio(new HashMap<>()); // Simulate market data
                    break;

                case 4:
                    System.out.println("Exiting the platform. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}