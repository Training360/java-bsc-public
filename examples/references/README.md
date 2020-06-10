# Referenciák

A JVM a memóriát két fő területre bontja: **stack** és **heap**. A stackben minden 
metódus külön területet kap, amelyben a paramétereit és a lokális változóit tárolja. 
Ez olyan, mintha egy saját fiókos szekrénye lenne címkézhető fiókokkal. Amikor 
deklarálunk egy változót, akkor a változó neve egy ilyen "fiók" címkéje lesz, a 
változó értéke pedig bekerül a fiókba. Innen később ki tudjuk olvasni, illetve 
le is tudjuk cserélni. Primitív típusú változó esetén a valódi értéke kerül ide, 
osztály típusú esetén pedig egy referencia a létrejött objektumra vagy `null`. 
Egy referencia típusú változóban tehát ténylegesen nem maga az objektum, hanem csak egy 
rá mutató referencia van.
Az objektumot szintén egy kis fiókos szekrényként képzelhetjük el egy hatalmas raktárban 
a heapen. Az objektum attribútumai ezért már a heapre kerülnek. Ha ezek primitív 
típusúak, akkor közvetlen az objektum területére, ha referencia típusúak, akkor 
megint csak referenciát tartalmaznak a heapen egy másik objektumra. Ez egy hatalmas 
irányított gráfként képzelhető el, ahol a nyilak kiindulásánál egy referencia változó, 
a végpontjában egy objektum áll.

Lássunk egy példát!

```java
public class Trainer {
    private String name;
    private int yearOfBirth;
    
    public Person(String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }
    
    //Getter, setter metódusok
}

public class Main {
    public static void main(String[] args) {
        int yearOfBirth = 1980;
        
        String employeeName = "John Doe";
        
        Employee jack = new Employee("Jack Doe", 1970);  
    }
}
```

Ekkor a `yearOfBirth` változó és annak értéke, az `1980` a stacken helyezkedik el.
A `John Doe` szöveg, mivel az egy `String` objektum, a heapen kerül eltárolásra,
de a rá mutató `employeeName` változó értéke, azaz a referencia a stacken kerül eltárolásra.

Az `Employee` objektum a heapen kerül letárolásra, míg a rá mutató `jack` változó,
azaz a referencia a stacken.

Ami még érdekes, hogy az `Employee` egyik attribútuma, a `name` maga is 
referencia típusú, azaz egy másik, `String` objektumra mutat.

Amikor két változót a `==` operátorral hasonlítunk össze, akkor azok értékértékeit hasonlítjuk össze. 
Ez primitív típusoknál maga az érték, míg referencia típus esetén maga a referencia az érték.
Ezért referencia típusok összehasonlítása azt vizsgálja, hogy a két referencia ugynarra az
objektumra mutat-e, és nem azt, hogy a kettő állapota megegyezik-e.

Egy osztály metódusán belül a példányra a `this` kulcsszóval lehet hivatkozni.
Ezt főleg akkor használjuk, ha a példány egy attribútumát elfedi egy lokális
változó, pl. paraméter.

## Ellenőrző kérdések

* Egy objektum példányosításkor annak állapota hol kerül tárolásra?
* Mit tartalmaz egy változó primitív típus és osztály típus esetén?
* Hol kerülnek letárolásra a lokális változók?

## Feladat

### Referenciák

Készíts egy `Person` osztályt a `references.parameters` csomagba, melyben eltárolod a nevét (`name`) és az életkorát (`age`)!
A konstruktor mindkét attribútumot megkapja, és mindenhez generálj gettert és settert!

Deklarálj a `ReferencesMain` osztály `main()` metódusában két `Person` típusú változót!
Példányosíts egy új `Person` objektumot, és add értékül az első változónak! A második változónak add értékül az elsőt!
Módosítsd a második változón át az objektum `name` attribútumát! Írd ki mindkét változó tartalmát a képernyőre! 
Mit tapasztalsz? Vajon mi történt?

Deklarálj két egész típusú változót! Az elsőnek add értékül a 24-et! A második 
változónak add értékül az elsőt, majd növeld meg a második változó értékét 1-gyel! 
Írd ki mindkét változót a képernyőre! Mit tapasztalsz? Miért?

Készíts egy új `Person` objektumot és add értékül az egyik `Person` típusú változónak! 
Írd ki mindkét változó tartalmát a képernyőre! Mit tapasztalsz? Miért?
 
 Próbáld követni, hogy mi történik a memóriában! Segítségedre lesz a debugger.

### Közösségi hálózat

Javaslat, hogy a feladat megoldása előtt próbáld meg lerajzolni az objektumokat,
és a közöttük lévő referenciákat.

Implementálj egy közösségi hálózatot, ami tagokból áll, és mindegyik tag ismerősnek jelölhet
egy másik tagot! Ki kell keresni azon kapcsolatokat, ahol a tagok egymást jelölték be.

![Social network UML](images/social_network_class.png)

Egy tagot reprezentáljon a `references.socialnetwork.Member` osztály. A `connections` attribútuma 
a bejelölt tagokat tartalmazza.

Figyeld meg, hogy az osztály egy saját típusú attribútumot is tartalmaz!

A `connectMember()` metódusa a listába beteszi a paraméterként átadott elemet.

Hozd létre a `references.socialnetwork.SocialNetwork` osztályt, mely `List<Member>` típusú 
attribútuma az összes tagot tartalmazza!

A `addMember()` metódusa példányosítson a paraméterként megadott
névvel egy `Member` osztályt, és adja hozzá a listához!

A `connect()` metódusa kikeresi az első tagot név szerint, majd kikeresi a második tagot név szerint,
és az első `connectMember()` metódusát kell meghívni a második taggal mint paraméterrel.

A kikereséshez implementálj egy privát `findByName()` segédmetódust a
`SocialNetwork` osztályba, ami kikeresi a `members` listából a tagot név
szerint.

A `bidirectionalConnections()` metódusa keresse ki azokat
a tagokat, melyek egymást bejelölték. Egy ciklusban végig kell menni a
`members` listán, majd azon belül egy másik ciklusban a kapcsolatain
(`getConnections()`). Amennyiben a második tag is bejelölte az első
tagot (azaz az második tag benne van a kapcsolatai listájában - használd
a lista `contains()` metódusát) -, a kettő tag nevét fűzd össze
egy Stringbe, és tedd egy `List<String>` típusú változóba!

A következő kódot kell majd megírni a `references.SocialNetworkMain` `main()` függvényben:

```java
SocialNetwork socialNetwork = new SocialNetwork();
socialNetwork.addMember("Joe");
socialNetwork.addMember("John");
socialNetwork.addMember("Jane");
socialNetwork.addMember("Richard");

socialNetwork.connect("Joe", "John");
socialNetwork.connect("John", "Joe");

System.out.println(socialNetwork.bidirectionalConnections());
```

Az utolsó sornak a következőt kell kiírnia:

```
[Joe - John, John - Joe]
```

### Közösségi hálózat szövegekben

Implementáld a `SocialNetwork` `toString()` metódusát a `members` változó
`toString()` metódusának hívásával!

Implementáld a `Member` `toString()` metódusát, hogy írja ki a tag nevét, és
azon tagok nevét, akiket bejelölt! Segítségként implementáld a `Member`
osztályban a `List<String> connectedNames()` metódust, mely egy listaként
visszaadja a bejelölt tagok nevét!

[rating feedback=java-references-halozat]

### Bónusz feladat 1

Miért nem működik a következő metódus a `Member` osztályban? Próbáld ki!

```java
@Override
public String toString() {
    return name + " " + connections.toString();
}
```

## Forrás

OCA - Chapter 1/Distinguishing Between Object References and Primitives


## Teszt

Melyik állítás IGAZ a Java memóriakezelésére?

* Az objektumok a heapen jönnek létre, míg az attribútumaik a stacken.
* A primitív típusú adatok a stacken, míg az objektumok a heapen tárolódnak.
* [x] A lokális változók mind a stacken jönnek létre, de a változó értéke primitív 
típus esetén maga az adat, objektum esetén pedig egy referencia a heapen létrejött objektumra.
* Mivel Javában minden adat objektum, ezért ugyan a változók a stacken jönnek létre, de 
a tartalmuk mindig a heapen található objektum referenciája.

Mi igaz az alábbi kódrészletre?

```java
int a = 6;
int b = a;
```

* [x] Mindkét változó tartalma 6, és egyik változtatása sem hat ki a másik értékére.
* Mindkét változó tartalma 6, és bármelyik változtatása kihat a másik értékére.
* Mindkét változó tartalma 6, és a `b` változó változtatása kihat az `a` értékére, 
de ez visszafelé nem igaz.
* Mindkét változó értéke 6, és az `a` változó változtatása kihat a `b` változó 
értékére, de ez visszafelé nem igaz.
