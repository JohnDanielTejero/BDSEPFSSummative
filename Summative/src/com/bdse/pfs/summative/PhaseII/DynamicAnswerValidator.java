package com.bdse.pfs.summative.PhaseII;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DynamicAnswerValidator {

    public static ArrayList<Integer> takeAnswer(int anslength){
        Scanner getAnswer = new Scanner(System.in);
        String [] PossibleAns = {"A","B","C","D"};
        Pattern AnsRegex = Pattern.compile("[a-dA-D]");
        ArrayList <Integer> Anskey = new ArrayList<>();
        ArrayList<String> StoredAns = new ArrayList<>();
        int Counter = 1;

        while (Counter <= anslength){
            String Answer = getAnswer.next();
            Matcher match = AnsRegex.matcher(Answer);
            boolean matchFound = match.find();

            if (Answer.length()== 1){
                if (matchFound){
                    if (Anskey.size() == 0){
                        for (int i = 0; i < PossibleAns.length; i++){
                            if(Answer.equalsIgnoreCase(PossibleAns[i])){
                                StoredAns.add(Answer);
                                Anskey.add(i);
                                break;
                            }
                        }
                    }else{
                        for(int i = 0; i < StoredAns.size(); i++){
                            if(Answer.equalsIgnoreCase(StoredAns.get(i))){
                                System.out.println("enter a new response");
                                return takeAnswer(anslength);
                            }
                        }

                        for(int i = 0; i < PossibleAns.length; i++){
                            if(Answer.equalsIgnoreCase(PossibleAns[i])){
                                StoredAns.add(Answer);
                                Anskey.add(i);
                                break;
                            }
                        }
                    }
                }else{
                    System.out.println("enter a new response");
                    return takeAnswer(anslength);
                }
            }else{
                System.out.println("enter a new response");
                return takeAnswer(anslength);
            }

            Counter++;
        }
        return Anskey;
    }
}
