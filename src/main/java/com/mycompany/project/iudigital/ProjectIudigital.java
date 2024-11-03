/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.project.iudigital;

import com.iudigital.project.config.ConnectionConfig;
import com.iudigital.project.controller.FuncionarioController;
import com.iudigital.project.data.FuncionarioDao;
import com.iudigital.project.domain.Funcionario;
import com.iudigital.project.view.FuncionarioView;
import java.sql.Connection;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;


public class ProjectIudigital {

    public static void main(String[] args) {
        try {
            
            // Crear una lista de roles que se pasará al constructor de FuncionarioView
        List<String> roles = Arrays.asList("Hijo,a", "Esposo", "Esposa", "Padre", "Madre");  // Cambia estos roles según tu necesidad
        
            // Crear instancia de la vista (interfaz gráfica)
            FuncionarioView funcionarioView = new FuncionarioView();
            
            // Crear instancia del DAO (para la interacción con la base de datos)
            FuncionarioDao funcionarioDao = new FuncionarioDao();

            // Crear el controlador e inyectar la vista y el modelo DAO
            FuncionarioController funcionarioController = new FuncionarioController(funcionarioView, funcionarioDao);

            // Configurar y mostrar la interfaz gráfica
            funcionarioView.setVisible(true);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
   
    }

