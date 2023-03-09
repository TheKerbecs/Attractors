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
public class NoseHoover extends Attractor {

    private final double a = 1.5;
    private final double scale = 50;
    private Color c = new Color(100, 0, 10);
    private Random r = new Random();
    private float h = 0.01f;
    private boolean rainbow;

    public NoseHoover(double xPos, double yPos, double zPos, boolean rainbow) {
        x = xPos;
        y = yPos;
        z = zPos;
        dt = 0.0009;
        this.rainbow = rainbow;
        h = r.nextFloat();
        c = new Color(r.nextFloat(), r.nextFloat(), r.nextFloat());
    }

    @Override
    public void update() {
        double xt = (y) * dt;
        double yt = (-x + y * z) * dt;
        double zt = (a - y * y) * dt;
        x = x + xt;
        y = y + yt;
        z = z + zt;
    }

    @Override
    public void draw(Graphics g) {
        if (rainbow) {
            h += 0.000009;
            c = Color.getHSBColor(h, 1, 1);
            if (h == 1) {
                h = 0;
            }
        }
        g.setColor(c);
        g.drawRect((int) (x * scale) + Panel.xWorld / 2, Panel.yWorld / 2 - (int) (y * scale), 1, 1);
    }
}
