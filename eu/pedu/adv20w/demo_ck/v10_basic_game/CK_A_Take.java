package eu.pedu.adv20w.demo_ck.v10_basic_game;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */

import java.util.Optional;



/*******************************************************************************
 * Instance třídy {@code CK_A_Take} zpracovávají příkazy, které
 * žádají o zvednutí předmětu.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2020-Winter
 */
public class CK_A_Take
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
    CK_A_Take()
    {
        super ("Vezmi",
               "Vezme zadaný předmět a vloží jej do košíku.");
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
        if (arguments.length <2) {
            return "Nevím, co mám zvednout.\n"
                 + "Je třeba zadat jméno zvedaného objektu.";
        }
        String         itemName = arguments[1];
        CK_World          world = CK_World.getInstance();
        CK_Place   currentPlace = world.currentPlace();
        CK_Bag              bag = CK_Bag.getInstance();
        Optional<CK_Item> oItem = currentPlace.oItem(itemName);
        if (! oItem.isPresent()) {
            return "Zadaný objekt v prostoru není: " + itemName;
        }
        CK_Item item = oItem.get();
        if (item.weight() == CK_Item.HEAVY) {
            return "Zadaný objekt není možno zvednout: " + itemName;
        }
        boolean added = bag.tryAddItem(item);
        if (added) {
            currentPlace.removeItem(item);
            return "Karkulka dala do košíku objekt: " + itemName;
        }
        else {
            return "Zadaný objekt se už do košíku nevejde!";
        }
    }



//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
