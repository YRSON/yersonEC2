package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Bodega;
import com.example.demo.repository.BodegaRepository;

@Service
public class BodegaServiceImp implements BodegaService {
	
	@Autowired
	private BodegaRepository repositorio;
	
	@Override
	public void guardar(Bodega bodega) {
		repositorio.save(bodega);
	}

	@Override
	public void actualizar(Bodega bodega) {
		repositorio.saveAndFlush(bodega);
	}

	@Override
	public void eliminar(Integer id) {
		repositorio.deleteById(id);
	}

	@Override
	public List<Bodega> listar() {
		return repositorio.findAll();
	}

	@Override
	public Bodega obtener(Integer id) {
		return repositorio.findById(id).orElse(null);
	}

}
