/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jconsigliclasse;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author Andrea
 */
public class JFileCSV {
   private String fileNameCalendar;
   private String fileNameClassi;

    public JFileCSV() {
        fileNameCalendar="";
        fileNameClassi="";
    }

   void setCalendar(String nomeFile){
       fileNameCalendar=nomeFile;
   }
   
   void setClassi(String nomeFile){
       fileNameClassi=nomeFile;
   }
   
   
    
   
   public void importaCalendario(JCalendarioGenerale calendario)
	{
		//ifstream fin(fileNameCalendar); //Apertura file.
        try{
         FileReader f;
         f= new FileReader(fileNameCalendar);

         BufferedReader b;
         b=new BufferedReader(f);
         
                    
        String riga="";

        while(true)
        {
            riga = b.readLine();
            if(riga==null)
                break;

           
            //C++
            //find ( parametroDaCercare , parametroDaCercare )
            //substr ( partenza , lunghezzaDaEstrarre )
            
            //JAVA
            //indexOf( parametroDaCercare , parametroDaCercare )
            //substring ( partenza , fine )
            
            int posComma1 = riga.indexOf(',', 0);
            String anno = riga.substring(0, 4);

            // SI FERMA QUIIIII :((((((((((((((((
            int posComma2 = riga.indexOf(',', posComma1 + 1);
            String mese = riga.substring(posComma1 + 1, posComma1 + 1+2);
           

            int posComma3 = riga.indexOf(',', posComma2 + 1);
            String giorno = riga.substring(posComma2 + 1, posComma2 + 1+2);

            int posComma4 = riga.indexOf(',', posComma3 + 1);
            String ore = riga.substring(posComma3 + 1,posComma3 + 1+ 2);

            int posComma5 = riga.indexOf(',', posComma4 + 1);
            String minuti = riga.substring(posComma4 + 1, posComma4 + 1+2);

            int posComma6 = riga.indexOf(',', posComma5 + 1);
            String classe = riga.substring(posComma5 + 1, posComma5 + 1+3);


            JConsiglio nuovo = new JConsiglio(anno, mese, giorno, ore, minuti, classe);

            calendario.add(nuovo);
        }                 
    }
    catch(Exception E)
    {

    }
}

	

	//LEGGE IL FILE DELLE CLASSI E LE IMPORTA IN UN VETTORE DI STRING
	public void importaClassi(JClassi vettoreClassi)
	{
                
        try{
            FileReader f;
            f= new FileReader(fileNameClassi);

            BufferedReader b;
            b=new BufferedReader(f);
                    	
                String riga;
                while(true)
                {
                    riga = b.readLine();
                    if(riga==null)
                        break;
                    
                   vettoreClassi.add(riga);

                }   

            }
            catch(Exception E)
            {

            }

                
                
                
        }
   
}
