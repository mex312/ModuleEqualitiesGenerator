package com.example.moduleequalitiesgenerator;

import java.util.Random;

public class ModuleEquality {
    private static final String NO_ROOTS_MESSAGE = "No Roots";

    private final long a;
    private final long ax;
    private final long b;
    private final long bx;
    private final int type;

    public ModuleEquality(Random rand, int type){
        if (type <= 0 || type > 5) type = rand.nextInt(1, 6);

        this.type = type;
        long next = rand.nextLong(-20, 21);
        if (next != 0) this.a = next; else a = 1;
        next = rand.nextLong(-20, 21);
        if (next != 0) if(Math.abs(a) != Math.abs(next)) this.b = next; else this.b = next + 1; else if(Math.abs(a) != 1) this.b = 1; else this.b = 2;
        next = rand.nextLong(-10, 11);
        if (next != 0) this.ax = next; else ax = 1;
        next = rand.nextLong(-10, 11);
        if (next != 0) if(Math.abs(ax) != Math.abs(next)) this.bx = next; else this.bx = next + 1; else if(Math.abs(ax) != 1) this.bx = 1; else this.bx = 2;
    }

    public String AsString(){
        String out = "";

        switch (type) {
            case (1):
                out += "|%dx ".formatted(ax + bx);
                if(a + b < 0) out += "- %d| = ".formatted(-(a + b));
                else out += "+ %d| = ".formatted(a + b);

                out += "|%dx ".formatted(ax);
                if(a < 0) out += "- %d| + ".formatted(-a);
                else out += "+ %d| + ".formatted(a);

                out += "|%dx ".formatted(bx);
                if(b < 0) out += "- %d|".formatted(-b);
                else out += "+ %d|".formatted(b);
                break;
            case (2):
                out += "|%dx ".formatted(ax - bx);
                if(a - b < 0) out += "+ %d| = ".formatted(-(a - b));
                else out += "- %d| = ".formatted(a - b);

                out += "|%dx ".formatted(ax);
                if(a < 0) out += "- %d| + ".formatted(-a);
                else out += "+ %d| + ".formatted(a);

                out += "|%dx ".formatted(bx);
                if(b < 0) out += "- %d|".formatted(-b);
                else out += "+ %d|".formatted(b);
                break;
            case (3):
                out += "%dx ".formatted(ax + bx);
                if(a + b < 0) out += "- %d = ".formatted(-(a + b));
                else out += "+ %d = ".formatted(a + b);

                out += "|%dx ".formatted(ax);
                if(a < 0) out += "- %d| + ".formatted(-a);
                else out += "+ %d| + ".formatted(a);

                out += "|%dx ".formatted(bx);
                if(b < 0) out += "- %d|".formatted(-b);
                else out += "+ %d|".formatted(b);
                break;
            case (4):
                out += "|%dx ".formatted(ax - bx);
                if(a - b < 0) out += "+ %d| = ".formatted(-(a - b));
                else out += "- %d| = ".formatted(a - b);

                out += "|%dx ".formatted(ax);
                if(a < 0) out += "- %d| - ".formatted(-a);
                else out += "+ %d| - ".formatted(a);

                out += "|%dx ".formatted(bx);
                if(b < 0) out += "- %d|".formatted(-b);
                else out += "+ %d|".formatted(b);
                break;
            case(5):
                out += "|%dx ".formatted(ax + bx);
                if(a + b < 0) out += "- %d| = ".formatted(-(a + b));
                else out += "+ %d| = ".formatted(a + b);

                out += "|%dx ".formatted(ax);
                if(a < 0) out += "- %d| - ".formatted(-a);
                else out += "+ %d| - ".formatted(a);

                out += "|%dx ".formatted(bx);
                if(b < 0) out += "- %d|".formatted(-b);
                else out += "+ %d|".formatted(b);
                break;
        }
        return out + " (type is %d)".formatted(this.type);
    }

    public String AnswerAsString(){
        String out = "";
        switch (type){
            case(1):
                double sqA = ax*bx;
                double sqB = ax*b + bx*a;
                double sqC = a*b;
                double D = sqB*sqB - 4*sqA*sqC;
                System.out.print(sqA);
                System.out.print(' ');
                System.out.print(sqB);
                System.out.print(' ');
                System.out.print(sqC);
                System.out.print(' ');
                System.out.println(D);
                if (D < 0){
                    if(sqA > 0) {
                        out = "x = R";
                    } else {
                        out = NO_ROOTS_MESSAGE;
                    }
                } else if (D == 0){
                    double x = (-sqB + Math.sqrt(D)) / (2*sqA);

                    if(sqA < 0){
                        out = "x = %f".formatted(x);
                    } else {
                        out = "x = R";
                    }
                } else {
                    double x1 = (-sqB + Math.sqrt(D)) / (2*sqA);
                    double x2 = (-sqB - Math.sqrt(D)) / (2*sqA);

                    if(sqA > 0){
                        out = "[ x <= %f\n[ x >= %f".formatted(Math.min(x1, x2), Math.max(x1, x2));
                    } else {
                        out = "[ x >= %f\n[ x <= %f".formatted(Math.min(x1, x2), Math.max(x1, x2));
                    }
                }
                break;
            case(2):

                break;
            case(3):
                if (ax > 0 && bx > 0) {
                    double x1 = -(double)a / ax;
                    double x2 = -(double)b / bx;
                    if (x1 > x2) out = "x >= %f".formatted(x1);
                    else out = "x >= %f".formatted(x2);
                } else if (ax < 0 && bx < 0) {
                    double x1 = -(double)a / ax;
                    double x2 = -(double)b / bx;
                    if (x1 < x2) out = "x <= %f".formatted(x1);
                    else out = "x <= %f".formatted(x2);
                } else {
                    double negX;
                    double posX;
                    if(ax < 0){
                        negX = -(double)a / ax;
                        posX = -(double)b / bx;
                    } else{
                        posX = -(double)a / ax;
                        negX = -(double)b / bx;
                    }

                    if(posX < negX){
                        out = "{ x >= %f\n{ x <= %f".formatted(posX, negX);
                    } else if(posX == negX) {
                        out = "x = %f".formatted(posX);
                    } else {
                        out = NO_ROOTS_MESSAGE;
                    }
                }
                break;
            case(4):

                break;
            case(5):

                break;

        }
        return out;
    }
}
