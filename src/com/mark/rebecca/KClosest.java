package com.mark.rebecca;

import java.util.*;

/**
 * Created by rebeccamark on 2/25/15.
 */
public class KClosest {
    public static List<Point> kClosestToOrigin(List<Point> points, int k) {
        Queue<Point> pointsQueue = new PriorityQueue<Point>(points.size(),
                new Comparator<Point>(){

                    @Override
                    public int compare(Point p1, Point p2) {
                        // things that are farther away from origin are smaller.
                        // compare words, return - num if smaller, 0 =, positive if pt 1 is greater than pt 2
                            Integer distanceOne = p1.distanceSquaredToOrigin();
                            Integer distanceTwo = p2.distanceSquaredToOrigin();
                        // this returns -1 0 or 1 like what we need.
                        return distanceOne.compareTo(distanceTwo);
                    }
                });

        for(Point p: points) {
            pointsQueue.offer(p);
        }
        List<Point> returnList = new ArrayList<Point>(k);


        for(int i = 0; i < k; i ++ ){
            returnList.add(pointsQueue.poll());
        }
        return returnList;
    }

    public static void main(String[] args) {
        List<Point> myPoints = new LinkedList<Point>();
        Random random = new Random();
        int randomNumOfPoints = random.nextInt(490) + 10;

        for(int i = 0; i < randomNumOfPoints; i ++ ){
            int randomX = random.nextInt(100);
            int randomY = random.nextInt(100);
            myPoints.add(new Point(randomX, randomY));
        }

        List<Point> closePoints = kClosestToOrigin(myPoints, 10);
        for (Point p : closePoints) {
            System.out.println(p);
        }
    }

}
