package dev.xeo.srrtplanner.entity;

import javax.persistence.*;


@Entity
@Table(name = "invoices")
public class Invoice {


    // define fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "email")
    private String email;


    @Column(name = "reference")
    private String reference;


    @Column(name = "amount")
    private int amount;


    @Column(name = "status")
    private String status;

    public Invoice() {

    }

    public Invoice(int id, String customerName, String email, String reference, int amount, String status) {
        this.id = id;
        this.customerName = customerName;
        this.email = email;
        this.reference = reference;
        this.amount = amount;
        this.status = status;
    }

    public Invoice(String customerName, String email, String reference, int amount, String status) {
        this.customerName = customerName;
        this.email = email;
        this.reference = reference;
        this.amount = amount;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", reference='" + reference + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}
