package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Thor extends Hero implements HavingSuperAbility{
    public Thor(int health, int damage, String name) {
        super(health, damage, SuperAbility.STUN, name);
    }
    @Override
        public void applySuperPower (Boss boss, Hero[]heroes){
            boolean chance = RPG_Game.random.nextBoolean();
            if (chance) {
                System.out.println("---> Thor stunned Boss!");
                boss.setStunned(true);
            }
        }
    }
