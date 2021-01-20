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
public class CK_A_Give
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
    CK_A_Give()
    {
        super ("Předej",
               "Karkulka předá babičce zadané dva dárky k narozeninám");
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
        if (arguments.length < 3) {
            return "Není zadán dostatečný počet dárků k předání";
        }
        String name1 = arguments[1];
        String name2 = arguments[2];
        Object item1, item2 = null;
        if (((item1 = verify(name1)) instanceof String)  ||
            ((item2 = verify(name2)) instanceof String)  )
        {
            return "" + ((item1 instanceof String)  ?  item1  : item2);
        }
        else {
            CK_Item item = whoIsHere();
            return ((item == null)  ?  "Není komu předat: "
                                    :  "Karkulka předala předměty: ")
                   + item1 + " a " + item2;
        }
    }



//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================

    /***************************************************************************
     * Prověří, že obbjekt se zadaným názvem leží v aktuálním prostoru
     * a je přenositelný.
     *
     * @param name Zadaný házev předávaného objektu0
     * @return Pokud objekt vyhovuje, vrátí odkaz na něj,
     *         pokud ne, vrátí chybovou zprávu
     */
    private Object verify(String name)
    {
        CK_World world = CK_World.getInstance();
        CK_Place    cp = world.currentPlace();
        Optional<CK_Item> oItem = INamed.getO(name, cp.items());
        if (! oItem.isPresent()) {
            return "Nelze předat nepřítomný předmět: " + name;
        }
        CK_Item item = oItem.get();
        if (item.weight() == CK_Item.HEAVY) {
            return "Nelze předat nepřenostný předmět: " + item.name();
        }
        return item;
    }



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================

}
