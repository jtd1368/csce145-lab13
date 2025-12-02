package com.jtd1368;

import java.util.Random;

public class Puzzle {
    public static final int SIZE = 4;
    public static final int MAX = SIZE*SIZE;

    public static final int SCRAMBLE_LENGTH = 80;

    private int[][] tiles;
    private int holeY;
    private int holeX;

    private Random random;

    public Puzzle() {
        tiles = new int[SIZE][SIZE];
        random = new Random();

        reset();
    }

    public int[][] getTiles() {
        return tiles;
    }

    public void moveLeft() {
        if (holeX + 1 == SIZE) return;

        tiles[holeY][holeX] = tiles[holeY][++holeX];
        tiles[holeY][holeX] = 0; // Replace tile with hole
    }

    public void moveRight() {
        if (holeX == 0) return;

        tiles[holeY][holeX] = tiles[holeY][--holeX];
        tiles[holeY][holeX] = 0;
    }

    public void moveUp() {
        if (holeY + 1 == SIZE) return;

        tiles[holeY][holeX] = tiles[++holeY][holeX];
        tiles[holeY][holeX] = 0;
    }

    public void moveDown() {
        if (holeY == 0) return;

        tiles[holeY][holeX] = tiles[--holeY][holeX];
        tiles[holeY][holeX] = 0;
    }

    public void reset() {
        int count = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                tiles[i][j] = ++count % MAX;
            }
        }

        // Place hole at bottom right
        holeY = SIZE - 1;
        holeX = SIZE - 1;
    }

    // TODO: Random state scrambling
    public void randomMove() {
        switch(random.nextInt(4)) {
        case 0:
            moveUp();
            break;
        case 1:
            moveDown();
            break;
        case 2:
            moveLeft();
            break;
        case 3:
            moveRight();
            break;
        default:
            break;
        }
    }

    public void scramble() {
        for (int i = 0; i < SCRAMBLE_LENGTH; i++) {
            randomMove();
        }
    }

    public boolean isSolved() {
        int count = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (tiles[i][j] != ++count % MAX) return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        String out = "";

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                out += String.format("%4d", tiles[i][j]);
            }

            out += "\n";
        }

        return out;
    }
}
