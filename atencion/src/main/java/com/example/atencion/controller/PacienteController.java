package com.example.atencion.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.atencion.service.PacienteService;
import com.example.atencion.model.Paciente;
import com.example.atencion.response.AtenResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> getAllPacientes(){
        return pacienteService.getAllPacientes();
    }
        
    @GetMapping("/{id}")
    public Optional<Paciente> getPacienteById(@PathVariable Integer id) {
        return pacienteService.getPacienteById(id);
    }

    @PostMapping("/crear")
    public Paciente createPaciente (@RequestBody Paciente paciente) {
        return pacienteService.createPaciente(paciente);
    }
    
    @PutMapping("edit/{id}")
    public Paciente updatePaciente(@RequestBody Paciente paciente, @PathVariable Integer id) {
        paciente.setId(id);
        return pacienteService.updatePaciente(paciente,id);
    }

    @DeleteMapping("eliminar/{id}")
    public AtenResponse deletePacienteById(@PathVariable Integer id){
        
        AtenResponse atenResponse =  pacienteService.deletePacienteById(id);
        return atenResponse;
    }

}
