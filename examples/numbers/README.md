# Egész és lebegőpontos számok

## A `/` operátor furcsaságai

A Java nyelvben a `/` operátornak a `+` operátorhoz hasonlóan két funkciója is 
van. Az egyik az egész osztás, a másik a valós osztás. Azt, hogy éppen melyiket 
kell elvégezni, az operandusok típusa határozza meg. Amennyiben mindkét operandus valamelyik 
egész típusból való, abban az esetben az eredmény is egész szám lesz, hiába tesszük 
lebegőpontos változóba.

```java
double quotient = 10 / 4; // az eredmény 2.0
```

Ha legalább az egyik operandus lebegőpontos szám, akkor az eredmény is lebegőpontos 
szám lesz.

```java
double fraction = 10 / 4.0; // az eredmény minden esetben 2.5
double fraction = 10 / 4D;
double fraction = (double) 10 / 4;
```

## Lebegőpontos számok összehasonlítása

Gyakran nevezzük a tizedes törteket valós számoknak, azonban a számítógép végtelen 
törteket nem tud ábrázolni, valahol mindig vége lesz a tizedesjegyek sorának. Ráadásul a bináris ábrázolás 
miatt a véges tizedes törtek sokszor csak végtelen kettedes törtként írhatóak le, vagyis csak 
pontatlanul ábrázolhatók. Ezek egyik mellékhatása, hogy két lebegőpontos szám nem lesz biztosan
egyenlő még akkor sem, ha egyébként annak kellene lennie.

```java
System.out.println(0.1 * 3 == 0.3); // false
```

```java
System.out.println(0.1 * 3); // 0.30000000000000004
```

A legjobb megoldás, ha két lebegőpontos számot nagyon kicsi eltéréssel már egyenlőnek 
tekintünk. De hogyan lehet ezt leírni? Ha az összehasonlítandó számok `a` és `b`, a 
megengedett eltérés pedig `delta`:

```java
boolean equals = Math.abs(a - b) < delta;
```

Például:

```java
System.out.println(Math.abs(0.1 * 3 - 0.3) < 0.005); // true
System.out.println(Math.abs(0.1 * 3 - 0.3) < 1.0e-15); // true
```

## Ellenőrző kérdések

* Mennyi lesz az 5/6 eredménye Javában? És az 5.0/6.0 eredménye? Miért?
* Hogyan lehet két lebegőpontos szám egyenlőségét megvizsgálni?

## Feladat

### Kör

Készíts egy `Circle` osztályt, amelyben eltárolod annak egész értékű átmérőjét 
(`diameter`) és a Pi értékét két tizedesjegy pontossággal!
Az átmérő konstruktorban kap értéket. Készíts két 
metódust: az egyik a kör kerületét adja vissza (`perimeter()`), a másik a 
területét (`area()`)! Ezek visszatérési típusa lebegőpontos legyen!

Próbáld ki az osztály működését a `CircleMain` `main()` metódusában! Készíts két 
kört és írd ki mindkét kör kerületét és területét! A körök átmérőjét
konzolról olvasd be!

### Matematikai feladatok

Készíts egy `MathOperations` osztályt! A `main()` metódusában írj ki a felhasználónak egy 
négy alapműveletet és zárójeleket tartalmazó számítási feladatot, majd kérd be tőle az 
eredményt! Ellenőrizd a kapott értéket, és jelezd vissza, hogy 
helyesen oldotta-e meg a feladatot. A megengedett eltérés 0.0001 legyen

A `Scanner` osztályt használhatod `double` típusú adatok bekérésére is. A `nextDouble()` metódusa 
a futtató operációs rendszer alapértelmezett formátumában értelmezi a beírt szöveget, azaz magyar 
környezet esetén a választ tizedesvesszőt használva kell megadni, például `5,342`.

## Forrás

OCA - Chapter 1/Understanding Default Initialization of Variables, Understanding Variable Scope

## Teszt

Mit ír ki az alábbi kódrészlet?

```java
int a = 10;
double b = (15 - a) / 2 * (double) 3;
System.out.println(b);
```

* [x] 6.0
* 7.5
* 0.8333333333333334
* 0.0

Mit ír ki?

```java
System.out.println(5 + 6 + "0");
```

* 11
* 56
* [x] 110
* 560
