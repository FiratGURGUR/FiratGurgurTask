package firat.gurgur.task;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ComListPojo {
    @SerializedName("Comments")
    @Expose
    private List<Comment> detailList = null;

    public List<Comment> getDetailList() {
        return detailList;
    }

    public void setdetailList(List<Comment> detailList) {
        this.detailList = detailList;
    }
}
