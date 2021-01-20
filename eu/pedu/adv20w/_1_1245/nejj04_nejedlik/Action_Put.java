package eu.pedu.adv20w._1_1245.nejj04_nejedlik;
import java.util.Optional;


/**************************************************************************
* Instance třídy {@code nejj04_a_Put} zpracovávají příkazy, které
* mají položi zadaný předmět.
*
* @author  Jan NEJEDLÍK
*/
public class Action_Put
extends A_Action
{

/***************************************************************************
* Vytvoří novou instanci daného příkazu.
*/
Action_Put()
{
super ("Polož",
"Předmět z košíku položí v aktuálním prostoru");
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
public String execute(String... arguments)
{
if (arguments.length < 2) {
return "Nezadáno jméno pokládaného objektu.\n";
}
String         itemName = arguments[1];
Bag bag = Bag.getInstance();
Optional<Item> oItem = bag.oItem(itemName);
if (! oItem.isPresent()) {
return "Zadaný objekt v batohu není: " + itemName;
}
Item item = oItem.get();
bag.removeItem(item);
Place currentPlace = World.getInstance().currentPlace();
currentPlace.addItem(item);
return "Byl položen objekt: " + item.name();
}
}
