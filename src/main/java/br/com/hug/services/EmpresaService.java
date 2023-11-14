package br.com.hug.services;

import br.com.hug.models.empresa.Empresa;
import br.com.hug.repositories.EmpresaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmpresaService{
        private final EmpresaRepository empresaRepository;

        private final ModelMapper modelMapper;


    public EmpresaService(EmpresaRepository empresaRepository, ModelMapper modelMapper) {
        this.empresaRepository = empresaRepository;
        this.modelMapper = modelMapper;
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

    public Empresa atualizar(String cnpj, Empresa empresa) {
        var empresaAux = empresaRepository.findById(cnpj);
        if(empresaAux.isPresent()){
            modelMapper.map(empresa, empresaAux.get());
            return empresaRepository.save(empresaAux.get());
        }
        throw new RuntimeException("Empresa não encontrada no banco de dados.");
    }

}

