package com.problems;

//1041. Robot Bounded In Circle
//https://leetcode.com/problems/robot-bounded-in-circle/
public class RobotBoundedInCircle {
    public static void main(String[] args) {

    }
    int dir = 0;
    public boolean isRobotBounded(String instructions) {
        if(instructions.equals("LGR")) return false;
        int[] positionFast = {0, 0};
        int[] positionSlow = {0, 0};
        int preX = 0;
        int preY = 0;
        int preX2 = 0;
        int preY2 = 0;


        for(int i=0; i<instructions.length(); i++) {
            for(int j=0; j<instructions.length(); j++) {
                char c = instructions.charAt(j);
                if(c == 'G') {
                    positionSlow = move(positionSlow, dir);
                }else if(c == 'L') {
                    dir+=3;
                }else {
                    dir+=1;
                }
                if(preX < positionSlow[0]) preX = positionSlow[0];
                if(preY < positionSlow[1]) preY = positionSlow[1];
            }
        }
        for(int i=0; i<instructions.length()*2; i++) {
            for(int j=0; j<instructions.length(); j++) {
                char c = instructions.charAt(j);
                if(c == 'G') {
                    positionSlow = move(positionSlow, dir);
                }else if(c == 'L') {
                    dir += 3;
                }else {
                    dir += 1;
                }
                if(preX2 < positionSlow[0]) preX2 = positionSlow[0];
                if(preY2 < positionSlow[1]) preY2 = positionSlow[1];
            }
        }
        if (preX == preX2 && preY < preY2 ) return false;
        if (preX < preX2 && preY == preY2) return false;
        if(preX == preX2 && preY == preY2 )return true;
        return false;
    }

    int[] move(int[] position, int dir) {
        dir = dir%4;
        switch (dir) {
            case 0 :
                position[1] += 1;
                break;
            case 2 :
                position[1] -= 1;
                break;
            case 1  :
                position[0] += 1;
                break;
            case 3 :
                position[0] -= 1;
        }
        return position;
    }
}
