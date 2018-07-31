public class MatchingEngine implements Runnable {
    private static final MatchingEngine matchingEngine = new MatchingEngine();

    private MatchingEngine() {}

    public static MatchingEngine getInstance() {
        return matchingEngine;
    }

    @Override
    public void run() {
        while (true) {
        //    System.out.println("Matching engine");
        //    System.out.println("Matching process");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
    }
}
