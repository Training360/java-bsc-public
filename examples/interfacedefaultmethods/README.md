# Default interfész metódusok

Az interfész utólagos módosításának az a veszélye, hogy az összes őt implementáló osztályt is módosítani kell. A Java 8 előtt ezt úgy lehetett megoldani, hogy új interfészt származtattunk a régiből, amely tartalmazta  az új metódusfejet, és ettől kezdve eldönthettük, hogy ezt vagy a régit implementáljuk egy osztály által. A Java 8 bevezette a `default` metódust, amely nem csak a metódus fejét, de az alapértelmezett működését is tartalmazza. Ezeket a metódusokat el kell látnunk a `default` módosítószóval, és nem tehetjük mellé a `static`, a `final` és az `abstract` módosítók egyikét sem. Természetesen az implementáló osztály dönthet úgy, hogy felülírja ezt a működést, de ha nem teszi, akkor sincs probléma. Ez által a régebben írt osztályok is működőképesek maradnak. Amennyiben az interfészből újabb interfészt származtatunk, akkor az dönthet úgy, hogy

- az eredeti default metódust meghagyja,
- absztrakttá teszi,
- illetve felül is írhatja másik default implementációval.

```java
public interface HasName {

    default String getName() {
        return "Anonymous";
    }
}

public interface HasUniqueName extends HasName { // absztrakttá teszi a getName metódust

    String getName();
}

public interface CanGetNewName extends HasName { // meghagyja az eredeti getName metódust

    void setName(string newName);
}

public interface HasTwoNames extends HasName { // új implementációval látja el a getName metódust

    default String getName() {
        return "John Doe";
    }
}
```

[important]
A Java 9 verzió bevezette a privát metódusokat is az interfészekben. Mivel ezek nem írhatóak felül az implementáló osztály által, ezért ezeket mindig implementálnia kell, és a `default` módosítót sem használjuk vele.
[/important]

## Ellenőrző kérdések

* Miért vezették be a default interfész metódusokat?
* Milyen szabályok vonatkoznak a default interfész metódusokra?
* Leszármazott interfésznek milyen lehetőségei vannak a default interfész metódussal kapcsolatban?
* Mi problémába futhatunk többszörös öröklődésnél, és hogyan lehet feloldani?

## Gyakorlat - Nyomtatható kiadványok

A feladat során egy nyomtatót és különböző nyomtatható anyagokat (újság, mesekönyv) kell implementálni.
A nyomtató képes színesben nyomtatni. Az újság csak fekete-fehér lehet, míg a mesekönyv színes (különböző oldalak
lehetnek különböző színűek).
A nyomtató nyomtatáskor a színeket vezérlőkarakterekkel jelzi.

Írj egy `Printable` interfészt a `getLength()`, `getPage()`, és `getColor()` metódusokkal.
A `getColor()` metódus default implementációja, hogy mindig feketét ad vissza, ami az interfészben
egy konstans `#000000` érték.

A `Printable` interfészt implementálja a `NewsPaper` és `StoryBook` osztály is. A `NewsPaper` osztály az
oldalak tartalmát egy `List<String>` attribútumban tartsa nyilván. A `StoryBook` használjon egy `ColoredPage`
immutable osztályt, mely az oldal tartalmát (`String`) és az oldal színét (`String`) tartalmazza. A `StoryBook`
egy ilyen listát tartalmazzon, így minden oldalra megmondható, hogy milyen színű.

A `Printer` osztály `print()` metódusa menjen végig a nyomtatható anyag oldalain, és fűzze össze egy `String`-be,
sortörésekkel elválasztva (használj `StringBuilder`-t). Amennyiben az oldal színes (azaz nem fekete-fehér),
az oldal tartalma elé írja ki vezérlőkarakterekként az oldal színét. Azaz ha az oldal piros (`#FF0000`),
és az oldal tartalma `Content`, akkor úgy fűzze hozzá a `String`-hez, hogy `[#FF0000]Content`.

[rating feedback=java-interfacemethods-nyomtathato]
