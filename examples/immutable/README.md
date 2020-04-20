# Immutable objektumok

Az immutable objektumok állandó állapotúak, azaz létrehozásuk után az állapotuk 
már nem módosítható. Az attribútumok csak a deklarációnál vagy konstruktorban 
kaphatnak értéket, később már nem. Ezt úgy biztosíthatjuk, hogy az attribútumokat 
a `final` kulcsszóval látjuk el, és nem írunk az osztályba setter metódusokat. 
Amennyiben az attribútum referenciát tartalmaz más objektumokra, akkor annak az 
objektumnak az állapota még módosítható marad a getter metóduson át is. Ezt úgy 
akadályozhatjuk meg, hogy vagy ez az objektum is immutable, vagy nem a tárolt 
referenciát, hanem egy másolatot adunk vissza a getterrel. 
(Jó gyakorlat, ha eleve egy másolatot tárolunk el a konstruktorban is.)

```java
import java.util.ArrayList;

public class Trainer {
    
    private final String name;
    private final List<String> courses;
    
    public Trainer(String name, List<String> courses) {
        this.name = name;
        this.courses = new ArrayList<>(courses);
    }
    
    public String getName() {
        return name;
    }
    
    public List<String> getCourses() {
        return List.copyOf(courses);
    }
}
```

Már találkoztál immutable objektummal, hiszen a `String` is ilyen. A `String` 
metódusai sosem módosítják a benne eltárolt szöveget, hanem mindig egy új példányt 
adnak vissza, amely a művelet eredményét tartalmazza.

## Ellenőrző kérdések

* Miért szerencsés az immutable objektumok használata?
* Mitől lesz egy osztály immutable?
* Milyen buktatók lehetnek immutable objektumok használatakor?

## Space agency

Valamikor a távoli jövőben...

A Naprendszert számos űreszköz járja, ezeket különböző szervezetek irányítják, megadják az aktuális céljukat.
Az esetleges zavaró hatások miatt a `SpaceAgency` nyilvántartja ezeket, regisztrációs számuk és a
kitűzött céljuk ismeretével. A célt mindig koordinátákkal adjuk meg, ez a Naphoz, mint origohoz rögzített, és egyes
kitüntetett csillagok irányában felvett x, y és z irányokban vannak meghatározva.
Az úticél módosítása is koordinátákban kerül megadásra, mindig a már megadott célponthoz képest a különbség kerül átadásra.
Az űreszköz `Satellite` navigációs rendszere ennek alapján automatikusan irányítja önmagát.

## Megvalósítás

`SpaceAgency` osztály és feladatai:
Regisztrálni lehet az útjukra indított eszközöket és azonosítójuk alapján ki is lehet keresni.

```java
public void registerSatellite(Satellite satellite)
public Satellite findSatelliteByRegisterIdent(String registerIdent)
```

`Satellite` osztály és feladatai:
A `CelestialCoordinates` immutable, azaz állapota nem módosítható.
Az aktuális úticél új különbözeti koordináták megadásával frissíthető, ekkor a `Satellite`
attribútuma új értéket vesz fel.

```java
public Satellite(CelestialCoordinates destinationCoordinates, String registerIdent)
public void modifyDestination(CelestialCoordinates diff)
public String toString()
```

`CelestialCoordinates` osztály attribútumként a koordinátákat tartalmazza, ezek mind `final` változók,
értéket a konstruktorban kapnak. Getter metódusok segítségével olvashatók.

```java
public String toString()
```

## Hibakezelés

Üres `String`, mint paraméter nem fogadható el, továbbá a szatellit regisztrációnál nem kaphat `null` paramétert.
Amennyiben a megadott azonosítóval nem található űreszköz, szintén kivételt várunk.

## Tippek

Az üres `String` paraméter vizsgálatára célszerű külön privát metódust írni.

```java
private boolean isEmpty(String str)
```

[rating feedback=java-immutable-spaceagency]
