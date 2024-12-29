package com.myapp.hellothere;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.geometry.Insets;
import java.io.*;
import java.net.Socket;
import static java.lang.System.exit;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.scene.input.KeyCode;

public class MainChatPanel extends Application {


    @Override
    public void start(Stage stage)  throws Exception {






        LinearGradient linearGradient =new LinearGradient(
                0.0,0.0,1.0,0.0,true,CycleMethod.NO_CYCLE,
                new Stop(0.0,new Color( 0.98, 0.0, 0.99, 1.0)),
                new Stop(1.0,new Color( 0.01, 0.86, 0.87, 1.0)));

        LinearGradient linearGradient2 = new LinearGradient(
                0.0,0.0,1.0,0.0,true,CycleMethod.NO_CYCLE,
                new Stop(0.0,new Color( 0.99, 0.87, 0.91, 1.0)),
                new Stop(1.0,new Color( 0.71, 1.0, 0.99, 1.0)));

        Color paint = new Color(0.0391, 0.0252, 0.3026, 1.0);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.color(0.88, 0.01, 0.98, 1.0));

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1200, 730);
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(1200,40);
        Color orange = new Color(1.0, 0.3057, 0.01, 1.0);
        anchorPane.setBackground(new Background(new BackgroundFill(paint, CornerRadii.EMPTY, Insets.EMPTY)));
        root.setTop(anchorPane);


        /*  Close  Button */

        Button button = new Button("X");
        double buttonRadius = 15;
        button.setMinSize(buttonRadius * 2, buttonRadius *2);
        button.setMaxSize(buttonRadius * 2, buttonRadius *2);
        Circle cir = new Circle(buttonRadius,buttonRadius,buttonRadius);
        button.setLayoutX(1130);
        button.setLayoutY(20);
        button.setTextFill(Color.BLACK);
        button.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD,14));
        button.setBackground(new Background(new BackgroundFill(orange,CornerRadii.EMPTY,Insets.EMPTY)));
        button.setEffect(dropShadow);
        dropShadow.setSpread(30);
        button.setClip(cir);
        anchorPane.getChildren().add(button);

        button.setOnAction(e ->{
            stage.close();
        });



        /* Chat App Label */
        Label label = new Label("SayHello");
        label.setFont(Font.font(40));
//        label.setFont(Font.font("Arial",FontWeight.EXTRA_BOLD,70));
        label.setTextFill(linearGradient2);
        label.setLayoutX(500);
        label.setLayoutY(10);
        anchorPane.getChildren().add(label);


        /*   Setting Button  */
        InputStream input = new FileInputStream(new File("src/main/java/com/myapp/hellothere/setting.png"));
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        Button setting = new Button("",imageView);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        imageView.setPreserveRatio(true);
        double buttonRadius1 = 15;
        setting.setMinSize(buttonRadius1 * 2, buttonRadius1 *2);
        setting.setMaxSize(buttonRadius1 * 2, buttonRadius1 *2);
        Circle cir1 = new Circle(buttonRadius1,buttonRadius1,buttonRadius1);
        setting.setLayoutX(1080);
        setting.setLayoutY(20);
        setting.setTextFill(Color.BLACK);
        setting.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD,14));
        setting.setClip(cir1);
        setting.setEffect(dropShadow);
        dropShadow.setSpread(10);
        setting.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                       try {

                            new settingPage().start(new Stage());
                       } catch (IllegalArgumentException e){
                           e.printStackTrace();
                       }
            }
        });

        anchorPane.getChildren().add(setting);

        /*   Profile Section    */
        InputStream imageInput = new FileInputStream(new File("src/main/java/com/myapp/hellothere/Me.JPG"));
        Image image2 = new Image(imageInput);
        ImageView avatarImage = new ImageView(image2);
        imageView.setPreserveRatio(true);
        avatarImage.setStyle(
                "-fx-background-color: wheat; " +
                        "-fx-border-color: #cccccc; " +
                        "-fx-border-width: 1px; " +
                        "-fx-border-radius: 60%; " +
                        "-fx-padding: 8px;"
        );
        avatarImage.setFitWidth(103);
        avatarImage.setFitHeight(101);

        Circle circle = new Circle(51,50,40);
        avatarImage.setClip(circle);
        avatarImage.setLayoutX(10);
        avatarImage.setLayoutY(-5);
        anchorPane.getChildren().add(avatarImage);

        ComboBox<String> statusComboBox = new ComboBox<>();
        statusComboBox.getItems().addAll("Online", "Away", "Busy", "Offline");
        statusComboBox.setPromptText("Status");
        statusComboBox.setValue("Online");
        statusComboBox.setStyle(
                "-fx-background-color: white;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 12px;"
        );
        statusComboBox.setLayoutX(110);
        statusComboBox.setLayoutY(30);
        anchorPane.getChildren().add(statusComboBox);



        /*  Left Section of the  BoderPane    */

        SplitPane sp = new SplitPane();
        sp.setPrefSize(200,640);
        ListView<Object> leftListView = new ListView<>();
        leftListView.setPrefWidth(sp.getPrefWidth());
        leftListView.setPrefHeight(sp.getPrefHeight());
        leftListView.setLayoutY(sp.getLayoutX());
        leftListView.setLayoutY(sp.getLayoutY());
        leftListView.setFixedCellSize(50);
        sp.getItems().add(leftListView);
        root.setLeft(sp);

        Label label1 = new Label("Online Users  : ");
        label1.setPrefWidth( 20 +leftListView.getPrefWidth());
        label1.setPrefHeight(leftListView.getPrefHeight() - 600);
        label1.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY,CornerRadii.EMPTY,Insets.EMPTY)));
        leftListView.getItems().add(label1);
        /*  Center Part of the BorderPane */
        ListView<String> listView1 = new ListView<>();
        listView1.getItems().addAll("");
        listView1.setFixedCellSize(50);
        listView1.setOnScrollStarted(new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent scrollEvent) {
                listView1.setOnScrollStarted(scrollEvent1 -> {
                    listView1.getOnScroll();
                });
            }
        });
        root.setCenter(listView1);

        /*   Bottom Part   */

      AnchorPane bottom = new AnchorPane();
      bottom.setBackground(new Background(new BackgroundFill(paint,CornerRadii.EMPTY,Insets.EMPTY)));
      bottom.setPrefSize(1200,40);
      root.setBottom(bottom);


        /*  Send_Button && TextField && Client Implementation */
        Client  client = new Client(listView1);
        client.connect();

      TextField textField = new TextField();
      textField.setPrefSize(1000,35);
      textField.setLayoutX(  200 + bottom.getLayoutX());
      textField.setLayoutY(bottom.getLayoutY());
      textField.setOnKeyPressed(e ->{
          if (e.getCode() == KeyCode.ENTER){
              String message = textField.getText();
              if (message != null){
                  client.sendMessage(message);
                  textField.clear();
              }
              e.consume();
          }
      });

      bottom.getChildren().add(textField);

      Button send = new Button("Send");
      send.setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent actionEvent) {
            String message = textField.getText();
            if (message != null){
                client.sendMessage(message);
              textField.clear();
            }
          }
      });


      send.setPrefWidth(90);
      send.setPrefHeight(40);
      send.setLayoutX(textField.getLayoutX() + 910);
      send.setLayoutY(textField.getLayoutY());
      bottom.getChildren().add(send);

        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        makeStageDraggable(stage, scene);
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
