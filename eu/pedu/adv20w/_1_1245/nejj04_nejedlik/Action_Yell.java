package eu.pedu.adv20w._1_1245.nejj04_nejedlik;

public class Action_Yell
extends A_Action {
//vytvoření instance daného příkazu
Action_Yell() {
super("Zakric",
"Křičíš jako o život");
}


@Override
public String execute(String... arguments) {
Place cp = World.getInstance().currentPlace();
Place les =
World.getInstance().getPlace(StringConstants.LES).get();

return cp.equals(les) ? "Nekřič po lesích, rušíš zvěř!" : "zakřičel/a jsi!";
}
}
