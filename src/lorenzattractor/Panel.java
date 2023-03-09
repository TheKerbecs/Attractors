/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package lorenzattractor;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author TheKerbecs
 */
public class Panel extends javax.swing.JPanel {

    public static final int xWorld = 1000, yWorld = 1000;
    private ArrayList<Attractor> a = new ArrayList<Attractor>();
    private final int numParticles = 10000;
    private boolean reset = false;

    Random r = new Random();

    public Panel() {
        initComponents();
        this.setFocusable(true);
        this.requestFocus();
        //Change <Name> to apply different attractors
        for (int i = 0; i < numParticles; i++) {
            a.add(new NoseHoover(5 + r.nextDouble(), 5 + r.nextDouble(), 10 + r.nextDouble(), false));
        }
    }
    int ds = 0;

    @Override
    protected void paintComponent(Graphics g) {
        if (ds < 200) {
            g.setColor(new Color(15, 22, 36));
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            ds++;
        }

        if (reset) {
            super.paintComponent(g);
            reset = !reset;
        }

        for (int i = 0; i < a.size(); i++) {
            a.get(i).update();
            a.get(i).draw(g);
        }
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}