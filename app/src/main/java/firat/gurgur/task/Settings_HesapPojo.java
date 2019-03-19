package firat.gurgur.task;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Settings_HesapPojo {
    @SerializedName("Hesap")
    @Expose
    private List<Settings_Hesap> detailList = null;

    public List<Settings_Hesap> getDetailList() {
        return detailList;
    }

    public void setdetailList(List<Settings_Hesap> detailList) {
        this.detailList = detailList;
    }
}
