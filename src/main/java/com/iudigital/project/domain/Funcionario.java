/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iudigital.project.domain;

/**
 *
 * @author juand
 */
public class Funcionario {
    
    private int funcionarioId;
    private int tipoIdentificacion;
    private String numeroIdentificacion;
    private String nombres;
    private String apellidos;
    private int estadoCivil;
    private String sexo;
    private String direccion;
    private String telefono;
    private String fechaNacimiento;
    private int rolId;

    /**
     * @return the funcionarioId
     */
    public int getFuncionarioId() {
        return funcionarioId;
    }

    /**
     * @param funcionarioId the funcionarioId to set
     */
    public void setFuncionarioId(int funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    /**
     * @return the tipoIdentificacion
     */
    public int getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    /**
     * @param tipoIdentificacion the tipoIdentificacion to set
     */
    public void setTipoIdentificacion(int tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    /**
     * @return the numeroIdentificacion
     */
    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    /**
     * @param numeroIdentificacion the numeroIdentificacion to set
     */
    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the estadoCivil
     */
    public int getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * @param estadoCivil the estadoCivil to set
     */
    public void setEstadoCivil(int estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the fechaNacimiento
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }
    
    public String getTipoIdentificacionTexto() {
        switch (this.tipoIdentificacion) {
            case 1:
                return "C.C.";
            case 2:
                return "T.I.";
            default:
                return "Desconocido";
        }
    }

    public String getEstadoCivilTexto() {
        switch (this.estadoCivil) {
            case 1:
                return "Soltero";
            case 2:
                return "Casado";
            case 3:
                return "Divorciado";
            case 4:
                return "Viudo";
            default:
                return "Desconocido";
        }
    }

    public String getRolIdTexto() {
        switch (this.rolId) {
            case 1:
                return "Hijo,a";
            case 2:
                return "Esposa";
            case 3:
                return "Esposo";
            case 4:
                return "Padre";
            case 5:
                return "Madre";
            default:
                return "Desconocido";
        }
    }
    
    @Override
    public String toString() {
        return "Funcionario {ID = " + funcionarioId +
               ", Tipo Identificación = '" + getTipoIdentificacionTexto() + "'" +
               ", Número Identificación = '" + numeroIdentificacion + "'" +
               ", Nombres = '" + nombres + "'" +
               ", Apellidos = '" + apellidos + "'" +
               ", Estado Civil = '" + getEstadoCivilTexto() + "'" +
               ", Sexo = '" + sexo + "'" +
               ", Dirección = '" + direccion + "'" +
               ", Teléfono = '" + telefono + "'" +
               ", Fecha de Nacimiento = '" + fechaNacimiento + "'" +
               ", Rol = '" + getRolIdTexto() + "'" +
               "}";
    }

}

