import java.util.ArrayList;
public class TradeLedger {
    private static final TradeLedger tradeLedger = new TradeLedger();
    private ArrayList <Trade> tradeList = new ArrayList<Trade>();

    private TradeLedger()
    {}

    public void addTrade (Trade trade)
    {
        Logging.logEvent(trade.toString());
        System.out.println();
        tradeList.add(trade);
    }

    public ArrayList <Trade> getTradeList ()
    {
        return tradeList;
    }

    public void printTrades ()
    {
        for (Trade i: tradeList)
        {
            System.out.println (i);
        }
    }

    public static TradeLedger getInstance()
    {
        return tradeLedger;
    }


}
