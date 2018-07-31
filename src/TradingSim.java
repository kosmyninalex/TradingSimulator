import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TradingSim {
    static Map<String, OrderBook> map = new HashMap<>();

    public static void main(String[] args) {
        Logging.logEvent("Trading Simulator started");
        Logging.logEvent("Type -help to see the list of available commands");
        Thread t1 = new Thread(new MatchingEngine());
        t1.start();

        {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                while (true) {
                    String s = bufferedReader.readLine();
                    parseInput(s);
                    if (s.equals("exit")) {
                        System.exit(0);
                    }
                }

            } catch (Exception e) {
                Logging.logEvent("Failed with " + e.getStackTrace());
            }

        }
        //Don't forget to add -help!!!!!!!!111


    }

    public static void parseInput(String s) {
        try {
            String[] res = s.split(" ");
            if (res[0].toLowerCase().equals("add")) {
                if (map.containsKey(res[1])) {
                    OrderBook orderBook = map.get(res[1]);
                    orderBook.addOrder(res[2], res[3], res[4]);
                } else {
                    OrderBook orderBook = new OrderBook(res[1]);
                    map.put(res[1], orderBook);
                    orderBook.addOrder(res[2], res[3], res[4]);
                }
            }
            if (res[0].toLowerCase().equals("get"))
            {
                for (Map.Entry<String, OrderBook> entry : map.entrySet())
                {
                    OrderBook orderBook = entry.getValue();
                    for (Order i: orderBook.getOrderList())
                    {
                        System.out.println (i);
                    }
                }
            }
        } catch (Exception e) {
            Logging.logEvent("Parsing failed with " + e.getStackTrace());
        }
    }

}