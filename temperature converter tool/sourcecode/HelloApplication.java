package com.javaintern.projectdemo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage primaryStage) throws IOException{

        System.out.println("start");    // Starts an application

        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("hello-view.fxml"));
        VBox rootNode =  fxmlLoader.load();

        MenuBar menuBar = createMenu();
        rootNode.getChildren().add(0,menuBar);//here if we don't give index then the welcome text will be the first then menuBar we don't want that

        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter Tool");
        primaryStage.show();
    }

    private MenuBar createMenu() {
        Menu filemenu = new Menu("File");

        MenuItem newMenuItem=new MenuItem("New");
        newMenuItem.setOnAction(actionEvent ->System.out.println("New menu item is clicked"));

        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();

        MenuItem quitMenuItem=new MenuItem("Quit");
        filemenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);

        quitMenuItem.setOnAction(actionEvent -> {
            Platform.exit();
            System.exit(0);});

        Menu helpmenu = new Menu("Help");
        MenuItem aboutApp=new MenuItem("About");

        helpmenu.getItems().addAll(aboutApp);

        aboutApp.setOnAction(actionEvent -> aboutApp());

        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(filemenu, helpmenu);
        return menuBar;
    }

    private void aboutApp() {

       Alert alertDialog=new Alert(Alert.AlertType.INFORMATION);//Here we are creating an alertdialog whose type is information there are many other too.

       alertDialog.setTitle("Converter App");//it is the title of alert dialog
       alertDialog.setHeaderText("TEMPERATURE CONVERTER TOOL");//it is subtitle
       alertDialog.setContentText("It  will convert the given temperature to celsius or fahrenheit according to the user choice");//it will set content

      //here we are customizing our dialog content by adding two buttons yes and no which when clicked will do some action
      // as it is only for learning im commenting below code
      /* ButtonType yesbtn=new ButtonType("Yes");
       ButtonType nobtn=new ButtonType("No");

       alertDialog.getButtonTypes().setAll(yesbtn,nobtn);//here we added buttons to alertdialog
        Optional<ButtonType> clickedbtn=alertDialog.showAndWait();//here show and wait will return which button was clicked and store it in thr optional class(which is a container and a feature of java 8)

        if(clickedbtn.isPresent() && clickedbtn.get()==yesbtn)
        {
            System.out.println("yes button is clicked !");
        }
        else {
            System.out.println("No button is clicked !");
        }*/

        alertDialog.show();// it should be visible to our user hence we write show method
    }

}