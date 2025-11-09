import java.io.*;
import java.util.*;

public class B_Make_Connected{
    static int n;
    static char[][] grid;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine().trim());
            grid = new char[n][n];
            for (int i = 0; i < n; i++) {
                grid[i] = br.readLine().toCharArray();
            }

            if (!hasAnyBlack()) {
                System.out.println("YES");
                continue;
            }

            if (!checkNoTriples(grid)) {
                System.out.println("NO");
                continue;
            }

            if (canConnectAllBlack()) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    // Check if there's any black cell
    static boolean hasAnyBlack() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == '#')
                    return true;
        return false;
    }

    // Check for triple blacks in rows or columns
    static boolean checkNoTriples(char[][] g) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j + 2 < n; j++)
                if (g[i][j] == '#' && g[i][j + 1] == '#' && g[i][j + 2] == '#')
                    return false;

        for (int j = 0; j < n; j++)
            for (int i = 0; i + 2 < n; i++)
                if (g[i][j] == '#' && g[i + 1][j] == '#' && g[i + 2][j] == '#')
                    return false;

        return true;
    }

    // Try connecting all black cells by painting minimal whites
    static boolean canConnectAllBlack() {
        boolean[][] visited = new boolean[n][n];
        int[] start = findFirstBlack();
        if (start == null) return false;

        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (visited[nr][nc]) continue;

                if (grid[nr][nc] == '#') {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                } else if (canPaint(nr, nc)) {
                    grid[nr][nc] = '#';
                    if (!checkNoTriples(grid)) {
                        grid[nr][nc] = '.'; // revert if triple formed
                        continue;
                    }
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        // check if all black cells are connected
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == '#' && !visited[i][j])
                    return false;
        return true;
    }

    // Find first black cell
    static int[] findFirstBlack() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == '#')
                    return new int[]{i, j};
        return null;
    }

    // Can we paint this white cell safely?
    static boolean canPaint(int r, int c) {
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == '#')
                return true;
        }
        return false;
    }
}
