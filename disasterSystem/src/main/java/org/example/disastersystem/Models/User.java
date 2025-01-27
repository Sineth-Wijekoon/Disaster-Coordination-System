package org.example.disastersystem.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "userInfo")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Full name cannot be empty")
    private String fullName;
    @Pattern(regexp = "^\\d{9}$", message = "Please enter a valid phone number")
    private String phoneNumber;
    @Email(message = "Please enter a valid email address")
    private String emailAddress;
    @Pattern(regexp = "^[0-9]{9}[vV]$", message = "Please enter a valid nic number")
    private String nic;
    @NotEmpty(message = "Please enter a valid street address")
    private String streetAddress;
    @NotEmpty(message = "Please enter a valid Grama Niladhari Division")
    private String gramaDivision;
    @NotEmpty(message = "Please enter a valid District")
    @Pattern(regexp = "^(?!Select District$).*$", message = "Please select a valid district")
    private String district;
    @NotEmpty(message = "Please enter a valid Province")
    @Pattern(regexp = "^(?!Select Province$).*$", message = "Please select a valid province")
    private String province;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "disaster_id")
    private Disaster disaster;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotEmpty(message = "Full name cannot be empty") String getFullName() {
        return fullName;
    }

    public void setFullName(@NotEmpty(message = "Full name cannot be empty") String fullName) {
        this.fullName = fullName;
    }

    public @Pattern(regexp = "^\\d{9}$", message = "Please enter a valid phone number") String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@Pattern(regexp = "^\\d{9}$", message = "Please enter a valid phone number") String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public @Pattern(regexp = "^[0-9]{9}[vV]$", message = "Please enter a valid nic number") String getNic() {
        return nic;
    }

    public void setNic(@Pattern(regexp = "^[0-9]{9}[vV]$", message = "Please enter a valid nic number") String nic) {
        this.nic = nic;
    }

    public @Email(message = "Please enter a valid email address") String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(@Email(message = "Please enter a valid email address") String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public @NotEmpty(message = "Please enter a valid street address") String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(@NotEmpty(message = "Please enter a valid street address") String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public @NotEmpty(message = "Please enter a valid Grama Niladhari Division") String getGramaDivision() {
        return gramaDivision;
    }

    public void setGramaDivision(@NotEmpty(message = "Please enter a valid Grama Niladhari Division") String gramaDivision) {
        this.gramaDivision = gramaDivision;
    }

    public @NotEmpty(message = "Please enter a valid District") @Pattern(regexp = "^(?!Select District$).*$", message = "Please select a valid district") String getDistrict() {
        return district;
    }

    public void setDistrict(@NotEmpty(message = "Please enter a valid District") @Pattern(regexp = "^(?!Select District$).*$", message = "Please select a valid district") String district) {
        this.district = district;
    }

    public @NotEmpty(message = "Please enter a valid Province") @Pattern(regexp = "^(?!Select Province$).*$", message = "Please select a valid province") String getProvince() {
        return province;
    }

    public void setProvince(@NotEmpty(message = "Please enter a valid Province") @Pattern(regexp = "^(?!Select Province$).*$", message = "Please select a valid province") String province) {
        this.province = province;
    }

    public Disaster getDisaster() {
        return disaster;
    }

    public void setDisaster(Disaster disaster) {
        this.disaster = disaster;
    }
}
