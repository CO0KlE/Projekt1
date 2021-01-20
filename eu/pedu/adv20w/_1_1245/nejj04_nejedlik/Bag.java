package eu.pedu.adv20w._1_1245.nejj04_nejedlik;

import eu.pedu.adv20w.api.IBag;

import java.util.ArrayList;
import java.util.Collection;

public class Bag extends A_Action_itemcontainer implements IBag {

/**
* Kapacita batohu.
*/
static final int CAPACITY = 4;

/**
* Jediná instance batohu ve hře.
*/
private static final Bag SINGLETON = new Bag();


/***************************************************************************
* Tovární metoda vracející odkaz na jedninou existující instanci dané hry.
*
* @return Instance dané hry
*/
static Bag getInstance() {
return SINGLETON;
}


/**
* Kolekce všech prostorů světa hry.
*/
private final Collection<Item> items;

/**
* Free capacity of the bag.
*/
private int remains;


@SuppressWarnings("unchecked")
Bag() {
super("Batoh");
items = new ArrayList<>();
}


/***************************************************************************
* Vrátí kapacitu batohu, tj. maximální povolený součet vah objektů,
* které je možno současně uložit do batohu.
*
* @return Kapacita batohu
*/
@Override
public int capacity() {
return CAPACITY;
}


/***************************************************************************
* The method initializing the bag.
* As the player of this game has an empty bag at the game beginning,
* this method can only clean the {@link #items} collection.
*/

public void initialize() {
initializeItems();
remains = CAPACITY;
}


/***************************************************************************
* Removes the given item from the bag
* and increases the free capacity of the bag.
*
* @param item Item taken away
*/
@Override
public void removeItem(Item item) {
super.removeItem(item);
remains += item.weight();
}


/***************************************************************************
* If the given item fits to the bag, it adds it;
* after that it returns the message on the result.
*/

public boolean tryAddItem(Item item) {
if (item.weight() > remains) {
return false;
}
addItem(item);
remains -= item.weight();
return true;
}


}
