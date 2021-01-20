package eu.pedu.adv20w._1_1245.nejj04_nejedlik;

import eu.pedu.adv20w.api.INamed;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;


/***************************************************************************
* Instance abstraktní třídy {@code nejj04_A_itemcontainer} jsou
* rodičovskými podobjekty objektů, sloužícími jako kontejnery h-objektů,
* konkrétně batohu a prostorů.
*
* @author Jan NEJEDLÍK
*/
abstract class A_Action_itemcontainer extends A_Action_named {
/**
* Names of items in this container at the game beginning.
*/
private final String[] itemNames;

/**
* Výchozí h-objekty v prostoru. -
*/
private final ArrayList<Item> initialItems;

/**
* Names of items currently present in this container.
*/
private final Collection<Item> items;

/**
* Immutable collection of items currently present in this container,
* that continuously maps the {@link #items} collection content.
*/
private final Collection<Item> exportedItems;


/***************************************************************************
* Creates the parent sub-object of the container of items
* with the given names of its initial items.
*
* @param name      Name of the child object
* @param itemNames Names of items in the container at the game beginning
*/
A_Action_itemcontainer(String name, String... itemNames) {
super(name);
this.itemNames = itemNames;
initialItems = new ArrayList<>();
for (String itemName : itemNames) {
initialItems.add(new Item(itemName));
}
this.items = new ArrayList<>(initialItems);
this.exportedItems = Collections.unmodifiableCollection(items);
}

/***************************************************************************
* Vrátí kolekci objektů nacházejících se v daném prostoru.
*
* @return Kolekce objektů nacházejících se v daném prostoru
*/
public Collection<Item> items() {
return exportedItems;
}


/***************************************************************************
* Returns the item with the given name wrapped into
* an {@link Optional}{@code <}{@link Item}{@code >}.
*
* @param  name Name of the asked item
* @return The item with the given name wrapped into
*         an {@link Optional}{@code <}{@link Item}{@code >}
*/
public Optional<Item> oItem(String name) {
return INamed.getO(name, items);
}


/***************************************************************************
* Adds the given item into the container.
*
* @param item The item that has to be added into the container
*/
public void addItem(Item item) {
items.add(item);
}


/***************************************************************************
* Cleans the container and saves into it the items
* located in the given container at the game beginning.
*/
public void initializeItems() {
items.clear();
items.addAll(initialItems);

}


/***************************************************************************
* Removes the given item from this container.
*
* @param item Item to be removed
*/
public void removeItem(Item item) {
items.remove(item);
}

}
