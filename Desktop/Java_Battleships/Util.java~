import java.util.Arrays;

public class Util {

    private static int letterToIndex(char letter) {
      assert letter >= 'A' && letter <= 'Z';
      return letter - 'A';
    }

    private static int numberToIndex(char number) {
      assert number >= '0' && number <= '9';
      return number - '0';
    }

    public static Coordinate parseCoordinate(String s) {
      assert s.length() == 2;
      int row = letterToIndex(s.charAt(0));
      int column = numberToIndex(s.charAt(1));
      return new Coordinate(row, column);
    }

    public static Piece hideShip(Piece piece) {
      switch (piece) {
        case SHIP : return Piece.WATER;
        default   : return piece;
      }
    }

    public static void hideShips(Piece[][] grid) {
      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
          grid[i][j] = hideShip(grid[i][j]);
        }
      }
    }

    public static Piece[][] deepClone(Piece[][] input) {
        Piece[][] output = new Piece[input.length][];
        for (int i = 0; i < input.length; i++) {
            output[i] = Arrays.copyOf(input[i], input[i].length);
        }
        return output;
    }
}
