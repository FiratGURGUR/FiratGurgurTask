package firat.gurgur.task;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fav {
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("meter")
    @Expose
    public String meter;
    @SerializedName("rate")
    @Expose
    public String rate;
    @SerializedName("lastTime")
    @Expose
    public String lastTime;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getMeter() {
        return meter;
    }

    public void setMeter(String meter) {
        this.meter = meter;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }
}
