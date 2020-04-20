# Tömbök kezelése

A tömbök kezelése nem is olyan egyszerű, sok művelethez van szükség ciklusra. 
A Java `Arrays` osztálya ebben könnyíti meg a dolgunk. Statikus metódusai 
egyszerűvé teszik a tömb kiírását, másolását, rendezését, tömbök összehasonlítását.

## Metódusok:

`String toString()`: A tömb elemeit adja vissza szöveges formában, paraméterként 
a tömböt kell átadni.

`String deepToString()`: Tömbök tömbjét adja vissza szöveges formában teljes 
mélységben olvashatóan, paraméterként a tömböt kell átadni.

`boolean equals()`:  Két azonos típusú elemekből álló tömböt hasonlít össze, 
és igazzal tér vissza, ha az elemek páronként egyenlőek.

`boolean deepEquals()`: Két tömbök tömbjét hasonlítja össze, és igazzal tér vissza, 
ha az elemek minden szinten páronként megegyeznek.

`void sort()`:  Berendezi egy tömb elemeit növekvő sorrendbe, amennyiben az elemek 
típusának van természetes rendezettsége. Paraméterként a rendezendő tömböt kell megadni.

`T[] copyOf()`: A paraméterként átadott tömb megadott hosszúságú másolatát adja 
vissza. Ha az eredeti tömb rövidebb, akkor a maradék helyeket alapértelmezett 
értékekkel tölti fel (lást a tömb adattípusnál), ha hosszabb, akkor levágja a végét.

`T[] copyOfRange()`: A paraméterként átadott tömb megadott indexek közötti szakaszát 
adja vissza. Az esetleges üres helyeket az alapértelmezett értékkel tölti fel.

## Ellenőrző kérdések

* Mire való az `Arrays` osztály?
* Milyen metódusai vannak?
* Hogyan kell meghívni ezeket?

## Feladat

Dolgozz az `arrays.ArraysMain` osztályban!

### `numberOfDaysAsString` metódus

A `String numberOfDaysAsString()` metódusban definiálj egy `numberOfDays` nevű változót, mely a 
hónapok napjainak számát tartalmazza, és add vissza `String`-ként egy utasítással az értékeit.

[rating feedback=java-arrays-numberOfDaysAsString]

### `daysOfWeek` metódus

A `List<String> daysOfWeek()` metódus adja vissza a napok neveit!

[rating feedback=java-arrays-daysOfWeek]

### `multiplicationTableAsString` metódus

A `multiplicationTableAsString(int size)` metódus definiáljon egy `size` méretű szorzótáblát,
és adja vissza az értékeket `String`-ként egy sorban.

[rating feedback=java-arrays-multiplicationTableAsString]

### `sameTempValues` metódus

A `sameTempValues(double[] day, double[] anotherDay)` hőmérsékleti értékeket vár,
órai mérésekkel, két napra. Vizsgáld meg, hogy a paraméterként megadott két nap
azonos méréseket tartalmazott-e!

[rating feedback=java-arrays-sameTempValues]

### `wonLottery` metódus

Döntsd el a `boolean wonLottery(int[], int[])` metódusban, hogy a megtett számok, és a
kihúzott számok megegyeznek-e! Nem biztos, hogy növekvő sorrendben vannak a számok.
Azaz ellenőrizd, hogy ugyanazokat az
értékeket tartalmazza-e a két paraméter, sorrendtől függetlenül!

Válaszd azt a megoldást, hogy mindkét tömböt rendezed, és úgy hasonlítod őket össze!

Miután a `main()` metódusban meghívtad a `wonLottery()` metódust, vizsgáld meg, 
hogy a
paraméterként átadott tömb rendezett lett-e, azaz a rendezésnek lett-e visszahatása
a paraméterként átadott tömbre! (Ehhez az kell, hogy a paraméterek változók legyenek,
melyek értékét a hívás után vizsgálni lehet.)

Ha igen, próbáld meg valahogy kikerülni a problémát, azaz a metódusnak ne legyen
mellékhatása.

[rating feedback=java-arrays-wonLottery]

### Bónusz feladat 1

A `sameTempValuesDaylight(double[] day, double[] anotherDay)` metódus
ugyanúgy hasonlítsa össze az értékeket, de vegye figyelembe a 23 és 25 órás
napokat is. Összehasonlítás során mindig a kisebb óraszámot vegye figyelembe alapként,
és úgy hasonlítson össze (mindkettőn hívd meg a `copyOfRange()` metódust)!

Implementálhatsz egy `min(int, int)` segédmetódust, mely a két óraszám közül
a kisebbet adja vissza.

## Teszt

Melyik paranccsal írnád ki a `String[][] words` változóban tárolt szavakat?

* `System.out.print(words.toString());`
* `System.out.print(words.deepToString());`
* `System.out.print(Arrays.toString(words))`;
* [x] `System.out.print(Arrays.deepToString(words));`

Adott az `int[] numbers = {2, 6, 3, 9, 10, 4}` egész számokból álló tömb. Hogyan 
másolnád át a második 3 elemét a `int[] secondPart` tömbbe a lehető legegyszerűbben?

* `Arrays.copyOf(numbers, 3, secondpart, 0, 3);`
* [x] `secondpart = Arrays.copyOfRange(numbers, 3, 6);`
* `secondpart = Arrays.copyOfRange(numbers, 3, 3);`
* `secondpart = numbers.copyOfRange(3, 6);`
