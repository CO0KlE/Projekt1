package eu.pedu.adv20w._1_1245.nejj04_nejedlik;

import java.util.Optional;


/*************************************************************************
* Instance třídy {@code nejj04_a_Take} zpracovávají příkazy, které
* žádají o zvednutí předmětu.
*
* @author Jan Nejedlík
*/
public class Action_Take
extends A_Action {
/***************************************************************************
* Vytvoří novou instanci daného příkazu.
*/
Action_Take() {
super("Vezmi",
"Vezme zadaný předmět a vloží jej do košíku.");
}


/***************************************************************************
* Metoda realizující reakci hry na zadání daného příkazu.
* Počet parametrů je závislý na konkrétním příkazu,
* např. příkazy <i>konec</i> a <i>nápověda</i> nemají parametry,
* příkazy <i>jdi</i> a <i>seber</i> mají jeden parametr
* příkaz <i>použij</i> muže mít dva parametry atd.
*
* @param arguments Parametry příkazu;
*                  jejich počet muže byt pro každý příkaz jiný
* @return Text zprávy vypsané po provedeni příkazu
*/
@Override
public String execute(String... arguments) {
if (arguments.length < 2) {
return "Nezadáno jméno zvedaného objektu.\n";
}
String itemName = arguments[1];
World world = World.getInstance();
Place currentPlace = world.currentPlace();
Bag bag = Bag.getInstance();
Optional<Item> oItem = currentPlace.oItem(itemName);
if (!oItem.isPresent()) {
return "Zadaný objekt v prostoru není: " + itemName;
}
Item item = oItem.get();
if (item.weight() == Item.HEAVY) {
return "Zadaný objekt v prostoru nejde sebrat: " + itemName;
}
boolean added = bag.tryAddItem(item);
if (added) {
currentPlace.removeItem(item);
return "Do batohu byl přidán objekt: " + itemName;
} else {
return "Zadaný objekt se už do batohu nevejde!";
}
}
}
