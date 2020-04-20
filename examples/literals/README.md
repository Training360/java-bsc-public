# Literálok

A literál a program kódba direktben beírt, "beégetett" érték, melynek önmagában is 
jelentése van. Fontos, hogy ezt futás közben nem tudjuk megváltoztatni.

## Objektumliterál

Java nyelvben egyetlen objektumliterál létezik, ez nem más, mint a `null`. Ezt az 
értéket akkor használjuk, ha azt akarjuk definiálni, hogy a változó nem mutat 
egyetlen objektumra sem, azaz nincs referenciája.

```java
String s = null;
```

## Logikai literál

Két értéke lehet `true` és `false`.

## Egész számok

Egész számot igen sok féle képpen le tudunk írni, különböző számrendszerekben.

* Bináris, pl. `0b0011`
* Oktális, pl. `0377`
* Hexadecimális, pl. `0xff`
* Decimális, pl. `12`

Vigyázzunk, a `0` előtagú számokat oktális és nem decimális számrendszerben értjük, 
így egészen más értéket kaphatunk, mint szerettük volna.

Alapértelmezett típusa az egész számoknak  `int` , ez átkonvertálható `long`  típusba, 
csupán a szám mögé kell egy `l` vagy `L` betűt írnunk. Javasolt az `L` használata, mert a 
`l` könnyen összetéveszthető az `1` számjeggyel. Pl. `012L`

Olvashatóság javítására használhatjuk az aláhúzás (`_`) karaktert. pl.: `0b0011_1100 , 100_000`

## Lebegőpontos számok

A lebegőpontos számokat kétféle képpen tudjuk megadni. Fontos, hogy a pont (`.`) a tizedes elválasztó karakter!

* Decimális megadási mód, pl. `-12.3`
* Exponens használata, pl. `-12.3e4` (-12.3 * 10^4 értéket képviseli )

Alapértelmezett típusa `double`. Ha azt szeretnénk, hogy `float` legyen, akkor az `f`, 
illetve az `F` suffixet kell használnunk, pl. `1.0F`.

Az egész értékű számokat kétféleképpen is megadhatjuk, hogy az `double` típusú literál legyen. 
Az egyik módszer, hogy kiírunk egy tizedes jegyet, azaz a `2` helyett `2.0`-t írunk le. A másik módszer, hogy 
a szám után `d` vagy `D` postfixet írunk, például `2d`.

## Karakteres literálok

Karakter literálként meg lehet adni egyetlen egy karaktert pl. `'a'`. Figyelnünk 
kell a speciális karakterekre, például az ékezetes betűkre, ugyanis a Java virtuális 
gép és az operációs rendszer kódolása eltérhet. Javasolt a fejlesztőezközt úgy 
beállítani, hogy minden állomány __UTF-8__ karakterkódolással legyen elmentve. 
A kódolást a Maven `pom.xml` fájlban kell megadni.

Speciális karakterek lehetnek például a sortörés, az idézőjel, vagy a visszaperjel, 
ilyenkor úgynevezett escape karaktert kell használnunk, ami a visszaperjel (`\`) , 
így ezek rendre : `'\n', '\”' , '\\'` . Karakteres literálokat is megadhatunk oktális, 
illetve hexadecimális számrendszerben, ekkor a prefix `\0` és `\u`. Például `'\u0067'`.

Ha egy szöveget szeretnénk megadni, azt idézőjelek (`""`) között tehetjük meg. 
Ilyenkor egy `String` objektum jön létre, amit a Java virtuális gép fog példányosítani.

## Osztályliterál

Még egy speciális literál a típust reprezentáló osztály objektum. 
Ebben az esetben a `.class` végződést kell használnunk. Például `String` esetében `String.class`.

## Ellenőrző kérdések

* Milyen objektumliterált ismersz?
* Amennyiben leírsz egy egész számot, annak mi a típusa? Hogyan lehet ezt módosítani?
* Milyen számrendszerben lehet megadni egész számokat?
* Hogyan lehet olvashatóbbá tenni?
* Lebegőpontos számoknál hogyan lehet exponenst megadni?
* Ha leírsz egy lebegőpontos számot, mi a típusa? Hogyan lehet módosítani?
* Hogyan ábrázolja a JVM a karaktereket?
* Hogyan szerepelnek a karakterek a forráskódban? Hogyan lehet ezt Maven `pom.xml`
állományban állítani?
* Milyen speciális karaktereket ismersz?
* Hogyan adsz meg osztályt reprezentáló literált?

## Feladat

A `literals.LiteralsMain` osztályba dolgozz!

### Összefűzés

Fűzd össze szövegként az `1` és `2` literált! Milyen megoldásokat ismersz?

### Osztás

Vedd a 3 és a 4 hányadosát, és tárold el a `double quotient` változóban, majd írd ki! 
Mi lesz az eredmény?

Miért van ez így?

Hogyan lehet ezt pontosítani kizárólag literálok használatával?

### Nagy szám

Definiáld a `3_244_444_444` literált, és add értékül a `long big` változónak!

### Karakterkódolás

Definiálj egy `String s` változót, melynek legyen az értéke `árvíztűrőtükörfúrógép`!
Fordítsd le úgy, hogy a `pom.xml` állományban megjegyzésbe teszed a karakterkódolásra
vonatkozó sorokat! Futtasd az alkalmazást parancssorból!
Megjegyzés: Nem várunk különbséget, mert az elmúlt egy évben a Maven "megokosodott" és a
karakterkódolás megadása nélkül is korrekt kimenetet biztosít.

### `String` mint objektum

Definiálj egy `String word` változót, melynek az értéke legyen a `TITLE` szöveg 
nagybetűkkel! A szövegliterál kisbetűkből álljon, és hajtsuk végre rajta
a `toUpperCase()` metódust az értékadás előtt!

### Szám bináris stringként

Írasd ki az 1 és a -2 értéket bináris formájában! Keresgélj az `Integer` osztály metódusai között!

[rating feedback=java-literals-feladatok]

## Teszt

Melyik NEM karakter literál a Javában?

* `'a'`
* [x] `"a"`
* `'\065'`
* `'\u0061'`
* `'\n'`


Milyen típusú a `0b0011` literál?

* `byte`
* [x] `int`
* `long`
* `char`
* `String`
