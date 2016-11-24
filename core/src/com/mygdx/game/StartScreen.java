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

/**
 * Created by Majki on 23.11.2016.
 */

public class StartScreen extends ApplicationAdapter implements GestureDetector.GestureListener {

    private Stage mainStage;
    private float dt;
    private Objekat start;
    private Objekat settings;
    private Objekat exit;

    @Override
    public void create() {
        mainStage = new Stage();

        start = new Objekat();
        start.setTexture(new Texture("start.png"));
        start.setVisible(true);
        start.setWidth(250);
        start.setHeight(100);
        start.setPosition(Gdx.graphics.getWidth() / 2 - start.getWidth() / 2, Gdx.graphics.getHeight() / 2 - start.getHeight() / 2 + 150);
        start.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                new MyGdxGame();
            }
        });

        settings = new Objekat();
        settings.setTexture(new Texture("settings.png"));
        settings.setVisible(true);
        settings.setWidth(200);
        settings.setHeight(70);
        settings.setPosition(Gdx.graphics.getWidth() / 2 - settings.getWidth() / 2, Gdx.graphics.getHeight() / 2 - settings.getHeight() / 2);
//        settings.addListener(new ClickListener(){
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                super.clicked(event, x, y);
//                new MyGdxGame();
//            }
//        });

        exit = new Objekat();
        exit.setTexture(new Texture("exit.png"));
        exit.setVisible(true);
        exit.setWidth(100);
        exit.setHeight(50);
        exit.setPosition(Gdx.graphics.getWidth() / 2 - exit.getWidth() / 2, Gdx.graphics.getHeight() / 2 - exit.getHeight() / 2 -  100);
//        exit.addListener(new ClickListener(){
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                super.clicked(event, x, y);
//                dispose();
//            }
//        });


        mainStage.addActor(start);
        mainStage.addActor(settings);
        mainStage.addActor(exit);

        Gdx.input.setInputProcessor(mainStage);
    }

    @Override
    public void render() {
        dt = Gdx.graphics.getDeltaTime();
        mainStage.act(dt);


        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mainStage.draw();
    }


//    @Override
//    public void dispose() {
//        super.dispose();
//        mainStage.dispose();
//    }

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

