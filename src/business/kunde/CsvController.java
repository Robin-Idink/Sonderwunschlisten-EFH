package business.kunde;

import java.io.FileWriter;
import java.io.Writer;

public class CsvController {
	
	Writer fw = null;
	
public void ausgabeGrundriss(String[] grundriss, int[] preise, int kundenNummer, String nachname) {
		
		String name = String.valueOf(kundenNummer);
		name = name + "_" + nachname + "_Grundriss.csv";
		
		int l�nge = grundriss.length;
		int gesamtpreis = 0;
		
		try {
			
			fw = new FileWriter(name);
			
			for(int i = 0; i<l�nge; i++) {
				fw.write(grundriss[i]+";");
				fw.append(preise[i]+"\n");
				gesamtpreis = gesamtpreis + preise[i];
				
				if(i+1 == l�nge) {
					fw.append("Gesamtpreis:;");
					String gesamtPreis = String.valueOf(gesamtpreis);
					fw.append(gesamtPreis);
				}
			}		
			
		}
		catch(Exception e){
			System.out.println("Die Datei konnte nicht erstellt werden");
		}
		
		finally {
			if( fw != null) {
				try{
					fw.close();
				}catch(Exception e) {}
			}
		}
		
	}
	
	public void ausgabeFensteruAusentueren(String[] fuA, int[] preise, int kundenNummer, String nachname) {
		
		String name = String.valueOf(kundenNummer);
		name = name + "_" + nachname + "_FensterUndAussentueren.csv";
		
		int l�nge = fuA.length;
		int gesamtpreis = 0;
		
		try {
			
			fw = new FileWriter(name);
			
			for(int i = 0; i<l�nge; i++) {
				fw.write(fuA[i]+";");
				fw.append(preise[i]+"\n");
				gesamtpreis = gesamtpreis + preise[i];
				
				if(i+1 == l�nge) {
					fw.append("Gesamtpreis:;");
					String gesamtPreis = String.valueOf(gesamtpreis);
					fw.append(gesamtPreis);
				}
			}		
			
		}
		catch(Exception e){
			System.out.println("Die Datei konnte nicht erstellt werden");
		}
		
		finally {
			if( fw != null) {
				try{
					fw.close();
				}catch(Exception e) {}
			}
		}
		
	}
	
	public void ausgabeInnentueren(String[] innentueren, int[] preise, int kundenNummer, String nachname) {
		String name = String.valueOf(kundenNummer);
		name = name + "_" + nachname + "_Innent�ren.csv";
		
		
		int l�nge = innentueren.length;
		int gesamtpreis = 0;
		
		try {
			
			fw = new FileWriter(name);
			
			for(int i = 0; i<l�nge; i++) {
				fw.write(innentueren[i]+";");
				fw.append(preise[i]+"\n");
				gesamtpreis = gesamtpreis + preise[i];
				
				if(i+1 == l�nge) {
					fw.append("Gesamtpreis:;");
					String gesamtPreis = String.valueOf(gesamtpreis);
					fw.append(gesamtPreis);
				}
			}		
			
		}
		catch(Exception e){
			System.out.println("Die Datei konnte nicht erstellt werden");
		}
		
		finally {
			if( fw != null) {
				try{
					fw.close();
				}catch(Exception e) {}
			}
		}
	}
}
