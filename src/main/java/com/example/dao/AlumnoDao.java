package com.example.dao;

import com.example.entity.Alumno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoDao extends CrudRepository<Alumno,Integer> {
}
