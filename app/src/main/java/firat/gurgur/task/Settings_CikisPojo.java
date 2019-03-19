package firat.gurgur.task;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Settings_CikisPojo {
    @SerializedName("Cikis")
    @Expose
    private List<Settings_Cikis> detailList = null;

    public List<Settings_Cikis> getDetailList() {
        return detailList;
    }

    public void setdetailList(List<Settings_Cikis> detailList) {
        this.detailList = detailList;
    }
}
