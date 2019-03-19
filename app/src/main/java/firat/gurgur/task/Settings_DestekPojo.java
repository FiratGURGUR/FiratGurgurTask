package firat.gurgur.task;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Settings_DestekPojo {
    @SerializedName("Destek")
    @Expose
    private List<Settings_Destek> detailList = null;

    public List<Settings_Destek> getDetailList() {
        return detailList;
    }

    public void setdetailList(List<Settings_Destek> detailList) {
        this.detailList = detailList;
    }
}
