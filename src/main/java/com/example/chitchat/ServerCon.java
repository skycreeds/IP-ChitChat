package com.example.chitchat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ServerCon  {
    Stage stage;
    public String Str;
    @FXML
    public TextField iptext;

    @FXML
   protected void OnButtonPressed(ActionEvent event) throws IOException {
        System.out.print("sssssssssssssssssssssssssssssssssssssssssss");
        Str= iptext.getText();
        stage = (Stage) iptext.getScene().getWindow();
        Parent root= FXMLLoader.load(getClass().getResource("ChatWindow.fxml"));
        System.out.print("oooooooooooooooooooooooooooooooooooooo");
        stage.setScene(new Scene(root));
        stage.show();
    }

}
