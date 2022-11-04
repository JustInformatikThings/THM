package pokemon;

public class Lavados extends Pokemon implements FlyingType, FireType{
    public Lavados(int hp, int attack) {
        super("Lavados", hp, attack);
    }


    @Override
    public boolean isStrongAgainst(Pokemon other){
        return other instanceof FlyingType || other instanceof FireType || other instanceof GrassType;
    }

    @Override
    public boolean isWeakAgainst(Pokemon other){
        return other instanceof WaterType || other instanceof GrassType;
    }
}
