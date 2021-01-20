package eu.pedu.adv20w._1_1245.nejj04_nejedlik;

import eu.pedu.adv20w.api.INamed;


/***************************************************************************
* Instance abstraktní třídy {@code nejj04_A_named}
* představují rodičovské podobjekty
* instancí tříd pojmenovaných objektů,
* tj. tříd implementujících interfejs {@link INamed}.
*
* @author Jan NEJEDLÍK
*/
public abstract class A_Action_named implements INamed {

/**
* Název dané instance.
*/
private final String name;

/***************************************************************************
* Vytvoří rodičovský podobjekt instance objektu se zadaným názvem.
* Konstruktor přitom zkontroluje, že zadávaný název není prázdný odkaz
* ani prázdný řetězec, a že není-li pojmenovávaný objekt objektem hry,
* tak je jednoslovný, tj. neobsahuje bílé znaky.
*
* @param name Název dané instance
*/
public A_Action_named(String name) {
if ((name == null) || name.isEmpty()) {
throw new IllegalArgumentException(
    "\nJako název objektu nesmí být zadán "
            + "prázdný odkaz ani prázdný řetězec");
}
if ((!name.equals(name.trim())) ||
(name.split("\\s").length > 1)) {
throw new IllegalArgumentException(
    "\nNázvy objektů musejí být jednoslovné, "
            + "tj. nesmějí obsahovat bílé znaky - Zadáno: «"
            + name + '»');
}
this.name = name;
}


/***************************************************************************
* Vrátí název dané instance.
*
* @return Název instance
*/
@Override
public String name() {
return name;
}


/***************************************************************************
* Vrátí textový podpis dané instance tvořený názvem instance.
*
* @return Název instance
*/
@Override
public String toString() {
return name;
}

}
