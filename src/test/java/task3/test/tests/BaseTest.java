package task3.test.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import task3.utilities.Driver;
import task3.utilities.logger.Log;
import task3.utilities.logger.TestResultLogger;

@ExtendWith(TestResultLogger.class)
public class BaseTest {

    static Log log=new Log();

    @BeforeEach
    public void beforeMethod(){
        log.info("before method");
    }

    @AfterEach
    public void killDriver(){
        Driver.closeDriver();
    } //arka planda çalışmasını önlüyor .
}