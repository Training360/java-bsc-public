#  Absztrakt metódusok implementálása felsorolásos típusokban

Absztrakt metódust az enum típus is tartalmazhat. Mivel maga az enum nem maradhat absztrakt, 
minden egyes példánynál, a felsorolt konstansokban implementálni kell az adott metódust. Ezt a konstans neve 
utáni kapcsos zárójelek között tehetjük meg. 

```java
public enum TransactionState {
  
  SUCCESS {
    @Override
    public boolean isComplete() {
      return true;
    }
  }, REJECTED {
    @Override
    public boolean isComplete() {
      return true;
    }
  }, PENDING {
    @Override
    public boolean isComplete() {
      return false;
    }
  };
  
  public abstract boolean isComplete();
}
```

Ugyanezt az eredményt érhetjük el azzal is, ha az `isComplete()` metódust 
kiemeljük egy interfészbe, és ezt az interfészt implementálja a `TransactionState` enum. 
Természetesen ebben az esetben sem maradhat absztakt a metódus, ezért vagy magában 
az enumben, vagy  minden egyes példányban meg kell adnunk a működést.

```java
public interface HasCompleteState {
  boolean isComplete();
}

public enum TransactionState implements HasCompleteState {
  
  // ...
}
```

## Ellenőrző kérdések

* Enum esetén hogyan lehetséges absztrakt metódus létrehozása?
* Implementálhat-e interfészeket egy enum? Ha igen, hogyan?

## Feladat

### Megrendelések

Egy webshop a megrendelések állapotát az `OrderState` enumben tárolja. Állapotai:
* `NEW`, ez az állapota minden újonnan leadott megrendelésnek.
* `CONFIRMED`, miután visszaigazolták a rendelést.
* `PREPARED`, miután a megrendelést összekészítették.
* `ONBOARD`, miután átadták a futárnak.
* `DELIVERED`, miután sikeresen kiszállították.
* `RETURNED`, sikertelen kiszállítási kísérlet után.
* `DELETED`, miután bármilyen okból a rendelést törölték.

Egy megrendelést addig lehet visszamondani, amíg még nem adták át a futárnak.

Készíts egy `Deletable` interfészt, és implementáld az enumban! Az interfész egyetlen 
absztrakt metódust tartalmazzon: `boolean canDelete()`. Az 
`OrderState` enum `NEW`, `CONFIRMED` és `PREPARED` értékei esetén igazat, 
minden más esetben hamisat kell visszaadjon.
