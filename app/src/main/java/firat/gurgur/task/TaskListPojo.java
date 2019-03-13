package firat.gurgur.task;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
public class TaskListPojo {
    @SerializedName("Tasks")
    @Expose
    private List<Task> detailList = null;

    public List<Task> getDetailList() {
        return detailList;
    }

    public void setdetailList(List<Task> detailList) {
        this.detailList = detailList;
    }
}
