package pl.sda.cardAnalyser.issuers.model;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.sda.cardAnalyser.issuers.dto.IssuerResponse;

@Component
@AllArgsConstructor
class IssuerService {

    private RestTemplate restTemplate;

    String detect(String cardNo) {
        ResponseEntity<IssuerResponse> response = restTemplate.getForEntity("http://localhost:8082/issuers/" + cardNo, IssuerResponse.class);
        return response.getBody().getIssuerName();
    }
}
