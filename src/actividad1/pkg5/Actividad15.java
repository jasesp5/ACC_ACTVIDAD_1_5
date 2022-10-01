/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad1.pkg5;

import Classes.DatosPersonales;
import Classes.DatosPublicos;
import Classes.Empleado;
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Shajinder
 */
public class Actividad15 {
    
    private static DatosPublicos datosPublicos;
    private static DatosPersonales datosPersonales;
    private static Empleado empleado;
    private static  ArrayList<Empleado> empleadoArrayList = new ArrayList<Empleado>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            Document document = documentBuilder.parse(new File("./resources/empleados.xml"));

            document.getDocumentElement().normalize();

            NodeList empleados = document.getElementsByTagName("empleado");
            System.out.println("Nodos empleado a recorrer: " + empleados.getLength());

            for (int i = 0; i < empleados.getLength(); i++) {
                Node nodoEmpleado = empleados.item(i);
                System.out.println(nodoEmpleado.getNodeName());
                NodeList datosPersonalesDatosPublicos = nodoEmpleado.getChildNodes();
                for (int j = 0; j < datosPersonalesDatosPublicos.getLength(); j++) {
                    int id = 0;
                    String apellido = "";
                    int departamento = 0;
                    float nomina = 0;
                    Node nodeHijos = datosPersonalesDatosPublicos.item(j);
                    if (("datosPersonales").equals(nodeHijos.getNodeName())) {
                        NodeList datosPersonalesNodeList = nodeHijos.getChildNodes();

                        for (int k = 0; k < datosPersonalesNodeList.getLength(); k++) {
                            Node nodeDatosPersonales = datosPersonalesNodeList.item(k);
                            if (("id").equals(nodeDatosPersonales.getNodeName())) {
                                id = Integer.parseInt(nodeDatosPersonales.getTextContent());
                            } else if (("apellido").equals(nodeDatosPersonales.getNodeName())) {
                                apellido = nodeDatosPersonales.getTextContent();

                            }

                        }
                        datosPersonales= new DatosPersonales(id, apellido);
                    } else if (("datosPublicos").equals(nodeHijos.getNodeName())) {
                        NodeList datosPublicosNodeList = nodeHijos.getChildNodes();

                        for (int k = 0; k < datosPublicosNodeList.getLength(); k++) {
                            Node nodeDatosPublicos = datosPublicosNodeList.item(k);
                            if (("dep").equals(nodeDatosPublicos.getNodeName())) {
                                departamento = Integer.parseInt(nodeDatosPublicos.getTextContent());
                            } else if (("salario").equals(nodeDatosPublicos.getNodeName())) {
                                nomina = Float.parseFloat(nodeDatosPublicos.getTextContent());
                            }
                        }
                        datosPublicos = new DatosPublicos(departamento, nomina);

                    }
                   

                }
                 Empleado empleado = new Empleado(datosPersonales,datosPublicos);
                    empleadoArrayList.add(empleado);
            }

        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
        
        readAllEmpleados();

    }
    
    public static void readAllEmpleados(){
        for (Empleado empleado1 : empleadoArrayList) {
            System.out.println(empleado1.datosPersonales.toString());
            System.out.println(empleado1.datosPublicos.toString());
        }
    }

}
