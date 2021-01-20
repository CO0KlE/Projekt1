package eu.pedu.adv20w.api;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */

import java.util.Collection;



/*******************************************************************************
 * Instance interfejsu {@code IPlace} představují prostory ve hře.
 * Dosažení prostoru si můžeme představovat jako částečný cíl,
 * kterého se hráč ve hře snaží dosáhnout.
 * Prostory mohou být místnosti, planety, životní etapy atd.
 * Prostory mohou obsahovat různé objekty,
 * které mohou hráči pomoci v dosažení cíle hry.
 * Každý prostor zná své aktuální bezprostřední sousedy
 * a ví, jaké objekty se v něm v daném okamžiku nacházejí.
 * Sousedé daného prostoru i v něm se nacházející objekty
 * se mohou v průběhu hry měnit.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2020-Winter
 */
public interface IPlace
         extends INamed, IItemContainer
{
//\CC== CLASS (STATIC) CONSTANTS ===============================================
//\CM== CLASS (STATIC) METHODS =================================================



//##############################################################################
//\AG== ABSTRACT GETTERS AND SETTERS ===========================================

    /***************************************************************************
     * Vrátí kolekci sousedů daného prostoru, tj. kolekci prostorů,
     * do nichž je možno se z tohoto prostoru přesunout příkazem typu
     * {@link eu.pedu.adv20w_fw.scenario.TypeOfStep#tsMOVE
     * TypeOfStep.tsMOVE}.
     *
     * @return Kolekce sousedů
     */
//    @Override
    public Collection<? extends IPlace> neighbors()
    ;


    /***************************************************************************
     * Vrátí kolekci objektů nacházejících se v daném prostoru.
     *
     * @return Kolekce objektů nacházejících se v daném prostoru
     */
    @Override
    public Collection<? extends IItem> items()
    ;



//\AM== REMAINING ABSTRACT METHODS =============================================
//\DG== DEFAULT GETTERS AND SETTERS ============================================
//\DM== REMAINING DEFAULT METHODS ==============================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
