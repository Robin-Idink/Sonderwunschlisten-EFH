# Konventionen

### Speicherung der Sonderwünsche

Die Sonderwünsche werden in einem int[] Array gespeichert.  
Jeder Punkt im Pflichtenheft wird am dazu analogen Index gespeichert.  
Beispiele: Punkt 2.4 im Pflichtenheft hat den Index 24, Punkt 3.9 hat den Index 39, etc.  
Der Wert an dem Index ist wie folgt zu setzen:  
0 : der Sonderwunsch ist *nicht* ausgewählt  
1 : der Sonderwunsch ist ausgewählt  
x : x entspricht der Anzahl an Türen, dies gilt für die Punkte 4.1 und 4.2 (Sonderwünsche Innentüren), also Index 41 und 42
