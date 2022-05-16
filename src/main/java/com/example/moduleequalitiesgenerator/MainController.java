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
    public static final String CLOSED_MESSAGE = "Ответ скрыт ";

    public TextField seedField;
    public TextField usedSeedField;

    public ChoiceBox eqTypeChoiceBox;

    public String eqTypeChoice1;
    public String eqTypeChoice2;
    public String eqTypeChoice3;
    public String eqTypeChoice4;
    public String eqTypeChoice5;
    public String eqTypeChoice6;

    public Label eqLabel;
    public Label eqAnsLabel;

    ModuleEquality activeEq;

    public void GenerateEq() {
        Random rand;
        long trueSeed = 0;
        int seedMult = 1;

        if (seedField.getCharacters().length() == 0){
            trueSeed = new Random(new Date().getTime()).nextLong();
        } else {
            long mult = seedField.getCharacters().toString().length() - 1;
            for (char c : seedField.getCharacters().toString().toCharArray()){
                long add = c - 48;

                if(c == '-') {
                    add = 0;
                    seedMult *= -1;
                }else{
                    for (int i = 0; i < mult; i++) {
                        add *= 10;
                    }
                }

                mult--;
                trueSeed += add;
            }
        }

        trueSeed *= seedMult;
        rand = new Random(trueSeed);

        if(eqTypeChoiceBox.getValue() == eqTypeChoice6) {
            activeEq = new ModuleEquality(rand, 0);
        }else{
            activeEq = new ModuleEquality(rand, Integer.parseInt(eqTypeChoiceBox.getValue().toString()));
        }

        eqAnsLabel.setText(CLOSED_MESSAGE);
        eqLabel.setText(activeEq.AsString());
        usedSeedField.setText(String.valueOf(trueSeed));
    }

    public void GenerateAns(){
        if(activeEq != null) eqAnsLabel.setText(activeEq.AnswerAsString());
    }

    public void initialize(){
        System.out.println("Initialized!\n");

    }
}