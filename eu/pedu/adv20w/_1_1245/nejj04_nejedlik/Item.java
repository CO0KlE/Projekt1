package eu.pedu.adv20w._1_1245.nejj04_nejedlik;

import eu.pedu.adv20w.api.IItem;


/**************************************************************************
* Instance třídy {@code nejj04_item} přestavují objekty v prostorech.
* Objekty mohou být jak věci, tak i osoby či jiné skutečnosti (vůně,
* světlo, fluidum, ...).
* Některé z objektů mohou charakterizovat stav prostoru (např. je rozsvíceno),
* jiné mohou být určeny k tomu, aby je hráč "zvednul" a získal tím nějakou
* schopnost či možnost projít nějakým kritickým místem hry
* (např. klíč k odemknutí dveří).
*
* Rozhodnete-li se použít ve hře objekty, které budou obsahovat jiné objekty,
* (truhla, stůl, ...), můžete je definovat paralelně jako zvláštní druh
* prostoru, do kterého se "vstupuje" např. příkazem "<i>prozkoumej truhlu</i>"
* a který se opouští např. příkazem "<i>zavři truhlu</i>".
*
* @author Jan Nejedlík
*/
public class Item extends A_Action_named implements IItem {

/**
* Kapacita batohu.
*/
static final int HEAVY = Bag.CAPACITY + 1;

/**
* Váha daného h-objektu.
*/
private final int weight;


/***************************************************************************
* Vytvoří objekt se zadaným názvem a dalšími zadanými vlastnostmi.
* Tyto dodatečné vlastnosti se zadávají prostřednictvím předpony
* vkládané před vlastní název objektu
*
* @param name Název vytvářeného objektu
*/
Item(String name) {
super(name.substring(1));
weight = (name.charAt(0) == '#') ? HEAVY : 1;
}

@Override
public int weight() {
return weight;
}

}
