# Vezérlési szerkezetek és az elágazás

Minden algoritmus felépíthető három vezérlési szerkezet használatával:

* szekvencia
* szelekció
* iteráció

A szekvencia jelenti az utasítások egymásutániságát, a szelekció az elágazást, 
az iteráció pedig a ciklus használatát. Ez a tétel egyben azt is jelenti, hogy 
nincs szükség ugró utasításra, a fenti három szerkezettel minden algoritmus 
felépíthető.

## Feltételes elágazás

A feltételes elágazáshoz az `if` kulcsszót kell használni, és két részből áll: 
fejből és törzsből. A fejben egy logikai kifejezés szerepel, ami ha igaz, akkor 
hajtódik végre a törzsben szereplő utasítássorozat. A kifejezéshez `else` ág is 
fűzhető. Ha a fejben szereplő logikai kifejezés hamis, akkor ide ugrik a vezérlés. 
Az `else` ághoz további `if`-eket fűzhetünk (`else if`).

```java
if ((x % 2) == 0) {
    System.out.println("Even");
} else {
    System.out.println("Odd");
}

```

A fenti példában, a fejben szereplő feltétel megvizsgálja, hogy `x` páros vagy páratlan 
szám-e, majd kiírja az eredményt.

## A `switch` utasítás

Ez is több részből áll. Szükség van egy kifejezésre, ami a `switch` fejében található. 
Ez lehet:

* bármi, ami `int` típussá automatikusan konvertálható
* felsorolásos típus
* `String`

Az úgynevezett `case` ágakban, fordítási időben ismert konstansok szerepelhetnek. 
Amikor a JVM a `switch` utasításhoz ér, kiértékeli a kifejezést, majd egyszerre 
a case ágakat. Amennyiben egyezést talál, elkezdi a végrehajtást, ami a 
következő `break` utasításig vagy a `switch` végéig tart. Ha nem talál egyezést, akkor 
a `default` ágra ugrik. Mivel a `default` ág megadása nem kötelező, elképzelhető, hogy 
egyetlen ág sem hajtódik végre.

```java
public String getTypeOfDayWithSwitchStatement(String dayOfWeekArg){
    String typeOfDay;
    switch(dayOfWeekArg){
        case "Monday":
            typeOfDay="Start of the work week";
            break;
        case "Tuesday":
        case "Wednesday":
        case "Thursday":
            typeOfDay="Midweek";
            break;
        case "Friday":
            typeOfDay="End of work week"
            break;
        case "Saturday":
        case "Sunday":
            typeOfDay="Weekend";
            break;
        default:
            throw new IllegalArgumentException("Unknown day");
    }

    return typeOfDay;

    }

}
```

A példában jól látható, hogy ha például kedd, szerda vagy csütörtök a beérkező paraméter, 
akkor a nap típusa mindegyiknél `Midweek` lesz, és csak az utána lévő `break` utasításra 
ugrunk ki a `switch`-ből. Ha olyan napot kapunk, amit nem ismerünk, akkor a `default` ágban kivételt dobunk.

## Ellenőrző kérdések

* Milyen vezérlési szerkezeteket ismersz elágazásra?
* Hogyan lehet az else ágakat összefűzni?
* Mikor kell használni a `break` utasítást?

## Feladatok

### Napszaktól függő köszönés

Írj egy metódust, mely paraméterként megkapja az órát és a percet, és amennyiben
 5:00 után van, köszönjön jó reggelttel, 9:00 és 18:30 között jó napottal, 20:00-ig jó estéttel,
 majd jó éjttel.

A `controlselection.greetings.Greetings` osztályba dolgozz!

[rating feedback=java-controlselection-koszones]

### Hónap napjainak visszaadása

Írj egy olyan metódust, mely az év és a hónap magyar neve alapján visszaadja, hogy
az hány napos! Használj `switch` szerkezetet! Figyelj arra, hogy ne számítson a kis- és
nagybetű különbség!

A `controlselection.month.DayInMonth` osztályba dolgozz!

Ha nem ismert a hónap, dobj kivételt a következő módon:

```java
throw new IllegalArgumentException("Invalid month: " + month);
```

Figyelj a szökőévre (év osztható néggyel, de nem osztható százzal, kivéve, ha
osztható 400-zal)!

[rating feedback=java-controlselection-honapnapjai]

### Hét napjai

Írj egy metódust, mely várja a hét neveit, és hétfő esetén azt adja vissza,
hogy "hét eleje" van, kedd, szerda és csütörtök esetén, hogy "hét közepe" van,
pénteken "majdnem hétvége", és szombat és vasárnap esetén "hét vége"!

Figyelj arra, hogy ne számítson a kis- és nagybetű különbség!

Ha nem ismert a nap, dobj kivételt a következő módon:

```java
throw new IllegalArgumentException("Invalid day: " + day);
```

A `controlselection.week.DayOfWeeks` osztályba dolgozz!

[rating feedback=java-controlselection-hetnapjai]

### Magánhangzó

Írj egy metódust, mely kap egy karakter paramétert! Amennyiben magánhangzót
kap, a következő mássalhangzót adja vissza! Ha mássalhangzót kap, akkor
a mássalhangzót adja vissza! Elég, ha az angol ábécé karaktereivel
működik.

A `controlselection.consonant.ToConsonant` osztályba dolgozz!

[rating feedback=java-controlselection-maganhangzo]

### Ékezetek

Írj egy metódust, mely magyar ékezetes karakter esetén annak ékezet nélküli párját
 adja vissza! Ha a karakter nem ékezetes, akkor magát a karaktert adja vissza!

A `controlselection.accents.WithoutAccents` osztályba dolgozz!

[rating feedback=java-controlselection-ekezetek]

## Teszt

Mi lesz a `spouse` változó értéke?

```java
String name = "Joe";
String spouse = "Jean";
switch(name) {
    case "John":
        spouse = "Eve";
    case "Joe":
        spouse = "Sarah";
    case "Jake":
        spouse = "Mary";
}
```

* Jean
* Eve
* Sarah
* [x] Mary

Mennyi lesz a `power` változó értéke?

```java
int stamina = 30;
int power;

if(stamina <= 10) {
    power = 1;
} else if(stamina <= 30) {
    power = 2;
} else if(stamina <= 80) {
    power = 3;
} else {
    power = 4;
}
```

* 1
* [x] 2
* 3
* 4
