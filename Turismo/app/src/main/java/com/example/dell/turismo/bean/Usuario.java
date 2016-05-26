package com.example.dell.turismo.bean;

/**
 * Created by DELL on 25/05/2016.
 */
public class Usuario {
    private Integer idUsuario;
    private String telefono;
    private String nombre;
    private String correo;
    private String nick;
    private String contraseña;
    private String tocken;
    private String exp;

    public Usuario(){
    }

    public  Usuario(Integer idUsuario, String nombre, String telefono, String correo, String nick, String contraseña, String tocken, String exp){
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.telefono=telefono;
        this.correo = correo;
        this.nick = nick;
        this.contraseña = contraseña;
        this.tocken = tocken;
        this.exp = exp;
    }

}
