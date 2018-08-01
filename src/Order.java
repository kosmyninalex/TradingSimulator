public class Order implements Comparable <Order>{
    private static int counter = 1;
    private int id;
    private OrderType orderType;
    private int quantity;
    private int price;
    private OrderBook orderBook;
    private boolean isCompleted;
    private boolean isPartlyCompleted;

    public Order (OrderBook orderBook, OrderType orderType, int price, int quantity)
    {
        this.orderBook = orderBook;
        this.orderType = orderType;
        this.quantity = quantity;
        this.price = price;
        id = counter;
        counter++;
        isCompleted = false;
        isPartlyCompleted = false;
        Logging.logEvent("Order with ID " + id + " added. " + "Order book: " + orderBook + ". Order type: " + orderType + ". Price: " + price + ". Quantity: " + quantity + ".");
    }

    public void setPartlyCompletedState ()
    {
        isPartlyCompleted = true;
    }

    public boolean getPartlyCompletedState ()
    {
        return isPartlyCompleted;
    }

    public void setCompletedState ()
    {
        isCompleted = true;
    }

    public boolean getCompletedState ()
    {
        return isCompleted;
    }


    public OrderType getOrderType() {
        return orderType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }


    public OrderBook getOrderBook() {
        return orderBook;
    }

    public void setOrderBook(OrderBook orderBook) {
        this.orderBook = orderBook;
    }

    public String toString ()
    {
        return "id: " + id + " " + orderBook + " " + orderType.toString() + " " + "price is: " + price + " " + "quantity " + quantity + " is completed state: " + isCompleted; }

    @Override
    public int compareTo(Order o) {
        return price - o.price;

    }
}
