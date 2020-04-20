# Típuskonverzió

A Java erősen típusos nyelv. Ha egy kifejezésben az operandusok különböző típusúak, 
akkor típuskonverzióra van szükség, tehát a típusokat össze kell egyeztetni. Ez 
általában fordítási időben ellenőrizhető. Van néhány eset, amikor futás közben derül ki, 
hogy nem konvertálható az érték, így kivétel keletkezik.

## Automatikus típuskonverzió

Az automatikus konverzió akkor működik, ha a bővebb ábrázolási tartomány felé kell 
konvertálni. Kivétel, hogy a `float` és `double` változónak adható `long` érték, de ez 
adatvesztéssel járhat.

```java
int number = 54;
long longNumber = number;
double doubleNumber = longNumber;
```

A `byte`, `short`, `char` típusnak értékül adható megfelelő 
`int` literál, ha az értékre belefér.

```java
byte byteNumber = -6;
short shortNumber = 12_398;
char charNumber = 6;
```

Számokkal való műveletvégzéshez mindig a bővebb ábrázolási tartományú típusra 
konvertálja az operandusokat, de egész számokat legalább `int`-re. Ezt azért fontos tudnunk, mert 
két `byte` típusú szám összege még akkor is `int` típusú, ha egyébként beleférne az eredmény a `byte`-ba.

```java
byte a = 4;
byte b = 5;
int i = 12;

byte c = a + b; //Nem jó, mert a jobb oldal int típusú.
int x = a * i;  // int * byte --> int
```

## Explicit típuskonverzió

Explicit konverziót akkor kell használni, amikor a szűkebb ábrázolási tartomány 
felé szeretnénk konvertálni. Ebben az esetben információvesztés történhet. Egész 
számok esetén elvesznek a felső bitek, míg lebegőpontos számok egészre való 
konvertálásakor nem kerekítés történik, hanem elvesznek a tizedes jegyek.

```java
public static void main(String[] args){
    int i = 5;
    long l = 500;
    float f = 1;
    double d = 10.1;

    i = (int) l;
    i = (int) d;
}
```

## Ellenőrző kérdések

* Mire való a típuskonverzió?
* Milyen fajta típuskonverziókat ismersz?
* Milyen furcsa esetet ismersz, amikor az automatikus konverzió furcsán működik?
* Hogyan adható meg explicit konverzió?
* Hogyan működik az explicit konverzió egész számok esetén?
* Hogyan működik az explicit konverzió, amennyiben lebegőpontos számot konvertálunk
egész számmá?

## Feladat

### Adatvesztés

A `typeconversion.dataloss.DataLoss` osztályba dolgozz! Írj egy `dataLoss()`
metódust, mely kiírja az első három olyan pozitív egész `long` értéket,
melyet `float`, majd vissza `long` értékké konvertálva adatvesztés történik!
Írd ki binárisan is!

Az eredeti és a konvertált érték között mennyi a különbség? Hány bináris
számjegynél jelenik meg a probléma?

Teszteld a `main()` metódusból!

[rating feedback=java-typeconversion-automatikuskonverzio]

### Melyik típusba való?

A `typeconversion.whichtype.WhichType` osztályba írj egy `List<Type> whichType(String s)`
metódust, mely visszaadja, hogy a paraméterben `String`-ként megadott
`long`-on biztosan ábrázolható szám milyen más adattípusokba férhet még bele
(`byte`, `short`, `int`). A `Type` egy enum, mely tartalmazza a típusokat,
és mindegyikhez külön attribútumban meg lehet adni `long`-ként a
minimális és maximális értéket.

Teszteld a `typeconversion.whichtype.WhichTypeMain` osztály `main()` metódusában!

[rating feedback=java-typeconversion-melyiktipusba]

Tipp: A paraméterként átadott értéket `long` értékké kell alakítani (`Long.parseLong()`),
majd ciklusban végigmenni az enum értékein, és megnézni, hogy belefér-e a tartományba.

## Teszt

Melyik értékadás helytelen, ha az `x` változó `int` típusú?

* `long l = x;`
* `double d = x;`
* [x] `short s = x;`
* `char c = (char) x;`
