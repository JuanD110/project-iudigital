/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iudigital.project.controller;

import com.iudigital.project.data.FuncionarioDao;
import com.iudigital.project.domain.Funcionario;
import com.iudigital.project.view.FuncionarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class FuncionarioController {

    private FuncionarioView view;
    private FuncionarioDao dao;

    public FuncionarioController(FuncionarioView view, FuncionarioDao dao) {
        this.view = view;
        this.dao = dao;

        // Registrar los listeners para los botones de la vista
        this.view.addAgregarListener(new AgregarListener());
        this.view.addActualizarListener(new ActualizarListener());
        this.view.addEliminarListener(new EliminarListener());
        this.view.addListarListener(new ListarListener());
    }

    // Acción para agregar un funcionario
    class AgregarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Funcionario funcionario = new Funcionario();
                funcionario.setTipoIdentificacion(view.getTipoIdentificacion());
                funcionario.setNumeroIdentificacion(view.getNumeroIdentificacion());
                funcionario.setNombres(view.getNombres());
                funcionario.setApellidos(view.getApellidos());
                funcionario.setEstadoCivil(view.getEstadoCivil());
                funcionario.setSexo(view.getSexo());
                funcionario.setDireccion(view.getDireccion());
                funcionario.setTelefono(view.getTelefono());
                funcionario.setFechaNacimiento(view.getFechaNacimiento());
                funcionario.setRolId(view.getRolId());  // Asignar rol_id

                dao.agregarFuncionario(funcionario);
                view.mostrarResultado("Funcionario agregado con éxito.");
                view.limpiarCampos();

            } catch (SQLException ex) {
                view.mostrarResultado("Error al agregar funcionario: " + ex.getMessage());
            } catch (NumberFormatException ex) {
                view.mostrarResultado("Error: Tipo de identificación o estado civil no válidos.");
            }
        }
    }

    // Acción para actualizar un funcionario
    class ActualizarListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Funcionario funcionario = new Funcionario();
            funcionario.setNumeroIdentificacion(view.getNumeroIdentificacion()); // Usa el número de identificación
            funcionario.setTipoIdentificacion(view.getTipoIdentificacion());
            funcionario.setNombres(view.getNombres());
            funcionario.setApellidos(view.getApellidos());
            funcionario.setEstadoCivil(view.getEstadoCivil());
            funcionario.setSexo(view.getSexo());
            funcionario.setDireccion(view.getDireccion());
            funcionario.setTelefono(view.getTelefono());
            funcionario.setFechaNacimiento(view.getFechaNacimiento());
            funcionario.setRolId(view.getRolId());

            dao.actualizarFuncionario(funcionario);
            view.mostrarResultado("Funcionario actualizado con éxito.");
            view.limpiarCampos();

        } catch (SQLException ex) {
            view.mostrarResultado("Error al actualizar funcionario: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            view.mostrarResultado("Número de identificación no válido.");
        }
    }
}


    // Acción para eliminar un funcionario
    class EliminarListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Obtener el número de identificación del campo de texto
            String numeroIdentificacion = view.getNumeroIdentificacion();
            
            // Llamar al método de eliminarFuncionario usando el número de identificación
            dao.eliminarFuncionario(numeroIdentificacion);
            view.mostrarResultado("Funcionario eliminado con éxito.");
            view.limpiarCampos();

        } catch (SQLException ex) {
            view.mostrarResultado("Error al eliminar funcionario: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            view.mostrarResultado("Número de identificación no válido.");
        }
    }
}


    // Acción para listar todos los funcionarios
    class ListarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                StringBuilder resultado = new StringBuilder("Lista de Funcionarios:\n");
                for (Funcionario funcionario : dao.obtenerFuncionarios()) {
                    resultado.append(funcionario.toString()).append("\n");
                }
                view.mostrarResultado(resultado.toString());

            } catch (SQLException ex) {
                view.mostrarResultado("Error al listar funcionarios: " + ex.getMessage());
            }
        }
    }
}


