package com.example.project;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class categoriesIncomeController {

    @FXML
    private TextField category;
    @FXML
    private Button exit;
    private Stage stage;
    private Scene scene;
    private Parent root;


    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    private float balance;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    private String username;

    @FXML
    protected void submitClick(ActionEvent event) {
        try {
            File folder = new File("target/classes/com/example/project/" + getUsername());
            File file = new File(folder + "/incomeCategories.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter w = new FileWriter(file, true);
            PrintWriter p = new PrintWriter(w);

            p.println(category.getText());
            p.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Main_Menu.fxml"));
            Parent root = null;
            try {
                root = loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            mainMenuController main = loader.getController();
            main.setBalance(getBalance());
            main.setUsername(getUsername());

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root, 1049, 518);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}