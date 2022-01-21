package com.bdse.pfs.summative.PhaseII;



import com.bdse.pfs.summative.PhaseI.StudentStat;

import java.util.ArrayList;

import static com.bdse.pfs.summative.PhaseII.MultiAns.getMultipleAns;
import static com.bdse.pfs.summative.PhaseII.SingleAns.getSingleAns;

public class QuestionAndAnswer extends StudentStat {

    //Instantiation
    public int questioncounter = 1; /*Dictate what item of the 3 arraylist appears first*/
    private static int maximumquestion;

    public void promptQuestion(ArrayList<String> qna, ArrayList<String> choices, ArrayList<String> answers) {

        this.setMaxQuestion(qna.size()-1);
        this.maximumquestion = this.getMaxQuestion();
        while (questioncounter <= maximumquestion){
            String[] listofans = (choices.get(questioncounter)).split("-"); /*Splits the string retrieved into an array*/
            String [] answer = (answers.get(questioncounter)).split("-"); /*Splits the string retrieved into an array*/
            System.out.println();
            System.out.println(questioncounter + ". "+ qna.get(questioncounter));
            System.out.println("a. "+ listofans[0]);
            System.out.println("b. "+ listofans[1]);
            System.out.println("c. "+ listofans[2]);
            System.out.println("d. "+ listofans[3]);

            if (answer.length == 1){ /*If answers is one only this gets executed*/
                int getAns = getSingleAns(); /*Returns a number corresponding to the numbering of ABCD indexed in 0*/
                if (listofans[getAns].equals(answer[0])){ /*Since there's only one answer, it is inside the array and gets retrieved*/
                    System.out.println("your answer is " + listofans[getAns] + " and it is correct");
                }else{
                    System.out.println("Wrong the correct answer is " + answer[0]);
                    this.setMistakes(this.getMistakes()+ 1);/*Mistakes get incremented*/
                }

            }else{ /*If answers is more than one this gets executed*/
                int[] getAns = getMultipleAns(answer.length);/*takes in answers depending on the length of the answers*/
                if ((listofans[getAns[0]].equals(answer[0]) || listofans[getAns[0]].equals(answer[1])) &&   /* If first answer is either of the 2 correct answer*/
                        (listofans[getAns[1]].equals(answer[0]) || listofans[getAns[1]].equals(answer[1]))) /*If second answer is either of the 2 correct answer*/
                    {
                        System.out.println("your answers are " + listofans[getAns[0]] + " and " + listofans[getAns[1]]+ " and it is correct");
                }else {
                    System.out.println("Wrong the correct answer is " + answer[0] +" and " + answer[1]);
                        this.setMistakes(this.getMistakes()+ 1); /*Mistakes get incremented*/
                }
            }
            questioncounter++;
        }

        //Gets all information and store in StudentProfile
       this.setMistakes(this.getMistakes());
       this.setFinalPoints(this.getMaxQuestion() - this.getMistakes()); /*Computes the final score before setting it as the final points*/
       this.setPercentScore(Math.round((Double.valueOf(this.getFinalPoints())/this.getMaxQuestion()*100)*100)/100); /*takes 2 decimal places and transforms it to percent*/

    }

}
