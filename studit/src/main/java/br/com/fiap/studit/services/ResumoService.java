package br.com.fiap.studit.services;

import br.com.fiap.studit.models.Resumo;
import br.com.fiap.studit.repository.ResumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResumoService {
    private final ResumoRepository resumoRepository;

    @Autowired
    public ResumoService(ResumoRepository resumoRepository) {
        this.resumoRepository = resumoRepository;
    }

    public List<Resumo> getAllResumos() {
        return resumoRepository.findAll();
    }

    public Optional<Resumo> getResumoById(Long id) {
        return resumoRepository.findById(id);
    }

    public Resumo saveResumo(Resumo resumo) {
        return resumoRepository.save(resumo);
    }

    public Resumo updateResumo(Resumo resumo) {
        return resumoRepository.save(resumo);
    }

    public void deleteResumoById(Long id) {
        resumoRepository.deleteById(id);
    }
}
