package com.dev.backendloja.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dev.backendloja.entity.Marca;
import com.dev.backendloja.repository.MarcaRepository;

public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> buscarTodos() {
        return marcaRepository.findAll();
    }

    public Marca inserir(Marca estado) {
        estado.setDataDeCriacao(new Date());
        Marca marcaNova = marcaRepository.saveAndFlush(estado);
        return marcaNova;
    }

    public Marca alterar(Marca estado) {
        estado.setDataDeCriacao(new Date());
        return marcaRepository.saveAndFlush(estado);

    }

    public void excluir(Long id) {
        Marca marca = marcaRepository.findById(id).get();
        marcaRepository.delete(marca);
    }
}
