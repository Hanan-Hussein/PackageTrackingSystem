package ke.yh_world_enterprises.packagetrackingsystem.wrappers;

import java.io.Serializable;

public class ChangePasswordWrapper implements Serializable {
    private  String oldPass;
    private String newPassword;

    public ChangePasswordWrapper() {
    }

    public ChangePasswordWrapper(String oldPass, String newPassword) {
        this.oldPass = oldPass;
        this.newPassword = newPassword;
    }

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }


}
