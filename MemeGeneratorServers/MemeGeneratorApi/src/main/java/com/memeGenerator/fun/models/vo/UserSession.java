package com.memeGenerator.fun.models.vo;

import java.time.Clock;
import java.time.OffsetDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;


@Entity
@Table(name="user_session")
public class UserSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_userId_user", value = ConstraintMode.CONSTRAINT))
    private User user;

    @Column(name="token" )
    private String sessionToken = UUID.randomUUID().toString();

    @Column(name = "created_date")
    private OffsetDateTime createdDate = OffsetDateTime.now(Clock.systemUTC());

    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }

    public int getId() {
        return id;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public User getUser() {
        return user;
    }

    public void setCreatedDate(OffsetDateTime createdDate) {
        this.createdDate = createdDate;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public void setUser(User user) {
        this.user = user;
    }
}