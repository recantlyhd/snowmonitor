package obj;

import java.time.LocalDate;

public class SnowMonitor {
    private int id;
    private String ort;
    private int snowDepth;
    private LocalDate date;
    public SnowMonitor(int id, String ort, int snowDepth, LocalDate date) {
        this.id = id;
        this.ort = ort;
        this.snowDepth = snowDepth;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public int getSnowDepth() {
        return snowDepth;
    }

    public void setSnowDepth(int snowDepth) {
        this.snowDepth = snowDepth;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SnowMonitor{" +
                "id=" + id +
                ", ort='" + ort + '\'' +
                ", snowDepth=" + snowDepth +
                ", date=" + date +
                '}';
    }
}

