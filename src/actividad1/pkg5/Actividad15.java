/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad1.pkg5;

import Classes.Empleado;
import java.io.File;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Shajinder
 */
public class Actividad15 {
    
    HashMap<Empleado,empleado>;
    
    

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

                    Node nodeHijos = datosPersonalesDatosPublicos.item(j);
                    if (("datosPersonales").equals(nodeHijos.getNodeName())) {
                        NodeList datosPersonales = nodeHijos.getChildNodes();
                        for (int k = 0; k < datosPersonales.getLength(); k++) {
                            Node nodeDatosPersonales = datosPersonales.item(k);
                            if (("id").equals(nodeDatosPersonales.getNodeName())) {
                                System.out.println(nodeDatosPersonales.getTextContent());
                            } else if (("apellido").equals(nodeDatosPersonales.getNodeName())) {
                                System.out.println(nodeDatosPersonales.getTextContent());
                            }

                        }
                    } else if (("datosPublicos").equals(nodeHijos.getNodeName())) {
                        NodeList datosPublicos = nodeHijos.getChildNodes();
                        for (int k = 0; k < datosPublicos.getLength(); k++) {
                            Node nodeDatosPublicos = datosPublicos.item(k);
                            if (("dep").equals(nodeDatosPublicos.getNodeName())) {
                                System.out.println(nodeDatosPublicos.getTextContent());
                            } else if (("salario").equals(nodeDatosPublicos.getNodeName())) {
                                System.out.println(nodeDatosPublicos.getTextContent());
                            }
                        }

                    }

                }
            }

        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }

}
