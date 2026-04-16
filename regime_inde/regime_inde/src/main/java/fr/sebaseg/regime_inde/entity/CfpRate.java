package fr.sebaseg.regime_inde.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@SuppressWarnings("Annotator")
@Entity
@Table(name = "cfp_rate")
@Getter @Setter @NoArgsConstructor
public class CfpRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String activity;

    @Column(nullable = false)
    private BigDecimal rate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cfp_reference_id", nullable = false)
    private CfpReference cfpReference;
}
