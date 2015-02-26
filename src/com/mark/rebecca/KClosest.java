package com.mark.rebecca;

import java.util.*;

/**
 * Created by rebeccamark on 2/25/15.
 */
public class KClosest {
    public static List<Point> kClosestToOrigin(List<Point> points, int k) {
        // create a priority queue, compared by distance to Origin.
            // first argument is the size of initial queue, second is the comparator.
            // we override comparator to enqueue in desired order.
        Queue<Point> pointsQueue = new PriorityQueue<Point>(points.size(),
                new Comparator<Point>(){
                    @Override
                    public int compare(Point p1, Point p2) {
                        // things that are farther away from origin need to be evaluated as smaller int.
                        // compare words, return - num if smaller, 0 if =, positive if pt 1 is greater than pt 2
                            Integer distanceOne = p1.distanceSquaredToOrigin();
                            Integer distanceTwo = p2.distanceSquaredToOrigin();
                        // this returns -1 0 or 1 like the compare method.
                        return distanceOne.compareTo(distanceTwo);
                    }
                });

        for(Point p: points) {
            pointsQueue.offer(p);
        }

        // initializes an ArrayList of length k, where k = the desired num of closest points
        List<Point> returnList = new ArrayList<Point>(k);
        // add a point from the beginning of the Queue to our final list K times.
        for(int i = 0; i < k; i ++ ){
            returnList.add(pointsQueue.poll());
        }
        return returnList;
    }

    public static void main(String[] args) {
        /// Initialize a LinkedList of a random number of points from 10 - 490;
        List<Point> myPoints = new LinkedList<Point>();
        Random random = new Random();
        int randomNumOfPoints = random.nextInt(490) + 10;

        // randomly generates the x and y values for each point.
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
