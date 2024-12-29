package com.myapp.hellothere;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class settingPage extends Application {
    @Override
    public void start(Stage stage){
            Pane root = new Pane();
        Scene scene = new Scene(root,350,500);

       LinearGradient linearGradient = new LinearGradient(
               0.0,0.0,1.0,0.0,true,CycleMethod.NO_CYCLE,
               new Stop(0.0,new Color( 0.73, 0.59, 0.88, 1.0)),
               new Stop(1.0,new Color( 0.36, 0.34, 0.73, 1.0)));
       LinearGradient linearGradient1 = new LinearGradient(
               0.0,0.0,1.0,1.0,true,CycleMethod.NO_CYCLE,
               new Stop(1,new Color( 0.83, 0.85, 0.87, 1.0)),
               new Stop(1.0,new Color( 0.24, 0.33, 0.41, 1.0)));
       LinearGradient linearGradient3 = new LinearGradient(
               0.0,0.0,1.0,1.0,true,CycleMethod.NO_CYCLE,
               new Stop(1,new Color( 0.83, 0.85, 0.87, 1.0)),
               new Stop(1.0,new Color( 0.24, 0.33, 0.41, 1.0)));

       DropShadow dropShadow = new DropShadow();
       dropShadow.setColor(new Color( 1.0, 1.0, 1.0, 1.0));

        Light.Distant light = new Light.Distant();
        light.setColor(Color.color(  0.99, 0.3, 0.58, 1.0));
        light.setAzimuth(115);
        Lighting lighting = new Lighting();
        lighting.setLight(light);
        lighting.setSurfaceScale(1.0);

       /*  Button X */

        Button button = new Button("X");
        BackgroundFill fill = new BackgroundFill(new Color( 0.2, 0.2, 0.2, 1.0),CornerRadii.EMPTY,Insets.EMPTY);
        Background bg = new Background(fill);
        button.setBackground(bg);
        button.setFont(Font.font("Arial", FontWeight.BOLD,17));
        button.setTextFill(Color.BLACK);
        button.setTextFill(Color.WHITE);
        button.setLayoutX(310);
        button.setLayoutY(5);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
            }
        });

        button.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                scene.setCursor(Cursor.HAND);
            }
        });

        button.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                scene.setCursor(Cursor.DEFAULT);
            }
        });


        /* Circle */

        Circle cir = new Circle(20);
        cir.setLayoutX(20);
        cir.setLayoutY(20);
        cir.setEffect(dropShadow);
        cir.setFill(linearGradient);
        TranslateTransition transition = new TranslateTransition(Duration.millis(5000),cir);
        transition.setToX(399);
        transition.setToY(499);
        transition.setInterpolator(Interpolator.EASE_BOTH);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.setNode(cir);
        transition.setAutoReverse(true);
        transition.play();


        /* circle 2 */
        LinearGradient liner = new LinearGradient(
                0.0,0.0,1.0,0.0,true,CycleMethod.NO_CYCLE,
                new Stop(0.0,new Color( 0.5, 0.0, 0.99, 1.0)),
                new Stop(1.0,new Color( 0.88, 0.01, 0.98, 1.0)));

        Circle cir1 = new Circle(20);
        cir1.setLayoutX(10);
        cir1.setLayoutY(20);

        DropShadow dropShadow1 = new DropShadow();
        dropShadow1.setColor(Color.color(0.88, 0.01, 0.98, 1.0));

        cir1.setEffect(dropShadow1);
        cir1.setFill(linearGradient);


        TranslateTransition transition1 = new TranslateTransition(Duration.millis(5000), cir1);
        transition1.setFromX(380);
        transition1.setFromY(0);
        transition1.setToX(0);
        transition1.setToY(499);
        transition1.setInterpolator(Interpolator.LINEAR);
        transition1.setCycleCount(Animation.INDEFINITE);
        transition1.setAutoReverse(true);
        transition1.setNode(cir1);

        transition1.play();

        /* circle 3 */

        Circle cir2 = new Circle(20);
        cir2.setLayoutX(10);
        cir2.setLayoutY(20);
        DropShadow dropShadow2 = new DropShadow();
        dropShadow2.setColor(Color.color(0.88, 0.01, 0.98, 1.0));
        cir2.setEffect(dropShadow2);
        cir2.setFill(linearGradient);
        TranslateTransition transition2 = new TranslateTransition(Duration.millis(5000), cir2);
        transition2.setToX(0);
        transition2.setToY(499);
        transition2.setInterpolator(Interpolator.EASE_BOTH);
        transition2.setCycleCount(Animation.INDEFINITE);
        transition2.setAutoReverse(true);
        transition2.setNode(cir2);
        transition2.play();

        /* Circle 4 */

        Circle cir3 = new Circle(20);
        cir3.setLayoutX(10);
        cir3.setLayoutY(20);
        DropShadow dropShadow3 = new DropShadow();
        dropShadow3.setColor(Color.color(0.88, 0.01, 0.98, 1.0));
        cir3.setFill(linearGradient);
        TranslateTransition transition3 = new TranslateTransition(Duration.millis(5000), cir3);
        transition3.setFromX(0);
        transition3.setFromY(499);
        transition3.setToX(399);
        transition3.setToY(0);
        transition3.setInterpolator(Interpolator.EASE_BOTH);
        transition3.setCycleCount(Animation.INDEFINITE);
        transition3.setAutoReverse(true);
        transition3.play();





        /* Circle 5 */
        Rectangle cir4 = new Rectangle(30,30);
        cir4.setLayoutX(10);
        cir4.setLayoutY(20);
        DropShadow dropShadow4 = new DropShadow();
        dropShadow4.setColor(Color.color(0.88, 0.01, 0.98, 1.0));
        cir4.setEffect(dropShadow4);
        cir4.setFill(linearGradient);
        TranslateTransition transition4 = new TranslateTransition(Duration.millis(5000), cir4);
        transition4.setFromX(180);
        transition4.setFromY(150);
        transition4.setToY(380);
        transition4.setCycleCount(Animation.INDEFINITE);
        transition4.setAutoReverse(true);
        transition4.play();

        /* Circle 6 */

        Circle cir5 = new Circle(20);
        cir5.setLayoutX(10);
        cir5.setLayoutY(20);
        DropShadow dropShadow5 = new DropShadow();
        dropShadow5.setColor(Color.color(0.88, 0.01, 0.98, 1.0));
        cir5.setEffect(dropShadow5);
        cir5.setFill(linearGradient);
        TranslateTransition transition5 = new TranslateTransition(Duration.millis(5000), cir5);

        transition5.setFromX(180);
        transition5.setFromY(500);
        transition5.setToY(0);
        transition5.setToX(180);
        transition5.setInterpolator(Interpolator.EASE_BOTH);
        transition5.setCycleCount(Animation.INDEFINITE);
        transition5.setAutoReverse(true);
        transition5.play();


        /*7 Circle*/

        Circle cir6 = new Circle(20);
        cir6.setLayoutX(10);
        cir6.setLayoutY(20);
        DropShadow dropShadow6 = new DropShadow();
        dropShadow6.setColor(Color.color(0.88, 0.01, 0.98, 1.0));
        cir6.setEffect(dropShadow6);
        cir6.setFill(linearGradient);
        TranslateTransition transition6 = new TranslateTransition(Duration.millis(5000), cir6);
        transition6.setFromX(110);
        transition6.setFromY(150);
        transition6.setToY(380);
        transition6.setInterpolator(Interpolator.EASE_BOTH);
        transition6.setCycleCount(Animation.INDEFINITE);
        transition6.setAutoReverse(true);
        transition6.play();


        Button register = new Button("Register A New Account");
        register.setLayoutX(90);
        register.setLayoutY(370);
        register.setBackground(new Background(new BackgroundFill(Color.color(0.2, 0.2, 0.2, 1.0),CornerRadii.EMPTY,Insets.EMPTY)));
        register.setTextFill(linearGradient1);

        register.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    new RegisterPanel().start(new Stage());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Button login = new Button("Login an Existing Account");
        login.setLayoutX(90);
        login.setLayoutY(330);
        login.setBackground(new Background(new BackgroundFill(Color.color(0.2, 0.2, 0.2, 1.0),CornerRadii.EMPTY,Insets.EMPTY)));
        login.setTextFill(linearGradient1);

        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    new LoginPage().start(new Stage());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });


        Text text = new Text("Setting");
        text.setFill(linearGradient3);
        text.setFont(Font.font("Adiro", FontWeight.BOLD, 60));
        text.setX(45.0);
        text.setY(10.0);
        text.setTextOrigin(VPos.TOP);

        text.setEffect(lighting);

            root.getChildren().addAll(button,cir,cir1,cir2,cir3,cir4,cir5,cir6,register,login,text);
            root.setBackground(new Background(new BackgroundFill(new Color( 0.2, 0.2, 0.2, 1.0),CornerRadii.EMPTY,Insets.EMPTY)));

            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            makeStageDraggable(stage,scene);
            stage.show();
    }

    private void   makeStageDraggable(Stage stage ,Scene scene) {
        scene.setOnMousePressed(pressEvent ->{
            scene.setOnMouseDragged(dragEvent->{
                stage.setX(dragEvent.getScreenX() - pressEvent.getSceneX());
                stage.setY(dragEvent.getScreenY() - pressEvent.getSceneY());
            });
        });
    }
}
