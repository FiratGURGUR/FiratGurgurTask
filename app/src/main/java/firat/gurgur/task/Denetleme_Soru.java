package firat.gurgur.task;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Denetleme_Soru {
    @SerializedName("soru")
    @Expose
    public String soru;
    @SerializedName("puan")
    @Expose
    public String puan;



    public String getSoru() {
        return soru;
    }

    public void setSoru(String soru) {
        this.soru = soru;
    }

    public String getPuan() {
        return puan;
    }

    public void setName(String puan) {
        this.puan = puan;
    }

}
