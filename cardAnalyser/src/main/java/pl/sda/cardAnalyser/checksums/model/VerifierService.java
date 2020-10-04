package pl.sda.cardAnalyser.checksums.model;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.sda.cardAnalyser.checksums.dto.ValidationResponse;

@Component
@AllArgsConstructor
class VerifierService {

    private RestTemplate restTemplate;

    public boolean verify(String cardNo) {
        ResponseEntity<ValidationResponse> response = restTemplate.getForEntity("http://localhost:8081/cards/" + cardNo, ValidationResponse.class);
        return response.getBody().getValidationResult();
    }
}
