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

            for (Map.Entry<String, OrderBook> entry : TradingGateway.getInstance().map.entrySet()) {
                OrderBook orderBook = entry.getValue();
                matchTrades(orderBook);
            }
        //    Logging.logEvent("Matching engine is working");
       try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
    }

    public void matchTrades(OrderBook orderBook)
    {
        ArrayList <Order> buyOrdersList = orderBook.getBuyOrdersList();
        ArrayList <Order> sellOrderList = orderBook.getSellOrdersList();

        for (int i=0; i < buyOrdersList.size(); i++) {
            Order buyOrder = buyOrdersList.get(i);
            if (buyOrder.getCompletedState() == false)
            {
                for (int j=0; j < sellOrderList.size(); j++)
                {
                Order sellOrder = sellOrderList.get(j);
                if ((sellOrder.getCompletedState() == false) && (buyOrder.getCompletedState() == false)) {
                    if (buyOrder.getPrice() >= sellOrder.getPrice()) {
                        int oldSellingQuantity = sellOrder.getQuantity();
                        int oldBuyingQuatity = buyOrder.getQuantity();
                        int quantityDiff = sellOrder.getQuantity() - buyOrder.getQuantity();
                        if (quantityDiff == 0) {
                            buyOrder.setCompletedState();
                            sellOrder.setCompletedState();
                            buyOrder.setQuantity(0);
                            sellOrder.setQuantity(0);
                        }
                        if (quantityDiff > 0)
                        {
                            buyOrder.setCompletedState();
                            buyOrder.setQuantity(0);
                            sellOrder.setQuantity(quantityDiff);
                        }
                        if (quantityDiff < 0)
                        {
                            sellOrder.setCompletedState();
                            sellOrder.setQuantity(0);
                            buyOrder.setQuantity(quantityDiff * (-1));
                        }
                        Trade trade = new Trade(orderBook, sellOrder, buyOrder, oldSellingQuantity, oldBuyingQuatity);
                        TradeLedger.getInstance().addTrade(trade);
                        }


                    }
                }
            }
            }
        }
    }

// MatchingEngine class with balancing that runs in a second (non-main) thread