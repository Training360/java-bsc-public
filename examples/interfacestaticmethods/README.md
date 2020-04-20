# Static interfész metódusok

Az interfészben definiálhatunk statikus metódust is, amelyet mindig implementálnunk kell. 
Ez csak publikus lehet, nem látható el a `default` módosítóval, és nem öröklődik. 
Kizárólag az interfész nevével minősítve hívható.

A cél az, hogy az interfészbe helyezzük el azokat a metódusokat, amelyek az interfész különböző 
példányain dolgoznak, ne pedig egy különálló osztályba. Ilyen metódus a `List.of()` mely az átadott 
elemek listájával tér vissza, függetlenül a konkrét lista implementációtól. Ez gyakorlatilag 
kiváltja a régóta meglévő `Arrays.asList()` metódust, mely egy olyan konkrét osztály 
statikus metódusa, amelynek semmi köze nincs a listákhoz.

Java 9 óta a statikus metódus is lehet privát.
 
## Ellenőrző kérdések
 
* Hogyan definiálhatunk statikus interfész metódust? Hogyan lehet meghívni?
 
## Feladat

### Értékek

Készíts egy `Valued` interfészt, mely egyetlen absztrakt metódust definiál. 
A `getValue()` metódus egy `Valued` példány értékét adja meg. Hozz létre az interfészben egy 
`sum()` metódust, mely paraméterként egy `List<Valued>` típusú adatot kap, és a benne található 
elemek összértékét számítja ki!
