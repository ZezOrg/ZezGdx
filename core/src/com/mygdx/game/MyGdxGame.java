package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MyGdxGame extends ApplicationAdapter {

    private Stage mainStage;
    private float dt;
    private double randomX;
    private double randomY;
    private int min = 10000;
    private int max = 10000;

    @Override
    public void create() {
        mainStage = new StartStage();
        Gdx.input.setInputProcessor(mainStage);
    }

    @Override
    public void render() {

        if (mainStage instanceof GameStage) {
            Objekat lopta = ((GameStage) mainStage).getLopta();
            Objekat gameover = ((GameStage) mainStage).getGameover();
            Objekat restart = ((GameStage) mainStage).getRestart();

            if (lopta.getX() < 0 || lopta.getY() < 0 || lopta.getX() + lopta.getWidth() > Gdx.graphics.getWidth() || lopta.getY() + lopta.getHeight() > Gdx.graphics.getHeight()) {
                lopta.brzinaX = 0;
                lopta.brzinaY = 0;
                ((GameStage) mainStage).setResizeBall(false);
                gameover.setVisible(true);
                restart.setVisible(true);
                Gdx.input.setInputProcessor(mainStage);
                if(((GameStage) mainStage).isRestartClicked()){
                    mainStage.dispose();
                    mainStage = new GameStage();
                }
            }

            if (Gdx.input.justTouched()) {
                lopta.started = true;
                if (((GameStage) mainStage).isResizeBall()) {
                    lopta.setSize(lopta.getWidth() + 3, lopta.getHeight() + 3);
                }
                lopta.brzinaX *= 1.03;
                lopta.brzinaY *= 1.03;
                randomX = -min + (int) (Math.random() * ((max - (-min)) + 1));
                randomY = -min + (int) (Math.random() * ((max - (-min)) + 1));
                if (randomX < 2500) {
                    lopta.brzinaX = -lopta.brzinaX;
                }
                if (randomY < 2500) {
                    lopta.brzinaY = -lopta.brzinaY;
                }
            }
        }

        if (mainStage instanceof StartStage) {
            if (((StartStage) mainStage).isStartClicked()) {
                mainStage = new GameStage();
            }
        }

        dt = Gdx.graphics.getDeltaTime();
        mainStage.act(dt);


        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mainStage.draw();
    }

}
