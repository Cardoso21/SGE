package br.com.sge.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="EVENTO")

public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATA_EVENTO")
    private LocalDate dataEvento;

    @Column(name = "JUSTIFICATIVA_ADIAMENTO")
    private String justificativaAdiamento;

    @Column(name = "VALOR")
    private Long valor;

    @JoinColumn(name = "ID_MOTIVO")
    @ManyToOne(fetch = FetchType.EAGER)
    private Motivo motivo;

    @JoinColumn(name = "ID_SITUACAO")
    @ManyToOne(fetch = FetchType.EAGER)
    private Situacao situacao;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "EVENTO_USUARIO",
            joinColumns = {@JoinColumn(name = "ID_EVENTO")},
            inverseJoinColumns = {@JoinColumn(name = "ID_USUARIO")})
    private List<Usuario> usuario = new ArrayList<>();

}

