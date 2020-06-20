package com.Student1;

import java.io.Serializable;
import java.util.Objects;

public class Grade implements Serializable {
    private String stdId;
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnwser() {
        return anwser;
    }

    public void setAnwser(String anwser) {
        this.anwser = anwser;
    }

    private String anwser;
    private String grade;
    public String getStdId() {
        return stdId;
    }

    public void setStdId(String stdId) {
        this.stdId = stdId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "stdId='" + stdId + '\'' +
                ", anwser='" + anwser + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
