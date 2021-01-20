package eu.pedu.adv20w.demo_ck.v10_basic_game;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */

import eu.pedu.adv20w.api.IPlace;

import java.util.Collection;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;



/*******************************************************************************
 * Instance třídy {@code CK_Place} představují prostory ve hře.
 * Dosažení prostoru si můžeme představovat jako částečný cíl,
 * kterého se hráč ve hře snaží dosáhnout.
 * Prostory mohou být místnosti, planety, životní etapy atd.
 * Prostory mohou obsahovat různé objekty,
 * které mohou hráči pomoci v dosažení cíle hry.
 * Každý prostor zná své aktuální bezprostřední sousedy
 * a ví, jaké objekty se v něm v daném okamžiku nacházejí.
 * Sousedé daného prostoru i v něm se nacházející objekty
 * se mohou v průběhu hry měnit.
 * <p>
 * V tomto programu jsou prostory ...
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2020-Winter
 */
public   class CK_Place
       extends CK_AItemContainer
    implements IPlace
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

    /** Stručný popis daného prostoru. */
    private final String description;

    /** Názvy výchozích sousedů. -*/
    private final String[] initialNeighborNames;

    /** Kolekce aktuálních sousedů. */
    private final Map<String, CK_Place> name2neighbor;

    /** Exportovaná kolekce aktuálních sousedů. */
    private final Collection<CK_Place> exportedNeighbors;



//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     *
     */
    CK_Place(String name, String description,
             String[] neighborNames, String... itemNames)
    {
        super(name, itemNames);
        this.description = description;
        this.initialNeighborNames = neighborNames;
        name2neighbor     = new HashMap<>();
        exportedNeighbors = Collections.
                            unmodifiableCollection(name2neighbor.values());
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================

    /***************************************************************************
     * Vrátí kolekci sousedů daného prostoru, tj. kolekci prostorů,
     * do nichž je možno se z tohoto prostoru přesunout příkazem typu
     * {@link eu.pedu.adv15p_fw.scenario.TypeOfStep#tsMOVE
     * TypeOfStep.tsMOVE}.
     *
     * @return Kolekce sousedů
     */
    @Override
    public Collection<CK_Place> neighbors()
    {
        return exportedNeighbors;
    }


    /***************************************************************************
     * Vrátí stručný popis daného prostoru.
     *
     * @return Stručný popis daného prostoru
     */
    public String getDescription()
    {
        return description;
    }



//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================

    /***************************************************************************
     * @todo initialize - Je třeba ještě doplnit komentář
     */
    void initialize()
    {
        initializeNeighbors();
        initializeItems();
    }



//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================

    /***************************************************************************
     * Inicializuje sousedy prostoru.
     */
    private void initializeNeighbors()
    {
        CK_World world = CK_World.getInstance();
        name2neighbor.clear();
        Arrays.stream(initialNeighborNames)
            .forEach(name ->
                name2neighbor.put(name.toLowerCase(),
                                  world.getPlace(name).get()));
    }

}
