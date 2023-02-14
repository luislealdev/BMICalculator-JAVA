package com.example.bmicalculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class BMICalculator extends Application {

    //Declare here to have access
    TextField tf_weight = new TextField();
    TextField tf_height = new TextField();
    Label l_showResult = new Label();

    Label l_message = new Label();

    Button b_cancel = new Button("Cancel");
    Button b_calculate = new Button("Calculate");

    @Override
    public void start(Stage stage) throws IOException {
        StackPane root = initGUI();
        root.setAlignment(Pos.CENTER);


        //Show screen
        Scene scene = new Scene(root, 400, 300);
        stage.setTitle("BMI Calculator!");
        stage.setScene(scene);
        stage.show();
    }

    private StackPane initGUI(){
        StackPane stackPane = new StackPane();
        //Center grid on stackpane

        //Create all elements (not in level class because it is only reference, were not using them)
        Label l_title = new Label("BMI Calculator");
        l_title.setAlignment(Pos.CENTER);

        Label l_weight = new Label("Weight");
        Label l_height = new Label("Height");
        Label l_result = new Label("Result");

        //Create gridpane
        GridPane gridpane = new GridPane();
        //Set styles
        gridpane.setAlignment(Pos.CENTER);
        gridpane.setHgap(10);
        gridpane.setVgap(15);

        //Add items to gridpane
        gridpane.add(l_title,0,0,2,1);
        gridpane.add(l_weight,0,1);
        gridpane.add(tf_weight, 1,1);
        gridpane.add(l_height,0,2);
        gridpane.add(tf_height, 1,2);
        gridpane.add(l_result,0,3);
        gridpane.add(l_showResult, 1,3);

        gridpane.add(l_message,0,4,2,1);

        gridpane.add(b_cancel, 0, 5);
        gridpane.add(b_calculate, 1, 5);

        //Add gridpane to stackpane
        stackPane.getChildren().add(gridpane);

        b_calculate.setOnAction(handlerButtons);

        //Init button

        return stackPane;
    }


    //Calculates the BMI
    private double getBMI(double weight, double height){
        return weight/(height*height);
    }

    //Method to handle buttons
    EventHandler<ActionEvent> handlerButtons = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            double weight = Double.valueOf(tf_weight.getText());
            double height = Double.valueOf(tf_height.getText());
            double result = getBMI(weight, height);
            l_showResult.setText(result+"");

            String message = getBMICategory(result);
            l_message.setText("You're in the " + message);
        }
    };

    private String getBMICategory(double bmi){
        String message;

        if(bmi<18.5) message="underweight range.";
        else if(bmi<24.9) message = "healthy weight range.";
        else if(bmi<29.9) message = "overweight range.";
        else message="the obese range.";

        return message;
    }

    public static void main(String[] args) {
        launch();
    }
}