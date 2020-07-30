package org.drools;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.acme.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kie.dmn.api.core.DMNContext;
import org.kie.dmn.api.core.DMNResult;
import org.kie.kogito.Application;
import org.kie.kogito.decision.DecisionModel;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.*;

import java.time.LocalDate;
import java.util.Map;

@QuarkusTest
public class SampleTest {

    /**
     * @deprecated we are working to make the DecisionModel directly injectable.
     */
    @Inject
    Application application;

    DecisionModel decisionModel;

    @BeforeEach
    void init() {
        decisionModel = application.decisionModels().getDecisionModel("myNS", "sample");
    }

    @Test
    public void testToday() {
        DMNContext dmnContext = decisionModel.newContext(Map.of("employee", 
                                                                new Person("John Doe", LocalDate.of(1981, 1, 1))));
        DMNResult dmnResult = decisionModel.evaluateAll(dmnContext);
        System.out.println(dmnResult);
    }

    @Test
    public void test1980() {
        DMNContext dmnContext = decisionModel.newContext(Map.of("employee", 
                                                                new Person("John Doe", LocalDate.of(1981, 1, 1)),
                                                                "Today's date",
                                                                LocalDate.of(1980, 12, 31)));
        DMNResult dmnResult = decisionModel.evaluateAll(dmnContext);
        System.out.println(dmnResult);
    }

}