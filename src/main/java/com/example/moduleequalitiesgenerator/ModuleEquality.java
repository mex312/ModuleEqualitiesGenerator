package com.example.moduleequalitiesgenerator;

import java.util.Random;

public class ModuleEquality {
    private long a;
    private long b;
    private int type;

    public ModuleEquality(Random rand, int type){
        if (type <= 0 || type > 5) type = rand.nextInt(1, 6);

        this.type = type;
        this.a = rand.nextLong(-10, 11);
        this.b = rand.nextLong(-10, 11);
    }

    public String AsString(){
        if (type == 1){
            return "|%dx + %dy| = |%dx| + |%dy|".formatted(a, b, a, b);
        } else{
            return "|%dx - %dy| = |%dx| - |%dy|".formatted(a, b, a, b);
        }
    }

    public String AnswerAsString(){
        return "ANSWER";
    }
}
