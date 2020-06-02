package com.company.Student;

public class Student {
    private String name;
    private String stdId;
    private String age;
    private String place;
    public Student() {

    }
    public Student(String name, String stdId, String age, String place) {
        super();
        this.name = name;
        this.stdId = stdId;
        this.age = age;
        this.place = place;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStdId() {
        return stdId;
    }
    public void setStdId(String stdId) {
        this.stdId = stdId;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }
}
