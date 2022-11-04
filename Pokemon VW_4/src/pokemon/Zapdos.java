package pokemon;

public class Zapdos extends Pokemon implements FlyingType, ElectricType{
    public Zapdos(int hp, int attack) {
        super("Zapdos", hp, attack);
    }


    @Override
    public boolean isStrongAgainst(Pokemon other){
        return other instanceof FlyingType || other instanceof ElectricType || other instanceof WaterType;
    }
    @Override
    public boolean isWeakAgainst(Pokemon other){
        return other instanceof GrassType;
    }

}
