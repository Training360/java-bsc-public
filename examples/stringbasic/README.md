# String alapok

A `String` osztály mögött valójában egy karaktertömb van. A `String` immutable 
(módosíthatatlan), vannak ugyan metódusai, de ezek nem a belső állapotot változtatják, 
hanem mindig egy új objektummal térnek vissza.

A Java virtuális gépen belül létezik egy  **String pool**, ami egy memóriaterület. 
A `String` literálok itt jönnek létre, nem pedig a heapen. Ha mégis a heapen 
szeretnénk létrehozni, akkor használjuk a `new` operátort.

A `String` osztályban taláható egy `intern()` metódus, ami azt nézi, hogy a 
paraméterként átadott `String` benne van-e a poolban, ha igen, arra ad vissza egy 
referenciát, ha nincs, akkor belerakja.

Fontos, hogy `String` objektumokat mindig az `equals()` metódussal hasonlítunk 
össze.

```java
String s = "abc";
String s2 = "abc";

s.equals(s2); // Igaz lesz

```

Az `==` operátor az objektumok referenciájának egyezőségét vizsgálja, ezért `String`-ek 
esetén csak akkor működik helyesen, ha tényleg ugyanaz az objetum van mögötte. Például két változó 
ugyanazt a literált kapja értékül.

## Mikor és hogyan használjunk `String`-eket?

A `String` típusú adat a legszélesebb körben használható, de pár jó tanácsot érdemes megfogadni:

* Amennyiben bájttömbből hozzuk létre, adjuk meg a karakterkódolást. Nem mindegy, 
hogy az adott karakterkódhoz milyen karakterkép társul.
* Ne használjuk arra, hogy több adatot összefűzve tároljunk benne.
* Ha csak bizonyos értékeket tartalmazhat, akkor használjunk inkább enumot.
* Vannak esetek, amikor számok helyett megfelelőbb a `String` használata. Amikor az 
adatnak nem a nagysága a fontos, nem akarunk vele aritmetikai műveleteket végezni, akkor 
praktikusabb `String`-ként tárolni. Ilyen például az irányítószám, az adóazonosító jel 
és a telefonszám.


## Ellenőrző kérdések

* Hol tárolódhatnak a String objektumok?
* Mitől függ a tárolás helye?
* Mikor `true` az `intern()` metódussal kapott ún. `canonical representation`
alapú összehasonlítás visszatérési értéke?
* Melyik az előnyös megoldás String objektumok létrehozására és miért?

## Feladat

### `String`-ek

Azonos tartalmú `String` objektumokat hozunk létre, amelyeket vagy a heapre,
vagy a poolba szánunk.

publikus metódusok:

```java
public String createStringForHeap()
public String createStringForPool()
```

[rating feedback=java-stringbasic-poolheap]

### Kis kedvenceink

Tervezz meg egy házi kedvencek adatainak nyilvántartására szolgáló `Pet` osztályt! 
Minden kedvencnek van neve, születési ideje, neme és regisztrációs száma. A neme 
csak hím, nőstény vagy ismeretlen lehet. A regisztrációs száma mindig egy 6 jegyű szám, 
például 000147.
Melyik attribútuma milyen típusú legyen?

Készíts gettereket minden attribútumhoz!

A `Vet` osztály tartalmazza egy adott orvoshoz tartozó kisállatok listáját. Készíts 
egy `add()` metódust, mely az újonnan érkező kisállatot adja a listához, de csak 
akkor, ha még nincs ott! Ennek vizsgálatára készíts egy privát `areEquals()` metódust, mely a paraméterül 
kapott két kisállat egyezőségét adja vissza! Két kedvenc akkor tekinthető ugyanannak, 
ha ugyanaz a regisztrációs számuk. A listához készíts gettert!

## Teszt

Mit ír ki az alábbi kódrészlet?

```java
String password1 = "John123";
String password2 = "John123";

System.out.println(password1 == password2);
System.out.println(password1.toUpperCase() == password2.toUpperCase());
```

* true true
* [x] true false
* false true
* false false

Mire való a String pool?

* A memória ezen részén tárolódnak a `String`-ek.
* [x] A memória ezen részén tárolódnak a literálként létrehozott `String`-ek, 
mégpedig mindegyik csak egyszer.
* A memória ezen részén tárolódnak a `new` operátorral létrehozott `String`-ek.
* A memória ezen részén tárolódnak a `String` metódusok által visszaadott 
`String`-ek, mégpedig mindegyik csak egyszer.
