package com.lambdaschool.macroCalc.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "usermetrics")
public class Usermetrics extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long usermetricsid;

    private String gender;

    private int age;

    private String height;

    private int weight;

    private String exercisefrequency;

    private String goal;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    @JsonIgnoreProperties("usermetrics")
    private User user;

    public Usermetrics() {
    }

    public Usermetrics(User user, String gender, int age, String height, int weight, String exercisefrequency, String goal) {
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.exercisefrequency = exercisefrequency;
        this.goal = goal;
        this.user = user;
    }


    public long getUsermetricsid() {
        return usermetricsid;
    }

    public void setUsermetricsid(long usermetricsid) {
        this.usermetricsid = usermetricsid;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getExercisefrequency() {
        return exercisefrequency;
    }

    public void setExercisefrequency(String exercisefrequency) {
        this.exercisefrequency = exercisefrequency;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
