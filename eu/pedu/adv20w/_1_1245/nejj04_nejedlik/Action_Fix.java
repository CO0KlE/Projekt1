package eu.pedu.adv20w._1_1245.nejj04_nejedlik;

public class Action_Fix extends A_Action {

//vytvoření instance daného příkazu
Action_Fix() {
super("Natáhnout_hodiny",
        "Natahnutí hodin, inbusem");
}

@Override
public String execute(String... arguments) {
//ošetření min. počtu argumentů
if (arguments.length < 2) {
return "Nezadán dostatečný počet argumentů";
}
String objekt = arguments[1];
World world = World.getInstance();
Place cp = world.currentPlace();

//ověření prostoru
Place hodinarstvi =
        world.getPlace(StringConstants.HODINARSTVI).get();
if (!hodinarstvi.equals(cp)) {
return "Nejsi v hodinářství, není co natáhnout";
}

//ověření zadání správného parametru
if (!objekt.equalsIgnoreCase(StringConstants.INBUS)) {
return "Na natažení hodin musíš použít Inbus.";
}

Bag bag = Bag.getInstance();

boolean found = false;
for (Item item : bag.items()) {
if (item.name().equals(StringConstants.INBUS)) {
found = true;
break;
}
}
//ověření inbusu v inventáři
if (!found) {
return "Nemáš inbus v inventáři";
}
//přidání prostoru chodba

world
.getPlace(StringConstants.HODINARSTVI)
.get()
.addNeighbour(StringConstants.CHODBA);

return "Natahuješ inbusem zastavenné nástěnné \n"
+ "hodiny a zeď se začne pomalu posouvat.";
}
}
