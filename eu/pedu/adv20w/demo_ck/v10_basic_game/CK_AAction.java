package eu.pedu.adv20w.demo_ck.v10_basic_game;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */

import eu.pedu.adv20w.api.IAction;
import eu.pedu.adv20w.api.INamed;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;



/*******************************************************************************
 * Třída {@code EmptyAAction} je společným rodičem všech tříd, jejichž instance
 * mají na starosti interpretaci příkazů zadávaných uživatelem hrajícím hru.
 * Název spouštěné akce bývá většinou první slovo řádku zadávaného
 * z klávesnice a další slova pak bývají interpretována jako parametry.
 * <p>
 * Můžete ale definovat příkaz, který odstartuje konverzaci
 * (např. s osobou přítomnou v místnosti) a tím přepne systém do režimu,
 * v němž se zadávané texty neinterpretují jako příkazy,
 * ale předávají se definovanému objektu až do chvíle,
 * kdy uživatel rozhovor ukončí a objekt rozhovoru přepne hru zpět
 * do režimu klasických příkazů.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2020-Winter
 */
abstract class CK_AAction
       extends CK_ANamed
    implements IAction
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==============

    private static final Map<String, CK_AAction> NAME_2_ACTION;

    static final Collection<CK_AAction> ACTIONS;

    static final Map<String, Boolean> name2awakened;



//\CV== CLASS VARIABLES (VARIABLE CLASS/STATIC ATTRIBUTES/FIELDS) ==============

    /** Příznak toho, že hra právě běží. */
    static boolean isAlive;



//##############################################################################
//\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) =========================

    static {
        isAlive = false;
        name2awakened = new HashMap<>();

        NAME_2_ACTION = new HashMap<>();
        Consumer<CK_AAction> put =
                action -> NAME_2_ACTION.put(action.name().toLowerCase(),
                                            action);
        put.accept(new CK_A_Help());
        put.accept(new CK_A_Take());
        put.accept(new CK_A_Put ());
        put.accept(new CK_A_GoTo());
        put.accept(new CK_A_End ());

        put.accept(new CK_A_Awaken      ());
        put.accept(new CK_A_SayHello    ());
        put.accept(new CK_A_Congratulate());
        put.accept(new CK_A_Give        ());

        ACTIONS = Collections.unmodifiableCollection(NAME_2_ACTION.values());
    }



//\CF== CLASS (STATIC) FACTORY METHODS =========================================
//\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================

    /***************************************************************************
     * Returns a collection of all actions that can be used in the game.
     *
     * @return A collection of all actions usable in the game
     */
    public static Collection<CK_AAction> getAllActions()
    {
        Collection<CK_AAction> collection, result;
        collection = NAME_2_ACTION.values();
        result     = Collections.unmodifiableCollection(collection);
        return result;
    }



//\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS ===========================

    /***************************************************************************
     * Zpracuje zadaný příkaz a vrátí text zprávy pro uživatele.
     *
     * @param command Zadávaný příkaz
     * @return Textová odpověď hry na zadaný příkaz
     */
//    @Override
    public static String executeCommand(String command)
    {
        command = command.trim();
        if (command.isEmpty()) {
            if(isAlive) {
                return "Prázdný příkaz lze použít pouze pro start hry";
            }
            isAlive = true;
            initialize();
            return "Vítejte!\n"
                 + "Toto je příběh o Červené Karkulce, babičce a vlkovi.\n"
                 + "Nevíte-li, jak pokračovat, zadejte příkaz '?'.";
        }
        else {
            if (isAlive) {
                if (command.isEmpty()) {
                    return "Prázdný příkaz lze použít pouze pro start hry";
                }
                String[]       words = command
                                      .trim()
                                      .toLowerCase()
                                      .split("\\s+");
                String   acttionName = words[0];
                CK_AAction    action = NAME_2_ACTION.get(acttionName);
                String        answer;
                if (action == null) {
                    answer = "Tento příkaz neznám: " + acttionName;
                }
                else {
                    answer = action.execute(words);
                }
                return answer;
            }
            else {
                return "\nPrvním příkazem není startovací příkaz."
                     + "\nHru, která neběží, lze spustit pouze "
                     + "startovacím příkazem.\n";
            }
        }
    }



//\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS ===========================

    /***************************************************************************
     * Inicializuje aplikaci při startu další hry.
     */
    private static void initialize()
    {
        CK_World.getInstance().initialize();
        CK_Bag  .getInstance().initialize();

        name2awakened.put("Babička", false);
        name2awakened.put("Vlk",     false);
    }



//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============

    /** Stručný popis dané akce. */
    private final String description;



//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     * Vytvoří rodičovský podobjekt vytvářené akce.
     *
     * @param name  Název vytvářené akce = text, který musí hráč zadat
     *              jako počáteční slovo zadávaného příkazu
     * @param description Stručný popis vytvářené akce
     */
    CK_AAction(String name, String description)
    {
        super(name);
        this.description = description;
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================

    /***************************************************************************
     * Metoda realizující reakci hry na zadání daného příkazu.
     * Počet parametrů je závislý na konkrétní akci,
     * např. akce typu <i>konec</i> a <i>nápověda</i> nemají parametry,
     * akce typu <i>jdi</i> a <i>seber</i> mají jeden parametr
     * akce typu <i>použij</i> muže mít dva parametry atd.
     *
     * @param arguments Parametry příkazu – akce;
     *                  jejich počet muže byt pro každou akci jiný,
     *                  ale pro všechna spuštění stejné akce je stejný
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    abstract
    public String execute(String... arguments)
    ;



//\IG== INSTANCE GETTERS AND SETTERS ===========================================

    /***************************************************************************
     * Vrátí popis příkazu s vysvětlením jeho funkce
     * a významu jednotlivých parametru.
     *
     * @return Popis příkazu
     */
    @Override
    public String description()
    {
        return description;
    }



//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================

    /***************************************************************************
     * Vrátí odkaz na h-objekt (osobu či zvíře), který lze budit a zdravit
     * a je v aktuálním prostoru; není-li takový, vrátí {@code null}.
     *
     * @return Odkaz na požadovaný h-objekt či {@code null}
     */
    CK_Item whoIsHere()
    {
        CK_World world = CK_World.getInstance();
        CK_Place    cp = world.currentPlace();
        CK_Item  item = null;
        //Zjistí, zda je v protoru někdo, koho lze budit
        for (String name : name2awakened.keySet()) {
            Optional<CK_Item> oItem =  INamed.getO(name, cp.items());
            if (oItem.isPresent()) {
                item = oItem.get();
                break;
            }
        }
        return item;
    }



//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
