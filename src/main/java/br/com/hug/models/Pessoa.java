package br.com.hug.models;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
}
