# GenerationPensionFonds

## Projektbeschreibung

Dieses Java-Lernprojekt simuliert die Generierung und Verarbeitung von Mitarbeiter- und Rentenfondsdaten.

Ziel des Projekts ist es, objektorientierte Programmierung, Dateiverarbeitung und die Java Stream API praktisch anzuwenden.

## Funktionen

- Generierung von bis zu 10.000 Mitarbeiterdatensätzen mit zufälligen Eigenschaften
- Generierung von 100 Rentenfondseinträgen
- Speicherung der generierten Daten in Textdateien
- Einlesen der Dateien und Umwandlung in Java-Objekte
- Zuordnung von Mitarbeitern zu Rentenfonds
- Beispielhafte Berechnung von Renten anhand definierter Koeffizienten

## Verwendete Technologien

- Java
- Objektorientierte Programmierung (OOP)
- Collections (`List`, `Set`, `Map`)
- Stream API
- Datei-I/O (`FileReader`, `FileWriter`, `BufferedReader`, `BufferedWriter`)
- Zufallsdatengenerierung mit `Random`

## Projektstruktur

- `HumanGenerator.java` – Generierung von Mitarbeiterdaten
- `PensionFondGenerator.java` – Generierung von Rentenfondsdaten
- `ObjectsWorkers.java` – Einlesen und Erstellen von Mitarbeiterobjekten
- `ObjectsPensionFonds.java` – Einlesen und Erstellen von Rentenfondsobjekten
- `Worker.java` – Modellierung eines Mitarbeiters und Rentenberechnung
- `PensionFund.java` – Modellierung eines Rentenfonds
- `Main.java` – Einstiegspunkt für das Laden der Daten

## Projektstatus

Das Projekt entstand im Rahmen praktischer Java-Übungen und befindet sich im Lern- und Weiterentwicklungsstadium.

Geplante Verbesserungen:

- Fehlerbehandlung und Ressourcenverwaltung verbessern
- Berechnungslogik überprüfen
- Konsolenausgabe der Ergebnisse ergänzen
- Automatisierte Tests mit JUnit hinzufügen
- Projektstruktur und Codequalität verbessern

## Lernziele

- Java-Klassen und Objekte modellieren
- Vererbung und Interfaces einsetzen
- Dateien lesen und schreiben
- Daten mit Collections und Streams verarbeiten
- Größere Datenmengen programmatisch generieren
