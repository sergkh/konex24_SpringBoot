package com.konex.servapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

/**
 * Created by kneimad on 28.09.2016.
 */

@Entity
@Table(name = "users")
public class User implements DomainObject{

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "login")
    @NotBlank
    @Size(min = 1, max = 20)
    private String username;

    @Column(name = "password")
    @NotBlank
    @Size(min = 4, max = 20)
    private String password;

    @Transient
    private String confirmPassword;

    @Column(name = "user_PIB")
    @NotBlank
    @Size(min = 1, max = 150)
    private String userPIB;

    @Column(name = "email", unique = true)
    @NotBlank
    @Email
    private String eMail;

    @Column(name = "mobile", unique = true)
    @NotBlank
    @Size(min = 8, max = 14)
    private String mobile;

    @Column(name = "birthday")
    @NotNull
    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date birthday;

    @Column(name = "sex")
    private String sex;

    @Column(name = "avatara")
    private byte[] avatara;

    @Column(name = "reg_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regTime;

    @PrePersist
    protected void onCreate() {
        regTime = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        regTime = new Date();
    }

    @Column(name = "confirmed")
    private Boolean confirmed;

    @Column(name = "updated")
    private Boolean updated;

    @Column(name = "rating")
    private Float rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_type")
    private UserType userType;

    @ManyToMany
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getUserPIB() {       return userPIB;    }

    public void setUserPIB(String userPIB) {         this.userPIB = userPIB;    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public byte[] getAvatara() {
        return avatara;
    }

    public void setAvatara(byte[] avatara) {
        this.avatara = avatara;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Boolean getUpdated() {
        return updated;
    }

    public void setUpdated(Boolean updated) {
        this.updated = updated;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
