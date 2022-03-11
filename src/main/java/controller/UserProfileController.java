package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserProfileController {

    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField nameTextFiled;
    @FXML
    private TextField genderTextFiled;
    @FXML
    private DatePicker dateOfBirthDataPicker;
    @FXML
    private TextField weightTextFiled;
    @FXML
    private TextField heightTextFiled;
    @FXML
    private ChoiceBox calorieChoiceBox;
    @FXML
    private TextField dailyGoalTextFiled;

    @FXML
    protected void onCreateProfileButtonClick() {
        //TODO check field data
        if(validateProfile()){
            System.out.println("Profile is valid"); //TODO make text_label
        } else {
            System.out.println("Profile is not valid"); //TODO make text_label
        }
    }

    private boolean validateProfile() {
        //TODO https://www.w3schools.blog/validate-username-regular-expression-regex-java
        //TODO https://www.geeksforgeeks.org/how-to-validate-a-password-using-regular-expressions-in-java/

        String PATTERN = "^[[A-ZÁÉÍÓÖŐÚÜŰ]?[ ][a-záéíóöőúüű ]]+[[A-ZÁÉÍÓÖŐÚÜŰ]?[ ][a-záéíóöőúüű ]]$"; //"[a-zA-Z]{3}-[\\d]{3}$";
        List<String> values = new ArrayList<String>();
        values.add("Sántha Máté Imre");
        values.add("Fenyvesi Matyas");
        values.add("Fa Ma9");
        values.add("FaMa");
        values.add("alma");
        values.add("Alma é");
        values.add(" ");
        values.add("A");
        values.add("jai_singh");
        values.add("ABC-123");
        values.add("ABCd-12");

        Pattern pattern = Pattern.compile(PATTERN);
        for (String value : values){
            Matcher matcher = pattern.matcher(value);
            if(matcher.matches()){
                System.out.println("Username "+ value +" is valid");
            }else{
                System.out.println("Username "+ value +" is invalid");
            }
        }

        return true;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(PasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public ChoiceBox getCalorieChoiceBox() {
        return calorieChoiceBox;
    }

    public void setCalorieChoiceBox(ChoiceBox calorieChoiceBox) {
        this.calorieChoiceBox = calorieChoiceBox;
    }

    public TextField getDailyGoalTextFiled() {
        return dailyGoalTextFiled;
    }

    public void setDailyGoalTextFiled(TextField dailyGoalTextFiled) {
        this.dailyGoalTextFiled = dailyGoalTextFiled;
    }

    public TextField getNameTextFiled() {
        return nameTextFiled;
    }

    public void setNameTextFiled(TextField nameTextFiled) {
        //"^[A-Z]{1}[a-z][\t]^[A-Z]{1}[a-z]{3,35}$"
        this.nameTextFiled = nameTextFiled;
    }

    public TextField getGenderTextFiled() {
        return genderTextFiled;
    }

    public void setGenderTextFiled(TextField genderTextFiled) {
        this.genderTextFiled = genderTextFiled;
    }

    public DatePicker getDateOfBirthDataPicker() {
        return dateOfBirthDataPicker;
    }

    public void setDateOfBirthDataPicker(DatePicker dateOfBirthDataPicker) {
        this.dateOfBirthDataPicker = dateOfBirthDataPicker;
    }

    public TextField getWeightTextFiled() {
        return weightTextFiled;
    }

    public void setWeightTextFiled(TextField weightTextFiled) {
        this.weightTextFiled = weightTextFiled;
    }

    public TextField getHeightTextFiled() {
        return heightTextFiled;
    }

    public void setHeightTextFiled(TextField heightTextFiled) {
        this.heightTextFiled = heightTextFiled;
    }
}