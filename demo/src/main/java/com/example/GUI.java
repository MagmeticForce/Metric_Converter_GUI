package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application {
    
    @Override
    public void start(Stage primary_stage) {

        primary_stage.setTitle("Metric Converter");

        //create text field object, button object, and text object
        TextField input_text_field = new TextField();
        Button km_to_mi_button = new Button ("Kilometers to Miles");
        Button kg_to_lb_button = new Button ("Kilograms to Pounds");
        Button g_to_o_button = new Button ("Grams to Ounces");
        Button cm_to_in_button = new Button ("Centimeters to Inches");
        Label output_label = new Label (" ");


        //make the buttons do things
        km_to_mi_button.setOnAction (e -> {
            String user_input_text = input_text_field.getText();
            boolean the_user_inputted_correctly = check_if_the_user_inputted_correctly(user_input_text);
            if (the_user_inputted_correctly) {
                double user_input_value = Double.parseDouble(user_input_text);
                double converted_value = convert(user_input_value, "km to mi");
                output_label.setText(user_input_value + " kilometers is about " + converted_value + " miles.");
            }
            else {
                output_label.setText("Sorry, that input cannot be evaluated. Please only input a number");
            }

        });
        kg_to_lb_button.setOnAction (e -> {
            String user_input_text = input_text_field.getText();
            boolean the_user_inputted_correctly = check_if_the_user_inputted_correctly(user_input_text);
            if (the_user_inputted_correctly) {
                double user_input_value = Double.parseDouble(user_input_text);
                double converted_value = convert(user_input_value, "kg to lb");
                output_label.setText(user_input_value + " kilograms is about " + converted_value + " pounds.");
            }
            else {
                output_label.setText("Sorry, that input cannot be evaluated. Please only input a number");
            }

        });
        g_to_o_button.setOnAction (e -> {
            String user_input_text = input_text_field.getText();
            boolean the_user_inputted_correctly = check_if_the_user_inputted_correctly(user_input_text);
            if (the_user_inputted_correctly) {
                double user_input_value = Double.parseDouble(user_input_text);
                double converted_value = convert(user_input_value, "g to o");
                output_label.setText(user_input_value + " grams is about " + converted_value + " ounces.");
            }
            else {
                output_label.setText("Sorry, that input cannot be evaluated. Please only input a number");
            }

        });
        cm_to_in_button.setOnAction (e -> {
            String user_input_text = input_text_field.getText();
            boolean the_user_inputted_correctly = check_if_the_user_inputted_correctly(user_input_text);
            if (the_user_inputted_correctly) {
                double user_input_value = Double.parseDouble(user_input_text);
                double converted_value = convert(user_input_value, "cm to in");
                output_label.setText(user_input_value + " centimeters is about " + converted_value + " inches.");
            }
            else {
                output_label.setText("Sorry, that input cannot be evaluated. Please only input a number");
            }

        });

        //display things
        VBox vbox_object = new VBox(10);
        vbox_object.getChildren().addAll(input_text_field, km_to_mi_button, kg_to_lb_button, g_to_o_button, cm_to_in_button, output_label);
        Scene scene_object = new Scene (vbox_object, 500, 300);
        primary_stage.setScene(scene_object);
        primary_stage.show();

    }

    private double convert(double value_input, String measurements_input) {   
        double value_output = 0;
        switch (measurements_input) {
            case "km to mi": {
                value_output = value_input * 0.621; //km to mi: multiply number of km by 0.621
                break;
            }
            case "kg to lb": {
                value_output = value_input * 2.205; //kg to lb: multiply number of kg by 2.205
                break;
            }
            case "g to o": {
                value_output = value_input * 0.0353; //g to o: multiply number of g by 0.0353
                break;
            }
            case "cm to in": {
                value_output = value_input * 0.394; //cm to in: multiply number of cm by 0.394
                break;
            }  
        }
        return value_output;
    }

    private boolean check_if_the_user_inputted_correctly (String user_input_input) {
        double user_input_value = 0;
        boolean the_input_is_correct_output = true;
        try {
            user_input_value = Double.parseDouble(user_input_input);
        }
        catch (NumberFormatException e) {
            the_input_is_correct_output = false;
        }
        return the_input_is_correct_output;
    }
}










