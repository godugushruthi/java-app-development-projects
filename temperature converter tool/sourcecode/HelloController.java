package com.javaintern.projectdemo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    // defined all the controllers
    @FXML
    public Label welcomeLabel;// it is id in the scene builder we have defined to define all the controllers
    @FXML
    private ChoiceBox<String> choiceBox;//here will make the choicebox type has string bcz we are adding text itself
    @FXML
    public TextField userinputfield;
    @FXML
    private Button convertButton;



   private static final String C_TO_F_TEXT = "Celsius to Fahrenheit";
   private static final String F_TO_C_TEXT = "Fahrenheit to Celsius";

   private boolean isC_TO_F=true;



   //In order to implement all this click events on all these controllers we use class of controller
    // when application starts for controller then initialize is the entry point for the program
    // we need to make a link between the controller and fxml for that purpose we write in the first line controller and give path of controller class
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        choiceBox.getItems().add(C_TO_F_TEXT);//all content in choicebox must have same datatype
        choiceBox.getItems().add(F_TO_C_TEXT);

        choiceBox.setValue(C_TO_F_TEXT);//we are setting by default choicebox with text

        //below will add some actions to choicebox and observable will describes property of selected item
        //old value gives which value was previously selected
        //new value gives which value was selected now by user
        // here when we change the value in choicebox from f to c or c to f then that value is returned by addListener it will be stored in new value

       // here we are using lambda expressions

        choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> isC_TO_F= newValue.equals(C_TO_F_TEXT));


        convertButton.setOnAction(event -> {
          convert(); // System.out.println("Convert Button Clicked")
        });
    }

    private void convert() {
        String input=userinputfield.getText();//we will get input in string
        float enteredtemp=0.0f;
        //if user enters wrong input to handle that case we wrote try catch
        try {
            enteredtemp = Float.parseFloat(input);
        }catch(Exception e)
        {
            warnUser();
            return;
        }
        float newTemp;
        if(isC_TO_F){
            newTemp=(enteredtemp*9/5)+32;
        } else {
            newTemp=(enteredtemp-32)*5/9;
        }
        display(newTemp);
    }

    private void warnUser()
    {
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Occured");
        alert.setHeaderText("Invalid Temperature Entered");
        alert.setContentText("Please enter a valid Temperature");
        alert.show();
    }

    private void display(float newTemp) {
        String unit=isC_TO_F ? "F" : "C" ;
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setContentText("The New Temperature is : "+newTemp + unit);
        alert.show();
    }


}



