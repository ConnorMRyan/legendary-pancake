package com.revature.models;

import com.revature.utils.ImageConvert;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "ers_reimbursement",schema = "reimb")

public class Reimbursement implements Serializable {
    @Id
    @Column(name = "reimb_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "reimb_amount")
    private int amount;
    @Column(name = "reimb_description")
    private String description;

    @Column(name = "reimb_resolved")
    private Timestamp resolved;
    @Column(name = "reimb_receipt")
    byte[] receipt;
    @Column(name = "reimb_author")
    int authorID;
    @Column(name = "reimb_resolver")
    Integer resolverID = null;
    @Column(name = "reimb_status_id")
    int status;
    @Column(name = "reimb_type_id")
    int type;

    public Reimbursement(Integer id, int amount,String description, Timestamp resolved, byte[] receipt, int authorID, int resolverID, int status, int type) {
        this.id = id;
        this.description = description;
        this.amount = amount;

        this.resolved = resolved;
        this.receipt = receipt;
        this.authorID = authorID;
        this.resolverID = resolverID;
        this.status = status;
        this.type = type;
    }
    public Reimbursement(int amount,String description, File imagePath, int authorID,int type) {
        this.amount = amount;
        this.description = description;
        this.receipt = ImageConvert.imageToArray(imagePath);
        this.authorID = authorID;
        this.type = type;
    }

    public Reimbursement(int ID){
        this.id = ID;
    }

    public Reimbursement() {}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public Timestamp getResolved() {
        return resolved;
    }

    public void setResolved(Timestamp resolved) {
        this.resolved = resolved;
    }

    public byte[] getReceipt() {
        return receipt;
    }

    public void setReceipt(byte[] reciept) {
        this.receipt = reciept;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public int getResolverID() {
        return resolverID;
    }

    public void setResolverID(int resolverID) {
        this.resolverID = resolverID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "id=" + id +
                ", amount=" + amount +
                ", resolved=" + resolved +
                ", reciept=" + Arrays.toString(receipt) +
                ", authorID=" + authorID +
                ", resolverID=" + resolverID +
                ", status=" + status +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reimbursement)) return false;
        Reimbursement that = (Reimbursement) o;
        return getAmount() == that.getAmount() &&
                getAuthorID() == that.getAuthorID() &&
                getResolverID() == that.getResolverID() &&
                getStatus() == that.getStatus() &&
                getType() == that.getType() &&
                Objects.equals(getId(), that.getId()) &&
                Objects.equals(getResolved(), that.getResolved()) &&
                Arrays.equals(getReceipt(), that.getReceipt());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getAmount(), getResolved(), getAuthorID(), getResolverID(), getStatus(), getType());
        result = 31 * result + Arrays.hashCode(getReceipt());
        return result;
    }
}
