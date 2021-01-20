package eu.pedu.adv20w.demo_ck.v10_basic_game;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */

import eu.pedu.adv20w.api.BasicActions;
import eu.pedu.adv20w.api.IAction;
import eu.pedu.adv20w.api.IBag;
import eu.pedu.adv20w.api.IGame;
import eu.pedu.adv20w.api.IWorld;

import java.util.Collection;



/*******************************************************************************
 * Instance třídy {@code CK_Game} mají na starosti logiku hry.
 * Jsou schopny akceptovat jednotlivé příkazy a poskytovat informace
 * o průběžném stavu hry a jejích součástí.
 * <p>
 * Třída hry musí být definována jako jedináček (singleton)
 * a kromě metod deklarovaných v interfejsu {@link IGame} musí definovat
 * statickou tovární metodu {@code getInstance()}.
 * Splnění této podmínky nemůže prověřit překladač,
 * ale prověří ji až následné testy hry.
 * <p>
 * Instance třídy {@code EmptyGame} představují prototypy instancí hry,
 * které ještě nejsou schopny plnohodnotného spuštění a slouží pouze
 * ke kompletaci těch vlastností správce scénářů, které bude v budoucnu
 * plnit ve spolupráci s plnohodnotnou hrou.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2020-Winter
 */
public   class CK_Game
    implements IGame
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==============

    /** Odkaz na jedinou instanci (jedináčka) této hry. */
    private static final CK_Game SINGLETON = new CK_Game();

    /** Přepravka s názvy povinných akcí. */
    private static final BasicActions BASIC_ACTIONS =
                     new BasicActions("Jdi", "Vezmi", "Polož",
                                      "?",   "Konec");



//\CV== CLASS VARIABLES (VARIABLE CLASS/STATIC ATTRIBUTES/FIELDS) ==============



//##############################################################################
//\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) =========================
//\CF== CLASS (STATIC) FACTORY METHODS =========================================

    /***************************************************************************
     * Tovární metoda vracející odkaz na jedninou existující instanci dané hry.
     *
     * @return Instance dané hry
     */
    public static CK_Game getInstance()
    {
        return SINGLETON;
    }



//\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================
//\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS ===========================

//\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS ===========================




//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============
//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     * Soukromý konstruktor definující jedinou instanci.
     * Protože je soukromý, musí být definován, i když má prázdné tělo.
     */
    private CK_Game()
    {
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================

    /***************************************************************************
     * Vrátí informaci o tom, je-li hra aktuálně spuštěná.
     * Spuštěnou hru není možno pustit znovu.
     * Chceme-li hru spustit znovu, musíme ji nejprve ukončit.
     *
     * @return Je-li hra spuštěná, vrátí {@code true},
     *         jinak vrátí {@code false}
     */
    @Override
    public boolean isAlive()
    {
        return CK_AAction.isAlive;
    }


    /***************************************************************************
     * Vrátí odkaz na batoh, do nějž bude hráč ukládat sebrané předměty.
     *
     * @return Batoh, do nějž hráč ukládá sebrané předměty
     */
    @Override
    public IBag bag()
    {
        return CK_Bag.getInstance();
    }


    /***************************************************************************
     * Vrátí kolekci všech příkazů použitelných ve hře.
     *
     * @return Kolekce všech příkazů použitelných ve hře
     */
    @Override
    public Collection<? extends IAction> allActions()
    {
        return CK_AAction.ACTIONS;
    }


    /***************************************************************************
     * Vrátí odkaz na přepravku s názvy povinných příkazů, tj. příkazů pro
     * <ul>
     *   <li>přesun hráče do jiného prostoru,</li>
     *   <li>zvednutí objektu (odebrání z prostoru a vložení do batohu),</li>
     *   <li>položení objektu (odebrání z batohu a vložení do prostoru),</li>
     *   <li>vyvolání nápovědy,</li>
     *   <li>okamžité ukončení hry.</li>
     * </ul>
     *
     * @return Přepravka názvy povinných příkazů
     */
    @Override
    public BasicActions basicActions()
    {
        return BASIC_ACTIONS;
    }


    /***************************************************************************
     * Vrátí odkaz na svět, v němž se hra odehrává.
     *
     * @return Svět, v němž se hra odehrává
     */
    @Override
    public IWorld world()
    {
        return CK_World.getInstance();
    }



//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================

    /***************************************************************************
     * Zpracuje zadaný příkaz a vrátí text zprávy pro uživatele.
     *
     * @param command Zadávaný příkaz
     * @return Textová odpověď hry na zadaný příkaz
     */
    @Override
    public String executeCommand(String command)
    {
        return CK_AAction.executeCommand(command);
    }


    /***************************************************************************
     * Ukončí celou hru a vrátí alokované prostředky.
     */
    @Override
    public void stop()
    {
        CK_AAction.isAlive = false;
    }



//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
