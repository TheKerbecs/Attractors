/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lorenzattractor;

import java.awt.Graphics;

/**
 *
 * @author TheKerbecs
 */
public abstract class Attractor {
    protected double x = 5, y = 5, z = 10;
    protected double dt = 0.0001;
    
    public abstract void update();
    public abstract void draw(Graphics g);
}
