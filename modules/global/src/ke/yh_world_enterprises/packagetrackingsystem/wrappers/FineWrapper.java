package ke.yh_world_enterprises.packagetrackingsystem.wrappers;

import java.io.Serializable;
import java.util.List;

public class FineWrapper  implements Serializable {
    private List<String> ids;
    private String notes;
    private String id;
    private String amount;
    private String PhoneNumber;

    public FineWrapper() {
    }

    public FineWrapper(List<String> ids, String notes, String id, String amount,String PhoneNumber) {
        this.ids = ids;
        this.notes = notes;
        this.id = id;
        this.amount = amount;
        this.PhoneNumber=PhoneNumber;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "FineWrapper{" +
                "ids=" + ids +
                ", notes='" + notes + '\'' +
                ", id='" + id + '\'' +
                ", amount=" + amount +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                '}';
    }
}
