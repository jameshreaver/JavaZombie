public enum Zombie {

  EASY(0.1d, 0.2d, 0.7d), MEDIUM(0.3d, 0.3d, 0.4d), HARD(0.7d, 0.2d, 0.1d);

  private final double biteChance;
  private final double hitChance;
  private final double destroyChance;

  private Zombie(double biteChance, double hitChance, double destroyChance) {
    this.biteChance = biteChance;
    this.hitChance = hitChance;
    this.destroyChance = destroyChance;
  }

  public Outcome randomOutcome() {
    return Util.calculateOutcome(Math.random(), biteChance, hitChance,
        destroyChance);
  }

}
