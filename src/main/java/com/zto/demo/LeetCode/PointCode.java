package com.zto.demo.LeetCode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: huangchaofan
 * @create: 2018/12/17 10:55
 */
public class PointCode {
    public Point[] kClosest(Point[] points, Point origin, int k) {
        HashMap<Integer, List<Point>> map = new HashMap<>();
        Arrays.stream(points).forEach(c -> {
            int j = (int) (Math.pow(origin.x - c.x, 2) + Math.pow(origin.y - c.y, 2));
            List<Point> value = map.get(j);
            if (value == null) {
                List<Point> list = new ArrayList<>();
                list.add(c);
                map.put(j, list);
            } else {
                value.add(c);
            }
        });
        List<Integer> collect = map.keySet().stream().sorted().collect(Collectors.toList());
        List<Point> pointList = new ArrayList<>(k);
        collect.forEach(c -> {
            map.get(c).stream().sorted(new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    if (o1.x == o2.x) {
                        return o1.y - o2.y;
                    }
                    return o1.x - o2.x;
                }
            }).forEach(x -> {
                pointList.add(x);
                if (pointList.size() == k) {
                    return;
                }
            });
        });

        Point[] result = new Point[k];
        for (int i = 0; i < k ; i++) {
            result[i] = pointList.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        PointCode pointCode = new PointCode();
        Point[] result = new Point[]{new Point(4, 6), new Point(4, 7), new Point(4, 4), new Point(2, 5), new Point(1, 1)};
        Point[] points = pointCode.kClosest(result, new Point(0, 0), 3);
        for (Point point : points) {
            System.out.println(point);
        }

    }


}
