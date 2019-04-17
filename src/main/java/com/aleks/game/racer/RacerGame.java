package com.aleks.game.racer;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Key;
import com.aleks.game.racer.road.RoadManager;

public class RacerGame extends Game {
  public static final int WIDTH = 64;
  public static final int HEIGHT = 64;
  public static final int CENTER_X = WIDTH / 2;
  public static final int ROADSIDE_WIDTH = 14;
  private static final int RACE_GOAL_CARS_COUNT = 40;
  private int score;
  private RoadMarking roadMarking;
  private FinishLine finishLine;
  private PlayerCar player;
  private RoadManager roadManager;
  private ProgressBar progressBar;
  private boolean isGameStopped;

  private void moveAll() {
	roadManager.move(player.speed);
	roadMarking.move(player.speed);
	finishLine.move(player.speed);
	progressBar.move(roadManager.getPassedCarsCount());
	player.move();
  }

  private void createGame() {
	isGameStopped = false;
	score = 3500;
	progressBar = new ProgressBar(RACE_GOAL_CARS_COUNT);
	roadMarking = new RoadMarking();
	player = new PlayerCar();
	roadManager = new RoadManager();
	finishLine = new FinishLine();
	drawScene();
	setTurnTimer(40);
  }

  private void gameOver() {
	isGameStopped = true;
	showMessageDialog(Color.DIMGREY, "GAME OVER", Color.GREEN, 28);
	stopTurnTimer();
	player.stop();
  }

  private void win() {
	isGameStopped = true;
	showMessageDialog(Color.DIMGREY, "YOU WIN!!!", Color.GREEN, 28);
	stopTurnTimer();
  }

  private void drawScene() {
	drawField();
	finishLine.draw(this);
	roadMarking.draw(this);
	player.draw(this);
	roadManager.draw(this);
	progressBar.draw(this);
  }

  private void drawField() {
	for (int i = 0; i < HEIGHT; i++) {
	  setCellColor(CENTER_X, i, Color.WHITE);
	}
	for (int i = 0; i < ROADSIDE_WIDTH; i++) {
	  for (int j = 0; j < HEIGHT; j++) {
		setCellColor(i, j, Color.GREEN);
	  }
	}
	for (int i = WIDTH - ROADSIDE_WIDTH; i < WIDTH; i++) {
	  for (int j = 0; j < HEIGHT; j++) {
		setCellColor(i, j, Color.GREEN);
	  }
	}
	for (int i = ROADSIDE_WIDTH; i < CENTER_X; i++) {
	  for (int j = 0; j < HEIGHT; j++) {
		setCellColor(i, j, Color.DIMGREY);
	  }
	}
	for (int i = CENTER_X + 1; i < WIDTH - ROADSIDE_WIDTH; i++) {
	  for (int j = 0; j < HEIGHT; j++) {
		setCellColor(i, j, Color.DIMGREY);
	  }
	}
  }


  @Override
  public void onTurn(int step) {
	if (roadManager.checkCrush(player)) {
	  gameOver();
	} else if (finishLine.isCrossed(player)) {
	  win();
	} else {
	  roadManager.generateNewRoadObjects(this);
	  if (roadManager.getPassedCarsCount() >= RACE_GOAL_CARS_COUNT) {
		finishLine.show();
	  }
	  score -= 5;
	  setScore(score);
	  moveAll();
	}
	drawScene();
  }

  @Override
  public void onKeyPress(Key key) {
	if (key == Key.RIGHT) {
	  player.setDirection(Direction.RIGHT);
	} else if (key == Key.LEFT) {
	  player.setDirection(Direction.LEFT);
	} else if (key == Key.SPACE && isGameStopped) {
	  createGame();
	} else if (key == Key.UP) {
	  player.speed = 2;
	}
  }

  @Override
  public void onKeyReleased(Key key) {
	if (key == Key.RIGHT && player.getDirection() == Direction.RIGHT) {
	  player.setDirection(Direction.NONE);
	}
	if (key == Key.LEFT && player.getDirection() == Direction.LEFT) {
	  player.setDirection(Direction.NONE);
	}
	if (key == Key.UP) {
	  player.speed = 1;
	}
  }

  @Override
  public void setCellColor(int x, int y, Color color) {
	if (x >= 0 && x <= (WIDTH - 1) && y >= 0 && y <= (HEIGHT - 1)) {
	  super.setCellColor(x, y, color);
	}

  }

  @Override
  public void initialize() {
	showGrid(false);
	setScreenSize(WIDTH, HEIGHT);
	createGame();
  }
}
