# Metódus hívások láncolása

Egy kifejezésen belül ugyanazon objektumon több metódust is hívhatunk láncoltan. Ennek feltétele, hogy a metódus azon objektumpéldánnyal térjen vissza, amelyen meghívtuk (`this`). Gyakran használjuk a Builder tervezési mintánál. (A Builder osztály egy másik osztály inicializálását és példányosítását végzi.)

Lássunk erre egy példát!

Készítsünk egy `Peasant` osztályt, ahol a sakktáblán a pozícióját követhetjük nyomon a `posX`, `posY` attribútumokkal. A metódusok a lépéseket imitálják. A pozíció 1 és 8 között változhat, és bármilyen irányban csak egyet léphet, ha tud.

```java
public class Peasant {
    public static final int MIN_X = 1;
    public static final int MAX_X = 8;
    public static final int MIN_Y = 1;
    public static final int MAX_Y = 8;

    private int posX;
    private int posY;

    public Peasant(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public Peasant forward() {
        if (posX < MAX_X){
            posX++;
        }
        return this;
    }

    public Peasant back() {
        if (posX > MIN_X) {
            posX--;
        }
        return this;
    }

    public Peasant left() {
        if (posY > MIN_Y) {
            posY--;
        }
        return this;
    }

    public Peasant right() {
        if (posY < MAX_Y) {
            posY++;
        }
    }

    public String toString() {
        return "X: " + posX + ", Y: " + posY;
    }
}
```

A mozgását láncolt metódushívással könnyen megadhatjuk:

```java
Peasant peasant = new Peasant(2, 3) // lehelyeztük a tábla (2, 3) mezőjére
    .forward()   // előre lépett
    .forward()   // előre lépett
    .left()      // balra lépett
    .backward()	 // hátra lépett
    .left()		 // balra lépett
    .forward()	 // előre lépett
    .right();	 // jobbra lépett

System.out.println(peasant); //X: 4 Y: 2
```

## Ellenőrző kérdések

* Mit tudsz a `this` pszeudóváltozóról?
* Milyen feltételei vannak a láncolható metódusoknak?

## Gyakorlat - Robot és mozgatása

Egy `Robot` objektumot  mozgatunk, utasításokat adva.
Ezek menj és fordulj lehet. Az utasítások láncban is kiadhatók,
azaz a robot egyszerre több utasítást is kaphat, amit sorban végrehajt és ezzel
egy adott távot megtéve, adott irányban áll meg.

Hozz létre egy `Robot` osztályt, amiben legyen két attribútum: `distance`,
amelyben a megtett eddigi összes távolságot, és `azimut` amiben az aktuális irányszöget (fokban) tárolja.

Publikus metódusok:

```java
 public Robot go(int meter)
 public Robot rotate(int angle)
```

[rating feedback=java-methodchain-robot]


## Bónusz feladat

Egészítsd ki a `Robot` osztályt azzal, hogy a robot a megfelelő utasításra feljegyzi az aktuális
pozícióját egy `NavigationPoint` objektumban, és ezt az objektumot hozzáadja egy listához.

Kiegészítő publikus metódus:

```java
 public Robot registerNavigationPoint()
```

 Így a robot mozgása utólag végigkövethető - feltéve, hogy kapott utasítást az adott pozícióban
 ennek feljegyzésére a láncolt utasítások között.
 Ehhez a `NavigationPoint` objektumot a robot aktuális távolságával és irányával (azimut) hozzuk létre,
 majd a robot listájához hozzáadjuk. A teszteléshez a `NavigationPoint` objektumban meg kell írni a
 megfelelő `toString` metódust is. 

