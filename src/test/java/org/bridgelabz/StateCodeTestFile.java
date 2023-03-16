package org.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateCodeTestFile {

    private static final String INDIAN_STATE_CODE_FILE = "C:\\Users\\asaha\\Desktop\\Java_Fellowship_242\\Indian_States_Census_Analyser_Problem_ALL\\src\\test\\resources\\StateCode.csv";

    //TC 2.2
    @Test
    public void givenIndianStateCodeFile_WhenLoad_ShouldReturnCorrectRecords() throws StateCodeCustomException {

        StateCode stateCode = new StateCode();
        int count = stateCode.loadIndianStateCode(INDIAN_STATE_CODE_FILE);
        Assertions.assertEquals(37, count);

    }

}
