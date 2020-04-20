# Konstans értékek használata

Konstansnak nevezzük azokat a névvel ellátott értékeket, amelyek a program futása 
alatt nem változtathatóak meg. A Java nyelvben nincs ennek megfelelő elem, de nagyon hasonló van.

## `final` módosító szó

Ha egy változót deklaráláskor `final` módosítóval látunk el, akkor annak csak egyszer 
adható érték, és az később nem változtatható meg. Attribútumnál, paraméternél és 
lokális változónál is használható. A `final` módosítóval deklarált attribútumnak legkésőbb a konstruktorban 
értéket kell kapnia.

```java
public double calculateGrossWeight(double netWeight){
	final double packageWeight = 2.4;
	return netWeight + packageWeight;
}
```

## Kvázi konstans

Azokat az attribútumokat, amelyeket `static final` módosítóval látunk el, az egész 
program futása alatt elérhetjük, de soha nem változtathatjuk meg. Ezeknek már az 
osztály betöltődésekor értéket kell kapniuk, és konvenció szerint csupa nagybetűvel 
írjuk őket, a több szóból állóknál pedig alulvonással segítjük az olvashatóságot.

```java
public static final int NUMBER_OF_SEASONS = 4;
```

Ezeket a kvázi konstansokat általában abban az osztályban deklaráljuk, ahol használni 
szeretnénk, így elérésükhöz elég a nevükkel hivatkozni rájuk. A `public static final` 
módosítóval ellátott attribútumokat más osztályból is elérhetjük, ha az osztálynéven 
át hivatkozunk rájuk vagy statikus importot használunk. Lássunk mindkettőre példát!

```java
public class Lion {

	public static final String SOUND = "roar";
	public static final String FOOD_TYPE = "meat";

	public void speak(){
		System.out.println(SOUND);
	}
}
```

```java
import static Lion.FOOD_TYPE;

public class Cub {

	private int weight;

	public void learnToSpeak(){
		System.out.println(Lion.SOUND);
	}

	public void eat(String food){
		if(food.equals(FOOD_TYPE)){
			weight++;
		}
  }
}
```

## Ellenőrző kérdések

* Mire való a `final` módosító szó?
* Hogyan definiálunk Javaban konstans-szerű értékeket?
* Hogyan használjuk?

## Feladat

### `Gentleman` osztály

Definiálj egy `finalmodifier.Gentleman` osztályt, melyben definiáld kvázi konstansként
a `MESSAGE_PREFIX` változót, mely a köszönés elejét tartalmazza! Írj egy
`String sayHello(String name)` metódust, mely a `MESSAGE_PREFIX` értékét összefűzi a
`name` paraméter értékével, és az eredményt visszaadja!

[rating feedback=java-finalmodifier-gentleman]

### `CircleCalculator` és `CylinderCalculator` osztály

Definiálj egy `finalmodifier.CircleCalculator` osztályt, melyben definiáld a Pi-t!
Írj egy `double calculatePerimeter(double r)` metódust, ami a kerületet számolja ki,
és egy `double calculateArea(double r)` metódust, ami a területet!

Írj egy `finalmodifier.CylinderCalculator` osztályt, melyben
legyen egy `calculateVolume(r, h)` metódus, és egy `calculateSurfaceArea(r, h)`
metódus, és használja a Pi értékét a `CircleCalculator` osztályból!

Teszteld a `finalmodifier.PiMain` osztály `main()` metódusából az elkészült
metódusokat!

Írd ki itt a Pi értékét is!

[rating feedback=java-finalmodifier-circleandcylinder]

### `TaxCalculator` osztály

Írj egy `finalmodifier.TaxCalculator` osztályt, mely tartalmazza az ÁFA
értékét, ami 27%. Írj egy `double tax(double price)` metódust, mely
a paraméterként megadott érték ÁFA értékét számolja, és egy `double priceWithTax(double)`
metódust, mely az árat adja vissza az ÁFÁ-val együtt!

[rating feedback=java-finalmodifier-taxcalculator]

### Bónusz feladat 1.

Definiálj egy `finalmodifier.Week` osztályt, mely `List<String>` típusú változóban tartalmazza a hét napjait!
Használd az `Arrays.asList()` metódust!

Próbáld meg a keddet lecserélni a `List`-ben szerdára! Fog sikerülni?

Próbálj értékül adni a változónak egy példányosított listát! Fog sikerülni?

### Bónusz feladat 2.

Mi történik, ha nem adsz értéket egy attribútumnak, és `final`-ként deklarálod?

Lehet-e lokális változót `final` módosító szóval úgy deklarálni, hogy nem adsz
neki értéket?

### Bónusz feladat 3.

A `finalmodifier.CylinderCalculatorBasedOnCircle` felépítése egyezzen meg a `CylinderCalculator` osztállyal,
de metódusai ne a `CircleCalculator` `PI` értékét használják, hanem a metódusait!

### Bónusz feladat 4.

Miért ad `circleCalculator.calculatePerimeter(10)` hívás különleges értéket vissza?

## Teszt

Milyen változtatással lehet elérni, hogy az alábbi osztály leforduljon?

```java
public class Coffee {
    private final String type;
    private final int weight;
    private final String taste;
    
    public Coffee(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }
    
    public void setTaste(String taste) {
        this.taste = taste;
    }
}
```

* [x] A `taste` attribútum elől töröljük a `final` módosítót.
* A `taste` attribútumnak deklarációkor kezdőértéket adunk.
* Töröljük a `setTaste()` metódust.
* A `taste` attribútumot is inicializálni kell a konstruktorban.
* Nem kell módosítani, az osztály úgy jó, ahogy van.

Konvenció szerint melyik helyes deklaráció?

* [x] public static final int NUMBER_OF_SEMESTERS = 7;
* private final int NUMBER_OF_SEMESTERS = 7;
* public static final int numberOfSemesters = 7;
* private final int number_of_semesters = 7;
