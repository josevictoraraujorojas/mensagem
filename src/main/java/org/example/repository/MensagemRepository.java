package org.example.repository;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.model.Mensagem;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@ApplicationScoped
public class MensagemRepository {

    private List<Mensagem> mensagens = new ArrayList<>();
    private AtomicLong contador = new AtomicLong();

    public List<Mensagem> listarTodas() {
        return mensagens;
    }

    public Optional<Mensagem> buscarPorId(Long id) {
        return mensagens.stream()
                .filter(m -> m.id.equals(id))
                .findFirst();
    }

    public Mensagem salvar(Mensagem mensagem) {
        mensagem.id = contador.incrementAndGet();
        mensagem.timestamp = java.time.LocalDateTime.now();
        mensagens.add(mensagem);
        return mensagem;
    }

    public boolean deletar(Long id) {
        return mensagens.removeIf(m -> m.id.equals(id));
    }
}
