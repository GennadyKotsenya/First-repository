package day11.task2;

abstract public class Hero implements PhysAttack{

    static final int MIN_HEALTH = 0;
    static final int MAX_HEALTH = 100;
    int health;
    double physDef;
    double magicDef;
    int physAtt;


    public Hero() {
        health = 100;
    }

    @Override
    public void physicalAttack(Hero hero) {
        double attackScore = physAtt * (1 - hero.physDef);
        if (hero.health - attackScore  < MIN_HEALTH) {
            hero.health = MIN_HEALTH;
        } else {
            hero.health -= attackScore;
        }
    }
}
