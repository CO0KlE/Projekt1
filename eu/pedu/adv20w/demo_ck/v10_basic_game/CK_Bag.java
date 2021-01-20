package eu.pedu.adv20w.demo_ck.v10_basic_game;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */

import eu.pedu.adv20w.api.IBag;

import java.util.ArrayList;
import java.util.Collection;



/*******************************************************************************
 * Instance třídy {@code CK_Bag} představuje úložiště,
 * do nějž hráči ukládají objekty sebrané v jednotlivých prostorech,
 * aby je mohli přenést do jiných prostorů a/nebo použít.
 * Úložiště má konečnou kapacitu definující maximální povolený
 * součet vah objektů vyskytujících se v úložišti.
 * <p>
 * V této hře je tímto úložištěm Karkulčin košík
 * s kapacitou 2 položky.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2020-Winter
 */
public   class CK_Bag
       extends CK_AItemContainer
    implements IBag
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==============

    /** Kapacita batohu. */
    static final int CAPACITY = 2;

    /** Jediná instance batohu ve hře. */
    private static final CK_Bag SINGLETON = new CK_Bag();



//\CV== CLASS VARIABLES (VARIABLE CLASS/STATIC ATTRIBUTES/FIELDS) ==============



//##############################################################################
//\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) =========================
//\CF== CLASS (STATIC) FACTORY METHODS =========================================

    /***************************************************************************
     * Tovární metoda vracející odkaz na jedninou existující instanci dané hry.
     *
     * @return Instance dané hry
     */
    static CK_Bag getInstance()
    {
        return SINGLETON;
    }



//\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================
//\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS ===========================
//\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS ===========================



//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============

    /** Kolekce všech prostorů světa hry. */
    private final Collection<CK_Item> items;



//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============

    /** Free capacity of the bag. */
    private int remains;



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     */
    @SuppressWarnings("unchecked")
    CK_Bag()
    {
        super("Košík");
        items = new ArrayList<>();
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================

    /***************************************************************************
     * Vrátí kapacitu batohu, tj. maximální povolený součet vah objektů,
     * které je možno současně uložit do batohu.
     *
     * @return Kapacita batohu
     */
    @Override
    public int capacity()
    {
        return CAPACITY;
    }



//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================

    /***************************************************************************
     * The method initializing the bag.
     * As the player of this game has an empty bag at the game beginning,
     * this method can only clean the {@link #items} collection.
     */
    public void initialize()
    {
        initializeItems();
        remains = CAPACITY;
    }


    /***************************************************************************
     * Removes the given item from the bag
     * and increases the free capacity of the bag.
     *
     * @param item Item taken away
     */
    @Override
    public void removeItem(CK_Item item)
    {
        super.removeItem(item);
        remains += item.weight();
    }


    /***************************************************************************
     * If the given item fits to the bag, it adds it;
     * after that it returns the message on the result.
     *
     * @param item The item that has to be added into the bag
     * @return The message on the result: {@code true} = was added,
     *         {@code false} = was not added
     */
    public boolean tryAddItem(CK_Item item)
    {
        if (item.weight() > remains) {
            return false;
        }
        addItem(item);
        remains -= item.weight();
        return true;
    }



//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
