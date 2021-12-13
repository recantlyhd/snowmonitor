package db;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import obj.SnowMonitor;

public class SnowMonitorDAO {
    static Connection con;
    static Statement stmt;

    public static int insertData(SnowMonitor snowMonitor) {

        String sql = "INSERT INTO SnowMonitor (ort, snowdepth, date) VALUES (?, ?, ?)";

        try (PreparedStatement pst = DbConnection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pst.setString(1, snowMonitor.getOrt());
            pst.setInt(2, snowMonitor.getSnowDepth());
            pst.setDate(3, Date.valueOf(snowMonitor.getDate()));

            int retVal = pst.executeUpdate();

            ResultSet rset = pst.getGeneratedKeys();

            if (rset.next()) {
                int id = rset.getInt(1);
                snowMonitor.setId(id);
                System.out.println(id);
            }

            return retVal;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public static ArrayList<SnowMonitor> getAllEntries() {
        ArrayList<SnowMonitor> snowMonitorArrayList = new ArrayList<SnowMonitor>();
        try {
            con = DbConnection.getConnection();
            stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * from SnowMonitor;");

            while(results.next()){
                int id = results.getInt(1);
                String ort = results.getString(2);
                int snowdepth = results.getInt(3);
                LocalDate date = results.getDate(4).toLocalDate();

                SnowMonitor newDate = new SnowMonitor(id, ort, snowdepth, date);

                snowMonitorArrayList.add(newDate);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return snowMonitorArrayList;
    }
}