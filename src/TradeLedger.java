import java.util.ArrayList;
public class TradeLedger {
    private static final TradeLedger tradeLedger = new TradeLedger();
    private ArrayList <Trade> tradeList = new ArrayList<Trade>();

    private TradeLedger()
    {}

    public void addTrade (Trade trade)
    {
        tradeList.add(trade);
    }

    public ArrayList <Trade> getTradeList ()
    {
        return tradeList;
    }

    public static TradeLedger getInstance()
    {
        return tradeLedger;
    }

    public void processTrades ()
    {

    }


}
