/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iudigital.project.data;

import com.iudigital.project.config.ConnectionConfig;
import com.iudigital.project.domain.Funcionario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao {
    
    private final Connection connection;

    public FuncionarioDao() throws SQLException {
        connection = ConnectionConfig.getConnection();
    }

    public void agregarFuncionario(Funcionario funcionario) throws SQLException {
        String query = "INSERT INTO Funcionarios (tipo_documento_id, numero_identificacion, nombres, apellidos, estado_civil_id, sexo, direccion, telefono, fecha_nacimiento, rol_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, funcionario.getTipoIdentificacion());
            stmt.setString(2, funcionario.getNumeroIdentificacion());
            stmt.setString(3, funcionario.getNombres());
            stmt.setString(4, funcionario.getApellidos());
            stmt.setInt(5, funcionario.getEstadoCivil());
            stmt.setString(6, funcionario.getSexo());
            stmt.setString(7, funcionario.getDireccion());
            stmt.setString(8, funcionario.getTelefono());

            // Convertir la fecha de nacimiento a java.sql.Date
            java.sql.Date sqlDate = java.sql.Date.valueOf(funcionario.getFechaNacimiento()); // Asegúrate de que sea "YYYY-MM-DD"
            stmt.setDate(9, sqlDate);
            stmt.setInt(10, funcionario.getRolId()); // Agregar rol_id

            stmt.executeUpdate();
        }
    }

    public List<Funcionario> obtenerFuncionarios() throws SQLException {
        List<Funcionario> funcionarios = new ArrayList<>();
        String query = "SELECT * FROM Funcionarios";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setFuncionarioId(rs.getInt("funcionario_id"));
                funcionario.setTipoIdentificacion(rs.getInt("tipo_documento_id"));
                funcionario.setNumeroIdentificacion(rs.getString("numero_identificacion"));
                funcionario.setNombres(rs.getString("nombres"));
                funcionario.setApellidos(rs.getString("apellidos"));
                funcionario.setEstadoCivil(rs.getInt("estado_civil_id"));
                funcionario.setSexo(rs.getString("sexo"));
                funcionario.setDireccion(rs.getString("direccion"));
                funcionario.setTelefono(rs.getString("telefono"));
                funcionario.setFechaNacimiento(rs.getString("fecha_nacimiento"));
                funcionario.setRolId(rs.getInt("rol_id")); // Obtener rol_id

                funcionarios.add(funcionario);
            }
        }
        return funcionarios;
    }

    public void actualizarFuncionario(Funcionario funcionario) throws SQLException {
    String sql = "UPDATE funcionarios SET tipo_documento_id = ?, nombres = ?, apellidos = ?, estado_civil_id = ?, sexo = ?, direccion = ?, telefono = ?, fecha_nacimiento = ?, rol_id = ? WHERE numero_identificacion = ?";
    
    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, funcionario.getTipoIdentificacion());
        stmt.setString(2, funcionario.getNombres());
        stmt.setString(3, funcionario.getApellidos());
        stmt.setInt(4, funcionario.getEstadoCivil());
        stmt.setString(5, funcionario.getSexo());
        stmt.setString(6, funcionario.getDireccion());
        stmt.setString(7, funcionario.getTelefono());
        
        
         // Convertir la fecha de nacimiento de String a Date
        try {
            Date fechaNacimiento = Date.valueOf(funcionario.getFechaNacimiento());
            stmt.setDate(8, fechaNacimiento); // Establecer la fecha correctamente
        } catch (IllegalArgumentException ex) {
            throw new SQLException("Formato de fecha inválido. Use el formato YYYY-MM-DD.");
        }

        
        
        stmt.setInt(9, funcionario.getRolId());
        stmt.setString(10, funcionario.getNumeroIdentificacion()); 

        int rowsUpdated = stmt.executeUpdate();
        if (rowsUpdated == 0) {
            throw new SQLException("No se encontró el funcionario con número de identificación: " + funcionario.getNumeroIdentificacion());
        }
    }
}


    public void eliminarFuncionario(String numeroIdentificacion) throws SQLException {
    String query = "DELETE FROM funcionarios WHERE numero_identificacion = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setString(1, numeroIdentificacion);
        int rowsAffected = stmt.executeUpdate();
        
        // Comprobar si se eliminó algún registro
        if (rowsAffected == 0) {
            throw new SQLException("No se encontró el funcionario con número de identificación: " + numeroIdentificacion);
        }
    }
}

}




