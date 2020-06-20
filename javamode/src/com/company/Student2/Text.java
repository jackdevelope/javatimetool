package com.Student1;

import java.io.Serializable;
import java.util.Objects;

public class Text implements Serializable{
    private  String textid;
    private  String textoption;
    private  String answer;
    private  String youranswer;
    public  String getTextid() {
        return textid;
    }

    public void setTextid() {
        double a=Math.random()*(3-1)+1;
        String string=Double.toString(a);
        this.textid=string;
    }

    public String getTextoption() {
        return textoption;
    }

    public void setTextoption() {
        this.textoption="3+4+5";
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer() {
        this.answer="A";
    }

    public String getYouranswer() {
        return youranswer;
    }

    public void setYouranswer(String youranswer) {
        this.youranswer = youranswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text = (Text) o;
        return answer.equals(text.youranswer);
    }
    @Override
    public int hashCode() {
        return Objects.hash(answer);
    }

    @Override
    public String toString() {
        return "Text{" +
                "textid='" + textid + '\'' +
                ", textoption='" + textoption + '\'' +
                '}';
    }
}
