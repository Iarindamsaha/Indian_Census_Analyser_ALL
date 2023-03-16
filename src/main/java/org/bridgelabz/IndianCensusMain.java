package org.bridgelabz;

public class IndianCensusMain {

    public static void main(String[] args) {

        CensusAnalyser censusAnalyser = new CensusAnalyser();
        try {

            censusAnalyser.loadIndiaCensusData("C:\\Users\\asaha\\Desktop\\Java_Fellowship_242\\Indian_States_Census_Analyser_Problem_ALL\\src\\main\\resources\\StateCensusData.csv");

        } catch (CensusAnalyzerCustomException e) {
            e.printStackTrace();
        }

    }
}
