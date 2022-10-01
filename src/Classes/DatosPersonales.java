/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Shajinder
 */
public class DatosPersonales {
    private int id;
    
    private String apellido;

    public int getId() {
        return id;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public String toString() {
        return "DatosPersonales{" + "id=" + id + ", apellido=" + apellido + '}';
    }

    public DatosPersonales(int id, String apellido) {
        this.id = id;
        this.apellido = apellido;
    }
}
