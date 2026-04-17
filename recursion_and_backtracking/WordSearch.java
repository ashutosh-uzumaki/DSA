package recursion_and_backtracking;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    if(helper(0, i, j, word, board, visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean helper(int idx, int row, int col, String word, char[][] board, boolean[][] visited) {
        // 1️⃣ Bounds + Visited + Mismatch check
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length ||
                visited[row][col] || board[row][col] != word.charAt(idx)) {
            return false;
        }

        // 2️⃣ Found the last character
        if (idx == word.length() - 1) return true;

        // 3️⃣ Mark & Explore
        visited[row][col] = true;
        boolean found = helper(idx + 1, row - 1, col, word, board, visited) ||
                helper(idx + 1, row + 1, col, word, board, visited) ||
                helper(idx + 1, row, col + 1, word, board, visited) ||
                helper(idx + 1, row, col - 1, word, board, visited);

        // 4️⃣ 🔑 BACKTRACK
        visited[row][col] = false;
        return found;
    }
}
