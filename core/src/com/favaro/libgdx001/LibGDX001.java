package com.favaro.libgdx001;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class LibGDX001 extends ApplicationAdapter {

	private Sound dropSound;
	private Music rainMusic;
	private Texture bucketTexture;
	private Texture dropletTexture;

	private SpriteBatch batch;
	private OrthographicCamera c;

	private static final int WIDTH = 800;
	private static final int HEIGHT = 480;

	private Rectangle bucket;

	@Override
	public void create () {
		rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
		dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
		bucketTexture = new Texture(Gdx.files.internal("bucket.png"));
		dropletTexture = new Texture(Gdx.files.internal("droplet.png"));

		rainMusic.setLooping(true);
		rainMusic.play();

		c = new OrthographicCamera();
		c.setToOrtho(false, WIDTH, HEIGHT);

		batch = new SpriteBatch();

		bucket = new Rectangle();
		bucket.width = 64;
		bucket.height = 64;
		bucket.x = (800 / 2) - (bucket.width / 2);
		bucket.y = 20;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.draw(bucketTexture, bucket.x, bucket.y);
		batch.end();

		if (Gdx.input.isTouched()) {
			Vector3 pos = new Vector3();

			pos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			c.unproject(pos);
			bucket.x = pos.x - (bucket.width / 2);
		}
	}

	@Override
	public void dispose () {
		dropSound.dispose();
		rainMusic.dispose();
		batch.dispose();
	}
}
