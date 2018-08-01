import java.util.ArrayList;
import java.util.Collections;

public class OrderBook{
    private String name;
    private ArrayList<Order> ordersList = new ArrayList<Order>();
    Order head;
    private ArrayList<Order> ordersListSell = new ArrayList<Order>();
    private ArrayList<Order> orderListBuy = new ArrayList<Order>();

    public OrderBook(String name) {
        this.name = name;
    }

    public void addOrderToBook (String orderType, String quantity, String price)
    {
        orderType = orderType.toUpperCase();
        OrderType orderType1 = OrderType.valueOf(orderType);
        Order order = (new Order(this, orderType1, Integer.parseInt(quantity), Integer.parseInt(price)));
        if (orderType1.equals(OrderType.SELL)) {
            ordersListSell.add(order);
            Collections.sort(ordersListSell);
        }
        else
        {
            orderListBuy.add(order);
            Collections.sort(orderListBuy);
        }
        ordersList.add(order);
    }

    public ArrayList<Order> getOrderList()
    {
        return ordersList;
    }

    public void printOrders ()
    {
        System.out.println ("----------- Order Book: " + this + "-----------");
        if (!orderListBuy.isEmpty()) {
            System.out.println("List of buying orders");
            for (Order i : orderListBuy) {
                System.out.println(i);
            }
        }
        else System.out.println ("List of buying orders is empty");

        if (!ordersListSell.isEmpty()) {
            System.out.println("List of selling orders");
            for (Order i : ordersListSell) {
                System.out.println(i);
            }
        }
        else
        {
            System.out.println ("List of selling orders is empty");
        }
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

    public ArrayList<Order> getBuyOrdersList ()
    {
        Collections.sort(orderListBuy);
        for (int i=0; i<orderListBuy.size(); i++)
        {
            if (orderListBuy.get(i).getCompletedState() == true)
            {
                orderListBuy.remove(i);
            }
        }
        return orderListBuy;
    }

    public ArrayList<Order> getSellOrdersList ()
    {
        Collections.sort(ordersListSell);

        for (int i=0; i<ordersListSell.size(); i++)
        {
            if (ordersListSell.get(i).getCompletedState() == true)
            {
                ordersListSell.remove(i);
            }
        }
        return ordersListSell;
    }
}

