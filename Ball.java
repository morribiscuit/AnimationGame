package com.example.AnimationGame;


public class Ball {
    public double x,y,xspeed,yspeed, max_x,max_y;

    Ball(double x1, double y1, double xspeed1, double yspeed1,double max_x1,double max_y1){
        x = x1;
        y = y1;
        xspeed = xspeed1;
        yspeed = yspeed1;
        max_x = max_x1;
        max_y = max_y1;
        y += yspeed;
        x += xspeed;

    }

    void update(double yacc){
        yspeed = yspeed + yacc;
        y += yspeed;
        x += xspeed;
        if((y>max_y)|| (y <0)){
            yspeed = yspeed * -0.8;
            y = y+ yspeed;
        }

        if((x>max_x)|| (x <0)){
            xspeed = xspeed * -0.8;
            x = x+ xspeed;
        }
    }



}
