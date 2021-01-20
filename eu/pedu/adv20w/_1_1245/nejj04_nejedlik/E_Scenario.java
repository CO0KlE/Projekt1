package eu.pedu.adv20w._1_1245.nejj04_nejedlik;
import eu.pedu.adv20w.api.IScenario;
import eu.pedu.adv20w.api.ScenarioStep;
import eu.pedu.adv20w.api.TypeOfScenario;

import java.util.Arrays;
import java.util.List;

import static eu.pedu.adv20w.api.TypeOfStep.*;

public enum E_Scenario
implements IScenario
{

HAPPY (TypeOfScenario.scHAPPY,
new ScenarioStep(0, tsSTART, "",
"Otevřete oči, ale nic nevidíte, pohnete nohou a ozve se ozvěna.\n" +
"Zjišťujete, že jste v jeskyni. V dálce uvidíte trošku\n" +
"světla a cosi zeleného. Stromy.\n\n" +
"Váš cíl je dostat se zpět do současnosti, protože jak\n"+
"brzy zjistíte, nacházíte se v dávné minulosti.\n\n"+
"TIP: Sbírejte vše, co by se vám mohlo hodit.\n"+
"Nevíte-li, jak pokračovat, zadejte příkaz '?'."
,
"Jeskyne",
new String[] { "Les" },
new String[] { "Kamen"},
new String[] { }
)
,

new ScenarioStep(tsNS_0, "Zakric",
"zakřičel/a jsi!"
,
"Jeskyne",
new String[] { "Les" },
new String[] {"Kamen"},
new String[] {  }

)
,

new ScenarioStep(tsGOTO, "Jdi Les",
"Přesouváte se do prostoru:\n"+
"Les s jeskyní\n\n"+
"Dostali jste se do lesa, kolem se válí různé haraburdí."
,
"Les",
new String[] { "Jeskyne", "Stezka" },
new String[] { "Bota", "Hadr", "Stare_kreslo", },
new String[] {  }

)
,

new ScenarioStep(tsTAKE,"Vezmi Hadr",
"Do batohu byl přidán objekt: hadr"
,
"Les",
new String[] { "Jeskyne", "Stezka" },
new String[] { "Bota", "Stare_kreslo", },
new String[] { "Hadr",}
)
,

new ScenarioStep(tsGOTO, "Jdi Stezka",
"Přesouváte se do prostoru:\n" +
"Dostali jste se na stezku z lesa, jak po ní jdete, vidíte\n"+
"u cesty různé předměty."
,
"Stezka",
new String[] { "Les", "Mestecko", "Farma", },
new String[] { "Kamen", "Klacek", },
new String[] { "Hadr", }
)
,
new ScenarioStep(tsTAKE,"Vezmi Klacek",
"Do batohu byl přidán objekt: klacek"
,
"Stezka",
new String[] { "Les", "Mestecko", "Farma", },
new String[] { "Kamen", },
new String[] { "Hadr", "Klacek"}
)
,

new ScenarioStep(tsGOTO,"Jdi Mestecko",
"Přesouváte se do prostoru:\n" +
"Podivné městečko\n\n" +
"Na ulicích zde vidíte zaparkovaná auta a lidi oblečené v oděvech,\n" +
"které si pamatujete jen z muzeií."
,
"Mestecko",
new String[] { "Stezka", "MesteckoTrzniUlice",
"MesteckoKostel", "Farma", },
new String[] { "Mince", "Tuzka", "Kaminek", },
new String[] { "Hadr", "Klacek", }
)
,
new ScenarioStep(tsTAKE,"Vezmi Mince",
"Do batohu byl přidán objekt: mince"
,
"Mestecko",
new String[] { "Stezka", "MesteckoTrzniUlice", "MesteckoKostel",
"Farma", },
new String[] { "Tuzka", "Kaminek", },
new String[] { "Hadr", "Klacek", "Mince" }
)
,

new ScenarioStep(tsGOTO,"Jdi MesteckoTrzniUlice",
"Přesouváte se do prostoru:\n" +
"Tržní ulice v městečku\n\n" +
"Dostali jste se do ulice, kde po stranách vidíte vývěsní\n" +
"štíty různých obchodů."
,
"MesteckoTrzniUlice",
new String[] { "Mestecko", "MesteckoKostel","Zastavarna",
"Hodinarstvi","Reznictvi","Banka", },
new String[] { "Rozbite_hodinky", "Inbus", },
new String[] { "Hadr", "Klacek", "Mince",}
)
,

new ScenarioStep(tsTAKE,"Vezmi Inbus",
"Do batohu byl přidán objekt: inbus"
,
"MesteckoTrzniUlice",
new String[] { "Mestecko", "MesteckoKostel","Zastavarna",
"Hodinarstvi","Reznictvi","Banka", },
new String[] { "Rozbite_hodinky", },
new String[] { "Hadr", "Klacek", "Mince", "Inbus",}
)
,
new ScenarioStep(tsGOTO,"Jdi Zastavarna",
"Přesouváte se do prostoru:\n" +
"Zastavárna v tržní ulici\n\n" +
"Vcházíte do zastavárny, pan zastavárník vám nabízí různé\n" +
"zajímavé předměty."
,
"Zastavarna",
new String[] { "MesteckoTrzniUlice","Hodinarstvi",
"Reznictvi","Banka", },
new String[] { "Hodinky", "Vodni_dymka", "Nausnice",
"Zapalovac","Mince", "Mince", "Mince", "Mince", },
new String[] { "Hadr", "Klacek", "Mince","Inbus",}
)
,

new ScenarioStep(tsNS_2,"Kup zapalovac mince",
"Získáváš Zapalovac za Mince"
,
"Zastavarna",
new String[] { "MesteckoTrzniUlice","Hodinarstvi",
"Reznictvi","Banka", },
new String[] { "Hodinky", "Vodni_dymka", "Nausnice",
"Mince", "Mince", "Mince", "Mince", "Mince", },
new String[] { "Hadr", "Klacek", "Inbus", "Zapalovac",}
)
,
new ScenarioStep(tsGOTO,"Jdi Hodinarstvi",
"Přesouváte se do prostoru:\n" +
"Hodinářství\n\n" +
"Vcházíte do hodinářství, ale uvnitř nikoho nenacházíte,\n" +
"jen tikání hodin. Najednou pocitíte něco zvláštního,\n" +
"přichází to ze zastavených nástěnných hodin.",
"Hodinarstvi",
new String[] { "MesteckoTrzniUlice",
"Zastavarna","Reznictvi","Banka", },
new String[] { "Hodinky", "Hodiny", "Budik",
"Nastenne_hodiny","Zastavene_nastenne_hodiny", },
new String[] { "Hadr", "Klacek", "Inbus", "Zapalovac",}
)
,

new ScenarioStep(tsNS_1, "Natáhnout_hodiny Inbus",
"Natahuješ inbusem zastavenné nástěnné \n" +
"hodiny a zeď se začne pomalu posouvat.\n"
,
"Hodinarstvi",
new String[] { "MesteckoTrzniUlice",
"Zastavarna","Reznictvi","Banka","Chodba", },
new String[] { "Hodinky", "Hodiny",
"Budik", "Nastenne_hodiny",
"Zastavene_nastenne_hodiny", },
new String[] { "Hadr", "Klacek", "Inbus", "Zapalovac",}
)
,

new ScenarioStep(tsGOTO,"Jdi Chodba",
"Přesouváte se do prostoru:\n" +
"Skrytá chodba z hodinářství\n\n"
+"Vejdete do tajemné chodby vedoucí z hodinářství\n" +
"pod zem, ale nic nevidíte, je tu tma!"
,
"Chodba",
new String[] { "Hodinarstvi", },
new String[] { },
new String[] { "Hadr", "Klacek", "Inbus", "Zapalovac",}
)
,

new ScenarioStep(tsNS_3,"Pochoden Klacek Hadr Zapalovac",
"Vytvořil jsi pochodeň a vidíš něco, co \n"
+ "připomíná vstup do jeskyně."
,
"Chodba",
new String[] { "Hodinarstvi", "JeskyneTed" },
new String[] { },
new String[] { "Pochoden", "Inbus", "Zapalovac",}
)
,

new ScenarioStep(tsGOTO,"Jdi JeskyneTed",
"Přesouváte se do prostoru:\n"+
"Jeskyně, ale v současnosti\n\n" +
"Vcházíte do jeskyně, připadá vám nějaká povědomá.\n" +
"ano! Už jste tu byl, ale přesto je něco jinak.\n" +
"vycházíte před jeskyni a vidíte moderní jedoucí traktor\n" +
"táhnoucí dřevo z lesa. Jste doma, dokázali jste to!\n" +
"\n" +
"Můžete ukončit hru příkazem konec"
,
"JeskyneTed",
new String[] { "Chodba" },
new String[] { },
new String[] { "Pochoden", "Inbus", "Zapalovac",}
)
,
new ScenarioStep(tsPUT_DOWN, "Polož Pochoden",
"Byl položen objekt: Pochoden"
,
"JeskyneTed",
new String[] { "Chodba" },
new String[] {"Pochoden"},
new String[] { "Inbus", "Zapalovac"}
)

,
new ScenarioStep(tsEND, "Konec",
"Hra ukončena příkazem Konec"
,
"JeskyneTed",
new String[] { "Chodba" },
new String[] {"Pochoden" },
new String[] { "Inbus", "Zapalovac",}
)
),






MISTAKES (TypeOfScenario.scMISTAKES,
new ScenarioStep(-1, tsNOT_START, "Start",
"\nPrvním příkazem není příkaz startu." +
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
"Jeskyne",
new String[] { "Les" },
new String[] {"Kamen"},
new String[] { }
)
,
new ScenarioStep(tsUNKNOWN, "maso",
"Neznámý příkaz: maso"
,
"Jeskyne",
new String[] { "Les" },
new String[] { "Kamen"},
new String[] { }
)
,
new ScenarioStep(tsMOVE_WA, "Jdi",
"Nezadáno jméno cílového prostoru."
,
"Jeskyne",
new String[] { "Les" },
new String[] { "Kamen"},
new String[] { }
)
,
new ScenarioStep(tsTAKE_WA, "Vezmi",
"Nezadáno jméno zvedaného objektu.\n"
,
"Jeskyne",
new String[] { "Les" },
new String[] { "Kamen" },
new String[] { }
)
,
new ScenarioStep(tsPUT_DOWN_WA, "Polož",
"Nezadáno jméno pokládaného objektu.\n"
,
"Jeskyne",
new String[] { "Les" },
new String[] { "Kamen"},
new String[] { }
)
,
new ScenarioStep(tsBAD_NEIGHBOR, "Jdi do_háje",
"Do zadaného prostoru se odsud jít nedá: do_háje"
,
"Jeskyne",
new String[] { "Les" },
new String[] { "Kamen"},
new String[] { }
)
,
new ScenarioStep(tsBAD_ITEM, "Vezmi whisky",
"Zadaný objekt v prostoru není: whisky"
,
"Jeskyne",
new String[] { "Les" },
new String[] { "Kamen"},
new String[] { }
)
,
new ScenarioStep(tsUNMOVABLE, "Vezmi Kamen",
"Zadaný objekt v prostoru nejde sebrat: Kamen"
,
"Jeskyne",
new String[] { "Les" },
new String[] { "Kamen", },
new String[] {  }
)
,
new ScenarioStep(tsGOTO, "Jdi Les",
"Přesouváte se do prostoru:\n"+
"Les s jeskyní\n\n"+
"Dostali jste se do lesa, kolem se válí různé haraburdí."
,
"Les",
new String[] { "Jeskyne", "Stezka" },
new String[] { "Bota", "Hadr", "Stare_kreslo", },
new String[] {  }

)
,

new ScenarioStep(tsTAKE,"Vezmi Hadr",
"Do batohu byl přidán objekt:"
+ " Hadr"
,
"Les",
new String[] { "Jeskyne", "Stezka" },
new String[] { "Bota", "Stare_kreslo", },
new String[] { "Hadr",}
)
,

new ScenarioStep(tsTAKE,"Vezmi Bota",
"Do batohu byl přidán objekt:"
+ " Bota"
,
"Les",
new String[] { "Jeskyne", "Stezka" },
new String[] {  "Stare_kreslo", },
new String[] { "Hadr","Bota",}
)
,

new ScenarioStep(tsGOTO, "Jdi Stezka",
"Přesouváte se do prostoru:\n" +
"Dostali jste se na stezku z lesa, jak po ní jdete, vidíte\n"+
"u cesty různé předměty."
,
"Stezka",
new String[] { "Les", "Mestecko", "Farma", },
new String[] { "Kamen", "Klacek", },
new String[] { "Hadr", "Bota",}
)
,
new ScenarioStep(tsTAKE,"Vezmi Klacek",
"Do batohu byl přidán objekt: klacek"
,
"Stezka",
new String[] { "Les", "Mestecko", "Farma", },
new String[] { "Kamen", },
new String[] { "Hadr", "Bota", "Klacek"}
)
,

new ScenarioStep(tsGOTO,"Jdi Mestecko",
"Přesouváte se do prostoru:\n" +
"Podivné městečko\n\n" +
"Na ulicích zde vidíte zaparkovaná auta a lidi oblečené v oděvech,\n" +
"které si pamatujete jen z muzeií."
,
"Mestecko",
new String[] { "Stezka", "MesteckoTrzniUlice",
"MesteckoKostel", "Farma", },
new String[] { "Mince", "Tuzka", "Kaminek", },
new String[] { "Hadr", "Bota", "Klacek" }
)
,

new ScenarioStep(tsTAKE,"Vezmi Mince",
"Do batohu byl přidán objekt: Mince"
,
"Mestecko",
new String[] { "Stezka", "MesteckoTrzniUlice",
"MesteckoKostel", "Farma", },
new String[] { "Tuzka", "Kaminek",},
new String[] { "Hadr", "Bota", "Klacek", "Mince",}
)
,

new ScenarioStep(tsBAG_FULL,"Vezmi Tuzka",
"Zadaný objekt se už do batohu nevejde!"
,
"Mestecko",
new String[] { "Stezka", "MesteckoTrzniUlice",
"MesteckoKostel", "Farma", },
new String[] {  "Kaminek","Tuzka"},
new String[] { "Hadr", "Bota", "Klacek", "Mince"}
)
,

new ScenarioStep(tsNOT_IN_BAG,"Polož Tuzka",


"Zadaný objekt v batohu není: "
+ "Tuzka"
,
"Mestecko",
new String[] { "Stezka", "MesteckoTrzniUlice",
"MesteckoKostel", "Farma", },
new String[] {  "Kaminek","Tuzka"},
new String[] { "Hadr", "Bota", "Klacek", "Mince"}
)
,
new ScenarioStep(tsHELP, "?",
"Tvým úkolem je získat několik předmětů a s jejich\n"
+ "pomocí najít tajnou chodbu a dostat se zpět do\n"
+ "vlastního času.\n"
+ "Můžeš zadat tyto příkazy:\n"
,
"Mestecko",
new String[] { "Stezka", "MesteckoTrzniUlice",
"MesteckoKostel", "Farma", },
new String[] {  "Kaminek","Tuzka"},
new String[] { "Hadr", "Bota", "Klacek", "Mince",}
)
,
new ScenarioStep(tsEND, "Konec",
"Hra ukončena příkazem Konec"
,
"Mestecko",
new String[] { "Stezka", "MesteckoTrzniUlice",
"MesteckoKostel", "Farma", },
new String[] {  "Kaminek","Tuzka"},
new String[] { "Hadr", "Bota", "Klacek", "Mince",}
)

),





/////////////////////////////////////////////////////////////////////////
MISTAKES_NS (TypeOfScenario.scMISTAKES_NS,
HAPPY.steps().get(0),
HAPPY.steps().get(1),
HAPPY.steps().get(2),

new ScenarioStep(tsNS0_WrongCond, "Zakric",
"Nekřič po lesích, rušíš zvěř!"
,
"Les",
new String[] { "Jeskyne", "Stezka" },
new String[] { "Bota", "Hadr", "Stare_kreslo", },
new String[] {  }

)
,


HAPPY.steps().get(3),
HAPPY.steps().get(4),
HAPPY.steps().get(5),
HAPPY.steps().get(6),
HAPPY.steps().get(7),
HAPPY.steps().get(8),
HAPPY.steps().get(9),

new ScenarioStep(tsNS2_WrongCond,"Kup Nausnice Klacek",
"Nejsi ve správném prostoru" +
" Tento příkaz můžeš vykonat v prostoru: Zastavarna"
,
"MesteckoTrzniUlice",
new String[] { "Mestecko", "MesteckoKostel","Zastavarna",
"Hodinarstvi","Reznictvi","Banka", },
new String[] { "Rozbite_hodinky", },
new String[] { "Hadr", "Klacek", "Mince", "Inbus",}
)

,

HAPPY.steps().get(10),  //Jdi Zastavarna

new ScenarioStep(tsNS2_1Args,"Kup Nausnice ",
"Nezadán dostatečný počet argumentů"
,
"Zastavarna",
new String[] { "MesteckoTrzniUlice","Hodinarstvi",
"Reznictvi","Banka", },
new String[] { "Hodinky", "Vodni_dymka", "Nausnice",
"Zapalovac","Mince", "Mince", "Mince", "Mince", },
new String[] { "Hadr", "Klacek", "Mince","Inbus",}
)
,


new ScenarioStep(tsNS2_WrongCond,"Kup Nausnice Klacek",
"Zastavárník nevymění "
+"nausnice za klacek"
,
"Zastavarna",
new String[] { "MesteckoTrzniUlice","Hodinarstvi",
"Reznictvi","Banka", },
new String[] { "Hodinky", "Vodni_dymka", "Nausnice",
"Zapalovac","Mince", "Mince", "Mince", "Mince", },
new String[] { "Hadr", "Klacek", "Mince","Inbus",}
)
,

new ScenarioStep(tsNS2_WRONG_1stARG,"Kup B Klacek ",
"Zastavárník nevymění b za klacek"
,
"Zastavarna",
new String[] { "MesteckoTrzniUlice","Hodinarstvi",
"Reznictvi","Banka", },
new String[] { "Hodinky", "Vodni_dymka", "Nausnice",
"Zapalovac","Mince", "Mince", "Mince", "Mince", },
new String[] { "Hadr", "Klacek", "Mince","Inbus",}
)
,

new ScenarioStep(tsNS2_WRONG_2ndARG,"Kup Nausnice B ",
"Zastavárník nevymění nausnice za b"
,
"Zastavarna",
new String[] { "MesteckoTrzniUlice","Hodinarstvi",
"Reznictvi","Banka", },
new String[] { "Hodinky", "Vodni_dymka", "Nausnice",
"Zapalovac","Mince", "Mince", "Mince", "Mince", },
new String[] { "Hadr", "Klacek", "Mince","Inbus",}
)
,

new ScenarioStep(tsNS1_WrongCond, "Natáhnout_hodiny Inbus",
"Nejsi v hodinářství, není co natáhnout"
,
"Zastavarna",
new String[] { "MesteckoTrzniUlice","Hodinarstvi",
"Reznictvi","Banka", },
new String[] { "Hodinky", "Vodni_dymka", "Nausnice",
"Zapalovac","Mince", "Mince", "Mince", "Mince", },
new String[] { "Hadr", "Klacek", "Mince","Inbus",}
)
,
HAPPY.steps().get(11),
HAPPY.steps().get(12),

new ScenarioStep(tsPUT_DOWN, "Polož Inbus",
"Byl položen objekt: Inbus"
,
"Hodinarstvi",
new String[] { "MesteckoTrzniUlice",
"Zastavarna","Reznictvi","Banka", },
new String[] { "Hodinky", "Hodiny",
"Budik", "Nastenne_hodiny",
"Zastavene_nastenne_hodiny", "Inbus" },
new String[] { "Hadr", "Klacek", "Zapalovac",}
)

,

new ScenarioStep(tsNS1_WrongCond, "Natáhnout_hodiny Inbus",
"Nemáš Inbus v inventáři"
,
"Hodinarstvi",
new String[] { "MesteckoTrzniUlice",
"Zastavarna","Reznictvi","Banka", },
new String[] { "Hodinky", "Hodiny",
"Budik", "Nastenne_hodiny",
"Zastavene_nastenne_hodiny", "Inbus"},
new String[] { "Hadr", "Klacek",  "Zapalovac",}
)
,

new ScenarioStep(tsNS1_0Args, "Natáhnout_hodiny",
"Nezadán dostatečný počet argumentů"
,
"Hodinarstvi",
new String[] { "MesteckoTrzniUlice",
"Zastavarna","Reznictvi","Banka", },
new String[] { "Hodinky", "Hodiny",
"Budik", "Nastenne_hodiny",
"Zastavene_nastenne_hodiny", "Inbus"},
new String[] { "Hadr", "Klacek",  "Zapalovac",}
)
,

new ScenarioStep(tsNS1_WRONG_ARG, "Natáhnout_hodiny Klacek",
"Na natažení hodin musíš použít Inbus."
,
"Hodinarstvi",
new String[] { "MesteckoTrzniUlice",
"Zastavarna","Reznictvi","Banka", },
new String[] { "Hodinky", "Hodiny",
"Budik", "Nastenne_hodiny",
"Zastavene_nastenne_hodiny", "Inbus"},
new String[] { "Hadr", "Klacek",  "Zapalovac",}
)
,

new ScenarioStep(tsNS1_WrongCond, "Natáhnout_hodiny Inbus",
"Nemáš inbus v inventáři"
,
"Hodinarstvi",
new String[] { "MesteckoTrzniUlice",
"Zastavarna","Reznictvi","Banka", },
new String[] { "Hodinky", "Hodiny",
"Budik", "Nastenne_hodiny",
"Zastavene_nastenne_hodiny", "Inbus"},
new String[] { "Hadr", "Klacek",  "Zapalovac",}
)
,

new ScenarioStep(tsTAKE,"Vezmi Inbus",
"Do batohu byl přidán objekt: inbus"
,
"Hodinarstvi",
new String[] { "MesteckoTrzniUlice",
"Zastavarna","Reznictvi","Banka", },
new String[] { "Hodinky", "Hodiny",
"Budik", "Nastenne_hodiny",
"Zastavene_nastenne_hodiny" },
new String[] { "Hadr", "Klacek", "Zapalovac", "Inbus"}
)
,

HAPPY.steps().get(13),
HAPPY.steps().get(14),

new ScenarioStep(tsNS3_012Args,"Pochoden Klacek Zapalovac",
"Nezadán dostatečný počet argumentů"
,
"Chodba",
new String[] { "Hodinarstvi", },
new String[] { },
new String[] { "Hadr", "Klacek", "Inbus", "Zapalovac",}
)
,

new ScenarioStep(tsNS3_WRONG_1stARG,"Pochoden Inbus Zapalovac Hadr",
"Na vytvoření pochodně je nutno použít" +
" Klacek, Hadr a Zapalovac."
,
"Chodba",
new String[] { "Hodinarstvi", },
new String[] { },
new String[] { "Hadr", "Klacek", "Inbus", "Zapalovac",}
)
,

new ScenarioStep(tsNS3_WRONG_2ndARG,"Pochoden Klacek Inbus Hadr",
"Na vytvoření pochodně je nutno použít" +
" Klacek, Hadr a Zapalovac."
,
"Chodba",
new String[] { "Hodinarstvi", },
new String[] { },
new String[] { "Hadr", "Klacek", "Inbus", "Zapalovac",}
)
,

new ScenarioStep(tsNS3_WRONG_3rdARG,"Pochoden Klacek Zapalovac Inbus",
"Na vytvoření pochodně je nutno použít" +
" Klacek, Hadr a Zapalovac."
,
"Chodba",
new String[] { "Hodinarstvi", },
new String[] { },
new String[] { "Hadr", "Klacek", "Inbus", "Zapalovac",}
)
,

new ScenarioStep(tsEND, "Konec",
"Hra ukončena příkazem Konec"
,
"Chodba",
new String[] { "Hodinarstvi", },
new String[] { },
new String[] { "Hadr", "Klacek", "Inbus", "Zapalovac",}
)
)
;

/** Typ daného scénáře. */
private final TypeOfScenario type;

/** Jednotlivé kroky daného scénáře. */
private final ScenarioStep[] steps;


private E_Scenario(TypeOfScenario type, ScenarioStep... steps)
{
this.type  = type;
this.steps = steps.clone();
}

@Override
public List<ScenarioStep> steps()
{
return Arrays.asList(this.steps);
}

@Override
public TypeOfScenario type()
{
return type;
}

public static void main(String[] args)
{
//        HAPPY.simulateSimple();
}
}
