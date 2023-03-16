package org.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.bridgelabz.CensusAnalyzerCustomException.ExceptionType.*;

public class CensusAnalyserTestFile {

    private static final String INCORRECT_FILE_FORMAT = "C:\\Users\\asaha\\Desktop\\Java_Fellowship_242\\Indian_States_Census_Analyser_Problem_ALL\\src\\main\\resources\\State.txt";
    private static final String CSV_WITH_WRONG_DELIMITER = "C:\\Users\\asaha\\Desktop\\Java_Fellowship_242\\Indian_States_Census_Analyser_Problem_ALL\\src\\test\\resources\\IncorrectDelimiterFile.csv";
    private  final String WRONG_CSV_FILE_PATH = "State.csv";
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

    //TC 1.3
    @Test
    public void givenIndiaCensusData_WithWrongFileFormat_ShouldThrowExceptionSadTest() {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        CensusAnalyzerCustomException exceptionRule = Assertions.assertThrows(CensusAnalyzerCustomException.class,()->{
            censusAnalyser.loadIndiaCensusData(INCORRECT_FILE_FORMAT);
        });
        Assertions.assertEquals(CENSUS_INCORRECT_FILE_FORMAT, exceptionRule.type);
    }

    @Test
    public void givenIndianCensusCSVFile_WhenCustomDelimiter_ShouldThrowException() {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        CensusAnalyzerCustomException exceptionRule = Assertions.assertThrows(CensusAnalyzerCustomException.class,()->{
            censusAnalyser.loadIndiaCensusData(CSV_WITH_WRONG_DELIMITER);
        });
        Assertions.assertEquals(CENSUS_WRONG_DELIMITER_OR_WRONG_HEADER, exceptionRule.type);
    }

}
