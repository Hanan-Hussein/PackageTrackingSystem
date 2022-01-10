package ke.yh_world_enterprises.packagetrackingsystem.wrappers;

import java.io.Serializable;

public class FirstTimeChangePassword implements Serializable {
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;
    private String email;

    public FirstTimeChangePassword(String newPassword, String confirmPassword, String email, String oldPassword) {
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
        this.email = email;
        this.oldPassword=oldPassword;
    }

    public FirstTimeChangePassword() {
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
}
