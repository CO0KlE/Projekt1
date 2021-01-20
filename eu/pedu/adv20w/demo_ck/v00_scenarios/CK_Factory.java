package eu.pedu.adv20w.demo_ck.v00_scenarios;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */

import eu.pedu.adv20w.api.IGameFactory;
import eu.pedu.adv20w.api.IScenario;

import java.util.Arrays;
import java.util.List;



/*******************************************************************************
 * Instance třídy {@code CK_Factory} představují tovární objekty,
 * které jsou schopny na požádání dodat instance klíčových objektů aplikace,
 * konkrétně aktuální hry, jejích scénářů a uživatelského rozhraní.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2020-Winter
 */
public   class CK_Factory
    implements IGameFactory
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
     * Povinný konstruktor – vytvoří tovární objekt
     * poskytující klíčové objekty aplikace.
     */
    public CK_Factory()
    {
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================

    /***************************************************************************
     * Vrátí jméno autora/autorky programu ve formátu <b>PŘÍJMENÍ Křestní</b>,
     * tj. nejprve příjmení psané velkými písmeny a za ním křestní jméno,
     * u nějž bude velké pouze první písmeno a ostatní písmena budou malá.
     * Má-li autor programu více křestních jmen, může je uvést všechna.
     *
     * @return Jméno autora/autorky programu ve tvaru PŘÍJMENÍ Křestní
     */
    @Override
    public String authorName()
    {
        return "PECINOVSKÝ Rudolf";
    }


    /***************************************************************************
     * Vrátí identifikační řetězec autora/autorky programu
     * zapsaný VELKÝMI PÍSMENY.
     * Tímto řetězcem bývá většinou login do informačního systému školy.
     *
     * @return Identifikační řetězec autora/autorky programu
     */
    @Override
    public String authorID()
    {
        return "PECR999";
    }


    /***************************************************************************
     * Vrátí sezmam spravovaných scénářů.
     * <ul>
     *   <li>
     *     Scénářem s indexem 0 se musí jmenovat <b>{@code HAPPY}</b> a musí<br>
     *     představovat základní úspěšný scénář dané hry.<br>
     *     &nbsp;</li>
     *   <li>
     *     Scénářem s indexem 1 se musí jmenovat <b>{@code MISTAKE}</b> a musí<br>
     *     představovat základní chybový scénář specifikující reakce hry<br>
     *     na všechny běžné uživatelské chyby při zadávání základních příkazů.<br>
     *     &nbsp;</li>
     *   <li>
     *     Scénářem s indexem 2 se musí jmenovat <b>{@code MISTAKE_NS}</b> a musí<br>
     *     představovat chybový scénář specifikující reakce hry na všechny běžné<br>
     *     uživatelské chyby při zadávání povinných doplňkových příkazů.<br>
     *     &nbsp;</li>
     *   <li>
     *     Názvy a účely dalších scénářů jsou již na libovůli autora.<br>
     *     &nbsp;</li>
     * </ul>
     *
     * @return Seznam spravovaných scénářů
     */
    @Override
    public List<IScenario> scenarios()
    {
        return Arrays.asList(CK_Scenario.values());
    }


    /***************************************************************************
     * Vrátí scénář se zadaným názvem.
     *
     * @param name Název požadovaného scénáře
     * @return Scénář se zadaným názvem; není-li, vrátí {@code null}
     */
    @Override
    public IScenario scenario(String name)
    {
        return CK_Scenario.valueOf(name);
    }


    /***************************************************************************
     * Vrátí scénář se zadaným indexem.
     *
     * @param index Index požadovaného scénáře
     * @return Scénář se zadaným indexem; není-li, vrátí {@code null}
     */
    @Override
    public IScenario scenario(int index)
    {
        return CK_Scenario.values()[index];
    }



//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================
//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
