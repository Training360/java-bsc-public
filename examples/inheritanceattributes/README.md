# Attribútumok öröklődése

Az Information hiding alapelv szerint egy osztály attribútumai mindig privátok, ahhoz csak a publikus metódusokon át lehet hozzáférni. Vajon mi történik, ha az osztályt kiterjesztjük? Azt láttuk, hogy az utód osztály nem fér közvetlenül hozzá ezekhez az attribútumokhoz, de tartalmazza ezeket is. Láthatósági módosítókkal természetesen szabályozhatjuk ezt, hiszen a `protected` és `public` kulcsszóval ellátott attribútumokat elérjük az utódból, azonban nem ez a követendő.

A Java nyelv megengedi, hogy a gyerek osztály ugyanolyan névvel deklaráljon egy attribútumot, amilyen a szülőben már volt. Ebben az esetben az attribútum elfedi a szülőben deklaráltat, de nem írja felül, vagyis az létezik, és elérhető a `super` minősítőn át. Ne tegyünk ilyet, mert a kód bonyolulttá, áttekinthetetlenné válik.

## Láthatósági módosítók

Attribútumokra a láthatósági módosítók ugyanazok, mint a metódusokra.

| módosító  | láthatóság |
| ---- | ---- |
| `private` | csak a saját osztályból elérhető (illetve ugyanolyan osztályú objektumból) |
| [default] (package private) | ugyanazon csomagban lévő osztályból érhető el                |
| `protected` | ugyanazon csomagban lévő és leszármazott osztályból érhető el |
| `public`  | minden osztály számára elérhető                              |

## Ellenőrző kérdések

* Öröklődnek-e az attribútumok?
* Minden örökölt attribútumot elér közvetlenül a leszármazott?
* Milyen láthatósági módosítók vannak? Ezek közül mely(ek) az ajánlottak?
* Hogyan érheti el a leszármazott osztály az ős osztály `private` attribútumát?

### Gyakorlat - `Book` és `ShippedBook` osztály

Készíts egy `Book` osztályt, **pontosan**  az alábbi előírások alapján!

Attribútumok:

* `private String title;`
* `protected int price;`

publikus metódusok:    
```java
 public Book(String title, int price)
 public String getTitle()
 public int purchase(int pieces)
```

Készíts egy `ShippedBook` osztályt a `Book` osztály leszármazottjaként,
egy `shippingCost` attribútummal.

publikus metódusok:    
```java
 public ShippedBook(String title, int price, int shippingCost)
 public int order(int pieces)
 public String toString()
```

[rating feedback=java-inheritanceattributes-bookshippedbook]

### **Tanulmányozandó**

Az öröklődés és a konstruktorok hívási lánca alapján értelmezzük,
hogy mi történik a gyerekosztály példányosítása során!
