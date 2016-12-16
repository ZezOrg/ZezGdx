package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Majki on 27.11.2016.
 */

public class GameStage extends Stage {

    private Objekat lopta;
    private Objekat gameover;
    private Objekat restart;
    private double randomX;
    private double randomY;
    private int min = 10000;
    private int max = 10000;
    private boolean restartClicked;
    private boolean resizeBall;
    private Objekat rect;
    private Label timeLabel;
    private Label tapLabel;
    private Label bestScoreTime;
    private Label bestScoreTaps;
    private BitmapFont font;
    private float rectDistance;
    private float ballSize;
    private float someScales;


    public GameStage() {

        rectDistance = (float) (Gdx.graphics.getWidth() * 0.04);
        ballSize = (float) (Gdx.graphics.getWidth() * 0.041);
        someScales = (float) (Gdx.graphics.getWidth() * 0.14);

        rect = new Objekat();
        rect.setTexture(new Texture("rect.png"));
        rect.setPosition(rectDistance, rectDistance);
        rect.setHeight(getHeight() - rectDistance * 5);
        rect.setWidth(getWidth() - rectDistance * 2);

        gameover = new Objekat();
        gameover.setTexture(new Texture("gameover.png"));
        gameover.setVisible(false);
        gameover.setWidth(someScales * 3);
        gameover.setHeight(someScales);
        gameover.setPosition(Gdx.graphics.getWidth() / 2 - gameover.getWidth() / 2, Gdx.graphics.getHeight() / 2 - gameover.getHeight() / 2);

        restart = new Objekat();
        restart.setTexture(new Texture("restart3.png"));
        restart.setVisible(false);
        restart.setWidth(someScales);
        restart.setHeight(someScales);
        restart.setPosition(Gdx.graphics.getWidth() / 2 - restart.getWidth() / 2, (float) (Gdx.graphics.getHeight() * 0.05));
        restart.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                restartClicked = true;
            }
        });

        restartClicked = false;
        resizeBall = true;

        lopta = new Objekat();
        lopta.setTexture(new Texture("ball2.png"));
        lopta.setWidth(ballSize);
        lopta.setHeight(ballSize);
        lopta.setPosition(Gdx.graphics.getWidth() / 2 - lopta.getWidth() / 2, (rect.getHeight() + 30) / 2 - lopta.getHeight() / 2);
        lopta.brzinaX = someScales;
        lopta.brzinaY = someScales;

        font = new BitmapFont();
        timeLabel = new Label("Time : ", new Label.LabelStyle(font, Color.RED));
        timeLabel.setPosition(Gdx.graphics.getWidth() * 0.05f, Gdx.graphics.getHeight() * 0.91f);
        timeLabel.setFontScale(2);

        tapLabel = new Label("Tap count : ", new Label.LabelStyle(font, Color.RED));
        tapLabel.setPosition(Gdx.graphics.getWidth() * 0.05f, Gdx.graphics.getHeight() * 0.94f);
        tapLabel.setFontScale(2);

        bestScoreTime = new Label("Best : ", new Label.LabelStyle(font, Color.RED));
        bestScoreTime.setPosition(Gdx.graphics.getWidth() * 0.75f, Gdx.graphics.getHeight() * 0.91f);
        bestScoreTime.setFontScale(2);

        bestScoreTaps = new Label("Best : ", new Label.LabelStyle(font, Color.RED));
        bestScoreTaps.setPosition(Gdx.graphics.getWidth() * 0.75f, Gdx.graphics.getHeight() * 0.94f);
        bestScoreTaps.setFontScale(2);

        addActor(timeLabel);
        addActor(tapLabel);
        addActor(bestScoreTime);
        addActor(bestScoreTaps);
        addActor(rect);
        addActor(lopta);
        addActor(gameover);
        addActor(restart);

    }

    public Objekat getLopta() {
        return lopta;
    }

    public void setLopta(Objekat lopta) {
        this.lopta = lopta;
    }

    public Objekat getGameover() {
        return gameover;
    }

    public void setGameover(Objekat gameover) {
        this.gameover = gameover;
    }

    public Objekat getRestart() {
        return restart;
    }

    public void setRestart(Objekat restart) {
        this.restart = restart;
    }

    public double getRandomX() {
        return randomX;
    }

    public void setRandomX(double randomX) {
        this.randomX = randomX;
    }

    public double getRandomY() {
        return randomY;
    }

    public void setRandomY(double randomY) {
        this.randomY = randomY;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public boolean isRestartClicked() {
        return restartClicked;
    }

    public void setRestartClicked(boolean restartClicked) {
        this.restartClicked = restartClicked;
    }

    public boolean isResizeBall() {
        return resizeBall;
    }

    public void setResizeBall(boolean resizeBall) {
        this.resizeBall = resizeBall;
    }

    public Objekat getRect() {
        return rect;
    }

    public void setRect(Objekat rect) {
        this.rect = rect;
    }

    public Label getTimeLabel() {
        return timeLabel;
    }

    public void setTimeLabel(Label timeLabel) {
        this.timeLabel = timeLabel;
    }

    public BitmapFont getFont() {
        return font;
    }

    public void setFont(BitmapFont font) {
        this.font = font;
    }

    public Label getTapLabel() {
        return tapLabel;
    }

    public void setTapLabel(Label tapLabel) {
        this.tapLabel = tapLabel;
    }

    public Label getBestScoreTime() {
        return bestScoreTime;
    }

    public void setBestScoreTime(Label bestScoreTime) {
        this.bestScoreTime = bestScoreTime;
    }

    public Label getBestScoreTaps() {
        return bestScoreTaps;
    }

    public void setBestScoreTaps(Label bestScoreTaps) {
        this.bestScoreTaps = bestScoreTaps;
    }
}
