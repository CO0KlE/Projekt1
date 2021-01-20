package eu.pedu.adv20w._1_1245.tests;
import eu.pedu.adv20w.api.IGameFactory;
import eu.pedu.adv20w.testers.FactoryTester;
import eu.pedu.adv20w._1_1245.nejj04_nejedlik.*;


/*******************************************************************************
 * Knihovní třída s testy prověřujícími aplikaci.
 *
 * @author  Nejedlík JAN
 */
public class Tests_Scenario
{

    /***************************************************************************
     * Postupně simuluje běh podle šťastného scénáře jednou bez stavu
     * a podruhé s výpisem aktuálního stavu.
     */
    private static void simulateHappy()
    {
        E_Scenario happy = E_Scenario.valueOf("HAPPY");
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


    /***************************************************************************
     * Metoda spouštějící celou aplikaci.
     *
     * @param args Parametry příkazového řádku
     */
    public static void main(String[] args)
    {
//        simulateHappy();
        testScenarios(new Factory());
    }

}
