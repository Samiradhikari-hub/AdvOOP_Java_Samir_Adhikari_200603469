package com.example.midtermexam;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class StudentViewController {

    @FXML
    private TableView<Student> tableView;

    @FXML
    private TableColumn<Student, Integer> studentNumCol;

    @FXML
    private TableColumn<Student, String> firstNameCol;

    @FXML
    private TableColumn<Student, String> lastNameCol;

    @FXML
    private TableColumn<Student, String> telephoneCol;

    @FXML
    private TableColumn<Student, String> addressCol;

    @FXML
    private TableColumn<Student, String> provinceCol;

    @FXML
    private TableColumn<Student, Integer> avgGradeCol;

    @FXML
    private TableColumn<Student, String> majorCol;

    @FXML
    private CheckBox ontarioCheckBox;

    @FXML
    private Label numOfStudentsLabel;

    @FXML
    private CheckBox honourRollCheckBox;

    @FXML
    private ComboBox<String> areaCodeComboBox;

    private ObservableList<Student> allStudents = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        areaCodeComboBox.getItems().add("All");
        areaCodeComboBox.getItems().add("416");
        areaCodeComboBox.getItems().add("647");
        areaCodeComboBox.getItems().add("905");

        studentNumCol.setCellValueFactory(new PropertyValueFactory<>("studentNumber"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        telephoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        provinceCol.setCellValueFactory(new PropertyValueFactory<>("province"));
        avgGradeCol.setCellValueFactory(new PropertyValueFactory<>("averageGrade"));
        majorCol.setCellValueFactory(new PropertyValueFactory<>("major"));


    }

    @FXML
    private void applyFilter() {
        ObservableList<Student> filteredStudents = FXCollections.observableArrayList();

        if (ontarioCheckBox.isSelected()) {
            for (Student student : allStudents) {
                if (student.getProvince().equals("ON")) {
                    filteredStudents.add(student);
                }
            }
        }

        if (honourRollCheckBox.isSelected()) {
            for (Student student : filteredStudents.isEmpty() ? allStudents : filteredStudents) {
                if (student.getAverageGrade() >= 80) {
                    filteredStudents.add(student);
                }
            }
        }

        String selectedAreaCode = areaCodeComboBox.getSelectionModel().getSelectedItem();
        if (selectedAreaCode != null && !selectedAreaCode.equals("All")) {
            for (Student student : filteredStudents.isEmpty() ? allStudents : filteredStudents) {
                if (student.getPhone().startsWith(selectedAreaCode)) {
                    filteredStudents.add(student);
                }
            }
        }

        tableView.setItems(filteredStudents);
    }
}
