# Tömbök tömbje

A Java nyelvben nem létezik többdimenziós tömb, azaz olyan tömb, amely egy 
táblázatra vagy táblázatok sorozatára hasonlít. Ellenben egy tömb elemei lehetnek 
tömbök is, így elérhető hasonló adatszerkezet. Ekkor arra kell figyelnünk, hogy a 
tömbök mérete akár mind különböző is lehet.

Létrehozása, ha például egy 5 soros, 3 oszlopos táblázatot szeretnénk egészekből:

```java
int[][] numbers = new int[5][3];
```

vagy ha különböző hosszú tömböket szeretnénk:

```java
int[][] numbers = new int[5][];
numbers[0] = new int[3];
numbers[1] = new int[8];
```

Létrehozás literállal:

```java
int[][] numbers = {{1}, {1, 2}, {1, 2, 3}};
```

## Ellenőrző kérdések

* Hogyan lehet Javában többdimenziós tömbhöz hasonló struktúrát létrehozni?
* Hogyan lehet ezt literálként feltölteni?

## Feladat

### Szorzótábla

A `arrayofarrays.ArrayOfArraysMain` osztályba dolgozz.

Hozz létre egy `int[][] multiplicationTable(int size)` metódust, mely a paraméterként 
megadott méretű szorzótáblát adja vissza!
A szorzótábla alakja (csak 4x4 esetén):

```
1 2 3 4
2 4 6 8
3 6 9 12
4 8 12 16
```

[rating feedback=java-arrayofarrays-szorzotabla]

### Tömbök tömbjének kiírása

Hozz létre egy `printArrayOfArrays(int[][] a)` metódust, mely kiír egy tömbök tömbjét!
A beágyazott tömbök elemeit egymás mellé, a külső tömb elemeit egymás alá.

A `main()` metódusában teszteld le a működést!

[rating feedback=java-arrayofarrays-kiiras]

### Háromszögmátrix

Hozz létre egy `int[][] triangularMatrix(int size)` metódust, mely a paraméterként 
megadott méretű háromszögmátrixot hozza létre, és minden sora a sor számának 
értékeit tartalmazza!
Ilyen kiírást várunk:
```
0
1 1
2 2 2
3 3 3 3
```

[rating feedback=java-arrayofarrays-haromszogmatrix]

### Napi mért értékek

A `int[][] getValues()` metódusban hozz létre egy 12 elemű tömböt, és mindegyik 
elem egy olyan hosszú tömböt tartalmazzon, amennyi nap van az adott hónapban 
(nem vagyunk szökőévben)! Minden elem kezdőértéke 0.

[rating feedback=java-arrayofarrays-napiertekek]

### Bónusz feladat 1.

A tömb kiírásánál figyelj arra, hogy minden egyes számértéknek három karakter 
legyen fenntartva, azaz ha egy számjegyű, akkor ki kell egészíteni két szóközzel, 
ha két számjegyű, akkor egy szóközzel (előtte)!

Például:

```
__1___2___3
_10__20__30
100_200_300
```

## Teszt

Melyik a helyes deklaráció, amelyik egy 3 soros és 5 oszlopos táblázatot 
(tömbök tömbjét) hoz létre?

* `int[][] table = new int[3];`
* `int[5] table = new int[3];`
* `int[3][5] table = new int[][];`
* [x] `int[][] table = new int[3][5];`

Adott az alábbi deklaráció: `String[][] words = new String[3];` Hogyan lehet azt elérni, hogy az 
első eleme egy 2 hosszú, a második eleme pedig egy 5 hosszú tömb legyen?

* 
```java
words[1] = new String[2];
words[2] = new String[5];
```
* [x]
```java
words[0] = new String[2];
words[1] = new String[5];
```
* 
```java
words[0][] = new String[2];
words[1][] = new String[5];
```
*
```java
words[][0] = new String[][2];
words[][1] = new String[][5];
```
