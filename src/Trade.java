import java.util.Date;

public class Trade {
    private OrderBook orderBook;
    private Order sellingOrder;
    private Order buyingOrder;
    private String date;

    private Trade(OrderBook orderBook, Order sellingOrder, Order buyingOrder)
    {
        this.orderBook = orderBook;
        this.sellingOrder = sellingOrder;
        this.buyingOrder = buyingOrder;
        date = CurrentDate.getDate();
    }



}
