# Tömb

Eddig olyan adattípusokkal ismerkedtünk meg, amelyek csak egy egyszerű értéket 
tárolhatnak. A **tömb** már sok ugyanolyan típusú elem tárolására képes, amelyeket a 
sorszámukkal (**index**) közvetlenül elérhetünk.

Deklarációkor meg kell adnunk, hogy milyen típusú elemeket szeretnénk tárolni benne. 
Létrehozni a `new` kulcsszóval lehet, és meg kell adnunk a tömb méretét is.

```java
int[] arrayOfNumbers = new int[10];
```

A tömb elemei mindig kapnak kezdőértéket: egész típusú elemek esetén ez `0`, 
lebegőpontos szám esetén `0.0`, logikai érték esetén `false`, osztály 
esetén `null` lesz.

Az elemek elérése szögletes zárójellel történik, amelybe az elem indexét kell 
írnunk. Az indexelés 0-tól kezdődik, és olyan indexre nem hivatkozhatunk, amely 
túlmutat bármelyik irányban az indexelés határain. Azaz egy 10 elemű tömb esetén 
az index csak 0 és 9 közötti értéket vehet fel. Például a fenti tömb 5. elemét 
az `arrayOfNumbers[4]` hivatkozással érhetjük el. Az `arrayOfNumbers[10]` 
esetén már `ArrayIndexOutOfBoundsException` kivételt kapunk.

A tömb hosszát a `length` tulajdonságán át kérdezhetjük le: `arrayOfNumbers.length`.

Létrehozhatunk tömb literált, amelyben a tömb elemeit tudjuk megadni kapcsos 
zárójelek között vesszővel elválasztva:

```java
String[] fruits = {"apple", "peach", "plum", "orange"};
```
Egy metódus paramétereként is használhatunk tömb literált a tömb létrehozására, 
de ebben az esetben eltérő a szintaktika:

```java
countArrayElements(new int[] {1, 2, 3, 4})
```

A tömbök elemeit bejárhatjuk a már megismert `for` ciklussal, de létezik egy 
hatékonyabb módja is annak, hogy minden egyes elemet elérjünk: a for-each ciklus. 
For-each ciklus használata esetén a tömb elemeit csak kiolvasni tudjuk, módosítani 
nem, illetve az elem sorszáma sem áll rendelkezésre. Amennyiben ezekre szükségünk van, 
használjuk a hagyományos `for` ciklust!

Tömbök között adatok átmásolásának azonban annál jobb módja is van, minthogy 
ciklussal bejárjuk, és egyenként átmásoljuk az elemeket: a `System.arraycopy()` metódus.

```java
for(int i = 0; i < fruits.length; i++){
	System.out.println(fruits[i]);
}

for(String fruit: fruits){
	System.out.println(fruit);
}

String[] favoriteFruits = new String[2];
System.arraycopy(fruits, 1, favoriteFruits, 0, 2); // favoriteFruits --> {"peach", "plum"}
```


## Ellenőrző kérdések

* Hogyan definiálunk Javában tömböt?
* Hogyan férünk hozzá egy tömb eleméhez?
* Hogyan kérjük le a tömb hosszát?
* Hogyan definiálunk tömb literált?
* Hogy lehet a tömb elemeit kiírni?
* Hogyan járhatjuk be egy tömb elemeit?

## Feladat

### Tömbök kezelése

Az `array.ArrayMain` osztály `main()` metódusába dolgozz!

Definiálj egy `String` tömböt a hét napjaival! Írd ki a második elemét (kedd)!
Írd ki a tömb hosszát is!

Definiálj egy öt elem hosszú `int` tömböt, és tárold le benne (ciklussal) a kettő
hatványait (1, 2, 4, 8 stb.)! Ciklusban írd ki az értékeit!

Definiálj egy hat elemű `boolean` tömböt, és felváltva írj bele `true` vagy
`false` értéket, 0. index esetén legyen `false`! Ciklusban írd ki az elemeit!

[rating feedback=java-array-arraymain]

### Keresés

Hozz létre egy `array.ArrayHandler` osztályt, és implementálj benne egy 
`boolean contains(int[] source, int itemToFind)` metódust, mely visszaadja, hogy 
a paraméterként megadott érték benne van-e a szintén paramérként átadott tömbben!

A fenti `array.ArrayHandler` osztályba implementálj egy újabb `int find(int[] source, int itemToFind)`
metódust, mely visszaadja a paraméterként megadott érték indexét, ha benne van a tömbben,
és -1-et, ha nincs benne!

[rating feedback=java-array-arrayhandler]

## Forrás

OCA - Chapter 3/Understanding Java Arrays

## Teszt

Melyik a helyes egész számokból álló tömb deklaráció és létrehozás?

* int[10] numbers = new int[];
* int[] numbers = new int[];
* [x] int[] numbers = new int[10];
* int numbers = new int[10];

Hogyan lehet megtudni a `numbers` tömb hosszát?

* [x] a `numbers.length` attribútummal
* a `numbers.length()` metódussal
* a `numbers.size()` metódussal
* a `numbers[]` kifejezéssel

Igaz-e az alábbi állítás?

A tömbök elemeinek mindig van alapértelmezett kezdőértéke.

* [x] igaz
* hamis
