package pl.sda.issuers.model;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.issuers.dto.IssuerResponse;

@RestController
@AllArgsConstructor
class IssuerController {

    private IssuerFacade facade;

    @GetMapping("/issuers/{cardNo}")
    ResponseEntity<IssuerResponse> getIssuer(@PathVariable String cardNo) {
        String issuer = facade.identifyIssuer(cardNo);
        IssuerResponse response = new IssuerResponse();
        response.setIssuerName(issuer);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
