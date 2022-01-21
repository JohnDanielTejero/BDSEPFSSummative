package com.bdse.pfs.summative.PhaseI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RetrieveQuestion extends StudentStat{

    //Instantiation
    private static String line = "";
    private static String splitBy = ",";
    private ArrayList<String> questionsbuffer = new ArrayList<String>();
    private ArrayList<String> choicesbuffer = new ArrayList<String>();
    private ArrayList<String> answersbuffer = new ArrayList<String>();

    public void retrieve(){
        try{
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("src\\com\\bdse\\pfs\\summative\\questions\\" + this.getSubject() + ".csv"));
            while ((line = br.readLine()) != null) { //returns a Boolean value
                String[] qna = line.split(splitBy); //used comma as separator
                //[Question, Choices, Answer]

                this.questionsbuffer.add(qna[0]); /*Stores the questions to the arraylist*/
                this.choicesbuffer.add(qna[1]); /*Stores the choices to the arraylist*/
                this.answersbuffer.add(qna[2]); /*Stores the answers to the arraylist*/
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        //sets the StudentProfile variables to gathered arraylists of their respective type
        this.setQuestions(questionsbuffer);
        this.setChoices(choicesbuffer);
        this.setAnswers(answersbuffer);

    }

}

