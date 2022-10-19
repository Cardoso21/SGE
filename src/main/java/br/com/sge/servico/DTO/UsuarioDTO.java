package br.com.sge.servico.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO implements Serializable {

    private Long id;

    @NotBlank
    private String nome;

    @Past(message = "Não pode ser uma data futura!")
    @NotBlank
    private LocalDate dataNascimento;

    @Email(message="Tem que ser um e-mail vaido!")
    @Size(min = 10, max = 50)
    @NotBlank
    private String email;

    @NotBlank
    private boolean status;

    @NotBlank(message = "Campo obrigatorio!")
    private String telefone;

    @NotBlank(message = "Campo obrigatorio!")
    private SelectDTO pagamento;

}
