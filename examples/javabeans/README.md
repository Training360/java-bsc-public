# JavaBeans objektumok

A Java Bean olyan speciális osztály, amelynek készítésekor be kell tartanunk néhány konvenciót, hogy az általunk írt osztály könnyen beilleszthető legyen egy már kész rendszerbe.

Szabályok:

- Minden attribútum privát, csak publikus getter és setter metódusokon át érhető el, illetve módosítható. (property = attribútum + getter és setter metódusa)
- A getter metódusok a "*get*" + attribútumnév nagy kezdőbetűvel elnevezési konvenciót követik. Ez alól kivétel a `boolean` típusú attribútum, mert ez "*is*" előtagot kap.
- A setter metódusok a "*set*" + attribútumnév nagy kezdőbetűvel elnevezési konvenciót követik.
- Rendelkeznek üres konstruktorral.

```java
public class Pet {
	  private String name;
    private String color;
    private int age;
    private boolean purebred;

    public Pet() {			
		}

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }

    public boolean isPurebred() {
        return purebred;
    }

    public String setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPurebred(boolean purebred) {
        this.purebred = purebred;
    }
}
```



## Ellenőrző kérdések

* Mire való a JavaBeans szabvány?
* Hogyan nevezzük el az életkor (`age`) nevű privát attribútum lekérdező metódusát (`int` típus)?
* Hogyan nevezzük el az életkor (`age`) nevű privát attribútum beállító metódusát (`int` típus)?
* Hogyan nevezzük el az érvényes (`valid`) nevű privát attribútum lekérdező metódusát (`boolean` típus)?

## Kutya osztály

Hozz létre egy kutya (`Dog`) osztályt, amely a következő attribútumokat tartalmazza:

* `name`: szöveges típusú
* `age`: egész típusú
* `pedigree`: logikai típusú (igaz, ha fajtiszta)
* `weight`: valós típusú

Generálj minden attribútumhoz gettert és settert.

[rating feedback=java-javabeans-kutya]

## Ember osztály

Hozz létre egy ember (`Human`) osztályt, amely a következő attribútumokat tartalmazza:

* `name`: szöveges típusú
* `weight`: valós típusú
* `iq`: egész típusú

Generálj minden attribútumhoz gettert és settert!

[rating feedback=java-javabeans-ember]

## Forrás

OCA - Chapter 4/Encapsulating Data
