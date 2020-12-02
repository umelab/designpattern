package umelab.designpattern.observer;

import java.io.IOException;

/**
 * ObserverTest class
 * When the specified CSV file is created or updated, call readCSV method
 * Only when selector read more than 30 degree, Notify TempObserver instance. 
 *
 */
public class ObserverTest
{
    private static final int SLEEP_TIME = 500;

    public static void main( String[] args )
    {
        
        String path = "c:\\tools\\db_source.csv";
        String encode = "SJIS";
        boolean flg = false;
        TempObserver observer = new TempObserver();
        DbSelector selector = new DbSelector();
        selector.addObserver(observer);

        while(!flg) {
            try {
                if(selector.isFileCreated()) {
                    selector.readCSV(path, encode);
                }
                Thread.sleep(SLEEP_TIME);
            } catch (IOException e) { 
                e.printStackTrace();
                flg = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
                flg = true;
            }
        }
} 
    
}
