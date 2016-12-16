package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class MyGdxGame extends ApplicationAdapter {

    private Stage mainStage;
    private float dt;
    private double randomX;
    private double randomY;
    private int min = 10000;
    private int max = 10000;
    private double safeClickZone;
    private long startTime = 0;
    private long elapsedTime = 0;
    private int clickCount = 0;
    private boolean clickable = true;
    private static final int RECT_CORRECTION = 5;
    private Preferences prefs;


    @Override
    public void create() {
        mainStage = new StartStage();
        Gdx.input.setInputProcessor(mainStage);
        safeClickZone = 0.10 * Gdx.graphics.getWidth();
        prefs = Gdx.app.getPreferences("Scores");
    }

    @Override
    public void render() {

        if (mainStage instanceof GameStage) {
            Objekat lopta = ((GameStage) mainStage).getLopta();
            Objekat gameover = ((GameStage) mainStage).getGameover();
            Objekat restart = ((GameStage) mainStage).getRestart();
            Objekat rect = ((GameStage) mainStage).getRect();
            Label timeLabel = ((GameStage) mainStage).getTimeLabel();
            Label tapLabel = ((GameStage) mainStage).getTapLabel();
            Label bestScoreTime = ((GameStage) mainStage).getBestScoreTime();
            Label bestScoreTaps = ((GameStage) mainStage).getBestScoreTaps();

            long milisBest = getBestTime() % 1000;
            long elapsedSecondsBest = getBestTime() / 1000;
            long minBest = elapsedSecondsBest / 60;
            long secBest = elapsedSecondsBest % 60;
            bestScoreTime.setText("Best : " + minBest + ":" + secBest + "." + milisBest);
            bestScoreTaps.setText("Best : " + getBestTaps());

            if (lopta.getX() <= rect.getX() + RECT_CORRECTION || lopta.getY() <= rect.getY() + RECT_CORRECTION || lopta.getX() + lopta.getWidth() >= rect.getX() + rect.getWidth() - RECT_CORRECTION || lopta.getY() + lopta.getHeight() >= rect.getY() + rect.getHeight() - RECT_CORRECTION) {
                lopta.brzinaX = 0;
                lopta.brzinaY = 0;
                clickable = false;
                ((GameStage) mainStage).setResizeBall(false);
                gameover.setVisible(true);
                restart.setVisible(true);
                checkIsThisBestScore(elapsedTime, clickCount);
                Gdx.input.setInputProcessor(mainStage);
                if (((GameStage) mainStage).isRestartClicked()) {
                    mainStage.dispose();
                    mainStage = new GameStage();
                    startTime = 0;
                    clickable = true;
                    clickCount = 0;
                }
            } else {
                elapsedTime = (System.currentTimeMillis() - startTime);
            }

            if (startTime != 0) {
                long milis = elapsedTime % 1000;
                long elapsedSeconds = elapsedTime / 1000;
                long min = elapsedSeconds / 60;
                long sec = elapsedSeconds % 60;
                timeLabel.setText("Time : " + min + ":" + sec + "." + milis);
            } else {
                timeLabel.setText("Time : 0:0.0");
            }

            tapLabel.setText("Tap count : " + clickCount);

            if (Gdx.input.justTouched()) {
                if (clickable) {
                    clickCount++;
                }
                if (clickCount == 1) {
                    startTime = System.currentTimeMillis();
                }
                lopta.started = true;
                if (((GameStage) mainStage).isResizeBall()) {
                    lopta.setSize(lopta.getWidth() + 3, lopta.getHeight() + 3);
                }
                lopta.brzinaX *= 1.03;
                lopta.brzinaY *= 1.03;
                randomX = -min + (int) (Math.random() * ((max - (-min)) + 1));
                randomY = -min + (int) (Math.random() * ((max - (-min)) + 1));

                if (lopta.getX() < rect.getX() + safeClickZone || lopta.getX() + lopta.getWidth() > rect.getX() + rect.getWidth() - safeClickZone) {
                    lopta.brzinaX = -lopta.brzinaX;
                } else if (randomX < 2500) {
                    lopta.brzinaX = -lopta.brzinaX;
                }
                if (lopta.getY() < rect.getY() + safeClickZone || lopta.getY() + lopta.getHeight() > rect.getY() + rect.getHeight() - safeClickZone) {
                    lopta.brzinaY = -lopta.brzinaY;
                } else if (randomY < 2500) {
                    lopta.brzinaY = -lopta.brzinaY;
                }
            }
        }

        if (mainStage instanceof StartStage) {
            if (((StartStage) mainStage).isStartClicked()) {
                mainStage.dispose();
                mainStage = new GameStage();
            }
        }

        dt = Gdx.graphics.getDeltaTime();
        mainStage.act(dt);


        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mainStage.draw();
    }

    public void saveScore(long time, int taps) {
        prefs.putLong("time", time);
        prefs.putInteger("taps", taps);
        prefs.flush();
    }

    public long getBestTime(){
        return prefs.getLong("time", 0);
    }

    public int getBestTaps(){
        return prefs.getInteger("taps", 0);
    }

    public boolean checkIsThisBestScore(long time, int taps){
        if(time < getBestTime()){
            return false;
        }else if(time == getBestTime()){
            if(taps < getBestTaps()){
                return false;
            }
        }else{
            saveScore(time, taps);
        }
        return true;
    }

}
