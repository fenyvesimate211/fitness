package database;

public class UserEntity {
    private String Name;
    private String Email;
    private String Password;
    private String Gender;
    private String DateOfBirth;
    private int Weight;
    private int Height;
    private int DailyGoal;

    public UserEntity() {

    }

    public UserEntity(Integer id, String name, String email, String password, String gender, String dateOfBirth, int weight, int height, int dailyGoal) {
        Name = name;
        Email = email;
        Password = password;
        Gender = gender;
        DateOfBirth = dateOfBirth;
        Weight = weight;
        Height = height;
        DailyGoal = dailyGoal;
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
