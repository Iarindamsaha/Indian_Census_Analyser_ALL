package org.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.bridgelabz.CensusAnalyzerCustomException.ExceptionType.CENSUS_FILE_PROBLEM;

public class CensusAnalyserTestFile {

    private static final String WRONG_CSV_FILE_PATH = "State.csv";
    private String INDIAN_CENSUS_CSV_FILE_PATH = "C:\\Users\\asaha\\Desktop\\Java_Fellowship_242\\Indian_States_Census_Analyser_Problem_ALL\\src\\main\\resources\\StateCensusData.csv";

    //TC 1.1
    @Test
    public void givenIndianCensusCSVFile_WhenLoad_ShouldReturnCorrectRecords() throws CensusAnalyzerCustomException {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        int count = censusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_CSV_FILE_PATH);
        Assertions.assertEquals(29, count);

    }

    //TC 1.2
    @Test
    public void givenIndiaCensusData_WithWrongFile_ShouldThrowExceptionSadTest() {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        CensusAnalyzerCustomException exceptionRule = Assertions.assertThrows(CensusAnalyzerCustomException.class,()->{
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        });
        Assertions.assertEquals(CENSUS_FILE_PROBLEM, exceptionRule.type);
    }
}
