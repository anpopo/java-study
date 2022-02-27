package javas.study.inflearn.not.inflear.udemy.fourthstep.opppart2;

public class Player {

    private String name;
    private int health = 100;
    private String weapon;

    public Player(String name, int health, String weapon) {
        this.name = name;
        if (health > 0 &&  health <= 100) this.health = health;
        this.weapon = weapon;
    }

    public void loseHeath (int damage) {
        health = health - damage;
        if (this.health <= 0) System.out.println("Player knocked out");
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public String getWeapon() {
        return weapon;
    }
}
