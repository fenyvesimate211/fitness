package controller;

import application.FitnessApplication;
import javafx.scene.control.*;
import service.UserService;
import service.UserServiceImplementation;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserController implements Initializable {

    public UserController() {
    }

    UserService userService = new UserServiceImplementation();

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
    @FXML
    private Label nameCheck;
    @FXML
    private Label emailCheck;
    @FXML
    private Label passwordCheck;
    @FXML
    private Label genderCheck;
    @FXML
    private Label dateOfBirthCheck;
    @FXML
    private Label weightCheck;
    @FXML
    private Label heightCheck;
    @FXML
    private Label dailyGoalCheck;

    private final String[] gender = {"Male", "Female"};
    private final String[] weight = {"kilogram", "gram", "pound (lb)"};
    private final String[] height = {"centimeter", "meter", "inch", "feet"};
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
            User user = new User(
                    getUserName().getText(),
                    getEmail().getText(),
                    getPassword().getText(),
                    "male",
                    String.valueOf(getDateOfBirth()),
                    Integer.parseInt(getWeightText().getText()),
                    Integer.parseInt(getHeightText().getText()),
                    Integer.parseInt(getDailyGoalText().getText()));
            userService.save(user);
            System.out.println("Profile is valid"); //TODO make text_label
        } else {
            System.out.println("Profile is not valid"); //TODO make text_label
        }
    }

    //TODO choiceBoxCheck
    private boolean validateProfile() {

        String NAME_PATTERN = "^[a-záéíóöőüűA-ZÁÉÍÓÖŐÚÜŰ ]{3,30}$";
        String EMAIL_PATTERN = "^(.+)@(.+)$";
        String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-záéíóöőüű])(?=.*[A-ZÁÉÍÓÖŐÚÜŰ])(?=.*[!%@#&()–{}:;',?/*~$^+=<>]).{8,20}$";
        String WEIGHT_HEIGHT_DAILYGOAL_PATTERN = "^[0-9]{1,3}.[0-9]{1,3}$";

        Matcher nameMatcher = Pattern.compile(NAME_PATTERN).matcher(getUserName().getText());
        Matcher emailMatcher = Pattern.compile(EMAIL_PATTERN).matcher(getEmail().getText());
        Matcher passwordMatcher = Pattern.compile(PASSWORD_PATTERN).matcher(getPassword().getText());
        Matcher weight_height_dailyGoalMatcher = Pattern.compile(WEIGHT_HEIGHT_DAILYGOAL_PATTERN).matcher(getWeightText().getText());

        //TODO logging not to console
        if (nameMatcher.matches() && !Objects.equals(getUserName().getText(), "")) {
            System.out.println("Username "+ getUserName().getText() +" is valid");
        } else {
            getNameCheck().setText("Name is invalid");
            return false;
        }

        if (emailMatcher.matches() && !Objects.equals(getEmail().getText(), "")) {
            System.out.println("Email "+ getEmail().getText() +" is valid");
        } else {
            getEmailCheck().setText("Email is invalid");
            return false;
        }

        if (passwordMatcher.matches() && !Objects.equals(getPassword().getText(), "")) {
            System.out.println("Password "+ getPassword().getText() +" is valid");
        } else {
            getPasswordCheck().setText("Password is invalid");
            return false;
        }

        if (getDateOfBirth() > 14) {
            System.out.println("Date of birth is valid " + getDateOfBirth());
        } else {
            getDateOfBirthCheck().setText("Birthday is invalid");
            return false;
        }

        if (weight_height_dailyGoalMatcher.matches() && !Objects.equals(getWeightText().getText(), "")) {
            System.out.println("Weight " + getWeightText().getText() + " is valid");
        } else {
            getWeightCheck().setText("Weight is invalid");
            return false;
        }

        if (weight_height_dailyGoalMatcher.matches() && !Objects.equals(getHeightText().getText(), "")) {
            System.out.println("Height " + getHeightText().getText() + " is valid");
        } else {
            getHeightCheck().setText("Height is invalid");
            return false;
        }

        if (weight_height_dailyGoalMatcher.matches() && !Objects.equals(getDailyGoalText().getText(), "")) {
            System.out.println("Daily Goal " + getDailyGoalText().getText() + " is valid");
        } else {
            getDailyGoalCheck().setText("Daily goal is invalid");
            return false;
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
        if (dateOfBirth.getValue() == null){
            return -1;
        } else {
            return Period.between(LocalDate.of(dateOfBirth.getValue().getYear(), dateOfBirth.getValue().getMonthValue(),
                    dateOfBirth.getValue().getDayOfMonth()), LocalDate.now()).getYears();
        }
    }

    public TextField getWeightText() {
        return weightText;
    }

    public TextField getHeightText() {
        return heightText;
    }

    public TextField getDailyGoalText() {
        return dailyGoalText;
    }

    public Label getNameCheck() {
        return nameCheck;
    }

    public Label getEmailCheck() {
        return emailCheck;
    }

    public Label getPasswordCheck() {
        return passwordCheck;
    }

    public Label getGenderCheck() {
        return genderCheck;
    }

    public Label getDateOfBirthCheck() {
        return dateOfBirthCheck;
    }

    public Label getWeightCheck() {
        return weightCheck;
    }

    public Label getHeightCheck() {
        return heightCheck;
    }

    public Label getDailyGoalCheck() {
        return dailyGoalCheck;
    }
}
