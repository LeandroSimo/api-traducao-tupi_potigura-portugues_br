package com.tcc.tradutor.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "palavras")
public class Palavra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tp_pt")
    private String palavraTupi;
    @Column(name = "pt_br")
    private String palavraPortugues;

}
