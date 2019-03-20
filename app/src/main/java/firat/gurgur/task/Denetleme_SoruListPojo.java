package firat.gurgur.task;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Denetleme_SoruListPojo {
    @SerializedName("Denetleme")
    @Expose
    private List<Denetleme_Soru> detailList = null;

    public List<Denetleme_Soru> getDetailList() {
        return detailList;
    }

    public void setdetailList(List<Denetleme_Soru> detailList) {
        this.detailList = detailList;
    }
}
