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
        if (orderType1.equals(OrderType.SELL)) {
            ordersListSell.add(new Order(this, orderType1, Integer.parseInt(quantity), Integer.parseInt(price)));
        }
        else
        {
            orderListBuy.add(new Order(this, orderType1, Integer.parseInt(quantity), Integer.parseInt(price));
        }
    }

    public ArrayList<Order> getOrderList()
    {
        Collections.sort(ordersList);
        return ordersList;
    }

    public String toString ()
    {
        return this.name;
    }

    @Override
    public void run() {
        if (head == null)
        {head = ordersList.get(0);}


    }
}
