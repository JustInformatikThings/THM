package pokedex;

import pokemon.Pokemon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Pokedex<T extends Nameable>{
    public ArrayList<T> pokemons;

    public Pokedex(){
        pokemons = new ArrayList<T>();
    }

    public void add(T nameable){
        pokemons.add(nameable);
    }

    public void remove(T nameable){
        pokemons.remove(nameable);
    }

    public T getPokemonByName(String name) {
        for (T pokemon : pokemons) {
            if (pokemon.getName().equalsIgnoreCase(name)) {
                return pokemon;
            }
        }
        return null;
    }

    public Set<T> getUniqueObjectsOf(Pokedex<T> others){
        Set<T> uniqueObjects = new HashSet<T>();

        Set<String> ownObjects = getPokemonNames();
        System.out.println(ownObjects.toString());
        System.out.println(others.getPokemonNames());

        for(String pokename: others.getPokemonNames()){
            if(!ownObjects.contains(pokename)){
                uniqueObjects.add(others.getPokemonByName(pokename));
            }
        }

        return uniqueObjects;
    }

    public Set<String> getPokemonNames(){
        Set<String> pokenames = new HashSet<>();
        for(T poke : pokemons){
            pokenames.add(poke.getName());
        }
        return pokenames;
    }


    public void swap(String name, Pokedex<T> other, String otherName){
        other.add(getPokemonByName(name));
        add(other.getPokemonByName(otherName));
        other.remove(getPokemonByName(otherName));
        remove(other.getPokemonByName(name));
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(T poke : pokemons){
            sb.append(poke.getName() + "\n");
        }
        return sb.toString();
    }

}
