package br.com.hug.services;

import br.com.hug.models.empresa.Empresa;
import br.com.hug.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmpresaService{
        private final EmpresaRepository empresaRepository;

        public EmpresaService(EmpresaRepository empresaRepository) {
            this.empresaRepository = empresaRepository;
        }

        @Transactional
        public Empresa criar(Empresa empresa) {
            return empresaRepository.save(empresa);
        }

        public Empresa buscar(String cnpj){
            return empresaRepository.getById(cnpj);
        }

        public void deletar(String cnpj){
            empresaRepository.deleteById(cnpj);
        }

        public List<Empresa> buscarTodos(){
            return empresaRepository.findAll();
        }

    public boolean existeEmpresa(String cnpj) {
            return empresaRepository.existsById(cnpj);
    }

    public Empresa atualizar(String cnpj, Empresa toEmpresa) {
            return null;
    }

    //TODO: fazer o atualizar
    }

