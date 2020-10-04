package pl.sda.cardAnalyser.analyser;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AnalyseResult {
    private String issuer;
    private Boolean checksumValidationResult;
    private String errorMsg;
}
