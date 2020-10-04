package pl.sda.cardAnalyser.issuers.model;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class IssuerFacade {

    private IssuerService detector;

    public String identifyIssuer(String cardNo) {
        return detector.detect(cardNo);
    }
}
