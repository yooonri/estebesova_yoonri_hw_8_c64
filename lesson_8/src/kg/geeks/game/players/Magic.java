package kg.geeks.game.players;

public class Magic extends Hero {
    private int boost;

    public Magic(int health, int damage, int boost, String name) {
        super(health, damage, SuperAbility.BOOST, name);
        this.boost = boost;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && this != hero) {
                hero.setDamage(hero.getDamage() + boost);
                {
                    System.out.println("--> Magic " + this.getName() + " boosted: " +
                            this.getDamage());
                }if(hero instanceof Witcher)
                    hero.setDamage(0);
            }
        }
    }
}
