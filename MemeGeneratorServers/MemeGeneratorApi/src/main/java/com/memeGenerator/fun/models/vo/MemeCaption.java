package com.memeGenerator.fun.models.vo;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.ForeignKey;

@Entity
@Table(name = "meme_caption")
public class MemeCaption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "caption")
    private String caption;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_userId_user", value = ConstraintMode.CONSTRAINT))
    private User user;

    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "guid", nullable = false)
    private String guid;

    // public int getId() {
    // return this.id;
    // }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaption() {
        return this.caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getGuid() {
        return this.guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
}
