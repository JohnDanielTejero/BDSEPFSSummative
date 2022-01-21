package com.bdse.pfs.summative.PhaseII;

import com.bdse.pfs.summative.PhaseI.StudentStat;
import java.util.ArrayList;

import static com.bdse.pfs.summative.PhaseII.DynamicAnswerValidator.takeAnswer;

public class QuestioningAndAnswering extends StudentStat {

    //Instantiation
    public int QuestionCounter = 1; /*Dictate what item of the 3 arraylist appears first*/
    private static int MaximumQuestion;

    public void promptQuestion(ArrayList<String> qna, ArrayList<String> choices, ArrayList<String> answers) {
        this.setMaxQuestion(qna.size()-1);
        this.MaximumQuestion = this.getMaxQuestion();

        while(QuestionCounter <= MaximumQuestion){
            String[] Listofans = (choices.get(QuestionCounter)).split("-"); /*Splits the string retrieved into an array*/
            String [] Answer = (answers.get(QuestionCounter)).split("-"); /*Splits the string retrieved into an array*/
            System.out.println();
            System.out.println(QuestionCounter + ". "+ qna.get(QuestionCounter));
            System.out.println("a. "+ Listofans[0] + "\nb. " + Listofans[1] + "\nc. " + Listofans[2] + "\nd. " + Listofans[3]);

            ArrayList<Integer> GetAnswer = takeAnswer(Answer.length);
            int Checking = 0;
            int CorrectCount = 0;
            ArrayList<Integer> AnswerRecord = new ArrayList<>();
            while (Checking < Answer.length){
                for (int i = 0; i <= Answer.length - 1; i++){
                    if (Listofans[GetAnswer.get(i)].equalsIgnoreCase(Answer[Checking])){
                        AnswerRecord.add(GetAnswer.get(i));
                        CorrectCount++;
                        break;
                    }else{
                        continue;
                    }
                }
                Checking++;
            }

            if (CorrectCount == Answer.length){
                /*Checks if the answer is correct and the display will depend on how many answers have been inputed*/
                if (Answer.length == 1){
                    System.out.print("Your answer is ");
                    for (int i = 0; i < AnswerRecord.size(); i++){
                        System.out.print(Listofans[AnswerRecord.get(i)] + " and it is correct.");
                    }
                    System.out.println();
                }else{
                    System.out.print("Your answers are ");
                    for (int i = 0; i < AnswerRecord.size(); i++){
                      if (i < AnswerRecord.size() - 1){
                          System.out.print(Listofans[AnswerRecord.get(i)] + ", ");
                      }else{
                          System.out.print("and " + Listofans[AnswerRecord.get(i)] + " and it is correct.");
                      }
                    }
                    System.out.println();
                }
            }else{
                /*Checks if the answer has one or more incorrect answer, the display shows as follows*/
                if (Answer.length == 1){
                    System.out.print("Wrong, the correct answer is ");
                    for (int i = 0; i < Answer.length; i ++){
                        System.out.print(Answer[i]);
                    }
                    System.out.println();
                }else{
                    System.out.print("Wrong, the correct answers are ");
                    for (int i = 0; i < Answer.length; i++){
                        if (i < Answer.length - 1){
                            System.out.print(Answer[i] + ", ");
                        }else{
                            System.out.print("and " + Answer[i] + ".");
                        }
                    }
                    System.out.println();
                }
                this.setMistakes(this.getMistakes()+ 1); /*Mistakes get incremented*/
            }
        AnswerRecord.clear();
        QuestionCounter++;
        }
        this.setMistakes(this.getMistakes());
        this.setFinalPoints(this.getMaxQuestion() - this.getMistakes()); /*Computes the final score before setting it as the final points*/
        this.setPercentScore(Math.round((Double.valueOf(this.getFinalPoints())/this.getMaxQuestion()*100)*100)/100); /*takes 2 decimal places and transforms it to percent*/

    }
}
