public class Main {
	
	private static int[][] matrix = {
			{0, 1, 1, 0, 1, 0, 0},
			{0, 0, 0, 0, 0, 1, 0},
			{0, 1, 0, 1, 0, 0, 1},
			{1, 1, 1, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 1, 0},
			{0, 1, 1, 1, 1, 1, 1},
			{0, 0, 0, 0, 0, 0, 0}
	};
	
	private static int M = matrix.length;

	private static boolean[][] visited = new boolean[M][M];
	private static int[][] path = new int[M][M];
	
	public static boolean dfs (int x, int y) {
		
		if (x < 0 || y < 0 || x >= M || y >= M)
			return false;
		
		if (visited [x][y] || matrix[x][y] == 1)
			return false;
		
		visited[x][y] = true;
		path[x][y] = 1;
		
		showPath();
		
		if (dfs(x+1,y) || dfs(x-1,y) || dfs(x,y+1) || dfs(x,y-1))
			return true;
		
		if (y == M - 1 && x == M - 1)
			return true;
		
		path[x][y] = 0;
		return false;

	}
	
	private static void showPath() {
		
		for (int[] row : path) {
			for (int ceil : row) {
				System.out.print(ceil == 1 ? '@' : '.');
			}
			System.out.println();
		}
		
		System.out.println();
		
	}

	public static void main(String[] args) {
		if (dfs(0,0)) {
			System.out.println("Caminho encontrado!");
			showPath();
		} else {
			System.out.println("Camniho não encontrado!");
			showPath();
		}
	}
	
}