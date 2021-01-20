package eu.pedu.adv20w._1_1245.nejj04_nejedlik;

import eu.pedu.adv20w.api.IAction;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;



//@author Jan NEJEDLÍK

abstract class A_Action
extends A_Action_named
implements IAction {

private static final Map<String, A_Action> NAME_2_ACTION;

static final Collection<A_Action> ACTIONS;


/**
* Příznak toho, že hra právě běží.
*/
static boolean isAlive;


static {
isAlive = false;
NAME_2_ACTION = new HashMap<>();
Consumer<A_Action> put =
        action -> NAME_2_ACTION.put(action.name().toLowerCase(),
                action);
put.accept(new Action_Help());
put.accept(new Action_Take());
put.accept(new Action_Put());
put.accept(new Action_GoTo());
put.accept(new Action_End());

put.accept(new Action_Yell());
put.accept(new Action_Exchange());
put.accept(new Action_Fix());
put.accept(new Action_Torch());
ACTIONS = Collections.unmodifiableCollection(NAME_2_ACTION.values());
}


public static Collection<A_Action> getAllActions() {
Collection<A_Action> collection, result;
collection = NAME_2_ACTION.values();
result = Collections.unmodifiableCollection(collection);
return result;
}

public static String executeCommand(String command) {
command = command.trim();
if (command.isEmpty()) {
    if (isAlive) {
        return "Prázdný příkaz lze použít pouze pro start hry";
    }
    isAlive = true;
    initialize();
    return "Otevřete oči, ale nic nevidíte"+
            ", pohnete nohou a ozve se ozvěna.\n" +
            "Zjišťujete, že jste v jeskyni. V dálce uvidíte trošku\n"+
            "světla a cosi zeleného. Stromy.\n\n" +
            "Váš cíl je dostat se zpět do současnosti, protože jak\n"+
            "brzy zjistíte, nacházíte se v dávné minulosti.\n\n"+
            "TIP: Sbírejte vše, co by se vám mohlo hodit.\n"+
            "Nevíte-li, jak pokračovat, zadejte příkaz '?'.";
} else {
    if (isAlive) {
        String[] words = command
                .trim()
                .toLowerCase()
                .split("\\s+");
        String acttionName = words[0];
        A_Action action = NAME_2_ACTION.get(acttionName);
        String answer;
        if (action == null) {
            answer = "Neznámý příkaz: " + acttionName;
        } else {
            answer = action.execute(words);
        }
        return answer;
    } else {
        return "\nPrvním příkazem není příkaz startu."
                + "\nHru, která neběží, lze spustit pouze "
                + "startovacím příkazem.\n";
    }
}
}

/***************************************************************************
* Inicializuje aplikaci při startu další hry.
*/
private static void initialize() {
World.getInstance().initialize();
Bag.getInstance().initialize();
//        InitProperties initProperties = InitProperties.getInstance();
//        IMyGSMFactory  factory        = initProperties.factory;
//        game = factory.getGame();
//        game.getBag()  .initialize();
//        game.getWorld().initialize();
//        State.initialize();
}

/**
* Stručný popis dané akce.
*/
private final String description;


/***************************************************************************
* Vytvoří rodičovský podobjekt vytvářené akce.
*
* @param name  Název vytvářené akce = text, který musí hráč zadat
*              jako počáteční slovo zadávaného příkazu
* @param description Stručný popis vytvářené akce
*/
A_Action(String name, String description) {
super(name);
this.description = description;
}


/***************************************************************************
* Metoda realizující reakci hry na zadání daného příkazu.
* Počet parametrů je závislý na konkrétní akci,
* např. akce typu <i>konec</i> a <i>nápověda</i> nemají parametry,
* akce typu <i>jdi</i> a <i>seber</i> mají jeden parametr
* akce typu <i>použij</i> muže mít dva parametry atd.
*
* @param arguments Parametry příkazu – akce;
*                  jejich počet muže byt pro každou akci jiný,
*                  ale pro všechna spuštění stejné akce je stejný
* @return Text zprávy vypsané po provedeni příkazu
*/
@Override
abstract
public String execute(String... arguments)
;

/***************************************************************************
* Vrátí popis příkazu s vysvětlením jeho funkce
* a významu jednotlivých parametru.
*
* @return Popis příkazu
*/
@Override
public String description() {
return description;
}

}
