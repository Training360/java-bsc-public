# Lista

A lista annyiban hasonlít a már megismert tömb típusra, hogy ez is azonos típusú 
elemek tárolására van, amelyek az indexükkel elérhetőek, de mérete nem fix, 
hanem dinamikusan változik a tartalommal. Lista típusú változót mindig a `List` 
interfésszel deklarálunk, így bármilyen listát megvalósító osztályt bele tudunk 
tenni. Ezekről később részletesebben is lesz szó, de most nézzük a leggyakoribbat, 
az `ArrayList` osztályt.

Megszoktuk már a tömböknél, hogy meg kell adnunk az elemek típusát. Lista esetén 
is így van, de itt `<>`-k között kell ezt megtennünk (generikus). Listában nem 
tárolhatunk primitív típusú elemeket, de szerencsére minden primitív típusnak 
van megfelelő, ún. **burkoló osztálya**. Ha a listába primitív értéket teszük, az 
automatikusan becsomagolódik a burkoló osztályába, a kivett elemet pedig kezelhetjük 
primitívként, mert az automatikusan kicsomagolódik.

```java
List<String> fruits = new ArrayList<>();
```

Az `ArrayList` példányosításakor már nem kell megismételnünk az elemek típusát, 
elég üres `<>`-t írni. Ezt hívjuk **diamond operátornak**.

A lista szöveges reprezentációjának előállítására itt is a `toString()` metódust 
használjuk, de itt a példányváltozón kell meghívni.

```java
System.out.println(fruits.toString());
```

Tömbökből is készíthetünk listát az `Arrays.asList()` metódussal azzal a 
megkötéssel, hogy elemeket utólagosan sem hozzáadni, sem törölni nem tudunk.

```java
String[] names = {"Adam", "Eve", "Jonathan"};
List<String> nameList = Arrays.asList(names);
```

## Metódusok

`boolean add()`: új elem hozzáadása a listához. Paraméterként a beszúrandó elemet 
kell megadni, illetve ha nem a végére akarjuk tenni, akkor az indexet is meg 
kell adnunk. Ebben az esetben az utána következő elemek eggyel hátrébb kerülnek.

`E get(int index)`: a megadott indexen lévő elemet adja vissza.

`void clear()`: törli a lista összes elemét

`boolean contains(Object o)`: igazzal tér vissza, ha a megadott elem benne van a 
listában. Ennek eldöntésére az elem `equals()` metódusát használja.

`int indexOf(Object o)`:  megadja, hogy a paraméterként átadott elem milyen 
indexen szerepel először a listában. Ha nincs a listában, -1-et ad vissza.

`boolean remove(Object o)`: törli a paraméterként átadott elem első előfordulását. Ha az elem nem szerepelt a listában, hamissal tér vissza.

`int size()`: a lista elemeinek száma

## Bejárás

A lista bejárható a hagyományos `for` ciklussal

```java
List<Integer> numbers= Arrays.asList(23, 41, 2, 7);
for(int i = 0; i < numbers.size(); i++){
	System.out.println(numbers.get(i));
}
```

vagy foreach ciklussal

```java
for(int item: numbers){
	System.out.println(item);
}
```

## Ellenőrző kérdések

* Mire való az `ArrayList`?
* Hogyan kell definiálni?
* Mire használjuk a generikust?
* Mi történik akkor, ha nem használunk generikust?
* Milyen metódusait ismered?
* Hogyan tudod bejárni az elemeit?

## Feladat

### `Capsules` osztály

Készíts egy `Capsules` osztályt, mely segít olyan műalkotás megtervezésében, 
amely újrahasznosított kávékapszulákból áll.
Egy hajlítható műanyag csőbe tudjuk helyezni a különböző színű kapszulákat egymás mellé. 
Így alakul ki az alkotás, amit aztán különböző formára hajlíthatunk.

A `Capsules` osztály egy `ArrayList` attribútumban tárolja a betett kapszulákat, 
méghozzá a színüket `String`-ként.

A `Capsules` osztálynak legyen egy `addLast(String)`, `addFirst(String)`, `removeFirst()`, `removeLast()` metódusa,
mely betesz, illetve kivesz kapszulákat a csőből. Legyen egy `List<String> getColors()` metódusa, mely visszaadja
a kapszulákat tartalmazó listát, hogy ki lehessen írni.

Írj egy `main()` metódust, mely teszteli a metódusok működését.

[rating feedback=java-arraylist-capsules]

### `Books` osztály

Készíts egy `Books` osztályt, melyben egy `ArrayList<String>` tárolja a könyvek címeit.
Írj egy `add(String)` metódust, mely felveszi a könyvet.
Legyen egy `List<String> findAllByPrefix(String prefix)` metódusa, mely az összes olyan könyvet visszaadja,
mely címének eleje megegyezik a paraméterként átadott szöveggel. Legyen egy `List<String> getTitles()`
metódus, mely visszaadja a könyvek címeit.

Írj egy `main()` metódust, mely teszteli a metódusok működését.

[rating feedback=java-arraylist-books]

### Bónusz feladat 1.

A `Capsules` osztály `getColors()` metódusával kérjük le a kapszulák színeit, majd az eredményt tároljuk le
egy változóba. A letárolt változón hívjuk meg a `clear()` metódust. Majd ismét kérjük le a kapszulák színeit a
`getColors()` metódussal , és nézzük meg, hogy az előző `clear()` hívásnak volt-e hatása erre?

### Bónusz feladat 2.

A `Books` osztálynak legyen egy `removeByPrefix(String prefix)` metódusa
mely kiveszi a könyvet a címének első pár karaktere alapján (az összes előfordulást).

Mi van akkor, ha egy ciklusban mész végig az elemeken, és ha a feltételnek megfelel az elem 
azonnal törölni próbálod? Hogyan lehet ezt kikerülni? Használd a `removeAll()` metódust!

## Forrás

OCA - Chapter 3/Understanding an ArrayList

## Teszt

Hogyan lehet egész számokból álló listát létrehozni?

* `List<int> heights = new ArrayList<>();`
* [x] `List<Integer> heights = new ArrayList<>();`
* `List<Integer> heights = new ArrayList<>;`
* `List<int> heights = Arrays.asList(1, 5, 7);`
