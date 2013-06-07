package dojo;

import org.apache.commons.lang.builder.EqualsBuilder;

/**
 *
 */
public class Coordinate {

    int x;
    int y;


    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
            return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public String toString() {
        return "CellPosition{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
