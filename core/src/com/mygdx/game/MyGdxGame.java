package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MyGdxGame extends ApplicationAdapter implements GestureDetector.GestureListener {

    Stage mainStage;
    Objekat lopta;
    Objekat gameover;
    Objekat restart;
    float dt;
    double randomX;
    double randomY;
    int min = 10000;
    int max = 10000;
    boolean resizeBall;

    @Override
    public void create() {
        mainStage = new Stage();

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
        restart.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                create();
            }
        });

        lopta = new Objekat();
        lopta.setTexture(new Texture("ball2.png"));
        lopta.setWidth(30);
        lopta.setHeight(30);
        lopta.setPosition(Gdx.graphics.getWidth() / 2 - lopta.getWidth() / 2, Gdx.graphics.getHeight() / 2 - lopta.getHeight() / 2);
        lopta.brzinaX = 50;
        lopta.brzinaY = 50;

        mainStage.addActor(lopta);
        mainStage.addActor(gameover);
        mainStage.addActor(restart);
        resizeBall = true;

        Gdx.input.setInputProcessor(mainStage);
    }

    @Override
    public void render() {

        if (lopta.getX() < 0 || lopta.getY() < 0 || lopta.getX() + lopta.getWidth() > Gdx.graphics.getWidth() || lopta.getY() + lopta.getHeight() > Gdx.graphics.getHeight()) {
            lopta.brzinaX = 0;
            lopta.brzinaY = 0;
            gameover.setVisible(true);
            resizeBall = false;
            restart.setVisible(true);
        }

        if (Gdx.input.justTouched()) {
            lopta.started = true;
            if (resizeBall) {
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

        dt = Gdx.graphics.getDeltaTime();
        mainStage.act(dt);


        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mainStage.draw();
    }


    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {

        return false;
    }

    @Override
    public boolean longPress(float x, float y) {

        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }

    @Override
    public void pinchStop() {

    }
}
