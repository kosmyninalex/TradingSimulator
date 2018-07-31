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
        ordersList.add(new Order(this, OrderType.valueOf(orderType), Integer.parseInt(quantity), Integer.parseInt(price)));
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
