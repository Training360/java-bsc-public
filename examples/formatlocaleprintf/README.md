# printf


A C/C++ nyelv egy igen széles körben elterjedt funkciója mely paraméteres szövegek kiírására jól használható. Ez a metódus Java-ban a `PrintWriter` osztályban található. Nézünk egy példát.:
```java
System.out.printf("The result is %d", 500);
```
A %d az egész számot jelöli. A paraméterek varargs formátumban adhatók meg. 


#### Konverziós karakterek
Nézzünk még egy példát:

```java
System.out.printf(%8.2f, 1000.0/3.0);
```
Ez azt, jelenti, hogy 8 karakteren írunk ki, két tizedesjegy pontossággal egy lebegőpontos számot. További placeholder karakterek: 

*	__%s__-szöveg
*	__%d__-egész szám
*	__%f__-lebegőpontos szám

Valójában Java-ban a `Formatter` osztály implementálja ezeket a műveleteket.


#### Dátumok használata

Dátum placeholder: %tc . Itt is az oprendszer alap locale-je van használva, ha ezen változtatni szeretnénk:

```java
System.out.printf(Locale.US, ”%tc”,new Date());
```


## Ellenőrző kérdések

* Hogyan lehet formátum string alapján szövegeket kiírni?
* Hol használható? Milyen alternatív neve van?
* Milyen formázási karaktereket ismersz? Hogyan lehet egész számot, lebegőpontos számot, dátumot formázni?
* Alapesetben milyen locale-lal dolgozik? Hogyan lehet más locale-t megadni?
* Milyen szerkezettel valósították meg a változók átadását?
* Milyen szerepe van az autoboxingnak?

## Gyakorlat - PrintFormat

Készítsünk egy `PrintFormat` osztályt, amelynek paraméterezhető metódusai különböző
String formázásokat biztosítanak a `String.format()` metódus segítségével.

### Hibakezelés

Amennyiben a format stringben felsorolt paraméterek száma több, mint a híváskor átadott, dobjon
`IllegalArgumentException`-t.

### Megvalósítás

publikus metódusok:
```java
public String checkException(String formatString, Integer i, Integer j)
public String printFormattedText(Double number)
public String printFormattedText(int count, String fruit)
public String printFormattedText(int number)
public String printFormattedText(Integer i, Integer j, Integer k)
```

### Megjegyzés

A hibakezelés nem általános megoldás, csupán egy tipikus kivétel bemutatását szolgálja.

[rating feedback=java-formatlocaleprintf-printformat]  
