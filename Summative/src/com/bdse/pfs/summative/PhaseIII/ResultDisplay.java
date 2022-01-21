package com.bdse.pfs.summative.PhaseIII;

import com.bdse.pfs.summative.PhaseI.StudentStat;

import java.util.Scanner;

public class ResultDisplay extends StudentStat {

    public void retrieveResult() { //Method that displays the final result

        System.out.println("Hi " + this.getName() + ", You answered " + this.getFinalPoints() +" Questions Right, " + this.getMistakes() +
                " Questions Wrong for a total of " + this.getMaxQuestion() + " Questions. You scored " + this.getPercentScore() + "%");

        //Feature added not in the Project Brief
        System.out.println("Do you want to see your stats? Type Y for yes and N for no");
        while(true){
            Scanner DisplayStat = new Scanner(System.in);
            String Stats = DisplayStat.next();

            if (Stats.equalsIgnoreCase("Y")){
                System.out.println("Here is the overall statistics of your MCQ test. \n");
                System.out.println(this + "\n");
                System.out.println("Thank you for answering, have a nice day!");
                break;
            }else if (Stats.equalsIgnoreCase("N")){
                System.out.println("Thank you for answering, have a nice day!");
                break;
            }else{
                System.out.println("Please enter an appropriate response");
            }
        }

    }

}
