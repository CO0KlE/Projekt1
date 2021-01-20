package eu.pedu.adv20w._1_1245.nejj04_nejedlik;

/*******************************************************************************
* Instance třídy {@code nejj04_a_End}
* zpracovávají příkazy, které
* ukončí hru.
*
* @author  Jan Nejedlík
*/
public class Action_End
extends A_Action
{
/***************************************************************************
* Vytvoří novou instanci daného příkazu.
*/
Action_End()
{
super ("Konec",
"Ukončení hry");
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
Game.getInstance().stop();
return "Hra ukončena příkazem Konec";
}

}
