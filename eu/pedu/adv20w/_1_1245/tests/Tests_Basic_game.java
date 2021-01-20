package eu.pedu.adv20w._1_1245.tests;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */

import eu.pedu.adv20w._1_1245.nejj04_nejedlik.Factory;
import eu.pedu.adv20w.api.IGameFactory;
import eu.pedu.adv20w.testers.ASolutionTester;
import eu.pedu.adv20w.testers.ATestVisitor;


/*******************************************************************************
 * Instance třídy {@code T20w10_Basic_game} testují hru bez modifikací
 * vytvořenou podle zadání ze zimního semestru 2020.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2020-Winter
 */
public class Tests_Basic_game
     extends ASolutionTester
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==============

    /** Identifikátor testovaného zadání. */
    public static final String TEST_ID = "20w10";

    /** Popis požadované modifikace. */
    public static final String DESCRIPTION =
      "Hra podle původního zadání bez modifikací";
//
//    /** Seznam výsledků provedených testů. */
//    private static final List<ScenariosSummary> INFOS = new ArrayList<>();



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
     * Vytvoří tester prověřující řešení základního zadání.
     */
    public Tests_Basic_game()
    {
        super(TEST_ID, DESCRIPTION, Visitor20w00::new);
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================
//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================
//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================

////////////////////////////////////////////////////////////////////////////////
//\N1C /////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

    /***************************************************************************
     * Instance třídy {@code Visitor18s00} představují návštěvníky prověřující
     * splnění základního zadání semestrální práce.
     */
    private static class Visitor20w00
                 extends ATestVisitor
    {
    //\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==========
    //\CV== CLASS VARIABLES (VARIABLE CLASS/STATIC ATTRIBUTES/FIELDS) ==========



    //##########################################################################
    //\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) =====================
    //\CF== CLASS (STATIC) FACTORY METHODS =====================================
    //\CG== CLASS (STATIC) GETTERS AND SETTERS =================================
    //\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS =======================
    //\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS =======================



    //##########################################################################
    //\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===========
    //\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===========



    //##########################################################################
    //\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===============================

        /***********************************************************************
         * Vytvoří návštěvníka pro prověření základní funkčnosti hry
         * poskytnuté zadaným továrním objektem.
         *
         * @param myTest  Zadavatel požadující vyřešení základního zadání
         * @param factory Tovární objekt poskytující základní objekty
         *                prověřované aplikace
         */
        Visitor20w00(ASolutionTester myTest, IGameFactory factory)
        {
            super(myTest, factory);
        }



    //\IA== INSTANCE ABSTRACT METHODS ==========================================
    //\IG== INSTANCE GETTERS AND SETTERS =======================================

        /***********************************************************************
         * Vrátí sdružený tester, jehož zadání prověřuje.
         *
         * @return Sdružený tester
         */
        @Override
        public ASolutionTester getTester()
        {
            return myTest;
        }



    //\IM== INSTANCE REMAINING NON-PRIVATE METHODS =============================
    //\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =============================



    //##########################################################################
    //\NT== NESTED DATA TYPES ==================================================
    }



//##############################################################################
//\MM== MAIN METHOD ============================================================

    /***************************************************************************
     * Metoda spouštějící celou aplikaci.
     *
     * @param args Parametry příkazového řádku
     */
    public static void main(String[] args)
    {
        Tests_Basic_game tester = new Tests_Basic_game();
        IGameFactory factory = new Factory();

//            new eu.pedu.adv20w._1_1245.
//                pecr910_pecinovsky.CK_Factory
//

        tester.test(factory);
        System.exit(0);
    }
}
