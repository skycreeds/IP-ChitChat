package com.example.chitchat;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;


public class ClientController implements Initializable{

    @FXML
    public TextField Textid2;
    @FXML
    public Label Label2;
    @FXML
    public Label Label1;
    @FXML
    public TextField WriteField;
    @FXML
     public TextField ipfield;

    String info="";
    private client2 client;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
              ServerCon server =new ServerCon();

               System.out.print("fffffffffffffffffffffffffffffffffffffffffffffff");
               client= new client2(new Socket(server.Str,50002));
               client.IncomingM();
        } catch (IOException e) {
            Label1.setText("server not connected");
        }

    }

    @FXML
    protected void KeyPressed(KeyEvent event) throws IOException {

        if(event.getCode()==KeyCode.ENTER){
            String info2;
            info2=WriteField.getText();
            client.DataOut(info2);
            info=info+"\n"+info2;
            Label1.setText(info);
        }

    }




}