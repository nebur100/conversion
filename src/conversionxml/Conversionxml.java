/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conversionxml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
/**
 *
 * @author ARMR_
 */
public class Conversionxml {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception{
        
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //factory.setNamespaceAware(true);

            DocumentBuilder builder = factory.newDocumentBuilder();
            org.w3c.dom.Document document = builder.parse("C:\\Users\\ARMR_\\Documents\\NetBeansProjects\\conversionxml\\contratos-adjudicados-sep-24.xml");
            document.getDocumentElement().normalize();

            XPath xPath = XPathFactory.newInstance().newXPath();
           

            String expression = "//*[local-name()='Row']";
            NodeList contractList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
            System.out.println("Cantidad de contratos encontrados: " + contractList.getLength());

            for (int i = 0; i < contractList.getLength(); i++) {
                Element contractElement = (Element) contractList.item(i);
                
                
                
                
                String nif = xPath.compile(".//*[local-name()='Cell'][1]/*[local-name()='Data']").evaluate(contractElement);
                String adjudicatario = xPath.compile(".//*[local-name()='Cell'][2]/*[local-name()='Data']").evaluate(contractElement);
                String objetoGenerico = xPath.compile(".//*[local-name()='Cell'][3]/*[local-name()='Data']").evaluate(contractElement);
                String objeto = xPath.compile(".//*[local-name()='Cell'][4]/*[local-name()='Data']").evaluate(contractElement);
                String fechaAdjudicacion = xPath.compile(".//*[local-name()='Cell'][5]/*[local-name()='Data']").evaluate(contractElement);
                String importe = xPath.compile(".//*[local-name()='Cell'][6]/*[local-name()='Data']").evaluate(contractElement);
                String tipoContrato = xPath.compile(".//*[local-name()='Cell'][8]/*[local-name()='Data']").evaluate(contractElement);
                
                
                System.out.println("Contrato " + (i + 1));
                System.out.println("NIF: " + nif);
                System.out.println("Adjudicatario: " + adjudicatario);
                System.out.println("Objeto Genérico: " + objetoGenerico);
                System.out.println("Objeto: " + objeto);
                System.out.println("Fecha de Adjudicación: " + fechaAdjudicacion);
                System.out.println("Importe: " + importe);
                System.out.println("Tipo de Contrato: " + tipoContrato);
                System.out.println("--------------------------");
                
            }
        
        
        
    }

   
  
    
}
