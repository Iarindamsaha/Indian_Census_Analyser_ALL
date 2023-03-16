package org.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.bridgelabz.CensusAnalyzerCustomException.ExceptionType.CENSUS_FILE_PROBLEM;
import static org.bridgelabz.StateCodeCustomException.ExceptionType.STATE_CODE_FILE_PROBLEM;

public class StateCodeTestFile {

    private static final String INDIAN_STATE_CODE_FILE = "C:\\Users\\asaha\\Desktop\\Java_Fellowship_242\\Indian_States_Census_Analyser_Problem_ALL\\src\\test\\resources\\StateCode.csv";
    private static final String WRONG_STATE_CODE_FILE = "Census.csv";

    //TC 2.2
    @Test
    public void givenIndianStateCodeFile_WhenLoad_ShouldReturnCorrectRecords() throws StateCodeCustomException {

        StateCode stateCode = new StateCode();
        int count = stateCode.loadIndianStateCode(INDIAN_STATE_CODE_FILE);
        Assertions.assertEquals(37, count);

    }

    @Test
    public void givenIndiaStateData_WithWrongFile_ShouldThrowExceptionSadTest() {

        StateCode stateCode = new StateCode();
        StateCodeCustomException exceptionRule = Assertions.assertThrows(StateCodeCustomException.class,()->{
            stateCode.loadIndianStateCode(WRONG_STATE_CODE_FILE);
        });

        Assertions.assertEquals(STATE_CODE_FILE_PROBLEM, exceptionRule.type);
    }

}
