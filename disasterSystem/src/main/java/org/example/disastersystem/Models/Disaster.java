package org.example.disastersystem.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.List;

@Entity
@Table(name = "disaster_info")
public class Disaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Please select a valid Disaster")
    @Pattern(regexp = "^(?!Type Of Disaster$).*$", message = "Please select a valid Disaster")
    private String disasterType;
    @NotEmpty(message = "Enter the date")
    private String disasterDate;
    @NotEmpty(message = "Enter the time")
    private String disasterTime;
    @NotEmpty(message = "Please enter a brief description of the disaster you are facing")
    private String disasterDescription;
    @NotNull(message = "Please enter the affected number of individuals")
    private int affectedIndividuals;
    @NotEmpty(message = "Please select the urgency level")
    @Pattern(regexp = "^(?!Urgency Level$).*$", message = "Please select the urgency level")
    private String urgencyLevel;

    @Enumerated(EnumType.STRING)
    private ReportStatus status = ReportStatus.PENDING;

    @OneToMany(mappedBy = "disaster")
    private List<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotEmpty(message = "Please select a valid Disaster") @Pattern(regexp = "^(?!Type Of Disaster$).*$", message = "Please select a valid Disaster") String getDisasterType() {
        return disasterType;
    }

    public void setDisasterType(@NotEmpty(message = "Please select a valid Disaster") @Pattern(regexp = "^(?!Type Of Disaster$).*$", message = "Please select a valid Disaster") String disasterType) {
        this.disasterType = disasterType;
    }

    public @NotEmpty(message = "Enter the date") String getDisasterDate() {
        return disasterDate;
    }

    public void setDisasterDate(@NotEmpty(message = "Enter the date") String disasterDate) {
        this.disasterDate = disasterDate;
    }

    public @NotEmpty(message = "Enter the time") String getDisasterTime() {
        return disasterTime;
    }

    public void setDisasterTime(@NotEmpty(message = "Enter the time") String disasterTime) {
        this.disasterTime = disasterTime;
    }

    public @NotEmpty(message = "Please enter a brief description of the disaster you are facing") String getDisasterDescription() {
        return disasterDescription;
    }

    public void setDisasterDescription(@NotEmpty(message = "Please enter a brief description of the disaster you are facing") String disasterDescription) {
        this.disasterDescription = disasterDescription;
    }

    @NotNull(message = "Please enter the affected number of individuals")
    public int getAffectedIndividuals() {
        return affectedIndividuals;
    }

    public void setAffectedIndividuals(@NotNull(message = "Please enter the affected number of individuals") int affectedIndividuals) {
        this.affectedIndividuals = affectedIndividuals;
    }

    public @NotEmpty(message = "Please select the urgency level") @Pattern(regexp = "^(?!Urgency Level$).*$", message = "Please select the urgency level") String getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(@NotEmpty(message = "Please select the urgency level") @Pattern(regexp = "^(?!Urgency Level$).*$", message = "Please select the urgency level") String urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    public ReportStatus getStatus() {
        return status;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}