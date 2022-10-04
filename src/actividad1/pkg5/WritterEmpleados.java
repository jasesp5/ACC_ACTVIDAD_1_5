/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad1.pkg5;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import Classes.Empleado;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author Shajinder
 */
public class WritterEmpleados {

    public void writeEmpleados(ArrayList<Empleado> empleadoArrayList) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        File file = new File("src\\nuevosEmpleados2.xml");

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();

            Document document;
            document = implementation.createDocument(null, "Empleados", null);
            writeWorkers(empleadoArrayList,document);

            document.setXmlVersion("1.0");
            /**
             * Creación de la fuente XML a partir del documento
             */
            Source source = new DOMSource(document);

            /**
             * Se crea el resultado en el fichero nuevosEmpleados.xml
             */
            Result result = new StreamResult(file);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            /**
             * Se realiza la transformación del documento a fichero
             */
            transformer.transform(source, result);
   
        } catch (ParserConfigurationException | TransformerException | DOMException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void createWorker(Document document, String id, String apellidos, String dep, String salario) {
        Element elementWorker = document.createElement("empleado");
        document.getDocumentElement().appendChild(elementWorker);
        Element elmentPersonalData = document.createElement("datosPersonales");
        Element elementPublicData = document.createElement("datosPublicos");

        elementWorker.appendChild(elmentPersonalData);
        elementWorker.appendChild(elementPublicData);

        Element elementId = document.createElement("id");
        Text textId = document.createTextNode(id);
        elementId.appendChild(textId);
        Element elementSurname = document.createElement("Apellido");
        Text textSurname = document.createTextNode(apellidos);
        elementSurname.appendChild(textSurname);
        Element elementDepartment = document.createElement("dep");
        Text textDepartment = document.createTextNode(dep);
        elementDepartment.appendChild(textDepartment);
        Element elementSalary = document.createElement("salario");
        Text textSalary = document.createTextNode(salario);
        elementSalary.appendChild(textSalary);

        elmentPersonalData.appendChild(elementId);
        elmentPersonalData.appendChild(elementSurname);
        elementPublicData.appendChild(elementDepartment);
        elementPublicData.appendChild(elementSalary);

    }
    
      public  void writeWorkers (ArrayList<Empleado> empleadoArrayList, Document document){
        String id;
        String apellidos;
        String dep;
        String salario;
        System.out.println("Entra");
           for (Empleado empleado1 : empleadoArrayList) {
               id = String.valueOf(empleado1.getDatosPersonales().getId());
               System.out.println(id);
               apellidos = String.valueOf(empleado1.getDatosPersonales().getApellido());
               dep = String.valueOf(empleado1.getDatosPublicos().getDepartamento());
               salario = String.valueOf(empleado1.getDatosPublicos().getNomina());
         createWorker(document,  id,  apellidos,  dep,  salario);    
        }
        
    }

 

}
