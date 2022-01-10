package ke.yh_world_enterprises.packagetrackingsystem.wrappers;

import java.io.Serializable;
import java.util.List;


public class ApproveWrapper implements Serializable {
    private List<String> ids;
    private String notes;
    private String id;

    public ApproveWrapper() {
    }

    public ApproveWrapper(List<String> ids, String notes) {
        this.ids = ids;
        this.notes = notes;
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public ApproveWrapper(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ApproveWrapper{" +
                "ids=" + ids +
                ", notes='" + notes + '\'' +
                '}';
    }
}
