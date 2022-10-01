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
public class Empleado {
    
    private DatosPersonales datosPersonales;
    
    private DatosPublicos datosPublicos;

    public Empleado(DatosPersonales datosPersonales, DatosPublicos datosPublicos) {
        this.datosPersonales = datosPersonales;
        this.datosPublicos = datosPublicos;
    }
}
