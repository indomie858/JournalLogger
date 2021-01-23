package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.time.LocalDate;

public class Controller {

    @FXML
    private DatePicker dateInput = new DatePicker();
    @FXML
    private TextArea journalInput = new TextArea();
    @FXML
    private TextField hoursInput = new TextField();
    @FXML
    private TextField labNumberInput = new TextField();
    @FXML
    private Button submitButton = new Button();

    @FXML
    private void handleSubmitButtonAction(ActionEvent event) {
        try {
            String date = getDate();
            String hoursWorked = getHoursWorked();
            String journalMessage = getJournalMessage();
            String journalEntry = date + " : " + hoursWorked + " : " + journalMessage;
            System.out.println(journalEntry);

            String labNumber = getLabNumber();
            String fileName = "CIT496P_lab" + labNumber + ".txt";

            File tempFile = new File(fileName);
            boolean fileExists = tempFile.exists();
            System.out.println(fileExists);

            if (!fileExists) {
                createFile(fileName);
            }
            writeToFile(fileName, journalEntry);
        } catch (Exception e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    private String getLabNumber(){
        return labNumberInput.getText();
    }

    private String getDate() {
        LocalDate date = dateInput.getValue();
        int dayOfMonth = date.getDayOfMonth();
        int month = date.getMonthValue();
        int year = date.getYear();
        return month + "/" + dayOfMonth + "/" + year;
    }

    private String getHoursWorked() {
        return hoursInput.getText();
    }

    private String getJournalMessage() {
        return journalInput.getText();
    }

    private void createFile(String fileName) {
        try {
            //String userHomeFolder = System.getProperty("user.home");
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void writeToFile(String fileName, String journalEntry) {
        try(FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(journalEntry + "\n");
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
