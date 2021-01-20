package eu.pedu.adv20w.testers;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */

import eu.pedu.adv20w.api.IGameFactory;
import eu.pedu.adv20w.api.IScenario;
import eu.pedu.adv20w.api.ScenarioStep;
import eu.pedu.adv20w.api.TypeOfScenario;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static eu.pedu.adv20w.testers.ConditionalPrinter.*;
import static eu.pedu.adv20w.testers.FormatStrings.*;



/*******************************************************************************
 * Instance třídy {@code FactoryTester} umějí otestovat
 * splnění základních povinných vlastností herní továrny.
 * Testují však pouze korektnost vlastních továren
 * a korektnost jimi spravovaných scénářů.
 * Nepokouší se pomocí scénářů zadaného továrny příslušnou hru testovat.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2020-Winter
 */
public class FactoryTester
     extends ATester
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==============

    /** Hladina, při níž se testují
     *  pouze základní vlastnosti továrního objektu. */
    public static final int FACTORY_ONLY = 0;

    /** Hladina, při níž se testuje tovární objekt plus
     *  jím poskytovaný správce scénářů. */
    public static final int HAPPY_LEVEL = 1;

    /** Hladina, při níž se testuje tovární objekt plus
     *  jím poskytovaný správce scénářů. */
    public static final int MISTAKES_LEVEL = 2;

    /** Hladina, při níž se testuje tovární objekt plus
     *  jím poskytovaný správce scénářů. */
    public static final int MISTAKES_NS_LEVEL = 3;

    /** Hladina, při níž se testuje tovární objekt plus
     *  jím poskytovaný správce scénářů a hra. */
    public static final int GAME_LEVEL = 4;

    /** Hladina, při níž se testuje tovární objekt plus
     *  jím poskytovaný správce scénářů, hra a textové uživatelské rozhraní. */
    public static final int TEXTUI_LEVEL = 5;

    /** Seznam lokalizovaných zpráv. */
    private static final List<String> ERR_MSG;

    /** Index zprávy o různých jménech autorů. */
    private static final int INSTANCE_NOT_GET_MSG;

    /** Index textu "správce scénářů". */
    private static final int SCEANRIO_MGR;

    /** Index textu "hry". */
    private static final int GAME;

    /** Index textu "uživatelského rozhraní". */
    private static final int UI;



//\CV== CLASS VARIABLES (VARIABLE CLASS/STATIC ATTRIBUTES/FIELDS) ==============



//##############################################################################
//\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) =========================

    static {
        ERR_MSG = new ArrayList<>();

        SCEANRIO_MGR = ERR_MSG.size();
        ERR_MSG.add("správce scénářů");

        GAME = ERR_MSG.size();
        ERR_MSG.add("hry");

        UI = ERR_MSG.size();
        ERR_MSG.add("správce scénářů");

        INSTANCE_NOT_GET_MSG = ERR_MSG.size();
        ERR_MSG.add("Při pokusu o získání instance %s byla vyhozena výjimka %s"
           + "\nTřída použitého generátoru: %s");

    }
//\CF== CLASS (STATIC) FACTORY METHODS =========================================
//\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================
//\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS ===========================




//\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS ===========================




//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============

    /** Kompletní zpráva o průběhu testu. */
    private final StringBuilder verboseMessageBuilder;



//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============

    /** Přepravka se souhrnem informací zjištěných ze scénářů spravovaných
     *  testovaným správcem scénářů. */
    protected ScenariosSummary scenariosSummary;



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     * Vytvoří objekt schopný testovat správce scénářů.
     *
     * @param factory Testovaný správce scénářů
     */
    public FactoryTester(IGameFactory factory)
    {
        super(factory);
        this.verboseMessageBuilder = new StringBuilder();
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================
//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================

    /***************************************************************************
     * Prověří formální korektnost metod zadaného továrního objektu,
     * přičemž sada prověřovaných metod je dána zadanou hladinou.
     *
     * @param level Hloubka testování určující sadu testovaných metod.
     *              Úrovně jsou definovány jako statické atributy.
     */
    public void testForLevel(int level)
    {
        verifyAuthor();
        scenariosSummary = verifyScenarios(level);
        if (level < GAME_LEVEL)    { return; }     //==========>

//        testGame();
    }



//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================

    /***************************************************************************
     * Inicializuje {@link StringBuilder}, do nějž se budou zapisovat výsledky.
     */
    private void initResultInformation()
    {
        verboseMessageBuilder.delete(0, verboseMessageBuilder.length());
    }


    /***************************************************************************
     * Prověří, že základní úspěšný scénář dodaný testovaným správcem
     * je prvním scénářem nabízeným jeho iterátorem.
     *
     * @param manager Testovaný správce scénářů
     * @throws TestException Chyba v testované aplikaci
     */
    private void requiredScenarios(int level)
    {
        level = Math.min(level, 3);
        List<? extends IScenario> scenarios = factory.scenarios();
        if (scenarios.size() < level) {
            throw new RuntimeException(
                "\nTovárna neposkytuje povinné " + level + " scénáře.");
        }
        for (int i=0;   i < level;   i++) {
            IScenario scenario = scenarios.get(i);
            TypeOfScenario tos = TypeOfScenario.values()[i];
            if ((scenario.type().ordinal() != i)  ||
               ! scenario.name().equals(tos.requiredName()) )
            {
                throw new TestException("\n"
                    + "Továrna neposkytuje " + tos.description()
                    + " zařazený jako scénář s indexem " + i
                    + "\nPožadováno: tos=" + tos
                    +            ", name=" + tos.requiredName()
                    + "\nObdrženo:  type=" + scenario.type()
                    +            ", name=" + scenario.name());
            }
        }
    }


    /***************************************************************************
     * Ověří, že udávané jméno autora odpovídá zadaným konvencím,
     * tj. že obsahuje nejméně dvě slova, první z nich je velkými písmeny
     * a druhé začíná velkým písmenem.
     *
     * @return Vektor stringů s jednotlivými slovy jména autora
     *         zbavenými diakritiky
     */
    private String[] verifyAuthor()
    {
        //Jméno zbavíme diakritiky pro snazší následnou kontrolu
        String authorASCII = Normalizer.normalize(factory.authorName(),
                                                  Normalizer.Form.NFD)
                                       .replaceAll("[^\\p{ASCII}]", "");
        String[] wordsInName = authorASCII.split(" ");
        String[] check       = authorASCII.split("\\s+");
        if (wordsInName.length != check.length) {
            ERROR("Špatně použité bílé znaky ve jméně autora.");
        }
        if ((wordsInName   .length    < 2)  ||
            (wordsInName[0].length() == 0)  ||
            (wordsInName[1].length() == 0))
        {
            ERROR("Autor nemá uvedeno příjmení + křestní jméno");
        }
        String surname   = wordsInName[0];
        String firstName = wordsInName[1];
        if (! surname.matches("[A-Z]+")) {
            ERROR("Prvním slovem jména autora není příjmení " +
                  "zapsané velkými písmeny");
        }
        if (! firstName.matches("[A-Z][a-z]+")) {
            ERROR("Druhé slovo jména autora nemá " +
                  "první písmeno velké a ostatní malá");
        }
        return wordsInName;
    }


    /***************************************************************************
     * Základní test ověřující,
     * jestli tovární třída vyhovuje zadaným okrajovým podmínkám, tj. jestli:
     * <ul>
     *   <li>Umí vrátit správně naformátované jméno autora/autorky hry
     *       a jeho/její xname.</li>
     *   <li>Dodá tři povínné scénáře.</li>
     *   <li>Základní úspěžšný scénář má následující vlastnosti:
     *     <ul>
     *       <li>Startovní příkaz, jehož název je prázdný řetězec</li>
     *       <li>Minimální požadovaný počet kroků</li>
     *       <li>Minimální počet navštívených místností</li>
     *       <li>Minimální počet "zahlédnutých" místností</li>
     *       <li>Použití příkazů pro standardní přechod z prostoru do prostoru
     *         zvednutí nějakého objektu a položení nějakého objektu</li>
     *       <li>Použití předepsaných nadstavbových akcí</li>
     *     </ul>
     *   </li>
     *   <li>Základní chybový scénář má následující vlastnosti:
     *     <ul>
     *       <li>Startovní příkaz, jehož název je prázdný řetězec</li>
     *       <li>Použití všech povinných chybových typů kroku
     *         definovaných ve třídě
     *         {@link eu.pedu.adv20w_fw.scenario.TypeOfStep}</li>
     *       <li>Vyvolání nápovědy</li>
     *       <li>Ukončení příkazem pro nestandardní ukončení hry</li>
     *     </ul>
     *   </li>
     * </ul>
     *
     * @param level Hloubka testování určující sadu testovaných metod.
     *              Úrovně jsou definovány jako statické atributy.
     * @return Vyhovuje-li, vrátí {@code true}, jinak vrátí {@code false}
     */
    private ScenariosSummary verifyScenarios(int level)
    {
        initResultInformation();    //Inicializace
        Date startTime =  new Date();
        String message = String.format(
                         "Autor testované továrny: %s – %s\n" +
                         "Instace třídy: %s%n" +
                         "########## START: %ta %<TF — %<tT\n",
                         factory.authorID(), factory.authorName(),
                         factory.getClass().getName(), startTime);
        verboseMessageBuilder.append(message);
        System.out.println(message);
        requiredScenarios(level);
        writeInvitation();

        scenariosSummary = ScenarioTester.testScenariosOf(factory, level);
        boolean ok = scenariosSummary.ok;

        Date stopTime =  new Date();
        long duration = (stopTime.getTime() - startTime.getTime());
        message = String.format("The scenario test was %sSUCCESSFUL",
                                (ok ? "" : "UN"));
        message = String.format(
            "########## STOP: %ta %<TF — %<tT\n  —  " +
            "Test duration: %d ms – %s\n" +
            "End of scenario tests from: %s – %s" + N_HASHES_N,
            stopTime, duration, message,
            factory.authorID(), factory.authorName());
        verboseMessageBuilder.append(message);
        prln(message);
        return scenariosSummary;
    }


    /***************************************************************************
     * Vypíše úvodní zprávu hry, ze které by se mělo dát odhadnout,
     * o čem hra bude.
     *
     * @param manager Správce scénářů hry, jejíž uvítání se vypisuje
     */
    private void writeInvitation()
    {
        ScenarioStep initialStep = factory.scenario(0).steps().get(0);
        prf("Welcome message:\n" +
            "================\n%s\n", initialStep.message);
    }



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
