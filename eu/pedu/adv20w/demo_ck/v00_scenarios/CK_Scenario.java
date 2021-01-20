package eu.pedu.adv20w.demo_ck.v00_scenarios;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */

import eu.pedu.adv20w.api.IScenario;
import eu.pedu.adv20w.api.ScenarioStep;
import eu.pedu.adv20w.api.TypeOfScenario;
import java.util.Arrays;
import java.util.List;

import static eu.pedu.adv20w.api.TypeOfStep.*;



/*******************************************************************************
 * Instance třídy {@code CK_Scenario} představují scénáře,
 * podle kterých je možno hrát hru, pro kterou jsou určeny.
 * Aby bylo možno jednotlivé scénáře od sebe odlišit,
 * je každý pojmenován a má přiřazen typ, podle které lze blíže určit,
 * k čemu je možno daný scénář použít.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2020-Winter
 */
public    enum CK_Scenario
    implements IScenario
{
//\CE== VALUES OF THE ENUMERATION TYPE =========================================

    /////////////////////////////////////////////////////////////////////////
    HAPPY (TypeOfScenario.scHAPPY,
        new ScenarioStep(0, tsSTART, "",
            "Vítejte!\n" +
            "Toto je příběh o Červené Karkulce, babičce a vlkovi.\n" +
            "Nevíte-li, jak pokračovat, zadejte příkaz '?'."
            ,
            "Domeček",
            new String[] { "Les" },
            new String[] { "Bábovka", "Víno", "Rum", "Stůl", "Panenka", },
            new String[] { }
        )
        ,
        new ScenarioStep(tsTAKE, "Vezmi víno",
            "Karkulka dala do košíku objekt: "
          + "Víno"
            ,
            "Domeček",
            new String[] { "Les" },
            new String[] { "Bábovka", "Rum", "Stůl", "Panenka", },
            new String[] { "Víno", }
        )
        ,
        new ScenarioStep(tsTAKE, "Vezmi Bábovka",
            "Karkulka dala do košíku objekt: "
          + "Bábovka"
            ,
            "Domeček",
            new String[] { "Les" },
            new String[] { "Rum", "Stůl", "Panenka",},
            new String[] { "Bábovka", "Víno", }
        )
        ,
        new ScenarioStep(tsGOTO, "Jdi Les",
            "Karkulka se přesunula do prostoru: "
          + "Les s jahodami, malinami a pramenem vody."
            ,
            "Les",
            new String[] { "Domeček", "Temný_les" },
            new String[] { "Maliny", "Jahody", "Studánka", },
            new String[] { "Bábovka", "Víno",  }
        )
        ,
        new ScenarioStep(tsGOTO, "Jdi Temný_les",
            "Karkulka se přesunula do prostoru "
          + "Temný_les s jeskyní a číhajícím vlkem"
            ,
            "Temný_les",
            new String[] { "Les", "Jeskyně", "Chaloupka", },
            new String[] { "Vlk", },
            new String[] { "Bábovka", "Víno", }
        )
        ,
        new ScenarioStep(tsGOTO, "Jdi Chaloupka",
            "Karkulka se přesunula do prostoru "
          + "Chaloupka, kde bydlí babička"
            ,
            "Chaloupka",
            new String[] { "Temný_les" },
            new String[] { "Postel", "Stůl", "Babička", },
            new String[] { "Bábovka", "Víno", }
        )
        ,
        new ScenarioStep(tsPUT_DOWN, "Polož Bábovka",
            "Karkulka položila objekt: "
          + "Bábovka"
            ,
            "Chaloupka",
            new String[] { "Temný_les" },
            new String[] { "Postel", "Stůl", "Babička", "Bábovka", },
            new String[] { "Víno", }
        )
        ,
        new ScenarioStep(tsPUT_DOWN, "Polož Víno",
            "Karkulka položila objekt: "
          + "Víno"
            ,
            "Chaloupka",
            new String[] { "Temný_les" },
            new String[] { "Postel", "Stůl", "Babička", "Bábovka", "Víno", },
            new String[] { }
        )
        ,
        new ScenarioStep(tsNS_1, "Probuď babička",
            "Karkulka probudila osobu: "
          + "Babička"
            ,
            "Chaloupka",
            new String[] { "Temný_les" },
            new String[] { "Postel", "Stůl", "Babička", "Bábovka", "Víno", },
            new String[] { }
        )
        ,
        new ScenarioStep(tsNS_0, "Pozdrav",
            "Karkulka pozdravila"
            ,
            "Chaloupka",
            new String[] { "Temný_les" },
            new String[] { "Postel", "Stůl", "Babička", "Bábovka", "Víno", },
            new String[] { }
        )
        ,
        new ScenarioStep(tsNS_0, "Popřej",
            "Karkulka popřála babičce vše nejlepší k narozeninám"
            ,
            "Chaloupka",
            new String[] { "Temný_les" },
            new String[] { "Postel", "Stůl", "Babička", "Bábovka", "Víno", },
            new String[] { }
        )
        ,
        new ScenarioStep(tsNS_2, "Předej Bábovka Víno",
            "Karkulka předala předměty: "
          + "Bábovka a Víno"
            ,
            "Chaloupka",
            new String[] { "Temný_les" },
            new String[] { "Postel", "Stůl", "Babička", "Bábovka", "Víno", },
            new String[] { }
        )
        ,
        new ScenarioStep(tsEND, "Konec",
            "Hra ukončena příkazem Konec"
            ,
            "Chaloupka",
            new String[] { "Temný_les" },
            new String[] { "Postel", "Stůl", "Babička", "Bábovka", "Víno", },
            new String[] { }
        )
    ),

    /////////////////////////////////////////////////////////////////////////
    MISTAKES (TypeOfScenario.scMISTAKES,
        new ScenarioStep(-1, tsNOT_START, "Start",
            "\nPrvním příkazem není startovací příkaz." +
            "\nHru, která neběží, lze spustit pouze startovacím příkazem.\n"
            ,
            "",
            new String[] {},
            new String[] {},
            new String[] {}
        ),

        HAPPY.steps().get(0),

        new ScenarioStep(1, tsEMPTY, "",
            "Prázdný příkaz lze použít pouze pro start hry"
            ,
            "Domeček",
            new String[] { "Les" },
            new String[] { "Bábovka", "Víno", "Rum", "Stůl", "Panenka", },
            new String[] { }
        )
        ,
        new ScenarioStep(tsUNKNOWN, "maso",
            "Tento příkaz neznám: maso"
            ,
            "Domeček",
            new String[] { "Les" },
            new String[] { "Bábovka", "Víno", "Rum", "Stůl", "Panenka", },
            new String[] { }
        )
        ,
        new ScenarioStep(tsMOVE_WA, "jdi",
            "Nevím, kam mám jít.\n"
          + "Je třeba zadat jméno cílového prostoru."
            ,
            "Domeček",
            new String[] { "Les" },
            new String[] { "Bábovka", "Víno", "Rum", "Stůl", "Panenka", },
            new String[] { }
        )
        ,
        new ScenarioStep(tsTAKE_WA, "vezmi",
            "Nevím, co mám zvednout.\n"
          + "Je třeba zadat jméno zvedaného objektu."
            ,
            "Domeček",
            new String[] { "Les" },
            new String[] { "Bábovka", "Víno", "Rum", "Stůl", "Panenka", },
            new String[] { }
        )
        ,
        new ScenarioStep(tsPUT_DOWN_WA, "polož",
            "Nevím, co mám položit.\n"
          + "Je třeba zadat jméno pokládaného objektu."
            ,
            "Domeček",
            new String[] { "Les" },
            new String[] { "Bábovka", "Víno", "Rum", "Stůl", "Panenka", },
            new String[] { }
        )
        ,
        new ScenarioStep(tsBAD_NEIGHBOR, "jdi do_háje",
            "Do zadaného prostoru se odsud jít nedá: do_háje"
            ,
            "Domeček",
            new String[] { "Les" },
            new String[] { "Bábovka", "Víno", "Rum", "Stůl", "Panenka", },
            new String[] { }
        )
        ,
        new ScenarioStep(tsBAD_ITEM, "vezmi whisky",
            "Zadaný objekt v prostoru není: whisky"
            ,
            "Domeček",
            new String[] { "Les" },
            new String[] { "Bábovka", "Víno", "Rum", "Stůl", "Panenka", },
            new String[] { }
        )
        ,
        new ScenarioStep(tsUNMOVABLE, "vezmi stůl",
            "Zadaný objekt není možno zvednout: stůl"
            ,
            "Domeček",
            new String[] { "Les" },
            new String[] { "Bábovka", "Víno", "Rum", "Stůl", "Panenka", },
            new String[] { }
        )
        ,
        new ScenarioStep(tsTAKE, "vezmi víno",
            "Karkulka dala do košíku objekt: "
          + "víno"
            ,
            "Domeček",
            new String[] { "Les" },
            new String[] { "Bábovka", "Rum", "Stůl", "Panenka", },
            new String[] { "Víno", }
        )
        ,
        new ScenarioStep(tsTAKE, "vezmi bábovka",
            "Karkulka dala do košíku objekt: "
          + "Bábovka"
            ,
            "Domeček",
            new String[] { "Les" },
            new String[] { "Rum", "Stůl", "Panenka", },
            new String[] { "Bábovka", "Víno", }
        )
        ,
        new ScenarioStep(tsBAG_FULL, "vezmi panenka",
            "Zadaný objekt se už do košíku nevejde!"
            ,
            "Domeček",
            new String[] { "Les" },
            new String[] { "Rum", "Stůl", "Panenka", },
            new String[] { "Bábovka", "Víno", }
        )
        ,
        new ScenarioStep(tsNOT_IN_BAG, "polož panenka",
            "Zadaný objekt v košíku není: "
          + "panenka"
            ,
            "Domeček",
            new String[] { "Les" },
            new String[] { "Rum", "Stůl", "Panenka", },
            new String[] { "Bábovka", "Víno", }
        )
        ,
        new ScenarioStep(tsHELP, "?",
            "Tvým úkolem je dovést Červenou Karkulku z domečku\n"
          + "až k babičce, která bydlí v chaloupce za lesem.\n"
          + "\n"
          + "Můžeš zadat tyto příkazy:\n"
            ,
            "Domeček",
            new String[] { "Les" },
            new String[] { "Rum", "Stůl", "Panenka", },
            new String[] { "Bábovka", "Víno", }
        )
        ,
        new ScenarioStep(tsEND, "konec",
            "Hra ukončena příkazem Konec"
            ,
            "Domeček",
            new String[] { "Les" },
            new String[] { "Rum", "Stůl", "Panenka", },
            new String[] { "Bábovka", "Víno", }
        )

    )
    ,

    /////////////////////////////////////////////////////////////////////////
    MISTAKES_NS (TypeOfScenario.scMISTAKES_NS,
        HAPPY.steps().get(0),
        HAPPY.steps().get(1),
        HAPPY.steps().get(2),
        HAPPY.steps().get(3),   //Jdi les
        HAPPY.steps().get(4),
        HAPPY.steps().get(5),
        HAPPY.steps().get(6),   ///Polož Bábovka
        HAPPY.steps().get(7),

        new ScenarioStep(8, tsNS0_WrongCond, "Pozdrav",
            "Nemá smysl zdravit, babička ještě není probuzená"
            ,
            "Chaloupka",
            new String[] { "Temný_les" },
            new String[] { "Postel", "Stůl", "Babička", "Bábovka", "Víno", },
            new String[] { }
        )
        ,
        new ScenarioStep(tsNS1_WRONG_ARG, "Probuď Stůl",
            "Nelze probudit předmět: Stůl"
            ,
            "Chaloupka",
            new String[] { "Temný_les" },
            new String[] { "Postel", "Stůl", "Babička", "Bábovka", "Víno", },
            new String[] { }
        )
        ,
        new ScenarioStep(tsNS_1, "Probuď babička",
            "Karkulka probudila osobu: Babička"
            ,
            "Chaloupka",
            new String[] { "Temný_les" },
            new String[] { "Postel", "Stůl", "Babička", "Bábovka", "Víno", },
            new String[] { }
        )
        ,
        new ScenarioStep(tsNS1_WrongCond, "Probuď babička",
            "Nelze budit osobu, která je již probuzená: Babička"
            ,
            "Chaloupka",
            new String[] { "Temný_les" },
            new String[] { "Postel", "Stůl", "Babička", "Bábovka", "Víno", },
            new String[] { }
        )
        ,
        new ScenarioStep(8, tsNS2_WRONG_1stARG, "Předej postel víno",
            "Nelze předat nepřenostný předmět: Postel"
            ,
            "Chaloupka",
            new String[] { "Temný_les" },
            new String[] { "Postel", "Stůl", "Babička", "Bábovka", "Víno", },
            new String[] { }
        )
        ,
        new ScenarioStep(8, tsNS2_WRONG_2ndARG, "Předej víno vlk",
            "Nelze předat nepřítomný předmět: Vlk"
            ,
            "Chaloupka",
            new String[] { "Temný_les" },
            new String[] { "Postel", "Stůl", "Babička", "Bábovka", "Víno", },
            new String[] { }
        )
        ,
        new ScenarioStep(tsGOTO, "Jdi Temný_les",
            "Karkulka se přesunula do prostoru "
          + "Temný_les s jeskyní a číhajícím vlkem"
            ,
            "Temný_les",
            new String[] { "Les", "Jeskyně", "Chaloupka", },
            new String[] { "Vlk", },
            new String[] {  }
        )
        ,
        new ScenarioStep(tsGOTO, "Jdi Les",
            "Karkulka se přesunula do prostoru: "
          + "Les s jahodami, malinami a pramenem vody."
            ,
            "Les",
            new String[] { "Domeček", "Temný_les" },
            new String[] { "Maliny", "Jahody", "Studánka", },
            new String[] {  }
        )
        ,
        new ScenarioStep(tsNS2_WrongCond, "předej maliny jahody",
            "Není komu předat: Maliny Jahody"
            ,
            "Les",
            new String[] { "Domeček", "Temný_les" },
            new String[] { "Maliny", "Jahody", "Studánka", },
            new String[] {  }
        )
        ,
        new ScenarioStep(tsEND, "konec",
            "Hra ukončena příkazem Konec"
            ,
            "Les",
            new String[] { "Domeček", "Temný_les" },
            new String[] { "Maliny", "Jahody", "Studánka", },
            new String[] {  }
        )
    )
;



//##############################################################################
//\CC== REMAINING CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ====
//\CV== CLASS VARIABLES (VARIABLE CLASS/STATIC ATTRIBUTES/FIELDS) ==============



//##############################################################################
//\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) =========================
//\CF== CLASS (STATIC) FACTORY METHODS =========================================
//\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================
//\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS ===========================
//\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS ===========================



//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============

    /** Typ daného scénáře. */
    private final TypeOfScenario type;

    /** Jednotlivé kroky daného scénáře. */
    private final ScenarioStep[] steps;



//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     * Vytvoří nový scénář zadaného názvu a typu určený pro zadanou hru.
     * Konstruktor prověří, jestli kroky scénáře alespoň formálně
     * vyhovují požadavkům.
     *
     * @param type  Typ vytvářeného scénáře
     * @param steps Jednotlivé kroky realizující daný scénář;
     *              příkaz v prvním (přesněji nultém) kroku
     *              musí být definována jako prázdný řetězec s výjimkou případu,
     *              kdy je testován krok typu {@link TypeOfStep#tsNOT_START}
     */
    private CK_Scenario(TypeOfScenario type, ScenarioStep... steps)
    {
        this.type  = type;
        this.steps = steps.clone();
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================

    /***************************************************************************
     * Vrátí seznam kroků daného scénáře.
     *
     * @return Seznam kroků daného scénáře
     */
    @Override
    public List<ScenarioStep> steps()
    {
        return Arrays.asList(this.steps);
    }


    /***************************************************************************
     * Vrátí typ daného scénáře.
     *
     * @return Typ daného scénáře
     */
    @Override
    public TypeOfScenario type()
    {
        return type;
    }



//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================
//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
