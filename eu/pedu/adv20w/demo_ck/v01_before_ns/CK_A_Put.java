package eu.pedu.adv20w.demo_ck.v01_before_ns;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */

import java.util.Optional;



/*******************************************************************************
 * Instance třídy {@code CK_A_Put} zpracovávají příkazy, které
 * mají položi zadaný předmět.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2020-Winter
 */
public class CK_A_Put
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
    CK_A_Put()
    {
        super ("Polož",
               "Předmět z košíku položí v aktuálním prostoru");
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
            return "Nevím, co mám položit.\n"
                 + "Je třeba zadat jméno pokládaného objektu.";
        }
        String         itemName = arguments[1];
        CK_Bag            bag = CK_Bag.getInstance();
        Optional<CK_Item> oItem = bag.oItem(itemName);
        if (! oItem.isPresent()) {
            return "Zadaný objekt v košíku není: " + itemName;
        }
        CK_Item item = oItem.get();
        bag.removeItem(item);
        CK_Place currentPlace = CK_World.getInstance().currentPlace();
        currentPlace.addItem(item);
        return "Karkulka položila objekt: " + item.name();
    }



//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
