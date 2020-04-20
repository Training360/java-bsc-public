# Konstruktorok

A konstruktorok felelősek az objektumok állapotának inicializálásáért. Amikor 
egy osztályt példányosítunk, akkor létrejönnek az attribútumai a memóriában. 
Ezek kezdőértéket kívülről konstruktoron át kapnak.

A konstruktor egy olyan speciális metódus, melynek nincs visszatérési értéke, 
a neve pedig megegyezik az osztály nevével.

```java
public class Trainer {
    
    private String name;
    
    private int yearOfBirth;
    
    public Trainer(String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }
    
    //getter és setter metódusok
}
```

Amikor a `new` operátorral szeretnénk egy `Trainer` objektumot létrehozni, akkor 
tulajdonképpen a `Trainer` osztály konstruktorát hívjuk meg. Ha ez paramétereket 
vár, akkor azokat is meg kell adnunk.

```java
public class TrainerMain {
    
    public static void main(String[] args) {
        Trainer trainer = new Trainer("John Doe", 1980); //konstruktor hívása
        
        System.out.println(trainer.getName()); //"John Doe"
        System.out.println(trainer.getYearOfBirth()); //1980
    }
}
```

Konstruktort a fejlesztőkörnyezet is tud generálni. Az IDEÁ-ban az `ALT + Insert`
billentyűkombináció lenyomása után a _Constructor_ menüpontot választva meg kell 
adnunk, hogy mely attribútumok kapjanak kezdőértéket, majd az IDE a konstruktor 
kódját automatikusan beszúrja.

## Ellenőrző kérdések

* Mi a konstruktor feladata?
* Milyen megkötések vannak, amikor konstruktort készítesz?
* Hogyan lehet az IDEA segítségével konstruktort létrehozni?

## Feladat

### Könyv osztály

Hozz létre egy `Book` osztályt, melynek három privát attribútuma van: 
szerző (`author`), cím (`title`) és regisztrációs szám (`regNumber`), 
mindhárom típusa `String`.

A `Book` példányosításakor csak a szerzőt és a címet kelljen megadni.

Legyen egy `public void register(String regNumber)` metódusa, mely a 
nyilvántartásba vételt implementálja, és ennek paraméterül kell megadni 
a regisztrációs számot.

Írj egy `main()` metódust a `BookMain` osztályba, amivel kipróbálod a működését!
Az attribútumok kiolvasásához használj gettereket!

### Raktár osztály

Készíts egy `Store` osztályt, mely egy raktárt modellez. A raktár jellemzője 
az, hogy miből (`product`) és aktuálisan mekkora mennyiséget (`stock`) tárol.
Az első attribútuma `String`, a második `int` típusú.

A `Store` példányosításakor elég megadni a tárolt terméket, a mennyiség mindig 0, 
ezért a konstruktor csak a terméket kapja meg kívülről.

Készíts hozzá két metódust, mely a tárolt mennyiséget változtatja: a `store()` metódusa
a paraméterként kapott mennyiséget eltárolja a raktárban növelve ezzel a készletet, 
míg a `dispatch()` metódusa az elszállítást modellezi, azaz a paraméterként kapott 
mennyiséggel csökkenti a készletet! (Most még nem kell ellenőrizned, hogy 
helyes mennyiségeket kapsz-e.)

A `StoreMain` osztály `main()` metódusában készíts két `Store` példányt, és 
teszteld, hogy mindkét raktár helyesen és függetlenül működik be- és kiszállítás 
esetén is!

## Teszt

Melyik állítás IGAZ?

* [x] A konstruktor az osztály példányosításakor fut le.
* A konstruktor visszatérési típusa mindig ugyanaz, mint az osztály neve.
* A konstruktor feladata az objektum állapotának módosítása.
* A konstruktor az osztály metódusait inicializálja.
