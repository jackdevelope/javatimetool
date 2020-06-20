package com.Student1;

public class Student implements Serializable{
    private String name;
    private String stdId;
    private String pass;
    public Student() {

    }
    public Student(String name, String stdId, String pass) {
        super();
        this.name = name;
        this.pass = pass;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", stdId='" + stdId + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
