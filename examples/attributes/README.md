# Bevezetés az attribútumok használatába

Az osztály attribútumai tárolják az objektum állapotát. Mivel a Java szigorúan 
típusos nyelv, az attribútumok deklarációjában meg kell adnunk azok típusát és 
nevét is. Ezen kívül adhatunk meg láthatóság módosítót és egyéb módosítókat is, 
mint például a `final`, amellyel már találkoztunk korábban.

```java
private final String name; //[láthatóság módosító] [egyéb módosító] típus azonosító;
```

Referencia típusú attribútumokkal kapcsolatot építhetünk objektumok között, ez a 
kapcsolat lehet szorosabb és lazább is, ez csak értelmezés kérdése. Például egy 
diák és a matematika dolgozatra kapott jegye között szoros a kapcsolat, hiszen a 
jegy önmagában nem értelmezhető, míg a diák és az osztálya között gyenge a 
kapcsolat, hiszen a diák nem szűnik meg létezni, ha kikerül az osztályból, 
legfeljebb átkerül egy másikba.

## Láthatósági módosítók

Egy objektum állapota más objektumok számára lehet rejtett és látható is, ez attól 
függ, hogy milyen láthatóság módosítóval deklaráljuk.

* `private`: senki számára nem látható és nem módosítható
* default vagy package private: csak az azonos csomagban lévő osztályok számára látható
* `protected`: csak az azonos csomagban lévő vagy a leszármazott osztályokból látható (az öröklésről később még lesz szó)
* `public`: mindenki számára látható és módosítható

Leggyakrabban private módosítóval látjuk el őket, mert az information hiding alapelv szerint az attribútumokat elrejtjük a külvilág elől, azokhoz csak metódusokon át lehet hozzáférni.

## Getter és setter metódusok

Mivel az objektum attribútumai legtöbbször rejtettek, értéküket kiolvasni és beállítani 
csak a konstruktorban vagy metódus segítségével lehet. Az értéket lekérdező metódusokat 
getternek, az értékadó metódusokat setternek nevezzük és konvenció szerintem az metódus neve 
megegyezik az attribútum nevével `get`, illetve `set` előtaggal. Ez alól kivétel a `boolean` 
típusú attribútum, amely gettere `is` vagy `has` előtagot kap.

```java
private String fontName;
private boolean bold;

public String getFontName () {...}

public void setFontName (String fontName) {...}

public boolean isBold () {...}

public void setBold (boolean bold) {...}
```

## Alapértelmezett értékek

Az attribútumok kezdőérték adása nélkül is rendelkeznek valamilyen értékkel, amely 
az attribútum típusától függ, szemben a lokális változókkal, amelyek nem.

| Típus                          | Alapértelmezett érték |
| ------------------------------ | --------------------- |
| `byte`, `short`, `int`, `long` | 0                     |
| `double`, `float`              | 0.0                   |
| `char`                         | '\u0000'              |
| `boolean`                      | false                 |
| osztály                        | null                  |

## Élettartam

Az attribútum addig érhető el, míg az őt tartalmazó objektum. Egy objektum, ha 
már a program nem használja, egy darabig még létezik a memóriában, vagyis helyet 
foglal. Előbb-utóbb azonban elfogyna a memória, ezért egy szemétgyűjtő (garbage 
collector) időnként felkutatja a referencia nélküli objektumokat, és felszabadítja 
az általuk elfoglalt területet.

## Ellenőrző kérdések

* Mire valók az attribútumok?
* Hogyan deklarálod az attribútumokat?
* Milyen láthatósági módosítókal rendelkezhet?
* Mi az alapértelmezett értékük?
* Meddig lehet hozzáférni?

## Feladat

### `Book` osztály

Hozz létre egy `attributes.book.Book` osztályt, és legyen egy `String title` attribútuma!
Hozz létre egy konstruktort, mely egy paraméteres és értéket ad a
`title` attribútumnak! Hozz létre egy `setTitle()` metódust, mely
értéket ad a `title` attribútumnak! Hozz létre egy `getTitle()` metódust,
mely lekéri az értékét!

Teszteld a `BookMain` `main()` metódusában.

[rating feedback=java-attributes-book]

### `Person` és `Address` osztály

Hozz létre egy `attributes.person.Person` osztályt, `String name`, `String identificationCard`
attribútumokkal!
Az osztályban hozz létre egy `String personToString()` metódust, mely szövegként adja vissza a `Person` adatait!

Hozz létre egy `Address` osztályt, `String country`, `String city`, `String streetAndNumber`,
 `String zipCode` attribútumokkal!
Az osztályban hozz létre egy `String addressToString()` metódust, mely szövegként adja vissza az `Address` adatait!

Az attribútumok konstruktorban is megadhatóak legyenek, és legyenek getter
metódusok. Legyen egy `correctData()` metódus mindkét osztályban, mellyel
át lehet írni az összes paraméter értékét!

A `Person` osztály tartalmazzon egy hivatkozást az `Address` osztályra!
(Azaz legyen a `Person` osztálynak egy `Address` típusú attribútuma!
Legyen egy `moveTo(Address)` metódus, mely beállítja a címet, és egy `getAddress()`,
mellyel lekérdezhetővé válik!

Teszteld az osztályokat a `PersonMain` `main()` metódusában!

[rating feedback=java-attributes-personaddress]

### `Bill` és `Item` osztály

Legyen egy
`attributes.bill.Item` osztály, melynek legyen `String product`, `int quantity` és egy
`double price` attribútuma! Legyen konstruktor, valamint legyenek getter
metódusok!

Legyen egy `Bill` osztály, melynek legyen egy `List<Item> items` attribútuma!
Legyen egy `addItem(Item)` metódus, és egy getter az `items` attribútumhoz!

A `Bill` osztályban legyen egy `calculateTotalPrice()` metódus, mely végigmegy
a számla tételein, beszorozza a `quantity` és `price` értékeket, és összeadja
őket!

Teszteld a `BillMain` `main()` metódusával!

[rating feedback=java-attributes-billitem]

## Forrás

OCA - Chapter 1/Declaring and Initializing Variables

## Teszt

Melyik állítás HAMIS?

* Minden attribútum automatikus kezdőértékkel rendelkezik.
* Minden referencia típusú attribútum automatikus kezdőértéke `null`.
* Minden lokális változó automatikus kezdőértékkel rendelkezik.
* Minden primitív típusú lokális változónak használat előtt értéket kell adnunk, 
mert nincs automatikus kezdőértékük.
