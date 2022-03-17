package controller;

import application.FitnessApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.converter.LocalDateStringConverter;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.Year;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserController implements Initializable {

    public UserController() {

    }

    FitnessApplication m = new FitnessApplication();
    @FXML
    private TextField userName;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private DatePicker dateOfBirth;
    @FXML
    private TextField weightText;
    @FXML
    private TextField heightText;
    @FXML
    private ChoiceBox<String> calorieChoiceBox;
    @FXML
    private TextField dailyGoalText;
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
    public void initialize(URL url, ResourceBundle resourceBundle){
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

        String NAME_PATTERN = "^[a-záéíóöőüűA-ZÁÉÍÓÖŐÚÜŰ ]{3,30}$";
        String EMAIL_PATTERN = "^(.+)@(.+)$";
        String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-záéíóöőüű])(?=.*[A-ZÁÉÍÓÖŐÚÜŰ])(?=.*[!%@#&()–{}:;',?/*~$^+=<>]).{8,20}$";
        String WEIGHT_HEIGHT_PATTERN = "^[0-9]{1,3}.[0-9]{1,3}$";

        Matcher nameMatcher = Pattern.compile(NAME_PATTERN).matcher(getUserName().getText());
        Matcher emailMatcher = Pattern.compile(EMAIL_PATTERN).matcher(getEmail().getText());
        Matcher passwordMatcher = Pattern.compile(PASSWORD_PATTERN).matcher(getPassword().getText());
        Matcher weight_heightMatcher = Pattern.compile(WEIGHT_HEIGHT_PATTERN).matcher(getWeightText().getText());

        if (nameMatcher.matches()) {
                System.out.println("Username "+ getUserName().getText() +" is valid");

            } else {
                System.out.println("Username "+ getUserName().getText() +" is invalid");
            }

        if (emailMatcher.matches()) {
            System.out.println("Email "+ getEmail().getText() +" is valid");
        } else {
            System.out.println("Email "+ getEmail().getText() +" is invalid");
        }

        if (passwordMatcher.matches()) {
            System.out.println("Password "+ getPassword().getText() +" is valid");
        } else {
            System.out.println("Password "+ getPassword().getText() +" is invalid");
        }

        if (getDateOfBirth() > 14) {
            System.out.println("Date of birth is valid " + getDateOfBirth());
        } else {
            System.out.println("Date of birth is invalid " + getDateOfBirth());
        }

        if (weight_heightMatcher.matches()) {
            System.out.println("Date of birth is valid " + getWeightText());
        } else {
            System.out.println("Date of birth is invalid " + getWeightText());
        }

        if (weight_heightMatcher.matches()) {
            System.out.println("Date of birth is valid " + getHeightText());
        } else {
            System.out.println("Date of birth is invalid " + getHeightText());
        }

        return true;
    }

    public void backToLogin() throws IOException {
        m.changeScene("/fxml/login.fxml");
    }

    public TextField getUserName() {
        return userName;
    }
    public TextField getEmail() {
        return email;
    }
    public PasswordField getPassword() {
        return password;
    }

    public int getDateOfBirth() {
        return Period.between(LocalDate.of(dateOfBirth.getValue().getYear(), dateOfBirth.getValue().getMonthValue(),
                dateOfBirth.getValue().getDayOfMonth()), LocalDate.now()).getYears();
    }

    public TextField getWeightText() {
        return weightText;
    }

    public TextField getHeightText() {
        return heightText;
    }
}
