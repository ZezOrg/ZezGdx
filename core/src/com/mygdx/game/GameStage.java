package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
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

    public GameStage() {

        gameover = new Objekat();
        gameover.setTexture(new Texture("gameover.png"));
        gameover.setVisible(false);
        gameover.setWidth(300);
        gameover.setHeight(100);
        gameover.setPosition(Gdx.graphics.getWidth() / 2 - gameover.getWidth() / 2, Gdx.graphics.getHeight() / 2 - gameover.getHeight() / 2);

        restart = new Objekat();
        restart.setTexture(new Texture("restart.png"));
        restart.setVisible(false);
        restart.setWidth(300);
        restart.setHeight(100);
        restart.setPosition(Gdx.graphics.getWidth() / 2 - restart.getWidth() / 2, 0);
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
        lopta.setWidth(30);
        lopta.setHeight(30);
        lopta.setPosition(Gdx.graphics.getWidth() / 2 - lopta.getWidth() / 2, Gdx.graphics.getHeight() / 2 - lopta.getHeight() / 2);
        lopta.brzinaX = 50;
        lopta.brzinaY = 50;

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

}
