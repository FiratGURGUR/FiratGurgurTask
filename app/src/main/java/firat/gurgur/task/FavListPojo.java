package firat.gurgur.task;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FavListPojo {
    @SerializedName("Favs")
    @Expose
    private List<Fav> detailList = null;

    public List<Fav> getDetailList() {
        return detailList;
    }

    public void setdetailList(List<Fav> detailList) {
        this.detailList = detailList;
    }
}
