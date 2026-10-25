package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.apache.logging.log4j.Logger;
import utils.LoggerUtility;

public class RetryAnalyzer implements IRetryAnalyzer {

    private static final Logger log = LoggerUtility.getLogger(RetryAnalyzer.class);
    private int count = 0;
    private static final int MAX_RETRY_COUNT = 2;

    @Override
    public boolean retry(ITestResult result) {
        if (count < MAX_RETRY_COUNT) {
            count++;
            log.warn("Retry Attempt " 
                + count 
                + " for Test : " 
                + result.getName());
            return true;
        }
        return false;
    }
}