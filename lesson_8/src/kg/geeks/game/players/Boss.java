package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Boss extends GameEntity {
    private SuperAbility defence = SuperAbility.NONE;
    private boolean stunned;

    public boolean isStunned() {
        return stunned;
    }
    public void setStunned(boolean stunned) {
        this.stunned = stunned;
    }
    public void resetStun() {
        stunned = false;
    }


    public Boss(int health, int damage, String name) {
        super(health, damage, name);
    }

    public void chooseDefence() {
        SuperAbility[] abilities = SuperAbility.values();
        int randomIndex = RPG_Game.random.nextInt(abilities.length - 1) + 1;
        this.defence = abilities[randomIndex];
    }

    public SuperAbility getDefence() {
        return defence;
    }

    public void attack(Hero[] heroes) {
        if (!isStunned()) {
            for (Hero hero : heroes) {
                if (hero.getHealth() > 0) {
                    if (hero instanceof Berserk &&
                            this.defence != SuperAbility.BLOCK_DAMAGE_AND_REVERT) {
                        int blocked = this.getDamage() / 5;
                        ((Berserk) hero).setBlockedDamage(blocked);
                        hero.setHealth(hero.getHealth() - (this.getDamage() - blocked));}
                    } else {
                        hero.setHealth(hero.getHealth() - this.getDamage());
                    }
                }
            }if (isStunned()) {
            resetStun();
        }
        }

    @Override
    public String toString() {
        return super.toString() + " defence: " + this.defence;
    }
}
