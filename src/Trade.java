import java.util.Date;

public class Trade {
    private static int counter = 1;
    private String orderBook;
    private Order sellingOrder;
    private Order buyingOrder;
    private String date;
    private int id;
    private int sellingOldQuantity;
    private int buyingOldQuantity;
    private String stringRepresentation;

    public Trade(OrderBook orderBook, Order sellingOrder, Order buyingOrder, int sellingOldQuantity, int buyingOldQuantity)
    {
        this.orderBook = orderBook.toString();
        this.sellingOrder = sellingOrder;
        this.buyingOrder = buyingOrder;
        date = CurrentDate.getDate();
        id = counter;
        counter++;
        this.sellingOldQuantity = sellingOldQuantity;
        this.buyingOldQuantity = buyingOldQuantity;
        stringRepresentation = "New execution with ID: " + id + " Order book: " + orderBook + ". BUYING ORDER. ID: " + buyingOrder.getId() + ". Qty before: " + buyingOldQuantity + ". Qty after: " + buyingOrder.getQuantity() + ". Price: " + buyingOrder.getPrice() + " SELL ORDER. ID: " + sellingOrder.getId() + ". Qty before: " + sellingOldQuantity + ". Qty after: " + sellingOrder.getQuantity() + ". Price: " + sellingOrder.getPrice();
    }

    public String toString ()
    {
        return stringRepresentation;
    }

}

//Trade element class with methods