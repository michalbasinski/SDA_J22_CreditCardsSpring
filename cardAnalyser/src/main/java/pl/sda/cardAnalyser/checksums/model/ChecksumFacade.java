package pl.sda.cardAnalyser.checksums.model;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ChecksumFacade {

    private VerifierService verifierService;

    public boolean verifyCardNumberChecksum(String cardNo) {
        return verifierService.verify(cardNo);
    }
}
