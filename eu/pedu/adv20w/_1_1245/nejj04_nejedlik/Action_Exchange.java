package eu.pedu.adv20w._1_1245.nejj04_nejedlik;

public class Action_Exchange extends A_Action {

//vytvoření instance daného příkazu
Action_Exchange() {
super("Kup",
"Kup zapalovač za mince");
}

//O co se snažím:

@Override
public String execute(String... arguments) {
//Počet argumentů
if (arguments.length < 3) {
return "Nezadán dostatečný počet argumentů";
}

//Musí být v Zastavarna
World world = World.getInstance();
Place cp = world.currentPlace();

Place zastavarna =
        world.getPlace(StringConstants.ZASTAVARNA).get();
if (!zastavarna.equals(cp)) {
return "Nejsi ve správném prostoru" +
" Tento příkaz můžeš vykonat v prostoru: Zastavarna";
}

//Musí mít napsán příkaz správně
if (!arguments[1].equalsIgnoreCase(StringConstants.ZAPALOVAC) ||
!arguments[2].equalsIgnoreCase(StringConstants.MINCE)) {
return "Zastavárník nevymění " + arguments[1] + " za " + arguments[2];
}

//Musí mít Mince
Bag bag = Bag.getInstance();

boolean a = false;
for (Item item : bag.items()) {
if (item.name().equalsIgnoreCase(StringConstants.MINCE)) {
a = true;
break;
}
}
if (!a) {
return "Nemáš v inventáři Mince";
}

//v obchodě musí být zapalovač
boolean b = false;
for (Item item : cp.items()) {
if (item.name().equalsIgnoreCase(StringConstants.ZAPALOVAC)) {
b = true;
break;
}
}
if (!b) {
return "V obchodě není zapalovač";
}
////////////////////////////////////////////////////////////

//Odebrat Mince přidat Zapalovac
Item mince = new Item("string");
Item zapalovac = new Item("string");

for (Item item : bag.items()) {
if (item.name().equalsIgnoreCase(StringConstants.MINCE)) {
mince = item;
}
}
for (Item item : cp.items()) {
if (item.name().equalsIgnoreCase(StringConstants.ZAPALOVAC)) {
zapalovac = item;
}
}
bag.removeItem(mince);
cp.addItem(mince);
cp.removeItem(zapalovac);
bag.tryAddItem(zapalovac);

return "Získáváš Zapalovac za Mince";
}


}
