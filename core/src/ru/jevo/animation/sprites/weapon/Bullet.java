package ru.jevo.animation.sprites.weapon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import ru.jevo.animation.basic.Ship;
import ru.jevo.animation.basic.Sprite;
import ru.jevo.animation.service.Rect;

/**
 * Created by Alexander on 08.12.2018.
 */
public class Bullet extends Sprite {

    private Ship owner;
    private int damage = 50;

    private Vector2 speedBul = new Vector2(0, 2.5f);
    Sound dropSound = Gdx.audio.newSound(Gdx.files.internal("sounds/weapon1_blaster.wav"));


    public Bullet() {
        regions = new TextureRegion[1];
    }

    public void set(
            Ship owner,
            TextureRegion region,
            float height,
            Rect serviceRect
    ) {
        this.owner = owner;
        this.regions[0] = region;
        this.pos.set(owner.pos.x, owner.getTop());
        setHeightProportion(height);
        this.mServiceRect = serviceRect;
        this.damage = damage;
        dropSound.play();
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        pos.mulAdd(speedBul, delta);
        if (isOutside(mServiceRect)) {
            setSpeedBul(new Vector2(0, 2.5f));
            setDestroyed(true);
        }
    }

    public Vector2 getSpeedBul() {
        return speedBul;
    }

    public void setSpeedBul(Vector2 speedBul) {
        this.speedBul = speedBul;
    }

    public Ship getOwner() {
        return owner;
    }

    public void setOwner(Ship owner) {
        this.owner = owner;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
