package eu.pedu.adv20w._1_1245.nejj04_nejedlik;
import eu.pedu.adv20w.api.INamed;

import java.util.Optional;


/**************************************************************************
* Instance třídy {@code nejj04_a_GoTo} zpracovávají příkazy, které
* mají přesunout hráče do zadaného sousedního prostoru.
*
* @author  Jan NEJEDLÍK
*/
@SuppressWarnings({"rawtypes", "unchecked"})
class Action_GoTo
extends A_Action
{

/***************************************************************************
* Creates the action instance for
* moving the player from the current place to the given neighboring one.
*/
Action_GoTo()
{
super ("Jdi",
"Přesune hráče do zadaného prostoru");
}




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
return "Nezadáno jméno cílového prostoru.";
}
String destinationName = arguments[1];
World world = World.getInstance();
Place currentPlace = world.currentPlace();
Optional<Place> oDestination = INamed.getO(destinationName,
                                 currentPlace.neighbors());
if (! oDestination.isPresent()) {
return "Do zadaného prostoru se odsud jít nedá: "
 + destinationName;
}
Place destinationRoom = oDestination.get();
world.setCurrentPlace(destinationRoom);
return "Přesouváte se do prostoru:\n"
+ destinationRoom.getDescription();
}


}
