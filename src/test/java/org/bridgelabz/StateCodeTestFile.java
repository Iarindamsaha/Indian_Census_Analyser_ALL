package org.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.bridgelabz.CensusAnalyzerCustomException.ExceptionType.*;
import static org.bridgelabz.StateCodeCustomException.ExceptionType.*;

public class StateCodeTestFile {

    private static final String INDIAN_STATE_CODE_FILE = "C:\\Users\\asaha\\Desktop\\Java_Fellowship_242\\Indian_States_Census_Analyser_Problem_ALL\\src\\test\\resources\\StateCode.csv";
    private static final String WRONG_STATE_CODE_FILE = "Census.csv";
    private static final String INCORRECT_STATE_CODE_FILE_FORMAT = "C:\\Users\\asaha\\Desktop\\Java_Fellowship_242\\Indian_States_Census_Analyser_Problem_ALL\\src\\test\\resources\\StateCode.txt";
    private static final String STATE_CODE_WRONG_DELIMITE_FILE = "C:\\Users\\asaha\\Desktop\\Java_Fellowship_242\\Indian_States_Census_Analyser_Problem_ALL\\src\\test\\resources\\StateCodeWrongDelimiter.csv";

    //TC 2.1
    @Test
    public void givenIndianStateCodeFile_WhenLoad_ShouldReturnCorrectRecords() throws StateCodeCustomException {

        StateCode stateCode = new StateCode();
        int count = stateCode.loadIndianStateCode(INDIAN_STATE_CODE_FILE);
        Assertions.assertEquals(37, count);

    }

    //TC 2.2
    @Test
    public void givenIndiaStateData_WithWrongFile_ShouldThrowExceptionSadTest() {

        StateCode stateCode = new StateCode();
        StateCodeCustomException exceptionRule = Assertions.assertThrows(StateCodeCustomException.class,()->{
            stateCode.loadIndianStateCode(WRONG_STATE_CODE_FILE);
        });

        Assertions.assertEquals(STATE_CODE_FILE_PROBLEM, exceptionRule.type);
    }

    //TC 2.3
    @Test
    public void givenIndiaStateCodeData_WithWrongFileFormat_ShouldThrowExceptionSadTest() {

        StateCode stateCode = new StateCode();
        StateCodeCustomException exceptionRule = Assertions.assertThrows(StateCodeCustomException.class,()->{
            stateCode.loadIndianStateCode(INCORRECT_STATE_CODE_FILE_FORMAT);
        });

        Assertions.assertEquals(STATE_CODE_INCORRECT_FILE_FORMAT, exceptionRule.type);
    }

    //TC 2.4
    @Test
    public void givenIndianStateCodeData_WhenCustomDelimiter_ShouldThrowException() {

        StateCode stateCode = new StateCode();
        StateCodeCustomException exceptionRule = Assertions.assertThrows(StateCodeCustomException.class,()->{
            stateCode.loadIndianStateCode(STATE_CODE_WRONG_DELIMITE_FILE);
        });
        Assertions.assertEquals(STATE_CODE_WRONG_DELIMITER_OR_WRONG_HEADER, exceptionRule.type);
    }


}
