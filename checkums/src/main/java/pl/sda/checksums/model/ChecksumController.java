package pl.sda.checksums.model;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.checksums.dto.ValidationResponse;

@RestController
@AllArgsConstructor
class ChecksumController {

    private ChecksumFacade checksumFacade;

    @GetMapping("/cards/{cardNo}")
    ResponseEntity<ValidationResponse> verifyCardNo(@PathVariable String cardNo) {
        ValidationResponse response = new ValidationResponse();
        try {
            boolean result = checksumFacade.verifyCardNumberChecksum(cardNo);
            response.setValidationResult(result);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
