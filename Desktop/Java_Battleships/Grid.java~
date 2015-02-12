public class Grid {

    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;

    private final Piece[][] grid = new Piece[HEIGHT][WIDTH];

    public Grid() {
      for (int i = 0; i < HEIGHT; i++) {
        for (int j = 0; j < WIDTH; j++) {
          grid[i][j] = Piece.WATER;
        }
      } 
    }

    public boolean canPlace(Coordinate c, int size, boolean isDown) {
      int row = c.getRow();
      int col = c.getColumn();
      if (isDown) {
        for (int i = 0; i < size; i++) {
          if (!isEmpty(row+i, col) || isOutside(row+i, col)) {
            return false;
          }
        }
        return true;
      } else {
        for (int i = 0; i < size; i++) {
          if (!isEmpty(row, col+i) || isOutside(row, col+i)) {
            return false;
          }
        }
        return true;
      }
    }

    private boolean isEmpty(int row, int col) {
      // Returns true iff the cell is empty.
      return grid[row][col] == Piece.WATER;
    }

    private boolean isOutside(int row, int col) {
      // Returns true iff the cell is outside the grid.
      return row < 0 && row > 9
          && col < 0 && col > 9;
    }

    public void placeShip(Coordinate c, int size, boolean isDown) {
      int row = c.getRow();
      int col = c.getColumn();
      if (isDown) {
        for (int i = 0; i < size; i++) {
          grid[row+i][col] = Piece.SHIP;
        }
      } else {
        for (int i = 0; i < size; i++) {
          grid[row][col+i] = Piece.SHIP;
        }
      }
    }

    public boolean wouldAttackSucceed(Coordinate c) {
      int row = c.getRow();
      int col = c.getColumn();
      return grid[row][col] == Piece.SHIP;
    }

    public void attackCell(Coordinate c) {
      int row = c.getRow();
      int col = c.getColumn();
      Piece p = grid[row][col];
      switch (p) {
        case SHIP : 
          grid[row][col] = Piece.DAMAGED_SHIP; break;
        case WATER :
          grid[row][col] = Piece.MISS; break;
        default : break;       
      }
    }

    public boolean areAllSunk() {
      for (int i = 0; i < HEIGHT; i++) {
        for (int j = 0; j < WIDTH; j++) {
          if (grid[i][j] == Piece.SHIP) {
            return false;
          }
        }
      } 
      return true;
    }

    public String toPlayerString() {
      Piece[][] hiddenGrid = Util.deepClone(grid);
      for (int i = 0; i < HEIGHT; i++) {
        for (int j = 0; j < WIDTH; j++) {
          if (grid[i][j] == Piece.SHIP) {
            hiddenGrid[i][j] = Piece.WATER;
          }
        }
      } 
      return renderGrid(hiddenGrid);
    }


    public String toString() {
        return renderGrid(grid);
    }

    private static String renderGrid(Piece[][] grid) {
        StringBuilder sb = new StringBuilder();
        sb.append(" 0123456789\n");
        for (int i = 0; i < grid.length; i++) {
            sb.append((char) ('A' + i));
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i
][j] == null) {
                    return "!";
                }
                switch (grid[i][j]) {
                case SHIP:
                    sb.append('#');
                    break;
                case DAMAGED_SHIP:
                    sb.append('*');
                    break;
                case MISS:
                    sb.append('o');
                    break;
                case WATER:
                    sb.append('.');
                    break;
                }

            }
            sb.append('\n');
        }

        return sb.toString();
    }
}
