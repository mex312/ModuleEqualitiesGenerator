package com.example.moduleequalitiesgenerator;

import java.util.Random;

public class ModuleEquality {
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
        return "ANSWER";
    }
}
