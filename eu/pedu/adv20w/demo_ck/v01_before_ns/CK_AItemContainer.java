package eu.pedu.adv20w.demo_ck.v01_before_ns;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */

import eu.pedu.adv20w.api.INamed;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;



/*******************************************************************************
 * Instance abstraktní třídy {@code AItemContainer} jsou
 * rodičovskými podobjekty objektů, sloužícími jako kontejnery h-objektů,
 * konkrétně batohu a prostorů.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2020-Winter
 */
abstract class CK_AItemContainer
       extends CK_ANamed
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

    /** Names of items in this container at the game beginning. */
    private final String[] itemNames;

    /** Výchozí h-objekty v prostoru. -*/
    private final ArrayList<CK_Item> initialItems;

    /** Names of items currently present in this container. */
    private final Collection<CK_Item> items;

    /** Immutable collection of items currently present in this container,
     *  that continuously maps the {@link #items} collection content. */
    private final Collection<CK_Item> exportedItems;



//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     * Creates the parent sub-object of the container of items
     * with the given names of its initial items.
     *
     * @param name      Name of the child object
     * @param itemNames Names of items in the container at the game beginning
     */
    CK_AItemContainer(String name, String... itemNames)
    {
        super(name);
        this.itemNames     = itemNames;
        initialItems = new ArrayList<>();
        for (String itemName : itemNames) {
            initialItems.add(new CK_Item(itemName));
        }
        this.items         = new ArrayList<>(initialItems);
        this.exportedItems = Collections.unmodifiableCollection(items);
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================

    /***************************************************************************
     * Vrátí kolekci objektů nacházejících se v daném prostoru.
     *
     * @return Kolekce objektů nacházejících se v daném prostoru
     */
    public Collection<CK_Item> items()
    {
        return exportedItems;
    }


    /***************************************************************************
     * Returns the item with the given name wrapped into
     * an {@link Optional}{@code <}{@link CK_Item}{@code >}.
     *
     * @param  name Name of the asked item
     * @return The item with the given name wrapped into
     *         an {@link Optional}{@code <}{@link CK_Item}{@code >}
     */
    public Optional<CK_Item> oItem(String name)
    {
        return INamed.getO(name, items);
    }



//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================

    /***************************************************************************
     * Adds the given item into the container.
     *
     * @param item The item that has to be added into the container
     */
    public void addItem(CK_Item item)
    {
        items.add(item);
    }


    /***************************************************************************
     * Cleans the container and saves into it the items
     * located in the given container at the game beginning.
     */
    public void initializeItems()
    {
        items.clear();
        items.addAll(initialItems);
//
//        Arrays.stream(itemNames)
//              .map(CK_Item::new)
//              .forEach(items::add);
    }


    /***************************************************************************
     * Removes the given item from this container.
     *
     * @param item Item to be removed
     */
    public void removeItem(CK_Item item)
    {
        items.remove(item);
    }



//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
