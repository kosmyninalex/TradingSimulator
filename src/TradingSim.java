import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

public class TradingSim {
 //   static TradingGateway tradingGateway = TradingGateway.getInstance();




    public static void main(String[] args) {

        Logging.logEvent("Trading Simulator started");
        Logging.logEvent("Type help to see the list of available commands");
        System.out.println();
        Thread t1 = new Thread(MatchingEngine.getInstance());
        t1.start();
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


    public static void parseInput(String s) {
        try {
            String[] res = s.split(" ");
            String command = res[0].toLowerCase();
            switch (command) {
                case "add": {
                    TradingGateway.getInstance().addOrder(res[1], res[2], res[3], res[4]);
                    break;
                }
                case "print":
                {
                    TradingGateway.getInstance().getBothOrdersLists ();
                    break;
                }

                case "help":
                {
                    Logging.logEvent("called help command");
                    System.out.println ("------------------");
                    System.out.println ("Type add [OrderBook] [OrderType] [Price] [Quantity] for adding a new order. E.g.: 'add goog buy 50 20'");
                    System.out.println ("Type print for printing a full orders list for each of the Order Books");
                    System.out.println ("Type 'exit' to exit app");
                    System.out.println ("------------------");
                    break;
                }
                case "exit":
                {
                    System.out.println("Exiting");
                    Logging.logEvent("called exit command");
                    break;
                }
                default:
                {
                    Logging.logEvent("Invalid command. Please type -help for more information");
                    break;
                }



            }

        } catch (Exception e) {
            Logging.logEvent("Parsing failed with " + e.getStackTrace());
        }
    }
}
