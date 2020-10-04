package pl.sda.issuers.model;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
class IssuerDetector {

    private static final String DEFAULT_VALUE = "UNKNOWN";
    private RulesRepository repository;

    String detect(String cardNo) {
        List<IssuerRule> rules = repository.findAll();
        for (IssuerRule rule : rules) {
            if (cardNo.length() == rule.getLength() && cardNo.startsWith(rule.getPrefix())) {
                return rule.getIssuerName();
            }
        }
        return DEFAULT_VALUE;
    }
}
