import java.util.HashMap;
import java.util.Iterator;
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

    public void getBothOrdersLists ()
    {
        if (!map.isEmpty()) {
        Iterator<Map.Entry<String,OrderBook>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String,OrderBook> entry = iter.next();
            OrderBook orderBook = entry.getValue();
            if ((orderBook.getBuyOrdersList().isEmpty()) && ((orderBook.getSellOrdersList().isEmpty())) )
            {
                iter.remove();
            }
            else {
                orderBook.printOrders();
            }
        }}
        else System.out.println ("No Order Books found");



    }

}

