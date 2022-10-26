package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Productos;
import com.example.demo.repository.ProductosRepository;

@Service
public class ProductosServiceImp implements ProductosService {
	
	@Autowired
	private ProductosRepository repositorio;
	
	@Override
	public void guardar(Productos productos) {
		repositorio.save(productos);
	}

	@Override
	public void actualizar(Productos productos) {
		repositorio.saveAndFlush(productos);
	}

	@Override
	public void eliminar(Integer id) {
		repositorio.deleteById(id);
	}

	@Override
	public List<Productos> listar() {
		return repositorio.findAll();
	}

	@Override
	public Productos obtener(Integer id) {
		return repositorio.findById(id).orElse(null);
	}

}
