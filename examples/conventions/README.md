# Kódolási konvenciók

## Kódformázás

Javában nincs egységes kódolási szabálygyűjtemény az elnevezésekre, behúzásokra, 
sortörésekre stb. Az Oracle weboldalán megtalálható egy ajánlás, valamint a 
nagyobb cégek is, mint például a Google, mind rendelkeznek saját konvenciókkal. 
Ezeket az alábbi linkeken tanulmányozhatod át:

http://www.oracle.com/technetwork/java/codeconvtoc-136057.html

https://google.github.io/styleguide/javaguide.html

Az IDE-k tartalmaznak kódformázó menüpontokat, de ezek sem egységesek.

## Behúzások, üres sorok, blokkok

Konvenció szerint beljebb kezdünk minden olyan utasítást, amely valamilyen másik 
utasításon, blokkon belül van. Így az osztályon belül beljebb kezdjük az 
attribútum és metódus deklarációkat, a metóduson belül a metódustörzset.

Az attribútumok és a metódusok között hagyjunk ki egy-egy üres sort, így a kódunk 
sokkal strukturáltabbá, olvashatóbbá válik.

## Elnevezések

A Java nyelvben használt azonosítók bármilyen Unicode betűt, számot `_`-t és `$`-t 
tartalmazhatnak, azonban kerüljük az ékezetes karakterek használatát. Legjobb, 
ha csak az angol ábécé betűit és számokat használunk. A több szóból álló elnevezés 
esetén minden szót nagybetűvel kezdünk (CamelCase) és egybe írunk. Mozaikszavak 
esetén is csak az első betűt írjuk naggyal, a többit kicsivel. Bármilyen elnevezés 
megengedett, kivéve a nyelv által lefoglalt kulcsszavakat, mégis kerüljük azokat, 
melyek megtévesztők. Például ne használjuk a `string` vagy az `integer` azonosítót, 
mert ezeket ugyan elfogadja a fordító, de összekeverhetőek a `String` és `Integer` 
típusokkal.

## Megjegyzések

Háromféle megjegyzés létezik. Az egysoros megjegyzést `//` karakterekkel kezdjük 
és a sor végéig tart. Ha többsoros megjegyzést szeretnénk írni, akkor azt a `/*` 
jellel kezdjük és  `*/` jellel zárjuk. A Javadoc megjegyzések olyan speciális elemek, 
amelyekből HTML-ben írt dokumentáció készíthető. Ezeket `/**` jellel kezdjük és `*/` 
jellel fejezzük be, és konvenció szerint minden sor elején `*` jel van. A Javadoc 
megjegyzés mindig azon elem fölé kerül, amelyikhez készítjük. Tartozhat osztályhoz, 
attribútumhoz és metódushoz is. Speciális jelöléseket használ például a metódus 
paraméterek vagy a visszatérési érték megadásához.

```java
/**
 * Tests if this date is before the specified date.
 *
 * @param   when   a date.
 * @return  {@code true} if and only if the instant of time
 *            represented by this {@code Date} object is strictly
 *            earlier than the instant represented by {@code when};
 *          {@code false} otherwise.
 * @exception NullPointerException if {@code when} is null.
 */
public boolean before(Date when) {
    return getMillisOf(this) < getMillisOf(when);
}
```

Forrás: http://www.oracle.com/technetwork/articles/java/index-137868.html

## Sorrendezés

A java fájlban először mindig a package deklaráció, utána az importok, 
végül az osztálydeklaráció következik. Ezek sorrendje kötött. Az, hogy az 
osztályon belül milyen sorrendben deklaráljuk az attribútumokat, metódusokat 
és konstruktorokat, az ránk van bízva, mégis konvencionálisan először adjuk meg 
az attribútumokat, utána a konstruktorokat, és csak legvégén a metódusokat. 
Ez utóbbiakat láthatóság szerint csökkenő sorrendbe szoktuk rendezni, azaz 
először írjuk a publikus, a legvégén pedig a privát metódusokat.

## Ellenőrző kérdések

* Mire valók a kódolási konvenciók?
* Hogyan nevezzük el az osztályokat, attribútumokat és metódusokat?
* Mire figyeljünk a betűszavaknál?
* Milyen sorrendben következzenek egy osztályon belül a különböző tagok?
* Milyen típusú megjegyzések vannak Java nyelvben?

## Feladat

### SonarLint telepítés

A SonarLint az IDÉ-be beépülve ellenőrzi a kódod minőségét, azaz, hogy mennyire 
tartod be a konvenciókat, illetve mennyire jól olvasható a kódod.

Nyisd meg a *File/Settings...* menüpontot, és a megjelenő ablak bal oldalán 
válaszd ki a *Plugins* szakaszt! A MarketPlace keresőjében keress rá a SonarLint 
bővítményre, és telepítsd fel! A bővítmény az IDE újraindítása után lesz elérhető.

Nyisd meg az előző gyakorlati feladatot, és nézd meg, mit ír róla a SonarLint! 
Az ablak alsó részében kell látnod egy SonarLint gombot. Amennyiben nem jelenik 
meg, a *View/Tool Windows/SonarLint* menüponttal bekapcsolhatod.


### Bónusz feladat 1.

Milyen különbségek vannak az Oracle (eredetileg Sun) és a Google kódolási 
konvenciói között?

## Forrás

OCA - Chapter 1/Ordering Elements in a Class

## Teszt

Megfelel a kódolási konvencióknak a Java `java.net.URL` vagy `java.net.URLConnection`
osztály?

* igen
* [x] nem
