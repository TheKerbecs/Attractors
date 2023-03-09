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
 * @author TheKerbecs
 */
public class SprottLinzE extends Attractor {

    private final double a = 1.8, b = -0.07, d = 1.5, m = 0.02;
    private final double scale = 25;
    private Color color = new Color(100, 0, 10);
    private Random r = new Random();
    private float h = 0.01f;
    private boolean rainbow;

    public SprottLinzE(double xPos, double yPos, double zPos, boolean rainbow) {
        x = xPos;
        y = yPos;
        z = zPos;
        this.rainbow = rainbow;
        dt = 0.0002;
        h = r.nextFloat();
        color = new Color(r.nextFloat(), r.nextFloat(), r.nextFloat());
    }

    @Override
    public void update() {
        double xt = (a * (x - y)) * dt;
        double yt = (-4 * a * y + x * z + m * (x * x * x)) * dt;
        double zt = (-d * a * z + x * y + b * (z * z)) * dt;
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
        g.drawRect((int) (x * scale) + Panel.xWorld / 2, (int) (Panel.yWorld / 1.2) - (int) (z * scale), 1, 1);
    }
}
