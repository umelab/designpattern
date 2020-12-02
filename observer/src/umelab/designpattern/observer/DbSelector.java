package umelab.designpattern.observer;

import java.io.IOException;

import umelab.csv.CSVReader;

public class DbSelector extends AbstractSubject {
    private static final int HOT_DAY = 30;
    private int temperature = 0;

    public int getStatus() {
        return temperature;
    }

    public void readCSV(String path, String encode) throws IOException {
        String tmp;
        int index = 7;
        CSVReader reader = new CSVReader(path, encode);

        while((tmp = reader.nextColumn(index)) != null) {
            System.out.println("token: " + tmp);
            temperature = Integer.parseInt(tmp);
            //condition
            if (temperature > HOT_DAY) {
                nofityObservers();
            }
        }
    }

    public boolean isFileCreated() {
        //for real world, check file timestamp for update though..
        return true;
    }
    public class DbState {
        private int recordCnt;


    }
}