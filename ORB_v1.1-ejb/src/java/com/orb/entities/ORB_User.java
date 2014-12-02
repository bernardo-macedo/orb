/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.entities;

import com.orb.persistence.UserListener;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import static javax.persistence.InheritanceType.JOINED;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author -Bernardo
 */
@Entity
@EntityListeners({UserListener.class})
@Inheritance(strategy=JOINED)
@DiscriminatorColumn(name="typeOfAccount")
public class ORB_User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Long id;
    @NotNull
    private String username = null;
    @NotNull
    private String password = null;
    @NotNull
    private String givenName = null;
    @NotNull
    private String lastName = null;
    @NotNull
    private String email = null;
    @NotNull
    private String typeOfAccount = null;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar creationTimeStamp = null;
    @NotNull
    private boolean deleted = false;

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

        public String getTypeOfAccount() {
        return typeOfAccount;
    }

    public void setTypeOfAccount(String typeOfAccount) {
        this.typeOfAccount = typeOfAccount;
    }
    
    public Calendar getCreationTimeStamp() {
        return creationTimeStamp;
    }

    public void setCreationTimeStamp(Calendar creationTimeStamp) {
        this.creationTimeStamp = creationTimeStamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ORB_User)) {
            return false;
        }
        ORB_User other = (ORB_User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orb.entities.User[ id=" + id + " ]";
    }

}
