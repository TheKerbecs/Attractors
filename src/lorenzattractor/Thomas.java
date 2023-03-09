/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lorenzattractor;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author radle
 */
public class Thomas extends Attractor {

    private final double b = 0.19;
    private final double scale = 100;
    private Color color = new Color(100, 0, 10);
    private Random r = new Random();
    private float h = 0.01f;
    private boolean rainbow;

    public Thomas(double xPos, double yPos, double zPos, boolean rainbow) {
        x = xPos;
        y = yPos;
        z = zPos;
        this.rainbow = rainbow;
        dt = 0.001;
        h = r.nextFloat();
        color = new Color(r.nextFloat(), r.nextFloat(), r.nextFloat());
    }

    @Override
    public void update() {
        double xt = (-b * x + Math.sin(y)) * dt;
        double yt = (-b * y + Math.sin(z)) * dt;
        double zt = (-b * z + Math.sin(x)) * dt;
        x = x + xt;
        y = y + yt;
        z = z + zt;
    }

    @Override
    public void draw(Graphics g) {
        if (rainbow) {
            h += 0.000009;
            color = Color.getHSBColor(h, 1, 1);
            if (h == 1) {
                h = 0;
            }
        }
        g.setColor(color);
        g.drawRect((int) (x * scale) + Panel.xWorld / 2, (Panel.yWorld / 2) - (int) (y * scale), 1, 1);
    }
}
