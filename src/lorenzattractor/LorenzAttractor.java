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
public class LorenzAttractor extends Attractor {

    private final double o = 10, p = 28, s = 8.0 / 3.0;
    private final double scale = 20;
    private Color c = new Color(0, 0, 0);
    private Random r = new Random();
    private float h = 0.01f;
    private boolean rainbow;

    public LorenzAttractor(double xPos, double yPos, double zPos, boolean rainbow) {
        x = xPos;
        y = yPos;
        z = zPos;
        this.rainbow = rainbow;
        h = r.nextFloat();
        c = new Color(r.nextFloat(), r.nextFloat(), r.nextFloat());
    }

    @Override
    public void update() {
        double xt = (o * (y - x)) * dt;
        double yt = (x * (p - z) - y) * dt;
        double zt = (x * y - s * z) * dt;
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
        g.drawRect((int) (x * scale) + Panel.xWorld / 2, Panel.yWorld - (int) (z * scale), 1, 1);

    }
}
