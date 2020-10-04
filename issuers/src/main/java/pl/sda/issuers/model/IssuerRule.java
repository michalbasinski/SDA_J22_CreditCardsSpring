package pl.sda.issuers.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Rules")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class IssuerRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String issuerName;
    private Integer length;
    private String prefix;
}
