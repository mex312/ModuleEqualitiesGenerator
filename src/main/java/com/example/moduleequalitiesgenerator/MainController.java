package com.example.moduleequalitiesgenerator;

import eu.hansolo.tilesfx.tools.TimeData;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Date;
import java.util.Random;
import java.util.random.RandomGenerator;

public class MainController {
    public TextField seedField;

    public ChoiceBox eqTypeChoiceBox;

    public String eqTypeChoice1;
    public String eqTypeChoice2;
    public String eqTypeChoice3;
    public String eqTypeChoice4;
    public String eqTypeChoice5;
    public String eqTypeChoice6;

    public Label label;

    @FXML
    protected void onButtonClick() {
        label.setText("Created equality with type " + eqTypeChoiceBox.getValue());

        Random rand;
        long trueSeed = 0;

        if (seedField.getCharacters().length() == 0){
            trueSeed = new Date().getTime();
        } else {
            long mult = seedField.getCharacters().toString().length() - 1;
            for (char c : seedField.getCharacters().toString().toCharArray()){
                long add = c - 48;

                for(int i = 0; i < mult; i++){
                    add *= 10;
                }

                mult--;
                trueSeed += add;
            }
        }

        System.out.println(trueSeed);
        rand = new Random(trueSeed);
    }

    public void initialize(){
        System.out.println("Initialized!\n");

    }
}