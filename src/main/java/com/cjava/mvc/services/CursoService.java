package com.cjava.mvc.services;

import com.cjava.mvc.model.entities.Curso;

import java.util.List;

public interface CursoService {
    public void grabar(Curso curso);
    public void eliminar(int  id);
    public Curso buscar(int id);
    public List<Curso> listar();
}
