public class Turn {

  private static final int NUM_EASY_ZOMBIES = 20;
  private static final int NUM_MEDIUM_ZOMBIES = 20;
  private static final int NUM_HARD_ZOMBIES = 10;

  private static final int MAX_NUM_ZOMBIES = NUM_EASY_ZOMBIES
      + NUM_MEDIUM_ZOMBIES + NUM_HARD_ZOMBIES;

  private static final int BITE_LIMIT = 6;
  private static final int HAND_SIZE = 5;

  private final int player;

  private final Zombies zombiePopulation = new Zombies(MAX_NUM_ZOMBIES);
  private final Zombies destroyed = new Zombies(MAX_NUM_ZOMBIES);
  private final Zombies hit = new Zombies(HAND_SIZE);
  private final Zombies bitten = new Zombies(MAX_NUM_ZOMBIES);

  public Turn(int player) {
    this.player = player;
    int i = 0;
    while (i < NUM_EASY_ZOMBIES) {
      zombiePopulation.addZombie(Zombie.EASY);
      i++;
    }
    while (i < NUM_MEDIUM_ZOMBIES + NUM_EASY_ZOMBIES) {
      zombiePopulation.addZombie(Zombie.MEDIUM);
      i++;
    }
    while (i < MAX_NUM_ZOMBIES) {
      zombiePopulation.addZombie(Zombie.HARD);
      i++;
    }
  }

  public int getCurrentPlayer() {
    return player;
  }

  public boolean hasBeenBittenTooManyTimes() {
    return bitten.getNumberOfZombies() >= BITE_LIMIT;
  }

  public int getCurrentScore() {
    if (hasBeenBittenTooManyTimes()) {
      return 0;
    }
    return destroyed.getNumberOfZombies();
  }

  private void addZombies(Zombies hand, int extraZombiesNeeded) {
    if (zombiePopulation.getNumberOfZombies() < extraZombiesNeeded) {
      hand.takeAllZombies(zombiePopulation);
    } else {
      for (int i = 0; i < extraZombiesNeeded; i++) {
        int index = (int) Math.random()*MAX_NUM_ZOMBIES;
        hand.addZombie(zombiePopulation.removeZombie(index));
      }
    }
  }

  private Outcome[] getOutcomesForHand(Zombies hand) {
    Outcome[] outcomes = new Outcome[hand.getNumberOfZombies()];
    for (int i = 0; i < outcomes.length; i++) {
      Zombie removedZombie = hand.removeZombie(i);
      outcomes[i] = removedZombie.randomOutcome();
      switch (outcomes[i]) {
        case BITTEN : bitten.addZombie(removedZombie); break;
        case HIT : hit.addZombie(removedZombie); break;
        case DESTROYED : destroyed.addZombie(removedZombie); break;
        default: break;
      }
    }
    return outcomes;
  }

  public Outcome[] drawAndGetOutcomes() {
      int numberOfZombies = hit.getNumberOfZombies();
      Zombies hand = new Zombies(HAND_SIZE);
      hand.takeAllZombies(hit);
      int extraZombiesNeeded = HAND_SIZE - numberOfZombies;
      if (extraZombiesNeeded > 0) {
          addZombies(hand, extraZombiesNeeded);
      }
      return getOutcomesForHand(hand);
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Destroyed: ");
    sb.append(destroyed);
    sb.append("\n");
    sb.append("Hits: ");
    sb.append(hit);
    sb.append("\n");
    sb.append("Bites: ");
    sb.append(bitten);
    return sb.toString();
  }

}
