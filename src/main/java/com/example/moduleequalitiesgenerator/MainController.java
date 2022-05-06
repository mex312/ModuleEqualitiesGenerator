package com.example.moduleequalitiesgenerator;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class MainController {
    public CheckBox checkBox1;
    public CheckBox checkBox2;
    public CheckBox checkBox3;
    public Label label1;
    public Label label2;
    public Label label3;

    @FXML
    protected void onButtonClick() {
        if(checkBox1.isSelected())
            label1.setText("CheckBox1 is selected");
        else
            label1.setText("CheckBox1 is not selected");

        if(checkBox2.isSelected())
            label2.setText("CheckBox2 is selected");
        else
            label2.setText("CheckBox2 is not selected");

        if(checkBox3.isSelected())
            label3.setText("CheckBox3 is selected");
        else
            label3.setText("CheckBox3 is not selected");

    }

    public void initialize(){
        System.out.print("Initialized!\n");

    }
}