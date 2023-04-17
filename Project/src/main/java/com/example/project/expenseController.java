package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class expenseController {

    @FXML
    private DatePicker date1;
    @FXML
    private TextField source1;
    @FXML
    private TextField amount1;
    @FXML
    private TextField description1;
    @FXML
    private DatePicker date2;
    @FXML
    private TextField source2;
    @FXML
    private TextField amount2;
    @FXML
    private TextField description2;
    @FXML
    private DatePicker date3;
    @FXML
    private TextField source3;
    @FXML
    private TextField amount3;
    @FXML
    private TextField description3;
    @FXML
    private DatePicker date4;
    @FXML
    private TextField source4;
    @FXML
    private TextField amount4;
    @FXML
    private TextField description4;
    @FXML
    private DatePicker date5;
    @FXML
    private TextField source5;
    @FXML
    private TextField amount5;
    @FXML
    private TextField description5;
    @FXML
    private Label status;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;

    @FXML
    private void submitClick(ActionEvent event) throws IOException {



        File folder = new File("target/classes/com/example/project/"+getUsername());
        File file = new File(folder +"/expense.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        FileWriter w = new FileWriter(file, true);
        PrintWriter p = new PrintWriter(w);


        File file2 = new File(folder +"/transactions.txt");
        if (!file2.exists()){
            file2.createNewFile();
        }
        FileWriter w2 = new FileWriter(file2, true);
        PrintWriter p2 = new PrintWriter(w2);

        File file3 = new File(folder +"/expenseAmount.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        FileWriter w3 = new FileWriter(file3, true);
        PrintWriter p3 = new PrintWriter(w3);


        try {
            if (checker1()) {
                p.println(date1.getValue() +","+ source1.getText() + ","+amount1.getText() +","+ description1.getText());
                p2.println(date1.getValue() +","+ source1.getText() + ","+amount1.getText() +","+ description1.getText()+",expense");
                p3.println(amount1.getText());
            } else {
                status.setVisible(true);
                status.setText("No Values Inputted");
            }
            if (checker2()) {
                p.println(date2.getValue() +","+ source2.getText() +","+ amount2.getText() +","+ description2.getText());
                p2.println(date2.getValue() +","+ source2.getText() +","+ amount2.getText() +","+ description2.getText()+",expense");
                p3.println(amount2.getText());
            }
            if (checker3()) {
                p.println(date3.getValue() +","+ source3.getText() +","+ amount3.getText() +","+ description3.getText());
                p2.println(date3.getValue() +","+ source3.getText() +","+ amount3.getText() +","+ description3.getText()+",expense");
                p3.println(amount3.getText());
            }
            if (checker4()) {
                p.println(date4.getValue() +","+ source4.getText() +","+ amount4.getText() +","+ description4.getText());
                p2.println(date4.getValue() +","+ source4.getText() +","+ amount4.getText() +","+ description4.getText()+",expense");
                p3.println(amount4.getText());
            }
            if (checker5()) {
                p.println(date5.getValue() +","+ source5.getText() +","+ amount5.getText() +","+ description5.getText());
                p2.println(date5.getValue() +","+ source5.getText() +","+ amount5.getText() +","+ description5.getText()+",expense");
                p3.println(amount5.getText());
            }
            p2.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
        p.close();
        if(checker1() || checker2() || checker3() || checker4() || checker5()) {
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
        }

    }

    private boolean checker1(){
        if(date1.getValue() == null) return false;
        if(source1.getText().isBlank()) return false;
        if(amount1.getText().isBlank()) return false;
        if(description1.getText().isBlank())return false;
        return true;

}
    private boolean checker2(){
        if(date2.getValue() == null) return false;
        if(source2.getText().isBlank()) return false;
        if(amount2.getText().isBlank()) return false;
        if(description2.getText().isBlank())return false;
        return true;

    }
    private boolean checker3(){
        if(date3.getValue() == null) return false;
        if(source3.getText().isBlank()) return false;
        if(amount3.getText().isBlank()) return false;
        if(description3.getText().isBlank())return false;
        return true;

    }
    private boolean checker4(){
        if(date4.getValue() == null) return false;
        if(source4.getText().isBlank()) return false;
        if(amount4.getText().isBlank()) return false;
        if(description4.getText().isBlank())return false;
        return true;

    }
    private boolean checker5(){
        if(date5.getValue() == null) return false;
        if(source5.getText().isBlank()) return false;
        if(amount5.getText().isBlank()) return false;
        if(description5.getText().isBlank())return false;
        return true;

    }
}