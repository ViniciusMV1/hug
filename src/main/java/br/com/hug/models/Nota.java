package br.com.hug.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notas")
public class Nota {
    @Id
    @GeneratedValue
    private Long id;
    private String texto;
}
