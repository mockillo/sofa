/*
 * The MIT License (MIT)
 * 
 * Copyright (c) 2014 Alexander Polden
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
 */

package com.tehforce.sofa;

import java.io.File;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.tehforce.sofa.ui.GameWorld;

/**
 * GameMain handles all rendering setup, and sets up the GameController, GameWorld and stages.
 * 
 * @author mockillo
 *
 */
public class GameMain implements ApplicationListener {
	private OrthographicCamera camera;
	@SuppressWarnings("unused")
	private GameController gc;
	private GameWorld gw;
	private Stage stage;

	File leftTeam, rightTeam;

	public GameMain(File leftTeam, File rightTeam) {
		this.leftTeam = leftTeam;
		this.rightTeam = rightTeam;
	}

	@Override
	public void create() {
		gc = new GameController(leftTeam, rightTeam);
		gw = new GameWorld();
		stage = new Stage();

		stage.addActor(gw.getGroup());

		camera = new OrthographicCamera();
		camera.translate(0, -500f);
		camera.update();
		stage.setViewport(1000, 1000, false);
	}

	@Override
	public void dispose() {
	}

	@Override
	public void render() {
		if (!(GameController.getBlueTeam().alive())) {
			System.out.println("Team one wins!");
			Gdx.app.exit();
		} else if (!(GameController.getRedTeam().alive())) {
			System.out.println("Team two wins!");
			Gdx.app.exit();
		}

		Gdx.gl.glClearColor(0.0f, 0.678f, 0.337f, 0.0f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		stage.draw();
		stage.getCamera().update();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
