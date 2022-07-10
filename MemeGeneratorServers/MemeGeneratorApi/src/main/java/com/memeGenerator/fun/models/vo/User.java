package com.memeGenerator.fun.models.vo;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

@Entity
@Table(name = "user")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    // @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    // @GeneratedValue(generator = "generator")
    @Column(name = "guid", nullable = false)
    private String guid = UUID.randomUUID().toString();;

    // public int getId() {
    //     return this.id;
    // }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGuid() {
        return this.guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    // @Override
    // public ExampleMatcher getMatcher() {
    //     ExampleMatcher caseInsensitiveExampleMatcher = ExampleMatcher.matchingAll().withIgnoreCase();
    //     return caseInsensitiveExampleMatcher;
    // }

    // @Override
    // public Object getProbe() {
    //     return this;
    // }
}
