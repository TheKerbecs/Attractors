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
public class DequamLI extends Attractor {

    private final double a = 40, k = 55, c = 1.833, d = 0.16, e = 0.65, f = 20;

    private final double scale = 2;
    private Color color = new Color(100, 0, 10);
    private Random r = new Random();
    private float h = 0.01f;
    private boolean rainbow;

    public DequamLI(double xPos, double yPos, double zPos, boolean rainbow) {
        x = xPos;
        y = yPos;
        z = zPos;
        this.rainbow = rainbow;
        h = r.nextFloat();
        color = new Color(r.nextFloat(), r.nextFloat(), r.nextFloat());
    }

    @Override
    public void update() {
        double xt = (a * (y - x) + d * x * z) * dt;
        double yt = (k * x + f * y - x * z) * dt;
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
