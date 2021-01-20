package eu.pedu.adv20w.demo_ck.v01_before_ns;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */

import eu.pedu.adv20w.api.INamed;

import java.util.Optional;



/*******************************************************************************
 * Instance třídy {@code CK_A_GoTo} zpracovávají příkazy, které
 * mají přesunout hráče do zadaného sousedního prostoru.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2020-Winter
 */
@SuppressWarnings({"rawtypes", "unchecked"})
class       CK_A_GoTo
    extends CK_AAction
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
     * Creates the action instance for
     * moving the player from the current place to the given neighboring one.
     */
    CK_A_GoTo()
    {
        super ("Jdi",
               "Přesune Karkulku do zadaného sousedního prostoru.");
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================
//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================

    /***************************************************************************
     * Moves the player into the place (room) given in an argument.
     * Requires that this place has to be a neighbor of the current place,
     * otherwise nothing will be done and the command is reported as wrong.
     *
     * @param arguments Parameter of the command
     * @return The message text written after accomplishing the command
     */
    @Override
    public String execute(String... arguments)
    {
        if (arguments.length < 2) {
            return "Nevím, kam mám jít.\n"
                 + "Je třeba zadat jméno cílového prostoru.";
        }
        String destinationName = arguments[1];
        CK_World         world = CK_World.getInstance();
        CK_Place  currentPlace = world.currentPlace();
        Optional<CK_Place> oDestination = INamed.getO(destinationName,
                                                 currentPlace.neighbors());
        if (! oDestination.isPresent()) {
            return "Do zadaného prostoru se odsud jít nedá: "
                 + destinationName;
        }
        CK_Place destinationRoom = oDestination.get();
        world.setCurrentPlace(destinationRoom);
        return "Karkulka se přesunula do prostoru:\n"
             + destinationRoom.getDescription();
    }



//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
