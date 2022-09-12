package br.com.sge.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="USUARIO")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1905122041950251207L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DT_NASCIMENTO")
    private LocalDate dataNascimento;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "STATUS")
    private boolean status;

    @Column(name = "TELEFONE")
    private String telefone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PAGAMENTO")
    private Pagamento pagamento;

    @ManyToMany(mappedBy = "usuario")
    private List<Evento> eventos = new ArrayList<>();
}