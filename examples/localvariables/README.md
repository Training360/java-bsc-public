# Literálok és lokális változók

## Adattípusok

A Java erősen típusos nyelv, azaz minden változó deklarációjakor meg kell adnunk 
annak típusát, és ezt később nem változtathatjuk meg. Egész típus
pl. a `boolean` mely egy logikai értéket tárol, `true` vagy `false`.
Az `int` egész típus, a `double` lebegőpontos típus.

Egy változó vagy primitív típusú, vagy referencia. A referencia típusú változók 
mindig egy objektumra mutatnak, de annak nem az állapotát, hanem csak egy 
hivatkozást tárolnak. Egy objektum állapota csak közvetve, ezen a hivatkozáson, 
vagy referencián keresztül érhető el. Ilyen referencia típus például a `String`.

## Bevezetés a literálok használatába

Literálnak hívjuk azokat a kifejezéseket, amelyeknek önmagukban is van jelentése. 
Ezekhez mindig implicit társul egy adattípus. A `true` és `false`
`boolean` típusú literál. Ha pl. leírjuk, hogy `12`, az egy
egész literál, melynek típusa `int`. Pl. a `1.5` egy lebegőpontos literál, melynek
típusa `double`.

Speciális literál a `null`, mely referencia változóknak adható értékül, amikor 
semmilyen objektumra nem mutatnak.

A `"John Doe"` egy `String` típusú literál.

## Lokális változók

Metóduson belül deklarált és paraméterként átadott változókat együttesen lokális 
változóknak nevezzük. 
Változókat deklarálni a típusukkal és a nevükkel lehet.
Ezen kívül opcionálisan meg lehet adni kezdőértéket is, egyenlőségjel után.

```java
double amount;
double sum = 1.5;

int i = 0;
```

[important]
A Java 10-ben jelent meg az a lehetőség, hogy a lokális változó típusát nem kell 
megadni, ha kezdőértékadás van, ekkor a kezdőérték típusa lesz a változó típusa.
[/important]

Ilyenkor a `var` kulcsszót kell alkalmazni. 

```java
var sum = 1.5;

var i = 0;
```

Ezeknek nincs automatikus kezdőértékük, ezért használatuk előtt mindig nekünk 
kell az értékadásról gondoskodni. Kizárólag a deklarációtól azon blokk végéig 
léteznek, amelyben deklaráltuk.

## Típuskonverzió

Alapszabály, hogy egy változónak csak olyan típusú érték adható, amilyen a 
deklarált típusa. Ha más típusú értéket szeretnénk benne tárolni, akkor azt 
konvertálni kell. Ez a konverzió történhet automatikusan, implicit módon vagy 
a programozó által jelölten, explicit módon.

Hasonló típusok között (pl. számok) a kisebb automatikusan konvertálható 
nagyobbra, mint például `int` típusú érték `double` típusúra. A nagyobb típusú 
csak típuskényszerítéssel (_cast_) konvertálható kisebbre, és ez esetleges 
adatvesztéssel járhat.

```java
double d = 12;         // int --> double implicit
int i = (int) 3.14; // double --> int kényszerítéssel, értéke 3
```

[important]
A videóban kerekítés hangzik el, de valójában levágja a tizedesjegyeket.
[/important]

Például a matematikai kerekítés szerint `3.6` értéke `4` lenne, de valójában
`3` lesz.

```java
double d = 3.6;
int i = (int) d; // i értéke 3 lesz
```

A Java nyelvben a logikai érték nem kapcsolható számértékhez, mint sok más nyelvben, 
ezért ezek nem konvertálhatók számmá.

## Objektumok élettartama

Egy objektum a létrehozásától (konstruktor hívása) addig létezik, amíg a garbage 
collector (GC) be nem gyűjti. Ez csak azután történhet meg, hogy a program már 
nem használja, de azután bármikor a program futása során.

## Ellenőrző kérdések

* Mire valók a literálok?
* Milyen literálokat ismersz, és hogyan deklarálod őket?
* A hol definiált változókat nevezzük lokális változóknak?
* Szükséges-e típust definiálni? Milyen típusokat különböztetünk meg?
* Mi a lokális változó láthatósága?
* Mi a kezdőértéke egy lokális változónak?
* Amennyiben értéket adunk neki, az értékhez meddig tudunk hozzáférni?
  (Primitív és osztály típus esetén is fejtsd ki!)

## Feladat

### Literálok és típusok

A `localvariables.LocalVariablesMain` osztály `main()` metódusában
hozd létre az alábbi lokális változókat!

Definiálj egy `boolean` típusú
változót `b` néven, majd írasd ki az értékét!

Sikerül?

Adj értékül neki `false` értéket!

Definiálj egy `int` típusú változót `2` kezdőértékkel `a` néven!

Definiálj egy sorban két `int` típusú változót `i` és `j` néven `3` és `4`
kezdőértékkel!

Definiálj egy `int` típusú változót `k` néven, és add neki értékül az
`i` változó értékét!

Próbálj egy változót definiálása előtt kiírni! Sikerül?

Definiálj egy `String` típusú változót `s` néven! Adj neki `"Hello World"`
értéket!

Definiálj egy `String` típusú változót `t` néven, és add értékül neki az `s`
változó értékét!

Metóduson belül definiálj egy blokkot (kapcsos zárójelek között)!
A blokkon belül definiálj egy `int` típusú `x` változót `0` kezdőértékkel!

Az értékét próbáld kiírni blokk után, a blokkon kívül! Fog sikerülni?

A blokkban próbáld meg kiírni a blokkon kívül, a blokk előtt definiált `a`
változó értékét!

### Időpontok

Készíts egy `Time` osztályt, amely egy adott időpontot reprezentál egy napon 
belül. Három attribútuma az óra, perc és másodperc értékét tárolja egész számként. Ezeket a  
a konstruktorban kapja meg. Készíts el az alábbi metódusokat:

* A `getInMinutes()` metódus az időpont értékét percekben adja vissza, de a 
másodperceket figyelmen kívül hagyja.
* A `getInSeconds()` metódus a teljes időpontot másodpercben adja vissza.
* A `earlierThan()` metódus paraméterként egy másik `Time` típusú objektumot kap. Amennyiben az adott 
objektum által reprezentált időpont korábbi, mint a paraméterül kapott, igazat ad vissza, különben hamisat. 
Használd a már elkészített metódusokat!
* A `toString()` metódusa az időpontot óra\:perc\:másodperc formában szövegként adja vissza.

A `TimeMain` osztály `main()` metódusában teszteld az osztályt! Kérj be a felhasználótól két 
időpontot, és írd ki az elsőt teljesen majd percekben, a másodikat teljesen majd 
másodpercekben, illetve azt, hogy az első korábbi-e, mint a második!

Egy lehetséges kimenet:

```
Az első időpont 12:3:43 = 723 perc
A második időpont 4:21:38 = 15698 másodperc
Az első korábbi, mint a második: false
```

## Forrás

OCA - Chapter 1/Understanding Default Initialization of Variables, Understanding Variable Scope

## Teszt

Válaszd ki a helytelen értékadást!

* `int x = 23;`
* `double d = 'a';`
* `double d = -1;`
* [x] `int b = true;`
