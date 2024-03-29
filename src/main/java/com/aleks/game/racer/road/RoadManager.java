package com.aleks.game.racer.road;

import com.javarush.engine.cell.Game;
import com.aleks.game.racer.PlayerCar;
import com.aleks.game.racer.RacerGame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RoadManager {
  public static final int LEFT_BORDER = RacerGame.ROADSIDE_WIDTH;
  public static final int RIGHT_BORDER = RacerGame.WIDTH - LEFT_BORDER;
  private static final int FIRST_LANE_POSITION = 16;
  private static final int FOURTH_LANE_POSITION = 44;
  private List<RoadObject> items = new ArrayList<>();
  private static final int PLAYER_CAR_DISTANCE = 12;
  private int passedCarsCount = 0;

  public int getPassedCarsCount() {
	return passedCarsCount;
  }

  public void draw(Game game) {
	for (RoadObject ro : items) {
	  ro.draw(game);
	}
  }

  public void move(int boost) {
	for (RoadObject ro : items) {
	  ro.move(boost + ro.speed, items);
	}
	deletePassedItems();
  }

  public void generateNewRoadObjects(Game game) {
	generateThorn(game);
	generateRegularCar(game);
	generateMovingCar(game);
  }

  public boolean checkCrush(PlayerCar playerCar) {
	for (RoadObject ro : items) {
	  if (ro.isCollision(playerCar)) {
		return true;
	  }
	}
	return false;
  }

  private boolean isRoadSpaceFree(RoadObject object) {
	for (RoadObject ro : items) {
	  if (ro.isCollisionWithDistance(object, PLAYER_CAR_DISTANCE)) {
		return false;
	  }
	}
	return true;
  }

  private boolean isMovingCarExists() {
	for (RoadObject ro : items) {
	  if (ro instanceof MovingCar) {
		return true;
	  }
	}
	return false;
  }

  private RoadObject createRoadObject(RoadObjectType type, int x, int y) {
	if (type.equals(RoadObjectType.THORN)) {
	  return new Thorn(x, y);
	} else if (type.equals(RoadObjectType.DRUNK_CAR)) {
	  return new MovingCar(x, y);
	} else {
	  return new Car(type, x, y);
	}
  }

  private void generateRegularCar(Game game) {
	int carTypeNumber = game.getRandomNumber(4);
	if (game.getRandomNumber(100) < 30) {
	  addRoadObject(RoadObjectType.values()[carTypeNumber], game);
	}

  }

  private void addRoadObject(RoadObjectType type, Game game) {
	int x = game.getRandomNumber(FIRST_LANE_POSITION, FOURTH_LANE_POSITION);
	int y = -1 * RoadObject.getHeight(type);

	RoadObject ro = createRoadObject(type, x, y);
	if (isRoadSpaceFree(ro)) {
	  items.add(ro);
	}
  }

  private boolean isThornExists() {
	for (RoadObject ro : items) {
	  if (ro.type == RoadObjectType.THORN) {
		return true;
	  }
	}
	return false;
  }

  private void generateThorn(Game game) {
	int randomNumber = game.getRandomNumber(100);
	if (randomNumber < 10 && !isThornExists()) {
	  addRoadObject(RoadObjectType.THORN, game);
	}
  }

  private void generateMovingCar(Game game) {
	if (game.getRandomNumber(100) < 10 && !isMovingCarExists()) {
	  addRoadObject(RoadObjectType.DRUNK_CAR, game);
	}
  }

  private void deletePassedItems() {
	Iterator<RoadObject> iteratorRoadObject = items.iterator();
	while (iteratorRoadObject.hasNext()) {
	  RoadObject nextRoadObject = iteratorRoadObject.next();
	  if (nextRoadObject.y >= RacerGame.HEIGHT) {
		if (!nextRoadObject.type.equals(RoadObjectType.THORN)) {
		  passedCarsCount++;
		}
		iteratorRoadObject.remove();
	  }
	}
  }

}
