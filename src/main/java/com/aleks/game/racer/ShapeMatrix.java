package com.aleks.game.racer;

public class ShapeMatrix {
  public static final int[][] PLAYER = new int[][]{
	  {0, 0, 123, 123, 0, 0},
	  {1, 0, 123, 123, 0, 1},
	  {1, 1, 123, 123, 1, 1},
	  {1, 0, 123, 123, 0, 1},
	  {0, 0, 123, 123, 0, 0},
	  {1, 0, 123, 123, 0, 1},
	  {1, 1, 123, 123, 1, 1},
	  {1, 0, 123, 123, 0, 1}
  };

  public static final int[][] PLAYER_DEAD = new int[][]{
	  {0, 0, 5, 5, 0, 0},
	  {1, 0, 5, 5, 0, 1},
	  {1, 1, 5, 5, 1, 1},
	  {1, 0, 5, 5, 0, 1},
	  {0, 0, 5, 5, 0, 0},
	  {1, 0, 5, 5, 0, 1},
	  {1, 1, 5, 5, 1, 1},
	  {1, 0, 5, 5, 0, 1}
  };

  public static final int[][] SPORT_CAR = new int[][]{
	  {5, 0, 5, 5, 0, 5},
	  {5, 1, 5, 5, 1, 5},
	  {5, 0, 5, 5, 0, 5},
	  {0, 0, 5, 5, 0, 0},
	  {5, 0, 5, 5, 0, 5},
	  {5, 1, 5, 5, 1, 5},
	  {5, 0, 5, 5, 0, 5},
	  {0, 0, 5, 5, 0, 0},
  };

  public static final int[][] DRUNK_CAR = new int[][]{
	  {3, 0, 3, 3, 0, 3},
	  {3, 1, 3, 3, 1, 3},
	  {3, 0, 3, 3, 0, 3},
	  {0, 0, 3, 3, 0, 0},
	  {3, 0, 3, 3, 0, 3},
	  {3, 1, 3, 3, 1, 3},
	  {3, 0, 3, 3, 0, 3},
	  {0, 0, 3, 3, 0, 0},
  };

  public static final int[][] PASSENGER_CAR = new int[][]{
	  {0, 4, 4, 4, 4, 0},
	  {4, 4, 1, 1, 4, 4},
	  {4, 1, 4, 4, 1, 4},
	  {4, 4, 4, 4, 4, 4},
	  {4, 1, 4, 4, 1, 4},
	  {4, 4, 4, 4, 4, 4},
	  {4, 1, 4, 4, 1, 4},
	  {4, 4, 1, 1, 4, 4},
	  {0, 4, 4, 4, 4, 0}
  };

  public static final int[][] TRUCK = new int[][]{
	  {0, 7, 7, 7, 7, 0},
	  {7, 7, 7, 7, 7, 7},
	  {7, 1, 7, 7, 1, 7},
	  {7, 1, 7, 7, 1, 7},
	  {7, 7, 7, 7, 7, 7},
	  {7, 1, 7, 7, 1, 7},
	  {7, 1, 7, 7, 1, 7},
	  {7, 7, 7, 7, 7, 7},
	  {0, 7, 7, 7, 7, 0},
	  {0, 1, 1, 1, 1, 0},
	  {0, 7, 7, 7, 7, 0},
	  {7, 7, 7, 7, 7, 7},
	  {7, 1, 2, 1, 1, 7},
	  {7, 1, 2, 1, 1, 7},
	  {0, 7, 7, 7, 7, 0},
  };

  public static final int[][] BUS = new int[][]{
	  {0, 8, 8, 8, 8, 0},
	  {8, 8, 8, 8, 8, 8},
	  {8, 1, 8, 8, 1, 8},
	  {8, 1, 8, 8, 1, 8},
	  {8, 8, 8, 8, 8, 8},
	  {8, 1, 8, 8, 1, 8},
	  {8, 1, 8, 8, 1, 8},
	  {8, 8, 8, 8, 8, 8},
	  {8, 1, 8, 8, 1, 8},
	  {8, 1, 8, 8, 1, 8},
	  {8, 8, 8, 8, 8, 8},
	  {8, 1, 2, 1, 1, 8},
	  {8, 1, 2, 1, 1, 8},
	  {8, 1, 2, 1, 1, 8},
	  {0, 8, 8, 8, 8, 0},
  };

  public static final int[][] ROAD_MARKING = new int[][]{
	  {2},
	  {2},
	  {2},
	  {2},
  };

  public static final int[][] FINISH_LINE = new int[][]{
	  {2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0},
	  {0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2},
	  {2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0},
	  {0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2},
	  {2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0},
	  {0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2},
	  {2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0}
  };

  public static final int[][] THORN = new int[][]{
	  {2, 0, 0, 0, 2, 0},
	  {7, 1, 2, 0, 7, 1},
	  {0, 0, 7, 1, 0, 0},
	  {2, 0, 0, 0, 2, 0},
	  {7, 1, 2, 0, 7, 1},
	  {0, 0, 7, 1, 0, 0}
  };
}
