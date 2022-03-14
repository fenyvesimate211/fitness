package controller;

import application.FitnessApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserController implements Initializable {

    FitnessApplication m = new FitnessApplication();
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
    private ChoiceBox<String> calorieChoiceBox;
    @FXML
    private TextField dailyGoalTextFiled;
    @FXML
    private ChoiceBox<String> genderChoiceBox;
    @FXML
    private ChoiceBox<String> weightChoiceBox;
    @FXML
    private ChoiceBox<String> heightChoiceBox;

    private final String[] gender = {"Male", "Female"};
    private final String[] weight = {"kilogram", "gram", "pound (lb)"};
    private final String[] height = {"meter", "centimeter", "inch", "feet"};
    private final String[] dailyGoal = {"kcal"};

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        genderChoiceBox.getItems().addAll(gender);
        weightChoiceBox.getItems().addAll(weight);
        heightChoiceBox.getItems().addAll(height);
        calorieChoiceBox.getItems().addAll(dailyGoal);
    }

    @FXML
    protected void createProfile() {
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

    public void backToLogin(ActionEvent event) throws IOException {
        m.changeScene("/fxml/login.fxml");
    }
}