package com.example.controller;

import com.example.entity.Alumno;
import com.example.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class ControllerAlumno {

    @Autowired
    AlumnoService alumnoService;

    @GetMapping("alumno/lista")
    public String listarAlumnos(Model model){
        model.addAttribute("listaAlumnos",alumnoService.listaAlumno());
        return "/alumno/lista";
    }

    @GetMapping("alumno/formulario/{id}")
    public String formulario(Model model, @PathVariable("id")Integer id){
        model.addAttribute("alumno",alumnoService.buscarAlumno(id));
        return "/alumno/form";
    }

    @PostMapping("alumno/actualizar/{id}")
    public String actualizar(@PathVariable("id")Integer id, @ModelAttribute("alumno")Alumno alumno){
        Alumno alumno1 = alumnoService.buscarAlumno(id);
        alumno1.setNombre(alumno.getNombre());
        alumno1.setEdad(alumno.getEdad());
        alumnoService.actualizarAlumno(alumno1);
        return "redirect:/alumno/lista";
    }

    @GetMapping("/alumno/formulario")
    public String formulario(Model model){
        model.addAttribute("alumno",new Alumno());
        return "/alumno/crear";
    }

    @PostMapping("/alumno/crear")
    public String crear(@ModelAttribute("alumno")Alumno alumno){
        alumnoService.guardarAlumno(alumno);
        return "redirect:/alumno/lista";
    }

    @GetMapping("/alumno/eliminar/{id}")
    public String eliminar(@PathVariable("id")Integer id){
        alumnoService.eliminarAlumno(id);
        return "redirect:/alumno/lista";
    }
}
