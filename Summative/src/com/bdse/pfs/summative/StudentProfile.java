package com.bdse.pfs.summative;

import java.util.ArrayList;

public abstract class StudentProfile {

    //Instantiation
    private String Name;
    private String Subject;
    private ArrayList<String> Questions = new ArrayList<>();
    private ArrayList<String> Choices = new ArrayList<>();
    private ArrayList<String> Answers = new ArrayList<>();


    //setter
    public void setName(String name) {
        Name = name;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public void setQuestions(ArrayList<String> questions) {
        Questions = questions;
    }

    public void setAnswers(ArrayList<String> answers) {
        Answers = answers;
    }

    public void setChoices(ArrayList<String> choices) {
        Choices = choices;
    }


    //getter


    public String getName() {
        return Name;
    }

    public String getSubject() {
        return Subject;
    }

    public ArrayList<String> getQuestions() {
        return Questions;
    }

    public ArrayList<String> getChoices() {
        return Choices;
    }

    public ArrayList<String> getAnswers() {
        return Answers;
    }

    public abstract void startTest();

}
