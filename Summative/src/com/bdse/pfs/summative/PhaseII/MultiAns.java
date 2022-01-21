package com.bdse.pfs.summative.PhaseII;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MultiAns extends QuestionAndAnswer{
    public static int[] getMultipleAns(int anslength) {
    Scanner getAnswer = new Scanner(System.in);
    String [] PossibleAns = {"A","B","C","D"};
    Pattern AnsRegex = Pattern.compile("[a-dA-D]");
    int []AnsKey = new int[anslength];

    String Answer1 = getAnswer.next();
    Matcher match1 = AnsRegex.matcher(Answer1);
    String Answer2 = getAnswer.next();
    Matcher match2 = AnsRegex.matcher(Answer2);
    boolean matchFound1 = match1.find();
    boolean matchFound2 = match2.find();

    if (Answer1.length() !=1 || Answer2.length()!=1){
        System.out.println("enter a new response.");
    }else{
        if ((matchFound1 && matchFound2)){
            if (Answer1.equalsIgnoreCase(Answer2)){
                System.out.println("enter a new response.");
            }else{
                for(int j = 0; j < PossibleAns.length; j++) {
                    if (Answer1.equalsIgnoreCase(PossibleAns[j])) {
                        AnsKey[0] = j;
                        break;
                    }
                }
                for (int i = 0; i < PossibleAns.length; i ++){
                    if (Answer2.equalsIgnoreCase(PossibleAns[i])){
                        AnsKey[1] = i;
                        break;
                    }
                }
                return AnsKey;
            }
        }else{
            System.out.println("enter a valid response");

        }
    }
        return getMultipleAns(anslength);
    }
}
