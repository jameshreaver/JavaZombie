import java.util.Arrays;

public class Zombies {

  private final Zombie[] zombies;
  private int numberOfZombies;

  public Zombies(int maxZombies) {
    assert (numberOfZombies == 0);
    this.zombies = new Zombie[maxZombies];
  }

  public int getNumberOfZombies() {
    return this.numberOfZombies;
  }

  public void addZombie(Zombie zombie) {
    assert(numberOfZombies <= zombies.length);
    zombies[numberOfZombies] = zombie;
    numberOfZombies++;
  }

  public Zombie removeZombie(int zombieIndex) {
    Util.swap(zombies, zombieIndex, numberOfZombies - 1);
    numberOfZombies--;
    return zombies[numberOfZombies];
  }

  public void takeAllZombies(Zombies other) {
    for (int i = 0; i < other.getNumberOfZombies(); i++) {
      addZombie(other.removeZombie(i));
    }
  }

  public String toString() {
    Zombie[] smaller = Arrays.copyOf(zombies, numberOfZombies);
    return Arrays.toString(smaller);
  }

}
