package pl.kgdev.jobboard.entities;

import javax.persistence.*;

@Entity
public class JobOfferResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Long jobOfferId;

    @ManyToOne
    private Long userId;

}
