import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      Grid grid = makeInitialGrid();
      int attacks = 0;
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println("WELCOME TO BATTLESHIPS!");
      System.out.println("-A game for warmongers-");
      System.out.println();
      do {
        System.out.println(grid.toPlayerString());
        System.out.println("Enter the coordinate you wish to attack.");
        String token = input.next();
        while (!(token.length() == 2
              && token.charAt(0) >= 'A' && token.charAt(0) <= 'J' 
              && token.charAt(1) >= '0' && token.charAt(1) <= '9')) {
          System.out.println("Coordinate not valid, try again.");
          input = new Scanner(System.in);
          token = input.next();
        }
        Coordinate c = Util.parseCoordinate(token);
        if (grid.wouldAttackSucceed(c)) {
          System.out.println();
          System.out.println("DIRECT HIT!");
        } 
        System.out.println();
        grid.attackCell(c);
        attacks++;
      } while (!grid.areAllSunk());
      System.out.println();
      System.out.println("CONGRATULATIONS! You've sunk all ships.");
      System.out.println("Attack attempts needed: " + attacks);
      System.out.println();
      System.out.println("GAME OVER");
      System.out.println();
      System.out.println(grid);
    }

    private static Grid makeInitialGrid() {
      Grid grid = new Grid();
      String[] coords = { "A7", "B1", "B4", "D3", "F7", "H1", "H4" };
      int[] sizes = { 2, 4, 1, 3, 1, 2, 5 };
      boolean[] isDowns = { false, true, true, false, false, true, false };
      for (int i = 0; i < coords.length; i++) {
          Coordinate c = Util.parseCoordinate(coords[i]);
          grid.placeShip(c, sizes[i], isDowns[i]);
      }
      return grid;
    }
}
