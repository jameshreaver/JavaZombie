import java.util.Arrays;

public class Main {
  
  private static void playTurn(Turn turn) {
    String answer;
    do {
      Outcome[] outcomes = turn.drawAndGetOutcomes();
      System.out.println("You got: " + java.util.Arrays.toString(outcomes));
      System.out.println("Current piles:");
      System.out.println(turn);
      if (turn.hasBeenBittenTooManyTimes()) {
        System.out.println("You've been bitten too many times.");
        return;
      }
      System.out.println("Enter 1 to score, or anything else to draw again:");
      answer = IOUtil.readString();
    } while (!answer.equals("s"));
    return;
   }

  public static void main(String[] args) {
    System.out.println("Welcome to ZOMBIE SURVIVOR.");
    System.out.println("A game for the brave.");
    System.out.println();
    System.out.println("How many survivors?");
    int players = IOUtil.readInt();
    ZombieSurvivor game = new ZombieSurvivor(players);
    Turn turn;
    while (!game.isGameOver()) {
      turn = game.startPlayerTurn();
      int player = turn.getCurrentPlayer();
      System.out.println();
      System.out.println("It's Player " + player + "'s turn!");
      playTurn(turn);
      int score = game.scorePlayerTurn(turn);
      System.out.println("Player " + player + "'s score: " + score);
      game.nextPlayer();
    }
    int winner = game.getWinningPlayer();
    System.out.println("Player " + winner + " wins!");
    System.out.println(game);
  }
}
