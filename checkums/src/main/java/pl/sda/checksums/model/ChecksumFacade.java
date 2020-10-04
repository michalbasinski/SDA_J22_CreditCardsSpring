package pl.sda.checksums.model;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ChecksumFacade {

    private LuhnChecksumVerifier luhnChecksumVerifier;

    public boolean verifyCardNumberChecksum(String cardNo) {
        return luhnChecksumVerifier.verify(cardNo);
    }
}
