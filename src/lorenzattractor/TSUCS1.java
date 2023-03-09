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
public class TSUCS1 extends Attractor {

    private final double a = 40, c = 0.833, d = 0.5, e = 0.65, f = 20;
    private double scale = 6;
    private Color color = new Color(100, 0, 10);
    private Random r = new Random();
    private float h = 0.01f;
    private boolean rainbow;

    public TSUCS1(double xPos, double yPos, double zPos, boolean rainbow) {
        x = xPos;
        y = yPos;
        z = zPos;
        this.rainbow = rainbow;
        dt = 0.0001;
        h = r.nextFloat();
        color = new Color(r.nextFloat(), r.nextFloat(), r.nextFloat());
    }

    @Override
    public void update() {
        double xt = (a * (y - x) + d * x * z) * dt;
        double yt = (f * y - x * z) * dt;
        double zt = (c * z + x * y - e * (x * x)) * dt;
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
        g.drawRect((int) (y * scale) + Panel.xWorld / 2, (int) (Panel.yWorld / 1.5) - (int) (z * scale), 1, 1);
    }
}
