package ke.yh_world_enterprises.packagetrackingsystem.entity;

import com.haulmont.cuba.core.entity.annotation.PublishEntityChangedEvents;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;

@PublishEntityChangedEvents
@Entity(name = "packagetrackingsystem_Admin")
public class Admin extends User {
    private static final long serialVersionUID = -649691568151041398L;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "NATIONAL_ID")
    private String nationalId;

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @PrePersist
    public void prePersist() {
        active=true;
    }
}