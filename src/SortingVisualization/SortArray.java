package SortingVisualization;


import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SortArray extends JPanel {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    private static final int BAR_WIDTH = 5;
    private static final int NUM_BARS = WIDTH / BAR_WIDTH;

    private final int[] array;
    private final int[] barColors;

    public SortArray(){
        this.setBackground(Color.darkGray);
        this.setBounds(0, 200, WIDTH, HEIGHT);

        array = new int[NUM_BARS];
        barColors = new int[NUM_BARS];

        for(int i = 0; i < NUM_BARS; i++){
            array[i] = i;
            barColors[i] = 0;
        }
    }

    public int getArraySize(){
        return array.length;
    }

    public int getValue(int i){
        return array[i];
    }

    public void swap(int first, int second, long msec){
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;

        barColors[first] = 100;
        barColors[second] = 100;

        repaint();
        Sleep.sleepFor(Sleep.millisecToNano(msec));
    }

    public void update(int index, int val, long msec){
        array[index] = val;
        barColors[index] = 100;
        repaint();
        Sleep.sleepFor(Sleep.millisecToNano(msec));
    }

    public void highlight(){
        for(int i = 0; i < array.length; i++){
            update(i, array[i], 10);
        }
    }

    public void shuffle(){
        Random rand = new Random();
        for(int i = 0; i < array.length; i++){
            int index = rand.nextInt(array.length - 1);
            swap(i, index, 5);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    public void resetColor(){
        for(int i = 0; i < NUM_BARS; i++){
            barColors[i] = 0;
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D graphics = (Graphics2D)g;
        super.paint(g);

        graphics.setColor(Color.white);

        for(int i = 0; i < NUM_BARS; i++){
            int height = array[i] * 3;
            int x = i + (BAR_WIDTH - 1) * i;
            int y = HEIGHT - height;

            int val = barColors[i] * 2;
            graphics.setColor(new Color(255, 255 - val, 255 - val));
            graphics.fillRect(x, y , BAR_WIDTH, height);

            if(barColors[i] > 0){
                barColors[i] = barColors[i] - 10;
            }
        }
    }
}
