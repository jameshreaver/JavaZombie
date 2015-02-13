public class Util {

  public static Outcome calculateOutcome(double index, double biteChance,
      double hitChance, double destroyChance) {
    if (index < biteChance) {
      return Outcome.BITTEN;
    } else if (index < biteChance + hitChance) {
      return Outcome.HIT;
    } else {
      return Outcome.DESTROYED;
    }
  }

  public static int findIndexGreaterThanOrEqualTo(int[] numbers, int target) {
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] >= target) {
        return numbers[i];
      }
    }
    return -1;
  }

  public static void swap(Zombie[] zombies, int x, int y) {
    Zombie tem = zombies[x];
    zombies[x] = zombies[y];
    zombies[y] = tem;
  }

}
