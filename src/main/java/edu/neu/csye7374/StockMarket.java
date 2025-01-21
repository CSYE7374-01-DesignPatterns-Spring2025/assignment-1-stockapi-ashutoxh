package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {

    private static StockMarket instance;
    private final List<StockAPI> stocks;

    private StockMarket() {
        stocks = new ArrayList<>();
    }

    public static StockMarket getInstance() {
        if (instance == null) {
            synchronized (StockMarket.class) {
                if (instance == null) {
                    instance = new StockMarket();
                }
            }
        }
        return instance;
    }

    public void addStock(StockAPI stock) {
        stocks.add(stock);
    }

    public void showStocks() {
        for (Tradable stock : stocks) {
            System.out.println(stock);
        }
    }

    public void tradeStocks(String name, String bid) {
        for (StockAPI stock : stocks) {
            if(stock.getName().equals(name))
                stock.setBid(bid);
        }
    }

    public void removeStock(String name) {
        int index = -1;
        for (int i=0; i < stocks.size(); i++) {
            if(stocks.get(i).getName().equals(name))
                index = i;
        }
        if(index != -1)
            stocks.remove(index);
    }

    public void startTrade() {
        addStock(new TSLAStock("Tesla Inc", 50, "TSLA"));
        addStock(new NVDIAStock("NVDIA Corp", 150, "NVDIA"));
        System.out.println("=== Stocks in the market ===");
        showStocks();

        tradeStocks("Tesla Inc", "45");
        tradeStocks("NVDIA Corp", "135");
        System.out.println("=== After Bid 1 ===");
        showStocks();

        tradeStocks("Tesla Inc", "42");
        tradeStocks("NVDIA Corp", "132");
        System.out.println("=== After Bid 2 ===");
        showStocks();

        tradeStocks("Tesla Inc", "33");
        tradeStocks("NVDIA Corp", "146");
        System.out.println("=== After Bid 3 ===");
        showStocks();

        tradeStocks("Tesla Inc", "35");
        tradeStocks("NVDIA Corp", "149");
        System.out.println("=== After Bid 4 ===");
        showStocks();

        tradeStocks("Tesla Inc", "44");
        tradeStocks("NVDIA Corp", "170");
        System.out.println("=== After Bid 5 ===");
        showStocks();

        tradeStocks("Tesla Inc", "56");
        tradeStocks("NVDIA Corp", "150");
        System.out.println("=== After Bid 6 ===");
        showStocks();

        removeStock("Tesla Inc");
        System.out.println("=== After removing stock - Tesla Inc ===");
        showStocks();
    }


}
