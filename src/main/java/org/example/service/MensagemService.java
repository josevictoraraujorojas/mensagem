package org.example.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.dto.MensagemDTO;
import org.example.model.Mensagem;
import org.example.repository.MensagemRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class MensagemService {

    @Inject
    MensagemRepository repository;

    public List<Mensagem> listar() {
        return repository.listarTodas();
    }

    public Optional<Mensagem> buscar(Long id) {
        return repository.buscarPorId(id);
    }

    public Mensagem criar(MensagemDTO dto) {
        Mensagem mensagem = new Mensagem(dto.remetente, dto.conteudo);
        return repository.salvar(mensagem);
    }

    public boolean deletar(Long id) {
        return repository.deletar(id);
    }
}