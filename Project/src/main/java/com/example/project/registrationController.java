package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class registrationController {
    @FXML
    private TextField user;
    @FXML
    private PasswordField pass;
    @FXML
    private TextField balance;
    private Button login;
    @FXML
    private Label status;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private String username;


@FXML
    protected void registerClick(ActionEvent event) throws IOException {
        File folder = new File("target/classes/com/example/project/"+user.getText().toLowerCase());
        try {
            if (checker()) {

                if (folder.mkdir()) {
                    File file = new File(folder +"/user.txt");
                    FileWriter w = new FileWriter(file);
                    PrintWriter p = new PrintWriter(w);

                    p.println(user.getText()+","+pass.getText()+","+balance.getText());
                    p.close();

                    System.out.println("Signup Successfully");
                    Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root, 1049, 518);
                    stage.setScene(scene);
                    stage.show();
                } else {
                    status.setVisible(true);
                    status.setText("Username already used");
                }
            }
        }
        catch (Exception e){
                System.out.println(e);
            }


    }
    @FXML
    private boolean checker(){
        if(user.getText().isEmpty()){
            status.setVisible(true);
            status.setText("Missing Username");
            return false;
        }
        if(pass.getText().isEmpty()){
            status.setVisible(true);
            status.setText("Missing Password");
            return false;
        }
        if(balance.getText().isEmpty()){
            status.setVisible(true);
            status.setText("Missing Balance");
            return false;
        }
        return true;
    }
}