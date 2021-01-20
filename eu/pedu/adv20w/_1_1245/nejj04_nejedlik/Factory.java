package eu.pedu.adv20w._1_1245.nejj04_nejedlik;

import eu.pedu.adv20w.api.IGame;
import eu.pedu.adv20w.api.IGameFactory;
import eu.pedu.adv20w.api.IScenario;

import java.util.Arrays;
import java.util.List;

public class Factory implements IGameFactory {

    public Factory() {
    }

    @Override
    public String authorName() {
        return "NEJEDLÍK Jan";
    }

    @Override
    public String authorID() {
        return "NEJJ04";
    }

    @Override
    public List<IScenario> scenarios() {
        return Arrays.asList(E_Scenario.values());
    }

    @Override
    public IScenario scenario(String name) {
        return E_Scenario.valueOf(name);
    }

    @Override
    public IScenario scenario(int index) {
        return E_Scenario.values()[index];
    }

    @Override
    public IGame game() {
        return Game.getInstance();
    }

}
