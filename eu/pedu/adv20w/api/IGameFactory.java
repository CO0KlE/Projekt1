package eu.pedu.adv20w.api;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */

import java.lang.reflect.InvocationTargetException;
import java.util.List;



/*******************************************************************************
*  Instance interfejsu {@code IGameFactory} představují tovární objekty,
 * které jsou schopny na požádání dodat instance klíčových objektů aplikace,
 * konkrétně aktuální hry, jejích scénářů a uživatelského rozhraní.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2020-Winter
 */
public interface IGameFactory
         extends IAuthor
{
//\CC== CLASS (STATIC) CONSTANTS ===============================================

    /** Název základního úspěšného scénáře. */
    public static final String HAPPY_SCENARIO_NAME = "HAPPY";

    /** Název základního chybového scénáře. */
    public static final String MISTAKE_SCENARIO_NAME = "MISTAKE";

    /** Název základního chybového scénáře nestandardních kroků. */
    public static final String MISTAKE_NS_SCENARIO_NAME = "MISTAKE_NS";



//\CM== CLASS (STATIC) METHODS =================================================

    /***************************************************************************
     * Vrátí odkaz na instanci zadané tovární třídy. Předpokládá přitom,
     * že tato třída má dostupný nulární (= bezparametrický) konstruktor.
     *
     * @param <T>           Typ tovární třídy
     * @param factoryClass  Class-objekt tovární třídy
     * @return Požadovaný odkaz
     * @throws IllegalArgumentException Instanci zadané třídy
     *                                  se nepodařilo vytvořit
     */
    public static <T extends IGameFactory>
           T getInstanceOfFactory(Class<T> factoryClass)
    {
        T result;
        try {
            result = factoryClass.getDeclaredConstructor().newInstance();
        }
        catch (IllegalAccessException | IllegalArgumentException |
               InstantiationException | NoSuchMethodException    |
               SecurityException      | InvocationTargetException  ex)
        {
            throw new IllegalArgumentException(
                "\nNepodařilo se vytvořit instanci třídy " + factoryClass, ex);
        }
        return result;
    }



//##############################################################################
//\AG== ABSTRACT GETTERS AND SETTERS ===========================================

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
//    @Override
    public List<? extends IScenario> scenarios()
    ;


    /***************************************************************************
     * Vrátí scénář se zadaným názvem.
     *
     * @param name Název požadovaného scénáře
     * @return Scénář se zadaným názvem; není-li, vrátí {@code null}
     */
//    @Override
    public IScenario scenario(String name)
    ;


    /***************************************************************************
     * Vrátí scénář se zadaným indexem.
     *
     * @param index Index požadovaného scénáře
     * @return Scénář se zadaným indexem; není-li, vrátí {@code null}
     */
//    @Override
    public IScenario scenario(int index)
    ;



//\AM== REMAINING ABSTRACT METHODS =============================================
//\DG== DEFAULT GETTERS AND SETTERS ============================================

    /***************************************************************************
     * Vrátí odkaz na (jedinou) instanci textové verze hry;
     * dokud ještě hra neexistuje, vyhazuje po zavolání výjimku
     * {@link UncompletedMethodException}.
     *
     * @return Požadovaný odkaz
     * @throws UnsupportedOperationException
     *         Potomek metodu korektně nepřebil
     */
//    @Override
    default
    public IGame game()
    {
        throw new UnsupportedOperationException("Není korektně definována "
                + "tovární metoda vracející instanci hry");
    }


    /***************************************************************************
     * Vrátí odkaz na instanci třídy realizující uživatelské rozhraní
     * textové verze hry;
     * dokud tato třída neexistuje, vyhazuje po zavolání výjimku
     * {@link UncompletedMethodException}.
     *
     * @return Požadovaný odkaz
     * @throws UnsupportedOperationException
     *         Potomek metodu korektně nepřebil
     */
//    @Override
    default
    public IUI userInterface()
    {
        throw new UnsupportedOperationException( "Není korektně definována "
                + "tovární metoda vracející uživatelské rozhraní");
    }



//\DM== REMAINING DEFAULT METHODS ==============================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
