package model;

import lombok.Data;

import javax.persistence.*;

@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String Name;

    private String Email;

    private String Password;

    private String Gender;

    private String DateOfBirth;

    private int Weight;

    private int Height;

    private int DailyGoal;

    public User(long id, String name, String email, String password, String gender, String dateOfBirth, int weight, int height, int dailyGoal) {
        this.id = id;
        Name = name;
        Email = email;
        Password = password;
        Gender = gender;
        DateOfBirth = dateOfBirth;
        Weight = weight;
        Height = height;
        DailyGoal = dailyGoal;
    }

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        Height = height;
    }

    public int getDailyGoal() {
        return DailyGoal;
    }

    public void setDailyGoal(int dailyGoal) {
        DailyGoal = dailyGoal;
    }
}
