# Abhängigkeiten Sonderwünsche

### Sonderwunschkategorien
GR = Sonderwünsche zu den Grundriss-Varianten

AF = Sonderwünsche Außentüren und Fenster

IT = Sonderwünsche Innentüren


### Grundrissvarianten
DGv = Dachgeschoss vorhanden



### Sonderwünsche Grundriss-Varianten

2.1) Wand zur Abtrennung der Küche von dem Essbereich  
2.2) Tür in der Wand zwischen Küche und Essbereich  
2.3) Großes Zimmer im OG statt zwei kleinen Zimmern  
2.4) Abgetrennter Treppenraum im DG  
2.5) Vorrichtung eines Bades im DG  
2.6) Ausführung eines Bades im DG

### Abhängigkeiten

2.2 needs 2.1  
2.4 needs DGv  
2.5 needs DGv  
2.6 needs (DGv and 2.5)

### Sonderwünsche Fenster und Außentüren

3.1) Schiebetüren im EG zur Terasse  
3.2) Schiebetüren im DG zur Dachterasse  
3.3) Erhöhter Einbruchschutz an der Haustür  
3.4) Vorbereitung für elektrische Antriebe Rolläden EG  
3.5) Vorbereitung für elektrische Antriebe Rolläden OG  
3.6) Vorbereitung für elektrische Antriebe Rolläden DG  
3.7) Elektrische Rolläden EG  
3.8) Elektrische Rolläden OG  
3.9) Elektrische Rolläden DG

### Abhängigkeiten

3.2 needs DGv  
3.7 needs 3.4  
3.8 needs 3.5
3.9 needs 3.6

### Sonderwünsche Innentüren

4.1) Mehrpreis für die Ausführung eines Glasausschnitts (Klarglas) in einer Innentür  
4.2) Mehrpreis für die Ausführung eines Glasausschnitts (Milchglas) in einer Innentür  
4.3) Innentür zur Garage als Holztür  

### Abhängigkeiten

4.3 needs DGv

x = Anz. vorhandene Türen  
y = Anz. Türen die einen Ausschnitt bekommen sollen (1 <= y <= x) and ((y + z) <= x)  
z = Anz. Türen die einen Ausschnitt bekommen sollen (1 <= z <= x) and ((y + z) <= x)  
  
Anz. Türen:  
Keller:  
1x needs DGv  
2x needs not DGv
  
EG:  
0x needs not 2.2  
1x needs 2.2  
  
OG:  
4x needs not 2.3  
3x needs 2.3  

DG:  
2x needs (DGv and 2.4 and 2.6)  
1x needs DGv and ((2.4 and not 2.6) or (not 2.4 and 2.6))
