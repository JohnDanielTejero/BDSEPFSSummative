package com.bdse.pfs.summative.PhaseI;


import com.bdse.pfs.summative.PhaseIII.ResultDisplay;
import com.bdse.pfs.summative.StudentProfile;
import com.bdse.pfs.summative.PhaseII.QuestioningAndAnswering;
public class StudentStat extends StudentProfile {

    //Instantiation
    private double PercentScore;
    private int FinalPoints;
    private int Mistakes = 0;
    private int MaxQuestion;

    //setter
    public void setMaxQuestion(int maxQuestion) {
        MaxQuestion = maxQuestion;
    }

    public void setMistakes(int mistakes) {
        Mistakes = mistakes;
    }

    public void setFinalPoints(int finalPoints) {
        FinalPoints = finalPoints;
    }

    public void setPercentScore(double percentScore) {
        PercentScore = percentScore;
    }

    //getter
    public int getFinalPoints() {
        return FinalPoints;
    }

    public double getPercentScore() {
        return PercentScore;
    }

    public int getMaxQuestion() {
        return MaxQuestion;
    }

    public int getMistakes() {
        return Mistakes;
    }

    @Override
    public void startTest() {

        //GATHERING INFORMATION
        InformationGather GatherInformation = new InformationGather(); /*Instantiate Gathering Class*/
        GatherInformation.informations(); /*Calls on information gathering method*/
        this.setName(GatherInformation.getName()); /*Sets the instance name of this class to input name*/
        this.setSubject(GatherInformation.getSubject()); /*Sets the instance subject of this class to input subject*/

        RetrieveQuestion RetrieveSet = new RetrieveQuestion(); /*Instantiate Gathering Class*/
        RetrieveSet.setSubject(this.getSubject()); /*Set the subject variable inherited to the current instance subject*/
        RetrieveSet.retrieve(); /*Calls on question set gathering method*/

        /*Assigning the values of inherited variables to current instance variable*/
        this.setQuestions(RetrieveSet.getQuestions());
        this.setChoices(RetrieveSet.getChoices());
        this.setAnswers(RetrieveSet.getAnswers());

        //QUESTION AND ANSWER
       //QuestionAndAnswer QuestionPrompt = new QuestionAndAnswer(); /*Instantiate  question class*/
       //QuestionPrompt.promptQuestion(this.getQuestions(), this.getChoices(), this.getAnswers());

        //prototype now working
       QuestioningAndAnswering QuestionPrompt = new QuestioningAndAnswering();
       QuestionPrompt.promptQuestion(this.getQuestions(), this.getChoices(),this.getAnswers());

        /*Assigning the values of inherited variables to current instance variable*/
        this.setMistakes(QuestionPrompt.getMistakes());
        this.setMaxQuestion(QuestionPrompt.getMaxQuestion());
        this.setPercentScore(QuestionPrompt.getPercentScore());
        this.setFinalPoints(QuestionPrompt.getFinalPoints());

        //RESULT
        ResultDisplay ShowResult = new ResultDisplay();/* instantiate ResultDisplay*/

        /*Retrieve Current instance variable and set the value of inherited variables to the value of this instance variable*/
        ShowResult.setName(this.getName());
        ShowResult.setSubject(this.getSubject());
        ShowResult.setMistakes(this.getMistakes());
        ShowResult.setPercentScore(this.getPercentScore());
        ShowResult.setFinalPoints(this.getFinalPoints());
        ShowResult.setMaxQuestion(this.getMaxQuestion());

        ShowResult.retrieveResult();  /* display result */

    }


    @Override
    public String toString() {
        return "Name:'" + this.getName() + '\'' + "\n" +
                "Subject:'" + this.getSubject() + '\'' + "\n"+
                "Score:" + this.getFinalPoints() + "/" + this.getMaxQuestion() + "\n" +
                "Percentage:" + this.getPercentScore() + "%";
    }
}
