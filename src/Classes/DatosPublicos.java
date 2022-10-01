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
    
    private int departamento;
    
    private float nomina; 

    public DatosPublicos(int departamento, float nomina) {
        this.departamento = departamento;
        this.nomina = nomina;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    public void setNomina(float nomina) {
        this.nomina = nomina;
    }

    public int getDepartamento() {
        return departamento;
    }
    
}
