package com.cjava.mvc.model.daos;

import com.cjava.mvc.model.entities.Curso;
import org.springframework.data.repository.CrudRepository;

public interface CursoDao extends CrudRepository<Curso,Integer> {
}
