package com.example.chitchat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;


import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends Application {




    @Override
    public void start(Stage stage) throws IOException {

        System.out.print("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
        Parent root=FXMLLoader.load(getClass().getResource("Serverconfig.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
        System.out.print("llllllllllllllllllllllllllll");
        }

    public static void main(String[] args) {
        launch();
    }
}