package pokemon;

import pokedex.Nameable;
import teams.Fightable;

import javax.naming.Name;

public abstract class Pokemon implements PokemonType, Fightable<Pokemon> , Nameable {
    private String name;
    private int hp;
    private int attack;


    public Pokemon(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }

    public String getName(){
        return name;
    }

    private void attack(Pokemon other) {
        int attackPoints = attack;

        if(isStrongAgainst(other))
            attackPoints *= 2;
        if(isWeakAgainst(other))
            attackPoints /= 2;

        other.hp = Math.max(0, other.hp - attackPoints);
        System.out.println(String.format("%s attacked %s: -%d (remaining HP: %d)",
                name, other.name, attackPoints, other.hp));
    }

    public boolean fight(Pokemon other) {
        attack(other);

        if (other.hp > 0) {
            return !other.fight(this);
        } else {
            System.out.println(other.name + " fainted!");
            System.out.println();
            return true;
        }
    }

    public boolean isAlive() {
        return hp > 0;
    }

    @Override
    public String toString() {
        return String.format("%s has %d HP", name, hp);
    }
}
