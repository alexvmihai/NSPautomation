package com.nsp.base;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Created by alex.mihai on 10/6/2017.
 */
public class RetryAnalyzer implements IRetryAnalyzer{
    int counter = 0;
    int retryLimit = 6;

    public boolean retry(ITestResult iTestResult) {
        if(counter < retryLimit){
            counter++;
            return true;
        }
        return false;
    }
}
