
package ccm_auto_insert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OutputInputFile {

//            public static void main(String[] args) {
////
////                       // pridani do msisdns
//                           String MSISDN = "60265507";
//                           String IMSI = "1234567891123456";
//                           writeMSISDN(MSISDN,IMSI);
//                           
////        
//                           String backend = "ODS";
//                           String resultOfCheck = "NOK";
////                       
//                           // Nacteni cisla, ktere jeste nebylo pro dany system kontrolovano (neni obsazeno v souboru checkedMSISDNS pro dany system
//                           String MSISDNtoCheck = getMSISDN(backend);
//
//                           System.out.println("Načteno číslo z msisdns.txt: " + MSISDNtoCheck);
////                       
////                       // Zapsani jiz zcheckovaneho cisla do listu zcheckovanych cisel pro dany system
//                           writeResultOffCheck(MSISDNtoCheck, backend, resultOfCheck);
//                           
//                           System.out.println("Zapsáno do checked_msisdns_" + backend + ".txt: " + MSISDNtoCheck);
////
//            }
                
                // Zapise MSISDN do souboru msisdns.txt v lokaci aplikace - nezapise cislo s delkou ruznou od 9
                public static void writeMSISDN(String MSISDN, String IMSI){
                               MSISDN = MSISDN.trim();
                               IMSI = IMSI.trim();
                               
                               if(MSISDN.length() != 9){

                               }
                               
                               else{
                               
                               try {

                                               File outputFile = new File("msisdns.txt");
                                               
                                               FileWriter fw = new FileWriter(outputFile.getAbsoluteFile(),true);
                                               BufferedWriter bw = new BufferedWriter(fw);
                                               
                                               if(!outputFile.exists()){
                                                               outputFile.createNewFile();
                                               }
                                               
                                               bw.write(MSISDN + ";" + IMSI);
                                               bw.newLine();

                                               bw.close();

                               } catch (IOException e) {
                                               e.printStackTrace();
                               }
                               
                  }
                }
                // Zapise MSISDN do souboru msisdns.txt v lokaci aplikace - nezapise cislo s delkou ruznou od 9
                public static void writeMSISDNVoipNG(String MSISDN, String ExtIDCU){
                               MSISDN = MSISDN.trim();
                               ExtIDCU = ExtIDCU.trim();
                               
                               if(MSISDN.length() != 9){

                               }
                               
                               else{
                               
                               try {

                                               File outputFile = new File("msisdnsvoipng.txt");
                                               
                                               FileWriter fw = new FileWriter(outputFile.getAbsoluteFile(),true);
                                               BufferedWriter bw = new BufferedWriter(fw);
                                               
                                               if(!outputFile.exists()){
                                                               outputFile.createNewFile();
                                               }
                                               
                                               bw.write(MSISDN + ";" + ExtIDCU);
                                               bw.newLine();

                                               bw.close();

                               } catch (IOException e) {
                                               e.printStackTrace();
                               }
                               
                  }
                }                
                
                // Vraci MSISDN ze souboru nove vytvorenych msisdns, ktere jeste nebylo kontrolovano v odpovidajicim backendu
                public static String getMSISDN(String backendSystem){
                               String MSISDN = null;
                               String line = null;
                               String lineInOutputFile = null;
                               String[] lineInOutputField = null;
                               String[] lineField = null;
                               
                               File inputFile = new File("msisdns.txt");
                               File outputFileChecked = new File("checked_msisdns_" + backendSystem + ".txt");
                               
                               
                               BufferedReader br = null;
                               BufferedReader br2 = null;
                               BufferedWriter bw = null;

                               try {

                                               br = new BufferedReader(new FileReader(inputFile));
                                               boolean msisdnCheckedAlready = false;
                                               
                                               if(!outputFileChecked.exists()){
                                                               outputFileChecked.createNewFile();
                                               }
                                               
                               while ((line = br.readLine()) != null) {
                                                               msisdnCheckedAlready = false;
                                                               
                                                               //Je treba vzdy pri kontrole MSISDN zacit od zacatku souboru - proto je treba vzdy nove nainicializovat
                                                               br2 = new BufferedReader(new FileReader(outputFileChecked));
                                               
//                                           1) Pokud nenacteme nic ze vstupniho souboru, tak se vrati MSISDN = null
//                                           2) Pokud nacteme neco, pak porovname s vystupnim souborem:
//                                                           a) Pokud jiz ve vystupnim souboru cislo je, pak preskakujeme na dalsi radku ve vstupnim souboru
//                                                           b) Pokud jeste neni ve vystupnim souboru, pak ho nacetem a zapiseme do vystupniho souboru
                                               
                                               while ((lineInOutputFile = br2.readLine()) != null){
                                               
//                                                                                          System.out.println(line.trim() + " - " + lineInOutputFile.substring(0, 9).trim());
                                                                                              
                                                                                              lineInOutputField = lineInOutputFile.split(";");
                                                                                              lineField = line.split(";");
                                                                                              
                                                                                              if(lineInOutputField[0].equals(lineField[0])){

                                                                                                              msisdnCheckedAlready = true;
                                                                                                              break;
                                                                                              }

                                               }
                                               
                                               if (msisdnCheckedAlready == false) {

                                                               lineField = line.split(";");
//                                                           MSISDN neni obsazeno ve vystupnim souboru jiz zkontrolovanych cisel, a tak ho vratime - je tedy k dispozici pro check v backendech                                                    
                                                               MSISDN = lineField[0];
                                                               
                                                               break;
                                               }
                                                               
                               }
                                               
                               } catch (IOException e) {
                                               e.printStackTrace();
                               } finally {
                                               try {
                                                               if (br != null)br.close();
                                                               if (br2 != null)br2.close();
                                                               if (bw != null)bw.close(); 
                                               } catch (IOException ex) {
                                                               ex.printStackTrace();
                                               }
                               }
                               
                               // Pokud se vrati null, pak pravdepodobne jiz vsechna cisla z msisdns byla zkontrolovana a jsou obsazena ve vystupni souboru pro dany backend
                               return MSISDN;
                }
                
                // Zapise zkontrolovane cislo + vysledek kontroly do souboru pro dany backend - nezapise cislo s delkou ruznou od 9
                public static void writeResultOffCheck(String MSISDN, String backendSystem, String resultOfValidation){
                               
                               MSISDN = MSISDN.trim();
                               backendSystem = backendSystem.trim();
                               resultOfValidation = resultOfValidation.trim();
                               
                               if (MSISDN.length() != 9) {
                                               System.out.println("Pokus o vlozeni kratsiho nebo delsiho cisla nez je 9 znaku");
                               }
                               
                               else{
                                               
                               File outputFileChecked = new File("checked_msisdns_" + backendSystem + ".txt");
                               
                               BufferedWriter bw = null;
                               
//                           Vytvarime pro zapis jiz zkontrolovanych cisel
                               try {
                                               
                                               bw = new BufferedWriter(new FileWriter(outputFileChecked.getAbsoluteFile(),true));
                               
                               if(!outputFileChecked.exists()){
                                               outputFileChecked.createNewFile();
                               }
                               
                                               bw.newLine();
                                               bw.append(MSISDN + ";" + resultOfValidation);
                               
                               
                               } catch (IOException e) {
                                               // TODO Auto-generated catch block
                                               e.printStackTrace();
                               } finally {
                                               try {
                                                               if (bw != null)bw.close();
                                               } catch (IOException ex) {
                                                               ex.printStackTrace();
                                               }
                               }
                               }
                }

}

