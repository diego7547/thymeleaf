package com.example.service;

import com.example.dao.AlumnoDao;
import com.example.entity.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {

    @Autowired
    AlumnoDao alumnoDao;

    public Alumno buscarAlumno(Integer id){
        return alumnoDao.findById(id).orElse(null);
    }

    public List<Alumno> listaAlumno(){
        return (List<Alumno>) alumnoDao.findAll();
    }

    public Alumno guardarAlumno(Alumno alumno){
        return  alumnoDao.save(alumno);
    }
    public Alumno actualizarAlumno(Alumno alumno){
        return  alumnoDao.save(alumno);
    }

    public void eliminarAlumno(Integer id){
        alumnoDao.deleteById(id);
    }
}
