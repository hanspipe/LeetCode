package leetCode;

/*
 * On a N * N grid, we place some 1 * 1 * 1 cubes that are axis-aligned with the x, y, and z axes.

Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).

Now we view the projection of these cubes onto the xy, yz, and zx planes.

A projection is like a shadow, that maps our 3 dimensional figure to a 2 dimensional plane. 

Here, we are viewing the "shadow" when looking at the cubes from the top, the front, and the side.

Return the total area of all three projections.
 */
public class Problem_883_ProjectionAreaof3DShapes {

	public static void main(String[] args) {
		int[][] g = {{1,2},{3,4}};
		System.out.println(projectionArea(g));
	}

	public static int projectionArea(int[][] grid) {
		int xy = 0;
		int xz = 0;
		int yz = 0;

		for (int i = 0; i < grid.length; i++) {
			int temp1 = 0;
			int temp2 = 0;
			for (int j = 0; j < grid.length; j++) {
				temp1 = Math.max(temp1, grid[i][j]);
				temp2 = Math.max(temp2, grid[j][i]);
				if(grid[i][j] != 0)
					xy += 1;
			}
			xz += temp1;
			yz += temp2;
		}

		return xy + xz + yz;
	}
}
