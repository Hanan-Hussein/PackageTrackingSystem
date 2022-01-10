package ke.yh_world_enterprises.packagetrackingsystem.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.util.Random;

@Table(name = "PACKAGETRACKINGSYSTEM_PACKAGE")
@Entity(name = "packagetrackingsystem_Package")
public class Package extends StandardEntity {
    private static final long serialVersionUID = -4084213912349217141L;

    @Column(name = "PACKAGE_DESCRIPTION")
    private String packageDescription;

    @Column(name = "DELIVERY_STAGE")
    private String deliveryStage;

    @Column(name = "DESTINATION_TO")
    private String destination_to;

    @Column(name = "RECIEVER_LAST_NAME")
    private String recieverLastName;

    @Column(name = "SENDER_LAST_NAME")
    private String senderLastName;

    @JoinColumn(name = "CUSTOMER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @Column(name = "COST_OF_PACKAGE")
    private String costOfPackage;

    @Column(name = "TRACKING_ID")
    private String trackingId;

    @Column(name = "RECEIVER_NAME")
    private String receiverFirstName;

    @Column(name = "RECEIVER_LAST_NAME")
    private String receiverLastName;

    @Column(name = "RECEIVER_EMAIL")
    private String receiverEmail;

    @Column(name = "SENDER_NAME")
    private String senderFirstName;

    @Column(name = "SENDER_EMAIL")
    private String senderEmail;

    @Column(name = "SENDER_NATIONAL_I")
    private String senderNationalId;

    @Column(name = "SENDER_PHONE_NUMBER")
    private String senderPhoneNumber;

    @Column(name = "DESTINATION")
    private String destination_from;

    public String getDeliveryStage() {
        return deliveryStage;
    }

    public void setDeliveryStage(String deliveryStage) {
        this.deliveryStage = deliveryStage;
    }

    public String getDestination_to() {
        return destination_to;
    }

    public void setDestination_to(String destination_to) {
        this.destination_to = destination_to;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public String getReceiverLastName() {
        return receiverLastName;
    }

    public void setReceiverLastName(String receiverLastName) {
        this.receiverLastName = receiverLastName;
    }

    public String getRecieverLastName() {
        return recieverLastName;
    }

    public void setRecieverLastName(String recieverLastName) {
        this.recieverLastName = recieverLastName;
    }

    public String getSenderLastName() {
        return senderLastName;
    }

    public void setSenderLastName(String senderLastName) {
        this.senderLastName = senderLastName;
    }

    public String getSenderPhoneNumber() {
        return senderPhoneNumber;
    }

    public void setSenderPhoneNumber(String senderPhoneNumber) {
        this.senderPhoneNumber = senderPhoneNumber;
    }

    public String getSenderNationalId() {
        return senderNationalId;
    }

    public void setSenderNationalId(String senderNationalId) {
        this.senderNationalId = senderNationalId;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDestination_from() {
        return destination_from;
    }

    public void setDestination_from(String destination_from) {
        this.destination_from = destination_from;
    }

    public String getSenderFirstName() {
        return senderFirstName;
    }

    public void setSenderFirstName(String senderFirstName) {
        this.senderFirstName = senderFirstName;
    }

    public String getReceiverFirstName() {
        return receiverFirstName;
    }

    public void setReceiverFirstName(String receiverFirstName) {
        this.receiverFirstName = receiverFirstName;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public String getCostOfPackage() {
        return costOfPackage;
    }

    public void setCostOfPackage(String costOfPackage) {
        this.costOfPackage = costOfPackage;
    }

    public String getPackageDescription() {
        return packageDescription;
    }

    public void setPackageDescription(String packageDescription) {
        this.packageDescription = packageDescription;
    }
    @PrePersist
    public void prePersist() {
        //create token
        Random random = new Random();
        trackingId = String.format("%06d", random.nextInt(10000));
        deliveryStage="Processing";
    }
}