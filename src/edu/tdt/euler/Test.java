package edu.tdt.euler;

/**
 * Created by Phuc Duong on 7/10/2016.
 * huuphucduong@gmail.com
 */
public class Test {

    public static void main(String[] args)
    {
        Euler euler = new Euler("resources/test_euler_2.txt");
        System.out.println(euler.getConnectedComponents());

        System.out.println(euler.isEulerCircuit());
        System.out.println(euler.getEulerCircuit(0));

        System.out.println(euler.isEulerTrail());
        System.out.println(euler.getEulerTrail());
    }
}
