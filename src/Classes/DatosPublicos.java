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
public class DatosPublicos {
    
     int departamento;
    
    private float nomina; 

    public DatosPublicos(int departamento, float nomina) {
        this.departamento = departamento;
        this.nomina = nomina;
    }

    @Override
    public String toString() {
        return "DatosPublicos{" + "departamento=" + departamento + ", nomina=" + nomina + '}';
    }
}
