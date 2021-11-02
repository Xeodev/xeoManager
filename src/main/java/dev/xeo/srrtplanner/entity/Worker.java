package dev.xeo.srrtplanner.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "worker")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "Last name field required")
    @Column(name = "last_name")
    private String lastName;


    @Column(name = "phone_number")
    private String phoneNumber;

    @NotEmpty(message = "Agency field required")
    @Column(name = "agency")
    private String agency;

    @NotEmpty(message = "Location field required")
    @Column(name = "location")
    private String location;

    @NotEmpty(message = "Date field required")
    @Column(name = "date")
    private String date;

    @NotEmpty(message = "Start time  required")
    @Column(name = "start_time")
    private String startTime;


    @Column(name = "hours_worked")
    @Min(value = 1)
    @Max(value = 9)
    private String hoursWorked;

    //Default constructor
    public Worker() {
    }

    //All args constructor

    public Worker(int id, String firstName, String lastName, String phoneNumber, String agency, String location, String date, String startTime, String hoursWorked) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.agency = agency;
        this.location = location;
        this.date = date;
        this.startTime = startTime;
        this.hoursWorked = hoursWorked;
    }


    //Custom constructor

    public Worker(String firstName, String lastName, String phoneNumber, String agency, String location, String date, String startTime, String hoursWorked) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.agency = agency;
        this.location = location;
        this.date = date;
        this.startTime = startTime;
        this.hoursWorked = hoursWorked;
    }


    //Getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(String hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", agency='" + agency + '\'' +
                ", location='" + location + '\'' +
                ", date='" + date + '\'' +
                ", startTime='" + startTime + '\'' +
                ", hoursWorked='" + hoursWorked + '\'' +
                '}';
    }
}
