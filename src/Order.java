public class Order implements Comparable <Order>{
    private static int counter = 1;
    private int id;
    private OrderType orderType;
    private int quantity;
    private int price;
    private OrderBook orderBook;

    public Order (OrderBook orderBook, OrderType orderType, int quantity, int price)
    {
        this.orderBook = orderBook;
        this.orderType = orderType;
        this.quantity = quantity;
        this.price = price;
        id = counter;
        counter++;
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
        return "id: " + id + " " + orderBook + " " + orderType.toString() + " " + quantity + " " + price;
    }

    @Override
    public int compareTo(Order o) {
        return price - o.price;

    }
}
