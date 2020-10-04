package pl.sda.issuers.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
class IssuerDetectorTest {

    @MockBean
    private RulesRepository repository;

    private IssuerDetector detector;

    @BeforeEach
    void setUp() {
        List<IssuerRule> ruleList =
                Arrays.asList(new IssuerRule(1L, "Master Card", 16, "51"),
                        new IssuerRule(2L, "Visa", 16, "4"));
        when(repository.findAll()).thenReturn(ruleList);

        detector = new IssuerDetector(repository);
    }

    @Test
    void shouldReturnMasterCardWhenCardNumberIs5100000000000000() {
        //given
        final String cardNo = "5100000000000000";
        final String expectedValue = "Master Card";
        //when
        String result = detector.detect(cardNo);

        //then
        assertEquals("Wrong issuer!", expectedValue, result);
    }

    @Test
    void shouldReturnUnknownWhenCardNumberIs100000000000000() {
        //given
        final String cardNo = "100000000000000";
        final String expectedValue = "UNKNOWN";
        //when
        String result = detector.detect(cardNo);

        //then
        assertEquals("Wrong issuer!", expectedValue, result);
    }
}