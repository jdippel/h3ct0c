# README #

HECTOC ist ein mathematisches Rätsel, das von Yusnier Viera entwickelt wurde.

https://wir-rechnen.de/hectoc

### Description ###

Gegeben sind 6 Ziffern zwischen 1 und 9 (keine Null). Diese Ziffern sind mit Rechenzeichen so zu verbinden, dass bei der Rechnung 100 herauskommt. Erlaubte Rechenzeichen sind Plus, Minus, Mal, Geteilt, Hoch und Klammern.

Beispiel: 987654, Lösung: 98 + 7 – 6 + 5 – 4 = 100

Einzelne Ziffern dürfen zu Zahlen verbunden werden.

Die Reihenfolge der Ziffern darf nicht verändert werden.

Alle Ziffern müssen benutzt werden.

### How to use? ###

Dies ist ein Programmfragment, weil man nur die endliche Anzahl der Untermengen bestimmen muss, wie die Ziffern zu Zahlen kombiniert werden können.
Dann reduziert man die Anzahl der Zahlen stetig, indem man zwei Zahlen mit einem zweistelligen Operator bearbeitet. 
Ist nur noch eine Zahl vorhanden, prüft man diese auf 100.
Eine Klippe gibt es, wenn man den Bereich der ganzen Zahlen verlässt - den Vergleich auf 100. Deshalb ist das Ergebnis zu prüfen.
Und ich war überrascht, dass das Dividieren durch 0 in Java bei double-Zahlen möglich ist.

Ich habe eine Mathematikaufgabe gesehen, an der viele Erwachsene scheitern sollen und dies noch als Multiple Choice mit vier Antworten.
Es geht um den Operatorenvorang bei den Grundrechenarten:

9 + 9 / 9 + 9 * 9 + 9

Die Antwort ist natürlich 100. Ein Beispiel, um auch die Vorgehensweise des Programms zu erklären.
Man schreibt einfach in die main-Methode den String "999999" und erhält alle Lösungen auf der Standardausgabe, wie man via Hectoc das Ergebnis 100 berechnen kann.
Als Ergebnis erhält man 705 Lösungsvorschläge, die man noch prüfen muss.

Beispielsweise ist eine Ausgabenzeile 

Match: 100 - [ ( ADD 1,000 99,000 = 100,000 ) ]  [ ( DIV 81,000 81,000 = 1,000 ) 99.0 ]  [ ( MUL 9,000 9,000 = 81,000 ) 81.0 99.0 ]  [ 9.0 9.0 ( MUL 9,000 9,000 = 81,000 ) 99.0 ]  initial

Man muss das Ergebnis von rechts nach links lesen:

9 9 9 9 99 -> 9 9 (9 * 9) 99 -> 9 9 81 99 -> (9 * 9) 81 99 -> 81 81 99 -> (81 / 81) 99 -> 1 99 -> (1 + 99) -> 100

Für die oben genannte Aufgabe ist beispielsweise dies eine Lösung:

Match: 100 - [ ( ADD 9,000 91,000 = 100,000 ) ]  [ 9.0 ( ADD 82,000 9,000 = 91,000 ) ]  [ 9.0 ( ADD 1,000 81,000 = 82,000 ) 9.0 ]  [ 9.0 ( DIV 9,000 9,000 = 1,000 ) 81.0 9.0 ]  [ 9.0 9.0 9.0 ( MUL 9,000 9,000 = 81,000 ) 9.0 ]  initial

9 9 9 9 9 9 -> 9 9 9 (9 * 9) 9 -> 9 9 9 81 9 -> 9 (9 / 9) 81 9 -> 9 1 81 9 -> 9 (1 + 81) 9 -> 9 82 9 -> 9 (82 + 9) -> 9 91 -> (9 + 91) -> 100

### Who do I talk to? ###

* Repo owner

