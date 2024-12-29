package com.myapp.hellothere;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.util.Random;

public class RegisterPanel extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    Pane pane = new Pane();
    Scene scene = new Scene(pane,400, 500);

        GaussianBlur  blur = new GaussianBlur(1.2);

        LinearGradient linearGradient =  new LinearGradient(
                0.0,0.0,1.0,0.0,true,CycleMethod.NO_CYCLE,
                new Stop(0.0,new Color( 0.99, 0.87, 0.91, 1.0)),
                new Stop(1.0,new Color( 0.71, 1.0, 0.99, 1.0)));

            Background bg = new Background(new BackgroundFill(linearGradient,CornerRadii.EMPTY,Insets.EMPTY));
            pane.setBackground(bg);




        /* Circle */

        Circle cir = new Circle(20);
        cir.setLayoutX(20);
        cir.setLayoutY(20);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.color(0.88, 0.01, 0.98, 1.0));
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
        cir3.setEffect(blur);
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

        /* Button */

        Button button = new Button("X");
        BackgroundFill fill = new BackgroundFill(Color.color( 0.71, 1.0, 0.99, 1.0), CornerRadii.EMPTY, Insets.EMPTY);
        Background bg2 = new Background(fill);
        button.setBackground(bg2);
        button.setFont(Font.font("Arial", FontWeight.BOLD,17));
        button.setTextFill(Color.BLACK);
        button.setLayoutX(365);
        button.setLayoutY(3);
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




        /* Register Section */

        Label label1 = new Label("Username *");
        label1.setTextFill(Color.WHITE);
        label1.setLayoutX(100);
        label1.setLayoutY(190);
        TextField username = new TextField();
        username.setLayoutX(110);
        username.setLayoutY(210);
        username.setPromptText("Enter UserName");
        username.setBackground(bg);


        Label label4 = new Label("Enter Your Name *");
        label4.setTextFill(Color.WHITE);
        label4.setLayoutX(100);
        label4.setLayoutY(130);
        TextField name = new TextField();
        name.setLayoutX(110);
        name.setLayoutY(150);
        name.setPromptText("Enter Name");
        name.setBackground(bg);





        Label label2 = new Label("Password *");
        label2.setTextFill(Color.WHITE);
        label2.setLayoutX(100);
        label2.setLayoutY(260);
        PasswordField passwordField = new PasswordField();
        passwordField.setLayoutX(110);
        passwordField.setLayoutY(280);
        passwordField.setPromptText("Enter Password");
        passwordField.setBackground(bg);


        Label label3 = new Label("Confirm Password *");
        label3.setTextFill(Color.WHITE);
        label3.setLayoutX(100);
        label3.setLayoutY(320);
        PasswordField passwordField1 = new PasswordField();
        passwordField1.setLayoutX(110);
        passwordField1.setLayoutY(350);
        passwordField1.setPromptText("Confirm  Password");
        passwordField1.setBackground(bg);


        /*    Signup  Button      */

        Button signUp = new Button("Sign Up");
        signUp.setBackground(bg);
        signUp.setLayoutX(150);
        signUp.setLayoutY(395);
        signUp.setPrefSize(100, 40);

        signUp.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                scene.setCursor(Cursor.HAND);
            }
        });

        signUp.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                scene.setCursor(Cursor.DEFAULT);
            }
        });


        signUp.setOnAction(e -> {
            try {
                handleRegister(username.getText(), passwordField.getText() );
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });



        Label label6 = new Label("Register Your Account");
        label6.setTextFill(Color.color(0.5, 0.0, 0.99, 1.0));
        label6.setFont(Font.font("Arial", FontPosture.ITALIC,20));
        label6.setLayoutX(80);
        label6.setLayoutY(30);




        pane.getChildren().addAll(cir,cir1,cir2,cir3,cir4,cir5,cir6,button,label2,passwordField,label3,passwordField1,label1,username,label4,
                name,signUp,label6);
        stage.initStyle(StageStyle.UNDECORATED);
        makeStageDraggable(stage,scene);
        stage.setScene(scene);
        stage.show();
    }


    private void handleRegister(String username, String password) throws Exception {

        UserRegistration userRegistration = new UserRegistration();
        String hashedPassword = PasswordUtils.hashPassword(password);
        if (userRegistration.registerUser(username, hashedPassword)){
            System.out.println("Registration successful!");

            startChat();
        }else {
            System.out.println("Register failed!");
        }
    }

    private void startChat() throws Exception {
        System.out.println("Redirecting to Login Page....");

        LoginPage loginPage = new LoginPage();
        loginPage.start(new Stage());
    }

    private void makeStageDraggable(Stage stage, Scene scene) {
        scene.setOnMousePressed(pressEvent -> {
            scene.setOnMouseDragged(dragEvent -> {
                stage.setX(dragEvent.getScreenX() - pressEvent.getSceneX());
                stage.setY(dragEvent.getScreenY() - pressEvent.getSceneY());
            });
        });
    }
}
