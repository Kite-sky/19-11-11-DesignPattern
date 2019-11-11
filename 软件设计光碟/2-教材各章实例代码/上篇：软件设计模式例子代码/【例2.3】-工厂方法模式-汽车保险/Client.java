//package com.javapatterns.factorymethod;

public class Client
{
    private static FruitGardener fg1, fg2, fg3;
    private static Fruit fruit1, fruit2, fruit3;

    private static PolicyProducer pp

    public static void main(String[] args)
    {
		fg1 = new AppleGardener();
        fruit1 = fg1.factory();
         fruit1.plant();
         fruit1.grow();
         fruit1.harvest();

		fg2 = new GrapeGardener();
        fruit2 = fg2.factory();
        fruit2.plant();
		fruit2.grow();
        fruit2.harvest();

        fg3 = new StrawberryGardener();
		fruit3 = fg3.factory();
		fruit3.plant();
	    fruit3.grow();
        fruit3.harvest();

    }
}
