package eu.pedu.adv20w.api;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */

import java.util.List;



/*******************************************************************************
 * Instance interfejsu {@code IScenario} představují scénáře,
 * podle nichž je možno simulovat věh hry nebo hru testovat.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2020-Winter
 */
public interface IScenario
{
//\CC== CLASS (STATIC) CONSTANTS ===============================================

    /** Povinný název nultého scénáře. */
    String HAPPY_NAME       = "HAPPY";

    /** Povinný název prvního scénáře. */
    String MISTAKE_NAME     = "MISTAKES";

    /** Povinný název druhého scénáře. */
    String MISTAKE_NS_NAME  = "MISTAKES_NS";



//\CM== CLASS (STATIC) METHODS =================================================



//##############################################################################
//\AG== ABSTRACT GETTERS AND SETTERS ===========================================
//\AM== REMAINING ABSTRACT METHODS =============================================

    /***************************************************************************
     * Vrátí název daného scénáře.
     *
     * @return Název daného scénáře
     */
    public String name()
    ;


    /***************************************************************************
     * Vrátí seznam kroků daného scénáře.
     *
     * @return Seznam kroků daného scénáře
     */
    public List<ScenarioStep> steps()
    ;

    /***************************************************************************
     * Vrátí typ daného scénáře.
     *
     * @return Typ daného scénáře
     */
    public TypeOfScenario type()
    ;




//\DG== DEFAULT GETTERS AND SETTERS ============================================
//\DM== REMAINING DEFAULT METHODS ==============================================

    /***************************************************************************
     * Vypíše na standardní výstup simulovaný průběh hry podle daného scénáře,
     * přičemž u každého kroku vypíše pouze zadávaný příkaz a odpověď hry.
     */
    default
    public void simulateSimple()
    {
        for(ScenarioStep step : steps()) {
            System.out.println(
                "\n" + step.index + ". " + step.command
                  + "\n----------"
                  + "\n" + step.message
                  + "\n====================================================="
            );
        }
    }


    /***************************************************************************
     * Vypíše na standardní výstup simulovaný průběh hry podle daného scénáře,
     * přičemž u každého kroku vypíše zadávaný příkaz, odpověď hry<br>
     * a za nimi informace o plánovaném stavu hry po provedeném příkazu.
     */
    default
    public void simulateComplex()
    {
        for(ScenarioStep step : steps()) {
            System.out.println(step
                + "\n==================================================\n"
            );
        }
    }



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
