import java.util.ArrayList;
import java.util.Collections;

public class OrderBook implements Runnable {
    private String name;
    private ArrayList<Order> ordersList = new ArrayList<Order>();
    Order head;
    private ArrayList<Order> ordersListSell = new ArrayList<Order>();
    private ArrayList<Order> orderListBuy = new ArrayList<Order>();

    public OrderBook(String name) {
        this.name = name;
    }

    public void addOrder (String orderType, String quantity, String price)
    {
        orderType = orderType.toUpperCase();
        OrderType orderType1 = OrderType.valueOf(orderType);
        Order order = (new Order(this, orderType1, Integer.parseInt(quantity), Integer.parseInt(price)));
        if (orderType1.equals(OrderType.SELL)) {
            ordersListSell.add(order);
        }
        else
        {
            orderListBuy.add(order);
        }
        ordersList.add(order);
    }

    public ArrayList<Order> getOrderList()
    {
        return ordersList;
    }

    public void orderBooksSort ()
    {
        Collections.sort(orderListBuy);
        Collections.sort(ordersListSell);
    }

    public String toString ()
    {
        return this.name;
    }

    public Order getOrderById (int id)
    {
        try {
            return ordersList.get(id - 1);
        }
        catch (Exception e)
        {
            Logging.logEvent("Error receiving utility.Order by ID");
            return null;
        }
    }

    @Override
    public void run() {
        if (head == null)
        {head = ordersList.get(0);}


    }
}
