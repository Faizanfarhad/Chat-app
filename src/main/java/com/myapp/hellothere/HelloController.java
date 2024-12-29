package com.myapp.hellothere;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private void BackgroundColor(){
        LinearGradient bg = new LinearGradient(
                0.0,0.0,1.0,0.0,true, CycleMethod.NO_CYCLE,
                new Stop(0.0,new Color( 0.1, 0.2, 0.22, 1.0)),
                new Stop(0.5,new Color( 0.18, 0.31, 0.35, 1.0)),
                new Stop(1.0,new Color( 0.22, 0.41, 0.49, 1.0)));

                new Background(new BackgroundFill(bg, CornerRadii.EMPTY , Insets.EMPTY ));
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}