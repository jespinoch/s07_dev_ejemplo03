package com.cjava.mvc.model.daos;

import com.cjava.mvc.model.entities.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface AlumnoDao extends CrudRepository<Alumno,Integer> {
}
