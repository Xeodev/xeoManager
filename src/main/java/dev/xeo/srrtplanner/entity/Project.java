package dev.xeo.srrtplanner.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="projects")
public class Project {

    // define fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty(message = "Project name required")
    @Column(name = "project_name")
    private String projectName;

    @Column(name = "description")
    private String description;

    @Column(name = "days")
    private String days;

    @Column(name = "price")
    private String price;


    @Column(name = "launch_date")
    private String launchDate;


    // define constructors


    public Project() {

    }

    public Project(int id, String projectName, String description, String days, String price, String launchDate) {
        this.id = id;
        this.projectName = projectName;
        this.description = description;
        this.days = days;
        this.price = price;
        this.launchDate = launchDate;
    }

    public Project(String projectName, String description, String days, String price, String launchDate) {
        this.projectName = projectName;
        this.description = description;
        this.days = days;
        this.price = price;
        this.launchDate = launchDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", description='" + description + '\'' +
                ", days='" + days + '\'' +
                ", price='" + price + '\'' +
                ", launchDate='" + launchDate + '\'' +
                '}';
    }
}














