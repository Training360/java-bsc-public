# Bevezetés a vezérlési szerkezetekbe

## Elágazás

Ha egy utasítást egy feltételtől függően szeretnénk végrehajtani, akkor **elágazást** 
kell használnunk. Meg kell adnunk egy feltételt, amely mindig egy logikai értéket 
adó kifejezés. Ha a kiértékelése igaz, akkor az első, ha hamis, akkor a második blokkban, az
(`else`) ágon lévő utasítássor fut le. Ha hamis esetén nem szeretnénk semmit sem 
csinálni, akkor ez az ág akár el is hagyható.

```java
if ((x % 2) == 0) {
    System.out.println("Even");
} else {
    System.out.println("Odd");
}
```

## Ciklus

Ha egy utasításblokkot többször szeretnénk végrehajtani, akkor nem kell az 
utasításokat sokszor kiadnunk egymás után, hanem elég a programban megadnunk, 
hogy mely utasításokat és meddig szeretnénk végrehajtani. Ezt a szerkezetet 
**ciklusnak** nevezzük. A Java nyelv többféle 
megoldást nyújt erre. Ezek közül az egyik igen gyakran használt a `for` 
kulcsszóval bevezetett ciklus. A fejrésze három részből áll: inicializációs rész, 
feltétel és léptetés. Törzsében azok az utasítások szerepelnek, amelyeket 
többször is végre szeretnénk hajtani.

```java
for (int i = 0; i < 10; i++) {
    System.out.println(i);
}
```

Az inicializációs részben a ciklusváltozó kezdőérték adása szerepel. Nagyon 
gyakran itt is deklaráljuk, ebben az esetben ez a cikluson kívülről nem érhető el. 
Először ez a rész fut le, méghozzá csak egyetlen egyszer. Ezután megvizsgálja a 
feltételt, és amennyiben igaz a kiértékelése, akkor végrehajtja a ciklusmagban 
megadott utasításokat, majd elvégzi a ciklusfejben megadott léptetést, és újra 
megvizsgálja a feltételt. Mindezt addig ismétli, amíg a feltétel hamissá nem 
válik, vagy valamilyen módon ki nem ugrunk a ciklusból.

## Ellenőrző kérdések

* Hogyan lehet feltételes utasítást Javában létrehozni?
* Hogyan lehet ciklust használni Javában?

## Feladat

### Bevezetés a vezérlési szerkezetek használatába

A `introcontrol.IntroControl` osztály `public int substractTenIfGreaterThanTen(int number)` metódusában
add vissza a paraméterként átadott értéket, ha az kisebb vagy egyelő, mint 10, ellenkező esetben
csökkentsd 10-zel, és azt add vissza!

Hívd meg a `main()` metódusból különböző értékekkel, és írd ki az eredményt!

A `public String describeNumber(int number)` metódusában adj vissza `"zero"` értéket,
ha a paraméterként átadott érték 0, és `"not zero"` értéket, ha nem 0!

A `public String greetingToJoe(String name)` metódusban adj vissza `Hello Joe` értéket,
ha a paraméterként átadott név `"Joe"`, és üres Stringet, ha nem!

Az értékesítők 10% jutalékot kapnak az eladások alapján, de csak abban az esetben, 
ha a havi eladás értéke legalább 1 000 000 Ft.
A `public int calculateBonus(int sale)` metódusban számold ki a jutalékot az eladási összeg alapján,
és a jutalék összegét add vissza!

A `public int calculateConsumption(int prev, int next)` metódusban
számold ki a paraméterként megadott mérőóraállások közötti különbséget. Ha a
villanyóra eléri a 9999 értéket, átfordul, és újraindul 0 értéktől. Tételezzük fel,
hogy csak egyszer fordulhat át, és nem érheti el az előző értéket. Tételezzük fel,
hogy 9999 értéknél nagyobbat nem kap paraméterül.

A `public void printNumbers(int max)` metódussal írd ki a pozitív egész számokat (nullával kezdve)
egészen a paraméterként megadott számig (az is legyen kiírva).

A `public void printNumbersBetween(int min, int max)` metódussal írd ki a pozitív egész számokat a két
paraméterként megadott érték között. Feltételezzük, hogy mindkét paraméterként kapott szám nagyobb vagy egyenlő nullával.

A `public void printNumbersBetweenAnyDirection(int a, int b)` metódussal írd ki a pozitív egész számokat a két
paraméterként megadott érték között. Ha az `a` értéke nagyobb, mint a `b` értéke, akkor csökkenő sorrendben történjen a kiíratás.

A `public void printOddNumbers(int max)` metódussal írd ki a páratlan pozitív egész számokat (egytől indítva)
egészen a paraméterként megadott számig (az is legyen kiírva, ha páratlan)!

### Bónusz feladat 1.

Mi történik a `printNumbers()` metódusban, amennyiben negatív számot adsz meg?

A `calculateBonus()` metódusban mi történik, ha az eredmény nem egész szám?

Mi történik, ha a `printNumbersBetween()` metódusban a `min` értéke nagyobb, mint
a `max` értéke?

[rating feedback=java-introcontrol-introcontrolclass]

### Bónusz feladat 2.

Miért kell a `main()` metódusban példányosítani az osztályt a többi metódus meghívásához?

### Csónakok

Egy csónakkölcsönzőben van 3 csónak. Az elsőben 5-en, a másodikban 3-an, a 
harmadikban 2-en férnek el. Amikor jön egy csoport, és szeretne csónakor bérelni, 
akkor úgy kell kiadni nekik a csónakokat, hogy miután kihajóznak, a lehető legtöbb 
hely és csónak maradjon bent egy következő csoportnak.

Például ha 6-an jönnek, akkor az öt- és kétszemélyes csónakot kell kiadni nekik, 
mert így még akár egy 3 fős csapat is ki tud hajózni.

Ha 5-en jönnek, akkor az 5 személyes csónakot kell kiadni nekik, mert így 2 csónak 
összesen 5 hellyel marad bent.

Készíts egy  `BoatRental` osztályt, ahol a `main()` metódusban bekéred az érkező 
csapat létszámát, majd írd ki, hogy melyik csónakokat vitték el és még hány fő mehet utánuk! 
Ha többen voltak, mint 10, akkor jelezd, hogy maradtak még a parton!

### Bónusz feladat 3.

Általánosítsd a csónakos feladatot úgy, hogy a csónakok létrehozásakor meg lehessen 
adni a kapacitásukat!

## Forrás

OCA - Chapter 2/Understanding Java Statements

## Teszt

Mit ír ki az alábbi kódrészlet?

```java
for(int i = 4; i <= 10; i++) {
    if(i >= 7) {
        System.out.println(i / 2);
    } else {
        System.out.println(i * 2);
    }
}
```

* 8 10 12 14 4 4 5
* [x] 8 10 12 3 4 4 5
* 8 10 12 3 4 4
* 8 10 12 14 4 4

