import java.util.Date;

public class Trade {
    private static int counter = 1;
    private String orderBook;
    private String sellingOrder;
    private String buyingOrder;
    private String date;
    private int id;

    public Trade(OrderBook orderBook, Order sellingOrder, Order buyingOrder)
    {
        this.orderBook = orderBook.toString();
        this.sellingOrder = sellingOrder.toString();
        this.buyingOrder = buyingOrder.toString();
        date = CurrentDate.getDate();
        id = counter;
        counter++;
    }

}
