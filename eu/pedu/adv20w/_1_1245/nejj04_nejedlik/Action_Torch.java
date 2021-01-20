package eu.pedu.adv20w._1_1245.nejj04_nejedlik;

public class Action_Torch extends A_Action {
//vytvoření instance daného příkazu
Action_Torch() {
super("Pochoden", "Vytvořil/a jsi pochodeň");
}

@Override
public String execute(String... arguments) {
//zkontrolování dostatku argumentů
if (arguments.length < 4) {
return "Nezadán dostatečný počet argumentů";
}
String objekt1 = arguments[1];
String objekt2 = arguments[2];
String objekt3 = arguments[3];

//zkontrolování prostoru
World world = World.getInstance();
Place cp = world.currentPlace();


Place chodba = world.getPlace(StringConstants.CHODBA).get();
if (!chodba.equals(cp)) {
return "Nejsi ve správném prostoru" +
" pro zapalování pochodní. Správný prostor: Chodba";

}
//zkontrolování správnosti částí příkazu
if (!objekt1.equalsIgnoreCase(StringConstants.KLACEK)
|| !objekt2.equalsIgnoreCase(StringConstants.HADR)
|| !objekt3.equalsIgnoreCase(StringConstants.ZAPALOVAC)) {
return "Na vytvoření pochodně je nutno použít" +
" Klacek, Hadr a Zapalovac.";
}

//zkontrolování, že v batohu jsou všechny součásti příkazu připraveny
Bag bag = Bag.getInstance();

int counter = 0;

for (Item item : bag.items()) {
if (item.name().equalsIgnoreCase(StringConstants.KLACEK)
|| item.name().equalsIgnoreCase(StringConstants.HADR)
|| item.name().equalsIgnoreCase(StringConstants.ZAPALOVAC)) {
++counter;
}
}

if (counter != 3) {
return "Nemáš všechny potřebné předměty" +
" v inventáři.";
}


//přidání prostoru jeskyne_ted
world
.getPlace(StringConstants.CHODBA)
.get()
.addNeighbour(StringConstants.JESKYNE_TED);

//odstranění klacku a hadru z inventáře
Item klacek = new Item("DUMMY");
Item hadr = new Item("DUMMY");

for (Item item : bag.items()) {
if (item.name().equalsIgnoreCase(StringConstants.KLACEK)) {
klacek = item;
}
if (item.name().equalsIgnoreCase(StringConstants.HADR)) {
hadr = item;
}
}

bag.removeItem(klacek);
bag.removeItem(hadr);
//přidání pochodně do inventáře
bag.tryAddItem(new Item("_" + StringConstants.POCHODEN));
return "Vytvořil jsi pochodeň a vidíš něco, co \n"
+ "připomíná vstup do jeskyně.";
}
}
