import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TradingGateway {
    public static final TradingGateway tradingGateway = new TradingGateway();
    public static Map<String, OrderBook> map = new ConcurrentHashMap<>();

    private TradingGateway() {}

    public static TradingGateway getInstance()
    {
        return tradingGateway;
    }


    public void addOrder (String orderBookString, String orderType, String price, String quantity)
    {
       if (tradingGateway.map.containsKey(orderBookString)) {
                OrderBook orderBook = map.get(orderBookString);
                orderBook.addOrderToBook(orderType, price, quantity);
            } else {
                OrderBook orderBook = new OrderBook(orderBookString);
                map.put(orderBookString, orderBook);
                orderBook.addOrderToBook(orderType, price, quantity);
            }

    }


    // Debug method!!!
    public void getBothOrdersLists ()
    {
        if (!map.isEmpty()) {
            for (Map.Entry<String, OrderBook> entry : map.entrySet()) {
                OrderBook orderBook = entry.getValue();
                orderBook.printOrders();
            }
        }
        else System.out.println ("All order books are empty");

    }






    public void cancelOrder (OrderBook orderBook, int orderId)
    {

    }



}

