import java.util.Scanner;

public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String[][] board = new String[ROW][COL];

    public static void main(String[] args) {
        boolean finished = false;
        Scanner in = new Scanner(System.in);
        String player;
        int moveCount;
        int row, col;
        final int MOVES_FOR_WIN = 5;
        final int MOVES_FOR_TIE = 7;

        do {
            player = "X";
            boolean playing = true;
            moveCount = 0;
            clearBoard();

            do {
                showBoard();
                System.out.println("Enter move for " + player);
                row = SafeInput.getRangeInt(in, "Enter row", 1, 3) - 1;
                col = SafeInput.getRangeInt(in, "Enter col", 1, 3) - 1;

                if (isValidMove(row, col)) {
                    board[row][col] = player;
                    moveCount++;

                    if (moveCount >= MOVES_FOR_WIN && isWin(player)) {
                        showBoard();
                        System.out.println("Player " + player + " wins!");
                        playing = false;
                    } else if (moveCount >= MOVES_FOR_TIE && isTie()) {
                        showBoard();
                        System.out.println("It's a tie!");
                        playing = false;
                    } else {
                        player = (player.equals("X")) ? "O" : "X";
                    }
                } else {
                    System.out.println("Invalid move, cell already taken. Try again.");
                }

            } while (playing);

            finished = SafeInput.getYNConfirm(in, "Done Playing?");
        } while (!finished);
    }

    private static void clearBoard() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                board[row][col] = " ";
            }
        }
    }

    private static void showBoard() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                System.out.print(" " + board[row][col] + " ");
                if (col < COL - 1) System.out.print("|");
            }
            System.out.println();
            if (row < ROW - 1) System.out.println("---+---+---");
        }
    }

    private static boolean isValidMove(int row, int col) {
        return board[row][col].equals(" ");
    }

    private static boolean isWin(String player) {
        return isColWin(player) || isRowWin(player) || isDiagnalWin(player);
    }

    private static boolean isColWin(String player) {
        for (int col = 0; col < COL; col++) {
            if (board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isRowWin(String player) {
        for (int row = 0; row < ROW; row++) {
            if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagnalWin(String player) {
        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
            return true;
        }
        if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) {
            return true;
        }
        return false;
    }

    private static boolean isTie() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                if (board[row][col].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }
}
