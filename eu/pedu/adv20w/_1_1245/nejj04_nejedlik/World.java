package eu.pedu.adv20w._1_1245.nejj04_nejedlik;

import eu.pedu.adv20w.api.INamed;
import eu.pedu.adv20w.api.IPlace;
import eu.pedu.adv20w.api.IWorld;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;


/*******************************************************************************
* Instance třídy {@code CK_World} reprezentuje svět hry.
* V dané hře je definována jako jedináček.
* Má na starosti uspořádání jednotlivých prostorů a udržuje informaci o tom,
* ve kterém z nich se hráč právě nachází.
* Vzájemné uspořádání prostorů se v průběhu této hry nemění,
* takže prostory v průběhu hry nezískávají ani neztrácejí sousedy.
* <p>
* V této hře je světem hry ...
* a jednotlivé prostory jsou ....
*
* @author Jan NEJEDLÍK
*/
public class World
implements IWorld {

/**
* Odkaz na jedinou instanci (jedináčka) této hry.
*/
private static final World SINGLETON = new World();

/***************************************************************************
* Tovární metoda vracející odkaz na jedninou existující instanci dané hry.
*
* @return Instance dané hry
*/
static World getInstance() {
return SINGLETON;
}

/**
* Kolekce všech prostorů světa hry.
*/
private final Collection<Place> places;

/**
* Kolekce všech prostorů světa hry poskytovaná tazatelům.
*/
private final Collection<Place> allPlaces;

/**
* Výchozí aktuální prostor na počátku hry.
*/
private final Place startPlace;

/**
* Aktuální prostor, v němž se nachází hráč.
*/
private Place currentPlace;

private World() {

places = new ArrayList<>();
places.add(startPlace = new Place("Jeskyne",
"Jeskyně, kde začíná příběh",
new String[]{"Les"},
"#Kamen"));
places.add(new Place("Les",
"Les s jeskyní\n\n"+
"Dostali jste se do lesa, kolem se válí různé haraburdí.",
new String[]{"Jeskyne", "Stezka"},
"_Bota", "_Hadr", "#Stare_kreslo"));
places.add(new Place("Stezka",
"Stezka z lesa\n\n"+
"Dostali jste se na stezku z lesa, jak po ní jdete, vidíte\n"+
"u cesty různé předměty.",
new String[]{"Les", "Mestecko", "Farma"},
"#Kamen", "_Klacek"));
places.add(new Place("Mestecko",
"Podivné městečko\n\n" +
"Na ulicích zde vidíte zaparkovaná auta a lidi oblečené v oděvech,\n" +
"které si pamatujete jen z muzeií.",
new String[]{"Stezka", "MesteckoTrzniUlice", "MesteckoKostel", "Farma"},
"_Mince", "_Tuzka", "_Kaminek"));
places.add(new Place("MesteckoTrzniUlice",
"Tržní ulice v městečku\n\n" +
    "Dostali jste se do ulice, kde po stranách vidíte vývěsní\n" +
    "štíty různých obchodů.",
new String[]{"Mestecko", "MesteckoKostel",
    "Zastavarna", "Hodinarstvi", "Reznictvi", "Banka"},
"_Rozbite_hodinky", "_Inbus"));
places.add(new Place("Zastavarna",
"Zastavárna v tržní ulici\n\n" +
    "Vcházíte do zastavárny, pan zastavárník vám nabízí různé\n" +
    "zajímavé předměty.",
new String[]{"MesteckoTrzniUlice", "Hodinarstvi", "Reznictvi", "Banka"},
"_Hodinky", "_Vodni_dymka", "_Nausnice",
"_Zapalovac", "_Mince", "_Mince", "_Mince", "_Mince"));
places.add(new Place("Hodinarstvi",
"Hodinářství\n\n" +
    "Vcházíte do hodinářství, ale uvnitř nikoho nenacházíte,\n" +
    "jen tikání hodin. Najednou pocitíte něco zvláštního,\n" +
    "přichází to ze zastavených nástěnných hodin.",
new String[]{"MesteckoTrzniUlice",
    "Zastavarna", "Reznictvi", "Banka"},
"_Hodinky", "_Hodiny", "_Budik",
"#Nastenne_hodiny", "#Zastavene_nastenne_hodiny"));
places.add(new Place("Chodba",
"Skrytá chodba z hodinářství\n\n"
+"Vejdete do tajemné chodby vedoucí z hodinářství\n" +
    "pod zem, ale nic nevidíte, je tu tma!"

,
new String[]{"Hodinarstvi"}
));
places.add(new Place("JeskyneTed",
"Jeskyně, ale v současnosti\n\n" +
    "Vcházíte do jeskyně, připadá vám nějaká povědomá.\n" +
    "ano! Už jste tu byl, ale přesto je něco jinak.\n" +
    "vycházíte před jeskyni a vidíte moderní jedoucí traktor\n" +
    "táhnoucí dřevo z lesa. Jste doma, dokázali jste to!\n" +
    "\n" +
    "Můžete ukončit hru příkazem konec",
new String[]{"Chodba"}
));
places.add(new Place("Farma",
"Farma u městečka",
new String[]{"Stezka", "Mestecko"},
"#Krava", "#Krava", "#Krava", "#Ovce", "#Ovce", "#Seno"));
places.add(new Place("MesteckoKostel",
"Kostel ve městečku",
new String[]{"Mestecko", "MesteckoTrzniUlice"},
"#Zlaty_Kriz", "#Lavice", "#Lavice"));
places.add(new Place("Reznictvi",
"Řeznictví v obchodní ulici",
new String[]{"MesteckoTrzniUlice", "Hodinarstvi", "Zastavarna", "Banka"},
"_Steak", "_Steak", "_Steak", "_Nůž"));
places.add(new Place("Banka",
"Banka v ulici s obchody",
new String[]{"MesteckoTrzniUlice", "Hodinarstvi", "Reznictvi", "Zastavarna"},
"#Lavice", "#Lavice", "#Safe"));
allPlaces = Collections.unmodifiableCollection(places);


}

/***************************************************************************
* Vrátí kolekci odkazů na všechny prostory vystupující ve hře.
*
* @return Kolekce odkazů na všechny prostory vystupující ve hře
*/
@Override
public Collection<? extends IPlace> places() {
return allPlaces;
}


/***************************************************************************
* Vrátí odkaz na aktuální prostor,
* tj. na prostor, v němž se hráč pravé nachází.
*
* @return Prostor, v němž se hráč pravé nachází
*/
@Override
public Place currentPlace() {
return currentPlace;
}


/***************************************************************************
* Vrátí odkaz na prostor se zadaným názvem.
*
* @param name
* @return Požadovaný prostor
*/
public Optional<Place> getPlace(String name) {
Optional<Place> oPlace = INamed.getO(name.toLowerCase(), places);
return oPlace;
}


/***************************************************************************
* Sets the given place as the current one,
* i.e. the place, in which the player is just situated.
*
* @param destinationRoom The set place
*/
public void setCurrentPlace(Place destinationRoom) {
currentPlace = destinationRoom;
}


/***************************************************************************
* Inicializuje svět hry, tj. inicializuje
* propojení prostorů a jejich obsah a nastaví výchozí aktuální prostor.
*/
public void initialize() {
places.stream().forEach(Place::initialize);
currentPlace = startPlace;
}

}
