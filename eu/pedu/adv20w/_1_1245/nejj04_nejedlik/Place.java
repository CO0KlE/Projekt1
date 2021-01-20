package eu.pedu.adv20w._1_1245.nejj04_nejedlik;

import eu.pedu.adv20w.api.IPlace;

import java.util.*;


/**************************************************************************
* Instance třídy {@code nejj04_place} představují prostory ve hře.
* Dosažení prostoru si můžeme představovat jako částečný cíl,
* kterého se hráč ve hře snaží dosáhnout.
* Prostory mohou být místnosti, planety, životní etapy atd.
* Prostory mohou obsahovat různé objekty,
* které mohou hráči pomoci v dosažení cíle hry.
* Každý prostor zná své aktuální bezprostřední sousedy
* a ví, jaké objekty se v něm v daném okamžiku nacházejí.
* Sousedé daného prostoru i v něm se nacházející objekty
* se mohou v průběhu hry měnit.
* V tomto programu jsou prostory ...
*
* @author Jan Nejedlík
*/
public class Place
extends A_Action_itemcontainer
implements IPlace {


/**
* Stručný popis daného prostoru.
*/
private final String description;

/**
* Názvy výchozích sousedů. -
*/
private final String[] initialNeighborNames;

/**
* Kolekce aktuálních sousedů.
*/
private final Map<String, Place> name2neighbor;

/**
* Exportovaná kolekce aktuálních sousedů.
*/
private final Collection<Place> exportedNeighbors;

Place(String name, String description,
      String[] neighborNames, String... itemNames) {
super(name, itemNames);
this.description = description;
this.initialNeighborNames = neighborNames;
name2neighbor = new HashMap<>();
exportedNeighbors = Collections.
unmodifiableCollection(name2neighbor.values());
}

@Override
public Collection<Place> neighbors() {
return exportedNeighbors;
}


/***************************************************************************
* Vrátí stručný popis daného prostoru.
*
* @return Stručný popis daného prostoru
*/
public String getDescription() {
return description;
}


void initialize() {
initializeNeighbors();
initializeItems();
}


/***************************************************************************
* Inicializuje sousedy prostoru.
*/
private void initializeNeighbors() {
World world = World.getInstance();
name2neighbor.clear();
Arrays.stream(initialNeighborNames)
.forEach(name -> name2neighbor.put(name.toLowerCase(),
        world.getPlace(name).get()));
}

public void addNeighbour(String name) {
World world = World.getInstance();
name2neighbor.put(name, world.getPlace(name).get());
}
}
