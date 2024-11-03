/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iudigital.project.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FuncionarioView extends JFrame {
    
    // Componentes de la interfaz gráfica
    private JComboBox<String> cbTipoIdentificacion;
    private JTextField txtNumeroIdentificacion;
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JComboBox<String> cbEstadoCivil;
    private JComboBox<String> cbSexo;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtFechaNacimiento;
    private JComboBox<String> cbRol;  // ComboBox para el rol
    private JTextArea txtAreaResultado;
    
    private JButton btnAgregar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnListar;

    public FuncionarioView() {  // Constructor sin lista de roles como parámetro
        // Inicialización de los JTextField y JButton
        txtNumeroIdentificacion = new JTextField(15);
        txtNombres = new JTextField(20);
        txtApellidos = new JTextField(20);
        txtDireccion = new JTextField(30);
        txtTelefono = new JTextField(15);
        txtFechaNacimiento = new JTextField(10);
        txtAreaResultado = new JTextArea(10, 30);
        
        btnAgregar = new JButton("Agregar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnListar = new JButton("Listar");
        
        // Opciones para ComboBox
        String[] tiposIdentificacion = { "C.C.", "T.I." };
        String[] estadosCiviles = { "Soltero", "Casado", "Divorciado", "Viudo" };
        String[] sexos = { "Masculino", "Femenino" };
        String[] roles = { "Hijo,a", "Esposa", "Esposo", "Padre", "Madre"  };  // Lista fija de roles
        
        // Inicializar ComboBox
        cbTipoIdentificacion = new JComboBox<>(tiposIdentificacion);
        cbEstadoCivil = new JComboBox<>(estadosCiviles);
        cbSexo = new JComboBox<>(sexos);
        cbRol = new JComboBox<>(roles);  // Inicializar con roles fijos

        // Configuración de la ventana principal
        setTitle("Gestión de Funcionarios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
        setLayout(new FlowLayout());

        // Añadir componentes a la ventana
        add(new JLabel("Tipo Identificación:"));
        add(cbTipoIdentificacion);
        add(new JLabel("Número Identificación:"));
        add(txtNumeroIdentificacion);
        add(new JLabel("Nombres:"));
        add(txtNombres);
        add(new JLabel("Apellidos:"));
        add(txtApellidos);
        add(new JLabel("Estado Civil:"));
        add(cbEstadoCivil);
        add(new JLabel("Sexo:"));
        add(cbSexo);
        add(new JLabel("Dirección:"));
        add(txtDireccion);
        add(new JLabel("Teléfono:"));
        add(txtTelefono);
        add(new JLabel("Fecha Nacimiento (YYYY-MM-DD):"));
        add(txtFechaNacimiento);
        add(new JLabel("Rol:"));  // Etiqueta para el rol
        add(cbRol);

        // Añadir botones
        add(btnAgregar);
        add(btnActualizar);
        add(btnEliminar);
        add(btnListar);
        
        // Área para mostrar resultados
        add(new JScrollPane(txtAreaResultado));
        txtAreaResultado.setEditable(false);
    }

    // Métodos para registrar los listeners de los botones
    public void addAgregarListener(ActionListener listener) {
        btnAgregar.addActionListener(listener);
    }

    public void addActualizarListener(ActionListener listener) {
        btnActualizar.addActionListener(listener);
    }

    public void addEliminarListener(ActionListener listener) {
        btnEliminar.addActionListener(listener);
    }

    public void addListarListener(ActionListener listener) {
        btnListar.addActionListener(listener);
    }

    // Métodos para obtener los valores ingresados o seleccionados
    public int getTipoIdentificacion() {
        String tipo = (String) cbTipoIdentificacion.getSelectedItem();
        switch (tipo) {
            case "C.C.":
                return 1;  // Valor asignado para C.C.
            case "T.I.":
                return 2;  // Valor asignado para T.I.
            default:
                return 0;  // Retorna 0 o un valor que indique error
        }
    }

    public String getNumeroIdentificacion() {
        return txtNumeroIdentificacion.getText();
    }

    public String getNombres() {
        return txtNombres.getText();
    }

    public String getApellidos() {
        return txtApellidos.getText();
    }

    public int getEstadoCivil() {
        String estado = (String) cbEstadoCivil.getSelectedItem();
        switch (estado) {
            case "Soltero":
                return 1;
            case "Casado":
                return 2;
            case "Divorciado":
                return 3;
            case "Viudo":
                return 4;
            default:
                return 0;
        }
    }

    public String getSexo() {
        return (String) cbSexo.getSelectedItem();
    }

    public String getDireccion() {
        return txtDireccion.getText();
    }

    public String getTelefono() {
        return txtTelefono.getText();
    }

    public String getFechaNacimiento() {
        return txtFechaNacimiento.getText();
    }

    public int getRolId() {
        return cbRol.getSelectedIndex() + 1; // Retorna el índice seleccionado +1 para obtener el ID del rol
    }

    // Método para mostrar resultados en el área de texto
    public void mostrarResultado(String resultado) {
        txtAreaResultado.setText(resultado);
    }

    // Método para limpiar los campos de texto
    public void limpiarCampos() {
        cbTipoIdentificacion.setSelectedIndex(0);
        txtNumeroIdentificacion.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        cbEstadoCivil.setSelectedIndex(0);
        cbSexo.setSelectedIndex(0);
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtFechaNacimiento.setText("");
        cbRol.setSelectedIndex(0);
    }
}
