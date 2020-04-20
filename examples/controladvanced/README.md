# Haladó vezérlési szerkezetek

## Címkék alkalmazásai

A feltételes és ciklusképző utasításokat meg lehet címkézni. Ez különösen hasznos, 
ha egymásba ágyazott utasításokat használunk, és a `break` és a `continue` utasításokkal 
szeretnénk vezérelni ezeket.

```java
OUTER: for (int i = 0; i < table.length; i++) {
    INNER: for(int j = 0; j < table[i].length; j++) {
        table[i][j] = i + j;
    }
}
```

## `break` utasítás

Ciklusokban használható. Ha címke nélkül használjuk, akkor kilép a legbelső éppen 
végrehajtott ciklusból. Ha címkével használjuk, akkor a címkézett utasításból lép ki.

A példában egy `String` tömbről szeretnénk eldönteni, hogy tartalmazza-e a `searchFor` szót.
```java
boolean foundIt;
for (int i=0; i<words.length; i++){
    if (words[i].equals(searchFor)) {
        foundIt = true;
        break;
    }
}
```

Jól látható, hogy ha a ciklusban beléptünk az `if` törzsébe, akkor a `foundIt` 
változót `true`-ra állítjuk, és kiugrunk a ciklusból a `break` utasítás segítségével.

## `continue` utasítás

Szintén ciklusban használható. Ha nem használunk címkét, akkor az éppen zajló 
legbelső ciklus törzsének többi részét kihagyja, és újra a feltétel kerül kiértékelésre. 
Amennyiben címkét használunk, akkor az adott címkéjű ciklus feltétel kiértékelésével 
folytatódik a végrehajtás.

```java
String words = "peter piper picked a ...";
int numPs = 0;

for (int i = 0; i < words.length(); i++) {
    if (words.charAt(i) != 'p') {
        continue;
    }

    numPs++;
}
```

A `break` és `contiune` utasításokat lehetőleg kerüljük, csak akkor használjuk, 
ha jobban átlátható, olvashatóbb kódot tudunk írni.


## Ellenőrző kérdések

* Mire való a `continue` utasítás?
* Mire való a `break` utasítás?

## Feladat
 
### `findDuplicates()` metódus

Szűrd ki egy `List<Integer>` listában a többször szereplő elemeket, és add vissza.

Több megoldás elképzelhető, egyik (nem hatékony) megoldás, hogy egy ciklusban
végigmész az elemeken, majd egy másik ciklusban pedig végigmész az összes
elem előtt lévő elemen. Ha egyezőséget találsz, átteszed az elemet egy másik
listába, és szakítsd meg a belső ciklust, különben ha egy elem háromszor
ismétlődik, rosszul fog működni.

[rating feedback=java-controladvanced-findduplicates]

### CSV validálás

Egy használt autó kereskedés az autók adatait CSV fájlban tárolja. Minden sor az alábbi 
szerkezetű kell legyen: rendszám;gyártási év;márka;szín.  
Például:  
`"ABC-123;2007;Volvo;red"`  
További szabályok:

* A rendszám mindig 7 karakterből áll és van benne `-` karakter.
* A gyártási év korábbi, mint 2019, de későbbi, mint 1970.

A feladat egy olyan metódus írása, mely a valid sorokat kigyűjti. A feladatot már 
megoldották, de sajnos a kód egyes sorai megsérültek. Ennyit sikerült megmenteni belőle:

```java
public List<String> filterLines(List<String> lines) {
    List<String> validLines = new ArrayList<>();
    for (String line: lines) {
        String[] parts = line.split(";");
        if(parts.length != 4) {
//Innen kezdve hiányzik jópár sor         
            
        }
        validLines.add(line);
    }
    return validLines;
}
```

## Forrás

OCA - Chapter 2/Understanding Advanced Flow Control

## Teszt

Az alábbi metódust 5 paraméterrel hívva mit ad vissza?

```java
public String findPerfectMatch(int number) {
    List<String> words = List.of("ninetyeight", "five", "eight", "ten", "thirteen");
    String perfect = null;
    
    for(String word: words) {
        if(Math.abs(word.length() - number) > number) {
            continue;
        }
        if(word.length() == number) {
            perfect = word;
            break;
        }
        int newLength = word.length() > number ? number : word.length();
        perfect = word.substring(0, newLength);
    }
    
    return perfect;
}
```

* ninet
* five
* [x] eight
* ten
* thirt
