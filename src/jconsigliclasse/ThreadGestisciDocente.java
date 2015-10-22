/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jconsigliclasse;

/**
 *
 * @author lanzi_andrea
 */
public class ThreadGestisciDocente extends Thread{
     private JCalendarioGenerale puntatoreCalendarioGenerale;
    private String professore, nomeFile;
    private Semaphore puntatoreSem;
    
    private String risultato;
    
    
    public ThreadGestisciDocente(JCalendarioGenerale puntatoreCalendarioGenerale,Semaphore puntatoreSem, String nomeFile, String professore)
    { 
        this.puntatoreCalendarioGenerale=puntatoreCalendarioGenerale;
        this.puntatoreSem=puntatoreSem;
        this.professore = professore;
        this.nomeFile = nomeFile;
        
    }

  
    public void run()
    { 
        //importo lista classi
        //incrocio con calendario e metto in calendario doc
        //controllo il calendario doc e metto i consigli problematici nella classe apposita
        
        JClassi vetClassi = new JClassi();
	JCalendarioDocente calendarioDoc = new JCalendarioDocente();
	JCalendarioProblematico consigliProblematici = new JCalendarioProblematico();

        JFileCSV file = new JFileCSV();
        file.setClassi(nomeFile);
        
	file.importaClassi(vetClassi);

//Incrocia il vettore del file calendario e il vettore del file classi e metto in un "calendarioDoc" le classi che combaciano.
	for (int i = 0; i < vetClassi.getLast(); i++)
		for (int j = 0; j < puntatoreCalendarioGenerale.getLast(); j++)
                {
                    if ( vetClassi.getClasse(i).equals(puntatoreCalendarioGenerale.getClasse(j)) )
                        calendarioDoc.add(puntatoreCalendarioGenerale.getConsiglio(j));
                }
			

	//controllo nel vettore calendarioDoc:
	//se ci sono consigli che hanno stessa giorno, mese, anno, ora e minuti uguali ad un altro consiglio questo viene messo nel vettore "consigliProblematici"
	for (int i = 0; i < calendarioDoc.getLast(); i++)
		for (int j = i++; j < calendarioDoc.getLast()-1; j++)
		{
		if (calendarioDoc.getOre(i) == calendarioDoc.getOre(j) &&
			calendarioDoc.getMinuti(i) == calendarioDoc.getMinuti(j) &&
			calendarioDoc.getGiorno(i) == calendarioDoc.getGiorno(j) &&
			calendarioDoc.getMese(i) == calendarioDoc.getMese(j) &&
			calendarioDoc.getAnno(i) == calendarioDoc.getAnno(j)
			)
			consigliProblematici.add(calendarioDoc.getConsiglio(i));

		}
        
        //NON E' AREA CRITICA, SERVE SOLO PER NON MISCHIARE LE PRINT TRA I THREAD!
        puntatoreSem.P();
        
        //Le print le gestisco 
        
        risultato="STAMPA DEL THREAD DEL "+ professore+"\n";
        //System.out.println("STAMPA DEL THREAD DEL "+ professore);
        risultato+="Calendario Docente:\n";
        //System.out.println("Calendario Docente:");
                risultato+=calendarioDoc.print()+"\n";
                //calendarioDoc.print();
         risultato+= "Classi Docente: \n";
        //System.out.println("Classi Docente:");
	       for (int i = 0; i < vetClassi.getLast(); i++) 
                   risultato+=i+1+") "+vetClassi.getClasse(i)+"\n";
        risultato+= "CONSIGLI PROBLEMATICI: \n";                    
        //System.out.println("CONSIGLI PROBLEMATICI:");
	       for (int i = 0; i < consigliProblematici.getLast(); i++) 
                  risultato+= i+1+") "+consigliProblematici.getClasse(i)+"\n";
               
        puntatoreSem.V();    
        
       
        
    }//END RUN
    
    public String getString()
    {
         return risultato;      
        
    }
}
