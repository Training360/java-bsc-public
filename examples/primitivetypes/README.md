# Egyszerű típusok

Nézzük meg részletesen a primitív típusokat, először azonban értelmezzük a csomagolóosztály fogalmát.

Míg a primitív típusok egyszerű adatokat tartalmaznak, addig a csomagoló osztályok ezen kívül az 
adaton dolgozó metódusokat is. Tulajdonképpen a primitív típusú adatot burkolják be, és ruházzák fel 
egyszerű műveletekkel.

A primitív típusok és a nekik megfelelő csomagoló osztályok sorra a következők:

|Primitív típus      | Csomagoló osztály           | Mit ábrázol?                          |
| ------------------ | --------------------------- | ------------------------------------- |
| `boolean`          | `Boolean`                   | logikai (8 bit)                       |
| `char`             | `Character`                 | 16 bites Unicode karakter _(UTF-16)_  |
| `byte`             | `Byte`                      | 8 bites előjeles egész szám           |
| `short`            | `Short`                     | 16 bites előjeles egész szám          |
| `int`              | `Integer`                   | 32 bites előjeles egész szám          |
| `long`             | `Long`                      | 64 bites előjeles egész szám          |
| `float`            | `Float`                     | 32 bites lebegőpontos racionális szám |
| `double`           | `Double`                    | 64 bites lebegőpontos racionális szám |

## Autoboxing

A primitív típus és a csomagoló osztálya között a fordító automatikusan tud be- és kicsomagolni. 
Ezt nevezzük **autoboxingnak**, illetve **unboxingnak**.

```java
int number = 5;
Integer numberObj = number; //Autoboxing
int number2 = numberObj; //Autounboxing
```

## Számrendszerek

Különböző értékek, különböző számrendszerekben való kiíratása. Az adott burkolóosztálynak 
van erre megfelelő `toString()`  metódusa.

*	`Integer.toString(100, 8)` oktális számrendszerben
*	`Integer.toString(100, 2)` bináris számrendszerben
*	`Integer.toString(100, 16)` hexadecimális számrendszerben

Ez a metódus a negatív számokat ugyanúgy jeleníti meg, mint a pozitívakat, csak elé teszi az előjelet.  
`Integer.toString(5, 2)` --> 101  
`Integer.toString(-5, 2)` --> -101

Fontos megjegyezni, hogy a negatív számokat a Java virtuális gép úgynevezett kettes 
komplementer kódban tárolja. Ez azt jelenti, hogy nem előjel bitet alkalmaz a negatív 
számok esetén, hanem a kivonást vezeti vissza összeadás műveletre. Ez alapján a -5 
az a szám, amihez 5-öt adva 0-t kapunk.

```text
    5: 00000000000000000000000000000101
   -5: 11111111111111111111111111111011  //A -5 kettes komplementer ábrázolása
    0: 00000000000000000000000000000000
```

A kettes komplementer szerinti karaktersorozatot az `Integer.toBinaryString()` metódussal kapjuk meg.  
`Integer.toBinaryString(-5)` --> 11111111111111111111111111111011

## Szövegből átalakítás

Lehetőségünk van szöveget számmá alakítani, illetve fordítva. Ha szövegből a burkoló 
osztály egy példányát szeretnénk létrehozni, akkor a szöveget a konstruktorban kell átadni. 
Ha primitív típust szeretnénk visszakapni, akkor használjuk a csomagolóosztály `parse` prefixű metódusát.

*	`Integer i = new Integer("123")`
*	`int i = Integer.parseInt("123")`

Szövegből logikai értéket a `Boolean.parseBoolean(String str)` metódussal tudunk készíteni. 
Amennyiben a paraméterként átadott szöveg a `"true"` szöveget tartalmazza bármilyen 
kis-nagybetű kombinációban, a konvertált érték `true` lesz, bármilyen más esetben `false`.

```java
boolean first = Boolean.parseBoolean("TruE");   // true
boolean second = Boolean.parseBoolean("yes"); 	//false
```

## "Szélsőséges" eredmények

A csomagoló osztályok konstansokat tartalmaznak a „szélsőséges” eredményekre. 
Például tárolják az értelmezési tartomány két végpontját, pl. `Integer.MIN_VALUE` , `Integer.MAX_VALUE`.

A különböző matematikai műveletek eredményét az _IEEE_ szabvány definiálja. Példák:

*	`1.0 / 0` eredménye `Double.POSITIVE_INFINITY`
*	`-1.0 / 0` eredménye `Double.NEGATIVE_INFINITY`
*	`Double.POSITIVE_INFINITY / Double.NEGATIVE_INFINITY` eredménye `Double.NaN` _(Not a Number)_


## Ellenőrző kérdések

* Milyen primitív típusokat ismersz?
* Hány biten vannak ábrázolva?
* Mit jelent a csomagoló típus?
* Mi az a bináris számrendszer?
* Mit jelent a kettes komplemens számábrázolás?

## Feladat

### Átváltás kettes számrendszerbe

A `primitivetypes.PrimitiveTypes` osztályba írj egy `String toBinaryString(int n)` metódust,
mely az adott pozitív egész számot kettes számrendszerbe váltja át!

Ellenőrizd a `PrimitiveTypesMain` `main()` metódusban, hogy értéke megegyezik-e a `Integer.toBinaryString()`
metódus által visszaadott értékkel!

A mi metódusunk annyiban legyen más, hogy a szám mindig 32 bites legyen, azaz 32 karakter hosszú
szöveget adjunk vissza, és az elején legyen kiegészítve nullákkal!

A 32 legyen külön változóba kiemelve!

Az algoritmus a következő: amíg a szám nagyobb, mint nulla, 
a számot osztani kell kettővel, és a maradékát is képezni kell. A maradék lesz 
a bináris számjegy. Fontos, hogy hátulról előre kell a számjegyeket leírni. 
A maradékos osztás Javaban a `%` operátorral történik.

[rating feedback=java-primitivetypes-kettesszamrendszer]

### Bónusz feladat

Van operator overloading Javában, azaz egyszerű operátorokkal, mint a
`+` operátor, lehet két `Integer` objektumot összadni?

Mit ír ki a `new Integer(1) + new Integer(2)` kifejezés? Miért?

## Teszt

Melyik szövegből vagy szöveggé alakító utasítás nem jó?

* `String s = Integer.toString(23);`
* [x] `long n = String.toLong("1_000_004");`
* `int a = Integer.parseInt("23");`
* `boolean b = Boolean.parseBoolean("ajaj");`
