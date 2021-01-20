package eu.pedu.adv20w.api;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */



/*******************************************************************************
 * Interfejs {@code IUI} deklaruje požadavky na třídu
 * definující uživatelské rozhraní (User Interface).
 * <p>
 * Zde deklarovaná metoda {@link #startGame()} slouží pouze ke spuštění hry,
 * Vlastní komunikace s hrou pak probíhá prostřednictvím opakovaných volání
 * metody {@link IGame#executeCommand(String)},
 * které UI předá příkaz zadaný uživatelem a od níž pak převezme zprávu,
 * kterou následné vypíše uživateli.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2020-Winter
 */
public interface IUI
{
//\CC== CLASS (STATIC) CONSTANTS ===============================================
//\CM== CLASS (STATIC) METHODS =================================================



//##############################################################################
//\AG== ABSTRACT GETTERS AND SETTERS ===========================================
//\AM== REMAINING ABSTRACT METHODS =============================================

    /***************************************************************************
     * Spustí hru pod uživatelským rozhraním.
     */
//    @Override
    public void startGame()
    ;



//\DG== DEFAULT GETTERS AND SETTERS ============================================
//\DM== REMAINING DEFAULT METHODS ==============================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
