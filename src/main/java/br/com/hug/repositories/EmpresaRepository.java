package br.com.hug.repositories;
import br.com.hug.models.Sessao;
import br.com.hug.models.empresa.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hug.models.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, String> {
}


