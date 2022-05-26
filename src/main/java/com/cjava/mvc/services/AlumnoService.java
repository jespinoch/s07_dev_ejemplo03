package com.cjava.mvc.services;

import com.cjava.mvc.model.entities.Alumno;

import java.util.List;

public interface AlumnoService {
    public void grabar(Alumno alumno);
    public void eliminar(int  id);
    public Alumno buscar(int id);
    public List<Alumno> listar();
}
