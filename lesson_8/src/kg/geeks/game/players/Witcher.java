package kg.geeks.game.players;

public class Witcher extends Hero {
    public Witcher(int health, int damage, String name) {
        super(health, damage, SuperAbility.GIVE_LIVE, name);
    }
    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() <= 0 && this != hero) {
                hero.setHealth(this.getHealth());
                this.setHealth(0);
                System.out.println("--> Witcher " + this.getName() + " sacrificed himself for: " +
                        hero.getName());
            }
        }
    }
}
