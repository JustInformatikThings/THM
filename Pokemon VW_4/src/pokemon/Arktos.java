package pokemon;

public class Arktos extends Pokemon implements FlyingType, IceType{
    public Arktos(int hp, int attack) {
        super("Arktos", hp, attack);
    }

    @Override
    public boolean isStrongAgainst(Pokemon other){
        return other instanceof FlyingType || other instanceof IceType || other instanceof GrassType;
    }

    @Override
    public boolean isWeakAgainst(Pokemon other){
        return other instanceof WaterType || other instanceof GrassType;
    }
}
