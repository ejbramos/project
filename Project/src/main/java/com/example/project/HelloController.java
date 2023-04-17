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
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class HelloController {
    @FXML
    private TextField user;
    @FXML
    private PasswordField pass;
    @FXML
    private Button login;
    @FXML
    private Label status;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    protected void loginClick(ActionEvent event) throws IOException {

        File file = new File("target/classes/com/example/project/" + user.getText());

        try {
            if (checker()) {
            if (Files.exists(file.toPath())) {
                Scanner in = new Scanner(new File("target/classes/com/example/project/"+user.getText()+"/user.txt"));
                String input = in.nextLine();
                String[] sep = input.split(",");
                String password = sep[1];
                String money = sep[2];

                if (password.equals(pass.getText())) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Main_Menu.fxml"));
                    Parent root = loader.load();

                    mainMenuController main = loader.getController();
                    main.setBalance(Float.parseFloat(money));
                    main.setUsername(user.getText());

                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root, 1049, 518);
                    stage.setScene(scene);
                    stage.show();
                }
                else {
                    status.setVisible(true);
                    status.setText("Incorrect Password");
                }
            }
            else {
                status.setVisible(true);
                status.setText("Username not found");
            }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    protected void registerClick(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("registration.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root,1049, 518);
        stage.setScene(scene);
        stage.show();
    }
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
        return true;
    }
}
