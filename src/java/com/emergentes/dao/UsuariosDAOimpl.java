package com.emergentes.dao;

import com.emergentes.modelo.Usuarios;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDAOimpl extends ConexionDB implements UsuariosDAO {

    public void insert(Usuarios usuarios) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO usuarios (usuario,correo,clave) values (?,?,?)");
            ps.setString(1, usuarios.getUsuario());
            ps.setString(2, usuarios.getCorreo());
            ps.setString(3, usuarios.getClave());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

 
    public void update(Usuarios usuarios) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE usuarios SET usuario = ?, correo = ?, clave = ? where id = ?");
            ps.setString(1, usuarios.getUsuario());
            ps.setString(2, usuarios.getCorreo());
            ps.setString(3, usuarios.getClave());
            ps.setInt(4, usuarios.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM usuarios WHERE id = ?");
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }


    public Usuarios getById(int id) throws Exception {
        Usuarios us = new Usuarios();
        try {
            this.conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM usuarios WHERE id = ?");
            ps.setInt(1,id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                us.setId(rs.getInt("id"));
                us.setUsuario(rs.getString("usuario"));
                us.setCorreo(rs.getString("correo"));
                us.setClave(rs.getString("clave"));
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return us;
    }

  
    public List<Usuarios> getAll() throws Exception {
        List<Usuarios> lista = null;
        try {
            this.conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM usuarios");
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Usuarios>();
            while (rs.next()){
                Usuarios us =  new Usuarios();
                
                us.setId(rs.getInt("id"));
                us.setUsuario(rs.getString("usuario"));
                us.setCorreo(rs.getString("correo"));
                us.setClave(rs.getString("clave"));
                
                lista.add(us);
            }
            rs.close();
            ps.close();
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }

}
