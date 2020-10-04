package pl.sda.issuers.model;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class IssuerFacade {

    private IssuerDetector detector;

    public String identifyIssuer(String cardNo) {
        return detector.detect(cardNo);
    }
}
