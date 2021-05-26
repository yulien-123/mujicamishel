/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.modelo;

/**
 *
 * @author Mujica
 */
public class Usuarios {
     private int id;
    private String usuario;
    private String correo;
    private String clave;

    public void setId(int id) {
        this.id = id;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public String getClave() {
        return clave;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "id=" + id + ", usuario=" + usuario + ", correo=" + correo + ", clave=" + clave + '}';
    }
}
