# Objektumok és attribútumok

Egy Java alkalmazás a futás közben létrejövő és egymással kommunikáló objektumok 
összessége. Ezen objektumok az osztályok alapján készülnek el. Az objektumok 
tárolhatnak adatokat, melyeket **attribútumnak** nevezünk. Az azonos típusú 
objektumok ugyanolyan mintára készülnek, ezért ugyanolyan típusú adatok tárolására 
alkalmasak. Egy objektum **állapotán** az attribútumok aktuális értékeinek 
összességét értjük.

<!-- Kép építőkockákból készített várról és a kockák legyártásához használt 
tervrajzokról, például kocka, kúp, híd. A tervrajzok mellett "osztály" felirat, 
a vár mellett "objektumok" felirat.) -->

Attribútumot a típusa és a neve megadásával deklarálhatunk:

```java
public class Trainer {
    
    String name;

    int yearOfBirth;

}
```

Egy objektum attribútumát a pont operátorral érhetjük el.

```java
public static void main(String[] args) {
    Trainer trainer = new Trainer(); // 1
    trainer.name = "John Doe";
    trainer.yearOfBirth = 1980;

    Trainer anotherTrainer = new Trainer(); // 2
    anotherTrainer.name = "Jack Doe";
}
```

A példában látható, hogy az `// 1` jelzéssel ellátott sorban példányosítunk egy
`Trainer` objektumot, és beállítjuk a nevét és a születési évét. Ez lesz
az objektum állapota. Majd a `// 2` jelzéssel ellátott sorban példányosítunk
egy másik `Trainer` objektumot, ennek más nevet állítunk be.

## Ellenőrző kérdések

* Mi az az attribútum? 
* Mit értünk egy objektum állapota alatt?

## Feladat

### Ügyfél osztály

Hozz létre egy `Client` osztályt, melynek három attribútuma van: név (`name`), születési év (`year`)
és cím (`address`). Típusaik rendre `String`, `int` és `String`.

Hozz létre egy `main()` metódust a `ClientMain` osztályba, amelyben kipróbálod 
a `Client` osztály működését. Példányosítani kell egy objektumot 
a `Client` osztály alapján, majd kérd be az attribútumok értékét a 
felhasználótól. Ellenőrzésképp írd ki minden attribútumának értékét a konzolra!

### Zeneszámok

Készíts egy `Song` osztályt, melyben eltárolhatod egy dal előadóját (`band`), címét 
(`title`) és a hosszát (`length`) másodpercekben!

Készíts `main()` metódust egy `Music` osztályba, ahol kérd be a felhasználótól
a kedvenc zeneszáma adatait! Ellenőrzésképp írd ki a megadott adatokat
`szerző - cím perc:másodperc` formában! 

(A percek számát megkapod, ha elosztod a beolvasott hosszt 60-nal. Javában az 
osztás operátor a `/`, és egész számok osztása esetén csak az egész hányadost 
adja vissza.)


## Forrás

OCA - Chapter 1/Understanding the Java Class Structure, Writing a main() Method

## Teszt

Igaz-e? Egy objektum állapotán az attribútumok aktuális értékeinek összességét értjük.

* [x] igaz
* hamis

Válaszd ki a HAMIS állítást!

* Az osztály attribútumának mindig van típusa.
* Az osztály attribútumának mindig van neve.
* [x] Az osztály attribútumai az osztály viselkedését írják le.
* Az osztály attribútumai az osztály állapotát írják le.
