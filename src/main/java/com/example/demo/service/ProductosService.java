package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Productos;


public interface ProductosService {
	void guardar(Productos productos);
	void actualizar(Productos productos);
	void eliminar(Integer id);
	List<Productos> listar();
	Productos obtener(Integer id);
}
