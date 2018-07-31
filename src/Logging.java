import java.io.*;
public class Logging {
    // private static int eventID = 0;
    private static String fileName = "log.txt";
    public static void logEvent (String s)
    {
        String res = "TradingSimulator: " +  CurrentDate.getDate() + ". Event: " + s;

        try {
            PrintWriter fileOutputStream = new PrintWriter(new FileOutputStream(new File(fileName), true));
            fileOutputStream.write(res + "\r\n");
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println ("Something bad has happened in the logger");
            e.printStackTrace();
        }

        System.out.print (res);


    }
}

//Class with logging method that prints String argument to console and append its as a new line to the end of file