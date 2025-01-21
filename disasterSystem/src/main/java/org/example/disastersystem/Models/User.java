package org.example.disastersystem.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotEmpty(message = "Full name cannot be empty")
    private String fullName;
    @NotEmpty(message = "Please enter a phone number")
    @Min(value=0,message = "Please enter a valid phone number")
    @Max(value=10, message = "Please enter a valid phone number")
    private int phoneNumber;
    @Email(message = "Invalid email")
    private String emailAddress;
    @NotEmpty(message = "Please enter a valid NIC number")
    private String nic;
    @NotEmpty(message = "Please enter a valid street address")
    private String streetAddress;
    @NotEmpty(message = "Please enter a valid Grama Niladhari Division")
    private String gramaDivision;
    @NotEmpty(message = "Please enter a valid District")
    private String district;
    @NotEmpty(message = "Please enter a valid Province")
    private String province;
    @Transient
    private String confirmPassword;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotEmpty(message = "Full name cannot be empty") String getFullName() {
        return fullName;
    }

    public void setFullName(@NotEmpty(message = "Full name cannot be empty") String fullName) {
        this.fullName = fullName;
    }

    @NotEmpty(message = "Please enter a phone number")
    @Min(value = 0, message = "Please enter a valid phone number")
    @Max(value = 10, message = "Please enter a valid phone number")
    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@NotEmpty(message = "Please enter a phone number") @Min(value = 0, message = "Please enter a valid phone number") @Max(value = 10, message = "Please enter a valid phone number") int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public @Email(message = "Invalid email") String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(@Email(message = "Invalid email") String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public @NotEmpty(message = "Please enter a valid NIC number") String getNic() {
        return nic;
    }

    public void setNic(@NotEmpty(message = "Please enter a valid NIC number") String nic) {
        this.nic = nic;
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

    public @NotEmpty(message = "Please enter a valid District") String getDistrict() {
        return district;
    }

    public void setDistrict(@NotEmpty(message = "Please enter a valid District") String district) {
        this.district = district;
    }

    public @NotEmpty(message = "Please enter a valid Province") String getProvince() {
        return province;
    }

    public void setProvince(@NotEmpty(message = "Please enter a valid Province") String province) {
        this.province = province;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
