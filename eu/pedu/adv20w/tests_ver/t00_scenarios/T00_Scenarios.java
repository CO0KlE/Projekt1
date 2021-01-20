package eu.pedu.adv20w.tests_ver.t00_scenarios;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */

import eu.pedu.adv20w.api.IGameFactory;
import eu.pedu.adv20w.api.IScenario;
import eu.pedu.adv20w.testers.FactoryTester;



/*******************************************************************************
 * Knihovní třída s testy prověřujícími aplikaci.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2020-Winter
 */
public class T00_Scenarios
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==============
//\CV== CLASS VARIABLES (VARIABLE CLASS/STATIC ATTRIBUTES/FIELDS) ==============



//##############################################################################
//\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) =========================
//\CF== CLASS (STATIC) FACTORY METHODS =========================================
//\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================
//\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS ===========================
//\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS



//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============

    /** Tovární objekt poskytující testované objekty. */
    private final IGameFactory factory;



//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     */
    private T00_Scenarios(IGameFactory factory)
    {
        this.factory = factory;
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================
//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================

    /***************************************************************************
     * Postupně simuluje běh podle šťastného scénáře jednou bez stavu
     * a podruhé s výpisem aktuálního stavu.
     */
    private static void simulateHappy(IGameFactory factory)
    {
        IScenario happy = factory.scenario(IScenario.HAPPY_NAME);
        happy.simulateSimple();
        System.out.println("\n##########################################\n");
        happy.simulateComplex();
    }


    /***************************************************************************
     * Otestuje všechny scénáře poskytované zadanou továrnou.
     */
    private static void testScenarios(IGameFactory factory)
    {
        FactoryTester tester = new FactoryTester(factory);
        tester.testForLevel(FactoryTester.MISTAKES_NS_LEVEL);
    }



//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
//
//##############################################################################
//== MAIN METHOD ===============================================================

    /***************************************************************************
     * Spustí simulaci hry následovanou testem definovaných scénářů.
     *
     * @param args Parametry příkazového řádku
     */
    public static void main(String[] args)
    {
        IGameFactory factory = new
                eu.pedu.adv20w.demo_ck.
                    v00_scenarios.CK_Factory

//            eu.pedu.adv20w._1_1245.
//                dvop10_dvorak.factory
//                jirj23_jirku.GameFactory
//                matd02_matejcek.Factory
//                mesi01_meshkov.DemoFactory
//                nedm03_nedbal.Factory
//                nejj04_nejedlik.Factory_nejj04
//                trat13_tranova.DemoFactory
        ();

//        simulateHappy(factory);
        testScenarios(factory);
    }

}
