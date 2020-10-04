package pl.sda.checksums.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CheckumsApplicationTests {

    @Test
    void contextLoads() {
    }

    static class LuhnChecksumVerifierTest {

        private LuhnChecksumVerifier verifier = new LuhnChecksumVerifier();

        @Test
        void shouldReturnFalseWhenCardNoIs18943() {
            //given
            final String cardNo = "18943";

            //when
            boolean result = verifier.verify(cardNo);

            //then
            assertFalse(result);
        }

        @Test
        void shouldReturnTrueWhenCardNoIs38943() {
            //given
            final String cardNo = "38943";

            //when
            boolean result = verifier.verify(cardNo);

            //then
            assertTrue(result);
        }

        @Test
        void shouldReturnFalseWhenCardNoIs1894() {
            //given
            final String cardNo = "1894";

            //when
            boolean result = verifier.verify(cardNo);

            //then
            assertFalse(result);
        }

        @Test
        void shouldReturnTrueWhenCardNoIs1891() {
            //given
            final String cardNo = "1891";

            //when
            boolean result = verifier.verify(cardNo);

            //then
            assertTrue(result);
        }

        @Test
        void shouldReturnTrueWhenCardNoIs18_91() {
            //given
            final String cardNo = "18 91";

            //when
            boolean result = verifier.verify(cardNo);

            //then
            assertTrue(result);
        }

        @Test
        void shouldThrowExceptionWhenNumberContainsLetters() {
            //given
            final String cardNo = "3123abcd1235435";
            //when
            try {
                verifier.verify(cardNo);
                fail();
            } catch (RuntimeException e) {
                //then
            }
        }
    }
}
