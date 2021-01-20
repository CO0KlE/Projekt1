package eu.pedu.adv20w._1_1245.nejj04_nejedlik;
import java.util.Collection;
import java.util.stream.Collectors;


/**************************************************************************
* Instance třídy {@code nejj04_a_Help} zpracovávají příkazy, které
* žádají o nápovědu.
*
* @author  Jan NEJEDLÍK
*/
public class Action_Help
extends A_Action
{

/***************************************************************************
* Vytvoří novou instanci daného příkazu.
*/
Action_Help()
{
super ("?",
"Zobrazí nápovědu s popisem jednotlivých akcí");
}



/***************************************************************************
* Metoda realizující reakci hry na zadání daného příkazu.
* Počet parametrů je závislý na konkrétním příkazu,
* např. příkazy <i>konec</i> a <i>nápověda</i> nemají parametry,
* příkazy <i>jdi</i> a <i>seber</i> mají jeden parametr
* příkaz <i>použij</i> muže mít dva parametry atd.
*
* @param arguments Parametry příkazu;
*                  jejich počet muže byt pro každý příkaz jiný
* @return Text zprávy vypsané po provedeni příkazu
*/
@Override
public String execute(String... arguments)
{
Collection<A_Action> actions = getAllActions();
String result = actions.stream()
.map(action -> '\n' + action.name()
+ '\n' + action.description())
.sorted()
.collect(Collectors.joining(
"\n\n",
"Tvým úkolem je získat několik předmětů a s jejich\n"
+ "pomocí najít tajnou chodbu a dostat se zpět do\n"
+ "vlastního času.\n"
+ "Můžeš zadat tyto příkazy:\n",
""));
return result;
}




}
