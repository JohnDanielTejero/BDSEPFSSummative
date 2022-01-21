/*
* MCQ Test System
*
* Version:      1.2
* Author:       John Daniel M. Tejero
* Date Created: 1/15/22
*
* Changelogs:
* As of January 15, 2022
*
* -Gathering information, Question and Answer, and Result is not part of getInformation class.
* -StudentStat can be reused without affecting the previous user information.
* -Can now have multiple student taking the quiz.
*
* As of January 17, 2022
* -Removed excessive override methods that does not necessarily have difference from the inherited method.
* -Fixed the issue where multiple characters are taken in and counted as correct answer.
* -Fixed issue where when multiple characters are input in the choices, it defaults to correct answer.
*
* As of January 18, 2022
* - Added dynamic answer checker, still not functional up to date.
* - Bugs are as follows, multiple answers only display A, one wrong answer is equals to correct.
* - Bugs regarding the new dynamic question and answer class are now fixed.
* - Refactored getInformation to startTest
* */

package com.bdse.pfs.summative;

import com.bdse.pfs.summative.PhaseI.StudentStat;

public class Main {
    public static void main(String[] args){

        StudentStat Student = new StudentStat(); /*Instantiation of new Student Class*/
        Student.startTest(); /*Gather data from the user*/
    }
}
