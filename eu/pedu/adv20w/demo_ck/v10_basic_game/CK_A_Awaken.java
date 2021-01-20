package eu.pedu.adv20w.demo_ck.v10_basic_game;

import eu.pedu.adv20w.api.INamed;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;



/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */



/*******************************************************************************
 * Instance třídy {@code EmptyAction} zpracovávají příkazy, které
 * probudí zadanou osobu.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2020-Winter
 */
public class CK_A_Awaken
     extends CK_AAction
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==============
//\CV== CLASS VARIABLES (VARIABLE CLASS/STATIC ATTRIBUTES/FIELDS) ==============



//##############################################################################
//\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) =========================
//\CF== CLASS (STATIC) FACTORY METHODS =========================================
//\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================
//\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS ===========================
//\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS ===========================



//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============
//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     * Vytvoří novou instanci daného příkazu.
     */
    CK_A_Awaken()
    {
        super ("Probuď",
               "Probudí zadaný h-objekt (osobu, zvíře)");
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================
//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================

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
            return "Nevím, koho mám probudit.\n"
                 + "Je třeba zadat jméno buzeného h-objektu.";
        }
        String      enteredName = arguments[1];
        CK_World          world = CK_World.getInstance();
        CK_Place   currentPlace = world.currentPlace();
        Optional<CK_Item> oItem = INamed.getO(enteredName,
                                              currentPlace.items());
        if (! oItem.isPresent()) {
            return "Zadaný h-objekt v prostoru není: " + enteredName;
        }
        CK_Item item = oItem.get();
        if (! name2awakened.containsKey(item.name())) {
            return "Nelze probudit předmět: " + item;
        }
        String name = item.name();
        if (name2awakened.get(name)) {
            return "Nelze budit osobu, která je již probuzená: " + name;
        }
        else {
            name2awakened.put(name, true);
            return "Karkulka probudila osobu: " + name;
        }
    }



//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
