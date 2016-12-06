package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Majki  on 27.11.2016.
 */

public class StartStage extends Stage{

    private Objekat start;
    private Objekat settings;
    private Objekat exit;
    private boolean startClicked = false;

    public StartStage(){

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
                startClicked = true;
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
//
//            }
//        });

        exit = new Objekat();
        exit.setTexture(new Texture("exit.png"));
        exit.setVisible(true);
        exit.setWidth(100);
        exit.setHeight(50);
        exit.setPosition(Gdx.graphics.getWidth() / 2 - exit.getWidth() / 2, Gdx.graphics.getHeight() / 2 - exit.getHeight() / 2 -  100);
        exit.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                dispose();
                Gdx.app.exit();
            }
        });

        addActor(start);
        addActor(settings);
        addActor(exit);
    }

    public Objekat getStart() {
        return start;
    }

    public void setStart(Objekat start) {
        this.start = start;
    }

    public Objekat getSettings() {
        return settings;
    }

    public void setSettings(Objekat settings) {
        this.settings = settings;
    }

    public Objekat getExit() {
        return exit;
    }

    public void setExit(Objekat exit) {
        this.exit = exit;
    }

    public boolean isStartClicked() {
        return startClicked;
    }

    public void setStartClicked(boolean startClicked) {
        this.startClicked = startClicked;
    }
}
