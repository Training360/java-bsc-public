# Felsorolásos típus

A felsorolásos típus valójában egy osztály, rendelkezik attribútumokkal, konstruktorral 
és metódusokkal. A különbség, hogy nem a `class`, hanem az `enum` kulcsszóval hozzuk létre, 
és csak a felsorolásos típuson belül definiált elemeket 
lehet neki értékül adni. Ezeket az elemeket konvenció szerint csupa nagybetűvel írjuk. 
Az elemek között sorrendiség definiált, így index alapján is elérhetőek, `for` ciklussal 
bejárható és `switch` szerkezetben is használhatóak. Gyakran használjuk logikai értékek helyett is, 
mert beszédes nevű elemek esetén jobban olvasható. 

```java
public enum Coin {
    TWOHUNDRED, HUNDRED, TWENTY, TEN, FIVE
}
```

Használata:

```java
Coin c = Coin.TWOHUNDRED;
```

Mint látható, a `Coin` olyan, mint egy osztály, a benne definiált értékek pedig ennek az 
osztálynak a példányai. Az enum `values()` metódusa az összes lehetséges értéket visszaadja 
egy tömbben ugyanolyan sorrendben, mint ahogy azt definiáltuk. Így az egyes enum értékek 
indexszel elérhetőek, illetve ciklussal bejárhatóak.

Bejárás:

```java
for(Coin i : Coin.values()){
    System.out.println(i);
}
```

Amennyiben az enumot attribútumokkal szeretnénk ellátni, abban az esetben ezt a felsorolás után, attól `;`-vel 
elválasztva tehetjük meg. Konstruktort és metódusokat is hasonlóan készíthetünk bele, mint bármilyen 
osztály esetén, azonban egy enum konstruktora sohasem lehet publikus. Hogy miért? Mert az enum a fejlesztő által nem 
példányosítható. Az egyes példányok a konstansként definiált enum értékekbe automatikusan kerülnek bele, ezért a konstruktor 
hívásához szükséges konkrét paramétereket a definiált értékeknél kell megadnunk.

```java
public enum Coin {
    TWOHUNDRED(200), HUNDRED(100), TWENTY(20), TEN(10), FIVE(5);

    private final int value;

    Coin(int value){
        this.value=value;
    }

    public int getValue(){
        return value;
    }

}
```

Így már minden elemhez hozzárendeltünk egy értéket, amit a getteren át le tudunk kérdezni.

```java
Coin coin = Coin.HUNDRED;
int coinValue = coin.getValue(); //100
```

### Hasznos metódusok

A `values()` metódusról már volt szó, ez az összes enum értéket tartalmazó tömböt ad vissza.

```java
Coin[] coins = Coin.values();
```

A `valueOf()` metódussal `String` alapján lehet lekérni a felsorolásos típus egy elemét, 
ahol a `String` maga a definiált konstans neve. 

```java
Coin c = Coin.valueOf("HUNDRED"); //Coin.HUNDRED
```

A `name()` metódus az ellenkező irány, amikor az enum értékből szeretnénk `String`-et kapni.

```java
Coin c = Coin.HUNDRED;
String nameOfCoin = c.name(); //"HUNDRED"
```

Az `ordinal()` visszaadja az adott elem sorszámát. Ugyanúgy, mint a tömb indexelése, ez is 0-val kezdődik.

```java
Coin c = Coin.HUNDRED;
int index = c.ordinal(); //1
```

## Ellenőrző kérdések

* Mire használjuk a felsorolásos típusokat?
* Hogyan lehet definiálni a felsorolásos típusokat?
* Milyen hasznos metódusokat ismersz velük kapcsolatban?

## Feladat

### A hét napjai

Vegyél fel egy `enumtype.week.DayType` enumot, melynek két értéke a `WORKDAY`, `HOLIDAY`!
Vegyél fel egy `Day` enumot, mely a hét napjait tartalmazza,
és a szombat és vasárnap legyen megjelölve szünnapnak! A
`WorkdayCalculator` osztályban legyen egy `List<DayType> dayTypes(Day firstDay, int numberOfDays)`
metódus, melynek meg kell mondani az első napot, majd az utána következő napok számát,
és visszaad egy listát, mely azt tartalmazza, hogy a i. nap milyen típusú!

Használj egy `private Day nextDay(Day day)` segédmetódust, mely megmondja a paraméterként
megadott nap után következő napot! Vasárnap után hétfő következik.

Teszteld a `WorkdayCalculatorMain` osztály `main()` metódusában!

[rating feedback=java-enumtype-hetnapjai]

### Mértékegységek

Legyen egy `enumtype.unit.LengthUnit` enum, mely tartalmazza a milliméter, centiméter,
méter, yard, foot és inch mértékegységeket. Mindegyik tartalmazza, hogy SI mértékegység-e,
valamint hogy egy egység mennyi milliméterre átváltva.

Írj a `UnitConverter` osztályban egy `BigDecimal convert(BigDecimal length, LengthUnit source, LengthUnit target)`
metódust, mely átváltja a paraméterként megkapott értéket, melynek meg van adva a mértékegysége a
cél mértékegységre! Először váltsd át milliméterre, majd vissza a cél mértékegységre! Négy tizedesjegyre kell
kerekíteni.

A `List<LengthUnit> siUnits()` metódus adja vissza az SI mértékegységeket.

A `UnitConverterMain` `main()` metódusában próbáld ki a `convert()` metódust, majd írd ki az összes mértékegységet,
valamint csak az SI mértékegységeket!

[rating feedback=java-enumtype-mertekegysegek]

### Bónusz feladat

Hol lenne a `nextDay()` valamint a `siUnits()` metódus helye? Hogy lehet ezt ott definiálni,
ha nem példányhoz, hanem osztályhoz tartozik? Hogy lehet meghívni?

## Forrás

OCP - Chapter 1/Working with Enums

## Teszt

Hogyan lehet szövegből enum példányt előállítani?

* `Coin c = Coin.values("TEN");`
* `Coin c = new Coin("TEN");`
* `Coin c = Coin.parse("TEN");`
* [x] `Coin c = Coin.valueOf("TEN");`

Hogyan lehet a felsorolásos típus második elemét lekérdezni?

* `Coin c = Coin.ordinal(1);`
* `Coin c = Coin.values()[1];`
* `Coin c = Coin.values(1);`
* `Coin c = Coin.valueOf(1);`
