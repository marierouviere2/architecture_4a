package com.esiea.tp4A.domain;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Set;

import static java.lang.StrictMath.round;
import static org.junit.jupiter.api.Assertions.*;

class MarsTest {
    @Test
    void initMars() {
        Mars mars=new Mars();
        int size=mars.getSize();
        assertFalse(size<=0);
        int[][] map= mars.getMars();
        assertEquals(size,map.length);
        assertEquals(size,map[0].length);
        int k=0;
        for(int y=0;y<size;y++) { for (int x = 0; x < size; x++) { if (map[y][x] == 1) k++; }
        }assertFalse(k+1<round(0.16*size*size));
    }

	@Test
	void obstaclePositions() {
	    Mars mars=new Mars();
	    Set<Position> obstacles=mars.obstaclePositions();
        int [][] map= mars.getMars();
        int offset = 1-map.length/2;
        for(int y=0;y<map.length;y++){
            for(int x=0;x<map[y].length;x++){
                if(map[y][x]==1){
                    assertNotEquals(0,obstacles.size());
                    Iterator<Position> iterator=obstacles.iterator();
                    while ((iterator.hasNext())){
                        Position position=iterator.next();
                        if(position.getX()==x+offset && position.getY()==y+offset){
                            iterator.remove();
                        }
                    }
                }
            }
        }
        assertNotEquals(0,obstacles.size());
	}
}
