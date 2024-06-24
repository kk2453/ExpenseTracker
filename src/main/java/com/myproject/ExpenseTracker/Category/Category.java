package com.myproject.ExpenseTracker.Category;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {
    //Category parameters
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected long id;
    protected String name;
    protected String description;
    protected char subscription;


    //No argument constructor
    public Category() {
    }

    //constructor without 'id' argument
    public Category(String name, String description, char subscription) {
        this.name = name;
        this.description = description;
        this.subscription = subscription;
    }

    //constructor with all arguments
    public Category(long id, String name, String description, char subscription) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.subscription = subscription;
    }

    //Getters and Setters
    public long getId() { return id; }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public char getSubscription() {
        return subscription;
    }

    public void setSubscription(char subscription) {
        this.subscription = subscription;
    }

    //toString method
    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", subscription=" + subscription +
                '}';
    }

}
