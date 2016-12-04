package com.korgutlova;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class Vector2DTest {
    private static Vector2D vector2D;
    private static Vector2D vector2DTwo;
    private static final double X_1 = 2.0;
    private static final double X_2 = 3.6;
    private static final double Y_1 = 5.1;
    private static final double Y_2 = -4.0;
    private static final double DELTA = 10e-4;

    @BeforeClass
    public static void setUp() {
        vector2D = new Vector2D(X_1, Y_1);
        vector2DTwo = new Vector2D(X_2, Y_2);
    }

    @Test
    public void getXShouldReturnCorrectX() {
        Assert.assertEquals(X_1, vector2D.getX(), DELTA);
    }

    @Test
    public void getYShouldReturnCorrectY() {
        Assert.assertEquals(Y_1, vector2D.getY(), DELTA);
    }

    @Test
    public void toStringShouldShowCorrectString() {
        Assert.assertEquals("{" + X_1 + ", " + Y_1 + "}", vector2D.toString());
    }

    @Test
    public void addShouldReturnCorrectVector2D() {
        Assert.assertTrue(new Vector2D(X_1 + X_2, Y_1 + Y_2).equals(vector2D.add(vector2DTwo)));
    }

    @Test
    public void multShouldReturnCorrectVector2D() {
        double k = 3.0;
        Assert.assertTrue(new Vector2D(k * X_1, k * Y_1).equals(vector2D.mult(k)));
    }

    @Test
    public void equalsShouldReturnTrue() {
        Assert.assertTrue(vector2D.equals(vector2D));
    }

    @Test
    public void equalsShouldReturnFalse() {
        Assert.assertFalse(vector2D.equals(vector2DTwo));
    }

    @Test
    public void lengthShouldReturnCorrectLength() {
        Assert.assertEquals(Math.sqrt(X_1 * X_1 + Y_1 * Y_1), vector2D.length(), DELTA);
    }

    @Test
    public void scalarMultiplicationShouldReturnCorrectDouble(){
        Assert.assertEquals(X_1 * X_2 + Y_1 * Y_2, vector2D.scalarMultiplication(vector2DTwo), DELTA);
    }
}
