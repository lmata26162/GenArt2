import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainWindow extends JPanel {
    //i initial setup of window
    //i panel is the canvas share we will draw the Art
    //extend makes the MainWIndow object a drawable object
    private final int WINDOW_WIDTH = 1920;
    private final int WINDOW_HEIGHT = 1080;
    Particle p;
    private final int NUM_PARTICLES = 100;
    ArrayList<Particle> particles;

    public MainWindow(){
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));//starting size of our window
        p = new Particle(100, 200, 10, new Color(100, 100, 100), WINDOW_WIDTH, WINDOW_HEIGHT);

        particles = new ArrayList<>();

        for(int i = 0; i<NUM_PARTICLES; i++){
            // min + Math.random() * (max - min)
            int x =(int)( Math.random() * WINDOW_WIDTH);
            int y = (int)(Math.random() *WINDOW_HEIGHT);
            //create a local radius variable and assign a value between 5-15
            int radius = randInt(5, 15);
            int red = randInt(0, 255);
            int blue = randInt(0, 255);
            int green = randInt(0, 255);
            // create RBG values between 0-255 to assign a random Color to new color
            particles.add(new Particle(x, y, radius, new Color(red, green, blue), WINDOW_WIDTH, WINDOW_HEIGHT));
        }
        // this runs every 16 milliseconds
        Timer timer = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
                repaint();
            }
        });
        timer.start();
    }

    public int randInt(int min, int max){
        return(int)(min + Math.random()*(max -min));
    }

    public static void main(String[] args){
        //frame is the window bar(bar, close button, resizing)
        JFrame frame = new JFrame("Title Here");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//actually quit the program when window close

        //initial setup of the window
        MainWindow mainWindow = new MainWindow();
        frame.setContentPane(mainWindow);// puts our drawable object into frame
        frame.pack();//sizes the frame to match our preferred size
        frame.setLocationRelativeTo(null);//opens window in the middle of the screen
        frame.setVisible(true); //false would hide this window
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 =(Graphics2D) g;
        for(Particle pTemp: particles){
            pTemp.draw(g2);
        }
    }

    public void update(){
        for(Particle pTemp: particles){
            pTemp.updateParticle();
        }
    }
}