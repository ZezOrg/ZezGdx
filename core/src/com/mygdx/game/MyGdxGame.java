package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MyGdxGame extends ApplicationAdapter implements GestureDetector.GestureListener {

    Stage mainStage;
    GestureDetector gd;
    Objekat lopta;
    Objekat gameover;
    float dt;
    double randomX;
    double randomY;

    @Override
    public void create() {
        mainStage = new Stage();

        gameover = new Objekat();
        gameover.setTexture(new Texture("gameover.png"));
        gameover.setVisible(false);
        gameover.setWidth(300);
        gameover.setHeight(100);
        gameover.setPosition(Gdx.graphics.getWidth() / 2 - gameover.getWidth() / 2, Gdx.graphics.getHeight() / 2 - gameover.getHeight() / 2);

        lopta = new Objekat();
        lopta.setTexture(new Texture("ball2.png"));
        lopta.setWidth(30);
        lopta.setHeight(30);
        lopta.setPosition(Gdx.graphics.getWidth() / 2 - lopta.getWidth() / 2, Gdx.graphics.getHeight() / 2 - lopta.getHeight() / 2);
        lopta.brzinaX = 50;
        lopta.brzinaY = 50;
        gd = new GestureDetector(this);
        Gdx.input.setInputProcessor(gd);
        mainStage.addActor(lopta);
        mainStage.addActor(gameover);
    }

    @Override
    public void render() {

        if (lopta.getX() < 0 || lopta.getY() < 0 || lopta.getX() + lopta.getWidth() > Gdx.graphics.getWidth() || lopta.getY() + lopta.getHeight() > Gdx.graphics.getHeight()) {
            lopta.brzinaX = 0;
            lopta.brzinaY = 0;
            gameover.setVisible(true);

        }


        if (Gdx.input.justTouched()) {
            lopta.started = true;
            lopta.setSize(lopta.getWidth() + 10, lopta.getHeight() + 10);
            lopta.brzinaX *= 1.1;
            lopta.brzinaY *= 1.1;
            lopta.brzinaX = -lopta.brzinaX;
            lopta.brzinaY = -lopta.brzinaY;
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
