package pl.sda.issuers.model;

import org.springframework.data.jpa.repository.JpaRepository;

interface RulesRepository extends JpaRepository<IssuerRule, Long> {
}
