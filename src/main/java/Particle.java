import java.awt.*;

public class Particle {
    //initialize x.y.color,radius
    private int x, y, radius;
    private Color color;
    private int xDirection, xSpeed, yDirection, ySpeed;

    private int width, height;

    // variables for circular motion
    private double angle;
    private double angularSpeed;
    private int orbitalRadius;
    private int centerX;
    private int centerY;

    public Particle(int x, int y, int radius, Color color, int windowWidth, int windowHeight){
        this.x = x;
        this.y = y;
         this.radius = radius;
         this .color = color;

         xDirection = 1;
         yDirection =1;
         ySpeed = (int)(2 + Math.random() * (5-2));
         xSpeed = (int)(2 + Math.random() * (5-2));

         width = windowWidth;
         height = windowHeight;

         centerX = windowWidth/2;
         centerY = randInt(0, windowHeight);
         angle = randInt(0, 50);
         angularSpeed = randDouble(0.02, 0.3);
         orbitalRadius = randInt(500, 50);
    }
    public int randInt(int min, int max){
        return(int)(min + Math.random() * (max - min));
    }
    public double randDouble(double min, double max){
        return min + Math.random() * (max - min);
    }


    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillOval(x, y, radius*2, radius*2);
    }

    public void updateParticle(){
        angle += angularSpeed;
        x = (int)(centerX + orbitalRadius * Math.cos(angle));
        y = (int)(centerY + orbitalRadius * Math.sin(angle));
    }

//    public void updateParticle(){
//        if (Math.random() >= .99 || x<=0 || x+(radius*2)  > width){
//            xDirection *= -1;
//        }
//        if(Math.random() >= .10||y <= 0 || y+(radius *2) > height){
//            yDirection *= -1;
//        }
//            x += xSpeed*xDirection;
//            y += ySpeed*yDirection;
//    }
}
