package app;

import db.SnowMonitorDAO;
import obj.SnowMonitor;

import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        System.out.println("--- INSERT ---");
        SnowMonitor newSnowMonitor = new SnowMonitor(-1, "Falkert", 125, LocalDate.of(2017, 03, 13));
        SnowMonitorDAO.insertData(newSnowMonitor);
        ArrayList<SnowMonitor> snowMonitorArrayList = SnowMonitorDAO.getAllEntries();
        for (SnowMonitor s: snowMonitorArrayList
             ) {
            System.out.println(s);
        }
    }
}
