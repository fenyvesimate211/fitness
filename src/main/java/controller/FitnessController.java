package controller;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class FitnessController {

    @FXML
    private TextField dailyGoalTextFiled;

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
    protected void onCreateProfileButtonClick() {
        //TODO check field data
        if(validateProfile()){
            System.out.println("Profile is valid"); //TODO make text_label
        } else {
            System.out.println("Profile is not valid"); //TODO make text_label
        }
    }

    private boolean validateProfile() {
        
        return true;
    }
}