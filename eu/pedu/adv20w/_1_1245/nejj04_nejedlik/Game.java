package eu.pedu.adv20w._1_1245.nejj04_nejedlik;

import eu.pedu.adv20w.api.*;

import java.util.Collection;


/**************************************************************************
* Instance třídy {@code nejj04_game} mají na starosti logiku hry.
* Jsou schopny akceptovat jednotlivé příkazy a poskytovat informace
* o průběžném stavu hry a jejích součástí.
*
* Třída hry musí být definována jako jedináček (singleton)
* a kromě metod deklarovaných v interfejsu {@link IGame} musí definovat
* statickou tovární metodu {@code getInstance()}.
* Splnění této podmínky nemůže prověřit překladač,
* ale prověří ji až následné testy hry.
* <p>
* Instance třídy {@code EmptyGame} představují prototypy instancí hry,
* které ještě nejsou schopny plnohodnotného spuštění a slouží pouze
* ke kompletaci těch vlastností správce scénářů, které bude v budoucnu
* plnit ve spolupráci s plnohodnotnou hrou.
*
* @author Jan Nejedlík
*/
public class Game implements IGame {

/**
* Odkaz na jedinou instanci (jedináčka) této hry.
*/
private static final Game SINGLETON = new Game();

/**
* Přepravka s názvy povinných akcí.
*/
private static final BasicActions BASIC_ACTIONS =
new BasicActions("Jdi", "Vezmi", "Polož",
"?", "Konec");


/***************************************************************************
* Tovární metoda vracející odkaz na jedninou existující instanci dané hry.
*
* @return Instance dané hry
*/
public static Game getInstance() {
return SINGLETON;
}


/***************************************************************************
* Soukromý konstruktor definující jedinou instanci.
* Protože je soukromý, musí být definován, i když má prázdné tělo.
*/
private Game() {
}

/***************************************************************************
* Vrátí informaci o tom, je-li hra aktuálně spuštěná.
* Spuštěnou hru není možno pustit znovu.
* Chceme-li hru spustit znovu, musíme ji nejprve ukončit.
*
* @return Je-li hra spuštěná, vrátí {@code true},
*         jinak vrátí {@code false}
*/
@Override
public boolean isAlive() {
return A_Action.isAlive;
}

/***************************************************************************
* Vrátí odkaz na batoh, do nějž bude hráč ukládat sebrané předměty.
*
* @return Batoh, do nějž hráč ukládá sebrané předměty
*/
@Override
public IBag bag() {
return Bag.getInstance();
}

/***************************************************************************
* Vrátí kolekci všech příkazů použitelných ve hře.
*
* @return Kolekce všech příkazů použitelných ve hře
*/
@Override
public Collection<? extends IAction> allActions()
{
return A_Action.ACTIONS;
}


/***************************************************************************
* Vrátí odkaz na přepravku s názvy povinných příkazů, tj. příkazů pro
*
*   přesun hráče do jiného prostoru,
*   zvednutí objektu (odebrání z prostoru a vložení do batohu),
*   položení objektu (odebrání z batohu a vložení do prostoru),
*   vyvolání nápovědy,
*   okamžité ukončení hry.
*
*
* @return Přepravka názvy povinných příkazů
*/
@Override
public BasicActions basicActions() {
return BASIC_ACTIONS;
}


/***************************************************************************
* Vrátí odkaz na svět, v němž se hra odehrává.
*
* @return Svět, v němž se hra odehrává
*/
@Override
public IWorld world() {
return World.getInstance();
}


/***************************************************************************
* Zpracuje zadaný příkaz a vrátí text zprávy pro uživatele.
*
* @param command Zadávaný příkaz
* @return Textová odpověď hry na zadaný příkaz
*/
@Override
public String executeCommand(String command) {
return A_Action.executeCommand(command);
}


/***************************************************************************
* Ukončí celou hru a vrátí alokované prostředky.
*/
@Override
public void stop() {
A_Action.isAlive = false;
}

}
