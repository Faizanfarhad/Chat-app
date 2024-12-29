package com.myapp.hellothere;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
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
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Light;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.SQLException;

public class LoginPage extends Application {
    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();
        Scene scene = new Scene(pane,400,500);


        /* Different Thread for server */
        Server server = new Server();
        Thread serverThread = new Thread( new ServerRunnable(server));
        serverThread.start();

        LinearGradient linearGradient = new LinearGradient(
                0.0,0.0,1.0,0.0,true,CycleMethod.NO_CYCLE,
                new Stop(0.0,new Color( 0.83, 0.85, 0.87, 1.0)),
                new Stop(1.0,new Color( 0.24, 0.33, 0.41, 1.0)));
        pane.setBackground(new Background(new BackgroundFill(Color.WHEAT, CornerRadii.EMPTY, Insets.EMPTY)));


        LinearGradient linearGradient2 =new LinearGradient(
                0.0,0.0,1.0,0.0,true,CycleMethod.NO_CYCLE,
                new Stop(0.0,new Color( 0.5, 0.0, 0.99, 1.0)),
                new Stop(1.0,new Color( 0.88, 0.01, 0.98, 1.0)));

        LinearGradient linearGradient3 = new LinearGradient(
                0.0,0.0,1.0,0.0,true,CycleMethod.NO_CYCLE,
                new Stop(0.0,new Color( 0.98, 0.3, 0.29, 1.0)),
                new Stop(1.0,new Color( 0.2, 0.56, 0.93, 1.0)));;

                LinearGradient linearGradient4 =new LinearGradient(
                        0.0,0.0,1.0,0.0,true,CycleMethod.NO_CYCLE,
                        new Stop(0.0,new Color( 0.76, 0.09, 0.01, 1.0)),
                        new Stop(1.0,new Color( 1.0, 0.78, 0.01, 1.0)));
                LinearGradient linearGradient5 = new LinearGradient(
                        0.0,0.0,1.0,0.0,true,CycleMethod.NO_CYCLE,
                        new Stop(0.0,new Color( 0.92, 0.8, 1.0, 1.0)),
                        new Stop(1.0,new Color( 0.65, 0.23, 0.9, 1.0)));

        Light.Distant light = new Light.Distant();
        light.setAzimuth(19);
//        light.setColor();

        /*First  circle */

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
            transition1.setToX(399);
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
        cir3.setEffect(dropShadow3);
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

        Circle cir4 = new Circle(20);
        cir4.setLayoutX(10);
        cir4.setLayoutY(20);
        DropShadow dropShadow4 = new DropShadow();
        dropShadow4.setColor(Color.color(0.88, 0.01, 0.98, 1.0));
        cir4.setEffect(dropShadow4);
        cir4.setFill(linearGradient);
        TranslateTransition transition4 = new TranslateTransition(Duration.millis(5000), cir4);
        transition4.setFromX(180);
        transition4.setToY(500);
        transition4.setInterpolator(Interpolator.EASE_BOTH);
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


        /* Button */

        Button button = new Button("X");
        BackgroundFill fill = new BackgroundFill(Color.WHEAT,CornerRadii.EMPTY,Insets.EMPTY);
        Background bg = new Background(fill);
        button.setBackground(bg);
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


        /* Login Section */

        TextField username = new TextField();
        username.setLayoutX(110);
        username.setLayoutY(240);
        username.setPromptText("Enter UserName");
        username.setBackground(bg);


        PasswordField passwordField = new PasswordField();
        passwordField.setLayoutX(110);
        passwordField.setLayoutY(280);
        passwordField.setPromptText("Enter Password");
        passwordField.setBackground(bg);

        Label label = new Label("Enter Details");
        label.setLayoutX(120);
        label.setLayoutY(210);
        label.setTextFill(linearGradient3);
        label.setFont(Font.font("Arial",FontWeight.BOLD,14));
        label.setFont(Font.font(12));

        /* Login Button  */

        Button login =  new Button("Log in");
        login.setBackground(bg);
        login.setFont(Font.font("Arial", FontWeight.BOLD,12));
        login.setTextFill(linearGradient3);
        login.setLayoutX(140);
        login.setLayoutY(320);

        login.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                scene.setCursor(Cursor.HAND);
            }
        });

        login.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                scene.setCursor(Cursor.DEFAULT);
            }
        });

                /*  Profile Section */

                InputStream imageInput = new FileInputStream(new File("src/main/java/com/myapp/hellothere/Defaultpp.jpg"));
                Image image = new Image(imageInput);
                ImageView avatarImage = new ImageView(image);

                avatarImage.setStyle(
                        "-fx-background-color: wheat; " +
                                "-fx-border-color: #cccccc; " +
                                "-fx-border-width: 1px; " +
                                "-fx-border-radius: 60%; " +
                                "-fx-padding: 8px;"
                );

                avatarImage.setEffect(dropShadow4);
                avatarImage.setFitWidth(103);
                avatarImage.setFitHeight(101);

                Circle circle = new Circle(51,50,40);
                avatarImage.setClip(circle);
                avatarImage.setLayoutX(140);
                avatarImage.setLayoutY(80);


            /*  Register Area */

           Label label2 = new Label("Don't have an account?");
           label2.setTextFill(linearGradient5);
           label2.setLayoutX(80);
           label2.setLayoutY(440);

            Button register = new Button("Register");
            register.setBackground(bg);
            register.setFont(Font.font("Arial",FontWeight.BOLD,14));
            register.setTextFill(linearGradient4);
            register.setLayoutX(240);
            register.setLayoutY(435);

        register.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                scene.setCursor(Cursor.HAND);
            }
        });

        register.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                scene.setCursor(Cursor.DEFAULT);
            }
        });

            /* Register Panel connection */

        register.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
               try{
                   new RegisterPanel().start(new Stage());
               }catch(Exception e){
                   e.printStackTrace();
               }
            }
        });


        login.setOnAction(e -> {
            try {
                handleLogin(username.getText(), passwordField.getText());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        pane.getChildren().addAll(cir,cir1,cir2,cir3,cir4,cir5,button,username,label,passwordField,login,avatarImage,label2,register);
        stage.initStyle(StageStyle.UNDECORATED);
        makeStageDraggable(stage,scene);
        stage.setScene(scene);

        stage.show();
    }


    private void handleLogin(String username, String password) throws Exception {
        UserAuthenticator authenticator = new UserAuthenticator();
        if (authenticator.authenticate(username,password)){
            System.out.println("Login Successful");

            startChat();
        }else {
            System.out.println("Invalid username or password");
        }
    }

        private void startChat() throws Exception {
            System.out.println(" Redirecting to chat room...");
            MainChatPanel mainChatPanel = new MainChatPanel();
            mainChatPanel.start(new Stage());

        }

        public  class ServerRunnable implements  Runnable{
        private Server server;

        public  ServerRunnable(Server server){
            this.server = server;
        }

            @Override
            public void run() {
                server.run();
            }
        }

        /*  Draggable Stage  */
    private void makeStageDraggable(Stage stage, Scene scene) {
        scene.setOnMousePressed(pressEvent -> {
            scene.setOnMouseDragged(dragEvent -> {
                stage.setX(dragEvent.getScreenX() - pressEvent.getSceneX());
                stage.setY(dragEvent.getScreenY() - pressEvent.getSceneY());
            });
        });
    }
}
