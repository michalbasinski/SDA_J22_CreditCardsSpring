package pl.sda.cardAnalyser.analyser;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.cardAnalyser.checksums.model.ChecksumFacade;
import pl.sda.cardAnalyser.issuers.model.IssuerFacade;

@RestController
@AllArgsConstructor
class CardAnalyserController {

    private ChecksumFacade checksumFacade;
    private IssuerFacade issuerFacade;

    @GetMapping("/cards/{cardNo}")
    ResponseEntity<AnalyseResult> analyseCardNo(@PathVariable String cardNo) {
        boolean checksumCorrect = checksumFacade.verifyCardNumberChecksum(cardNo);
        String issuer = issuerFacade.identifyIssuer(cardNo);
        AnalyseResult result = new AnalyseResult();
        result.setChecksumValidationResult(checksumCorrect);
        result.setIssuer(issuer);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
