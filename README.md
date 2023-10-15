## Übung1, Dongxin Wang
1.1.)
• Eine Factory-Methode kann helfen. Sie soll im Package von control geliegt werden.

• Hier wurde Factory-Methede verwendet. Der software-technische Nutzen ist Kontrolle über die Objekterzeugung.

Zwar In Java werden die folgenden Entwurfsmuster häufig verwendet:
1.Das Singleton (Das Einzelstück) Design Pattern
2.Das Immutable (Das Unveränderliche) Design Pattern
3.Interfaces (Schnittstellen) in Java
4.Das Iterator (Zugriffszeiger) Design Pattern
5.Das Delegate (übertragen) Design Pattern
Und andere Software-technischer Nutzen:
1.Flexibilität
2.Entkopplung
3.Wiederverwendung von Code
4.Testbarkeit

• Das Interface soll public sein. Sonst ist es default und kann nicht von den anderen Packages gesehen werden.

3.)
• Vorteile einer separaten Test-Klasse:
1.Trennung von Test- und Produktionscode
2.Bessere Lesbarkeit
3.Einfachere Wartung
4.Bessere Testabdeckung

• Bei einem Blackbox-Test der Sinn von Äquivalenzklassen:
Äquivalenzklassen sind eine Methode, um Testfälle von einer hohen Fehlerentdeckungsrate mit einer möglichst geringen Anzahl für Blackbox-Tests zu erstellen.

Die Idee ist, dass sich das Testobjekt bei allen Elementen, die derselben Äquivalenzklasse angehören, gleich verhält. Es ist daher bei einem Test ausreichend, einen Repräsentanten pro Äquivalenzklasse zu verwenden 123.

Bei der Bildung von Äquivalenzklassen werden die Eingabedaten in Gruppen unterteilt, so dass man annehmen kann, dass mit jedem beliebigen Objekt einer Klasse die gleichen Fehler wie mit jedem anderen Objekt dieser (Äquivalenz-)Klasse gefunden werden.

Abfolge: Analyse und Spezifikation der Eingabedaten, der Ausgabedaten und der Bedingungen gemäß den Spezifikationen; Bildung der Äquivalenzklassen durch Klassifizierung der Wertebereiche für Ein- und Ausgabedaten; Bestimmung der Testfälle durch Werteauswahl für jede Äquivalenzklasse 124.

• Ein Blackbox-Test mit JUnit auf der Klasse Client ist nicht unmittelbar durchführbar,
weil sie abhängig von der Klasse GermanTranslator ist, man kann auch nicht gut Fälle unterscheiden,
und wenn ein Fehler kommt, muss man immer noch die obere Klasse prüfen.
