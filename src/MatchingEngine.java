import java.util.ArrayList;
import java.util.Map;

public class MatchingEngine implements Runnable {
    private static final MatchingEngine matchingEngine = new MatchingEngine();

    private MatchingEngine() {}

    public static MatchingEngine getInstance() {
        return matchingEngine;
    }

    @Override
    public void run() {
        while (true) {
        //    System.out.println("Matching engine");
        //    System.out.println("Matching process");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
    }

    public void processTradesInOrderBooks ()
    {
        for (Map.Entry<String, OrderBook> entry : TradingGateway.getInstance().map.entrySet()) {
            OrderBook orderBook = entry.getValue();
            matchTrades(orderBook);
        }
    }

    public void matchTrades(OrderBook orderBook)
    {
        ArrayList <Order> buyOrdersList = orderBook.getBuyOrdersList();
        ArrayList <Order> sellOrderList = orderBook.getSellOrdersList();

        for (int i=0; i < buyOrdersList.size(); i++)
        {
            for (int j=0; j < sellOrderList.size(); j++)
            buyOrdersList.get(i)
        }
    }
}
