package com.example.midtermexam;

public class Student {
    private int studentNumber;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String province;
    private double averageGrade;
    private String major;

    // Constructor with validation
    public Student(int studentNumber, String firstName, String lastName, String phone,
                   String address, String province, double averageGrade, String major) {
        if (studentNumber <= 200034000) throw new IllegalArgumentException("Invalid student number");
        if (firstName.length() <= 1 || lastName.length() <= 1) throw new IllegalArgumentException("Invalid name");
        if (!phone.matches("^\\d{3}-\\d{3}-\\d{4}$")) throw new IllegalArgumentException("Invalid phone number format");
        if (address.length() <= 6) throw new IllegalArgumentException("Address must be longer than 6 characters");
        if (!province.matches("AB|BC|MB|NB|NL|NS|NT|NU|ON|PE|QC|SK|YT")) throw new IllegalArgumentException("Invalid province");
        if (averageGrade < 0 || averageGrade > 100) throw new IllegalArgumentException("Average grade must be between 0 and 100");
        if (major.length() <= 5) throw new IllegalArgumentException("Major must be longer than 5 characters");

        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.province = province;
        this.averageGrade = averageGrade;
        this.major = major;
    }

    // Getters
    public int getStudentNumber() { return studentNumber; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    public String getProvince() { return province; }
    public double getAverageGrade() { return averageGrade; }
    public String getMajor() { return major; }

    // Setters
    public void setStudentNumber(int studentNumber) { this.studentNumber = studentNumber; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setAddress(String address) { this.address = address; }
    public void setProvince(String province) { this.province = province; }
    public void setAverageGrade(double averageGrade) { this.averageGrade = averageGrade; }
    public void setMajor(String major) { this.major = major; }
}
