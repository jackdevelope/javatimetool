package com.Student1;

import java.util.Objects;

public class Grade implements Serializable{
    private String stdId;
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
                ", grade='" + grade + '\'' +
                '}';
    }
}
