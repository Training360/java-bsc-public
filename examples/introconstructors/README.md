# Bevezetés a konstruktorok használatába

Az osztály példányosításakor egy speciális metódus, a **konstruktor** fut le, ezért az 
attribútumok inicializálását ebben végezzük.  A konstruktornak speciális szignatúrája 
van: nincs visszatérési értéke, és a neve meg kell egyezzen az osztály nevével. 
Minden osztálynak van konstruktora, akkor is, ha nem írunk. Ebben az esetben a 
fordító generál egy paraméter nélküli **alapértelmezett (default) konstruktort**. 
Az objektum kezdő állapotát a konstruktor paraméterein át tudjuk beállítani. 
A formális paraméterek neve nagyon gyakran megegyezik az attribútum nevével, ezzel 
eltakarva azt. Ekkor az attribútumokat `this` kulcsszóval minősítve érhetjük el.

```java
public class Person {

	private String name;
  
	private int age;

	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}
}
```

Az IntelliJ IDEA támogatja a konstruktor létrehozását. Miután megadtuk az osztály 
attribútumait, nyomjuk le az _ALT + Insert_ billentyűkombinációt és válasszuk a 
_Constructor_ menüpontot! A megjelenő ablakban kiválaszthatjuk, hogy mely attribútumokat 
szeretnénk a konstruktorban beállítani, és az IDE létrehozza azt nekünk. A létrejött 
konstruktort később módosíthatjuk, ha szükséges.

## Ellenőrző kérdések

* Mire való a konstruktor?
* Hogyan definiáljuk a konstruktort?
* Mikor kerül meghívásra?

## Feladat

### Feladatok

Hozz létre egy `Task` osztályt, mely az elvégzendő feladatokról tartalmaz információkat. A 
feladatnak van címe (`title`), leírása (`description`), elkezdésének időpontja (`startDateTime`), időtartama 
(`duration`).

Fordítsd le az osztályt, és nyisd meg az editorban a `Task.class` fájlt! Van benne 
konstruktor? Ha van, mi a tartalma?

`Task` példányt a feladat címének és leírásának megadásával lehet létrehozni. Ennek megfelelően 
készítsd el az osztály konstruktorát! Fordítás után újra nézd meg a a `Task.class` fájl tartalmát! 
Milyen és hány konstruktor van benne?

Készíts minden attribútumhoz gettert, a `duration` attribútumhoz settert, és egy 
`start()` metódust, mely a `startDateTime` attribútumot az aktuális dátumra és időpontra állítja be!

A `main()` metódusban teszteld az osztályt!

### Étterem

Hozz létre egy `introconstructors.Restaurant` osztályt, melyben
van egy `List<String> menu`, egy `String name` és egy `int capacity` attribútum!

Hozz létre egy `Restaurant(String name, int numberOfTables)` konstruktort, mely beállítja az étterem
nevét, a kapacitást feltölti az asztalok számának négyszeresével (csak négyszemélyes
asztalok vannak) és feltölti a menüt pár étellel (ez utóbbit szervezd ki külön metódusba)!

Legyenek az osztálynak getter metódusai!

A `RestaurantMain` osztály `main()` metódusában példányosítsd a `Restaurant` osztályt, majd írd ki az állapotát!

[rating feedback=java-introconstructors-etterem]

## Forrás

OCA - Chapter 1/Creating objects

## Teszt

Igaz-e? Default konstruktora minden osztálynak van.

* Igaz
* [x] Hamis

Mikor fut le a konstruktor?

* Az osztály betöltődésekor.
* [x] Az osztály példányosításakor.
* Létező objektumon hívhatjuk meg bármikor.
