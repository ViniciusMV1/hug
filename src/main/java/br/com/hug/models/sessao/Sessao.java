package br.com.hug.models.sessao;

import br.com.hug.models.Paciente;
import br.com.hug.models.Psicologo;
import br.com.hug.models.nota.Nota;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Sessões")
public class Sessao {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Paciente paciente;
    @OneToOne
    private Psicologo psicologo;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime data;
    @OneToOne
    private Nota nota;

}
