package com.glw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Create by glw
 * 2019/1/27 12:10
 * 56. Merge Intervals
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class MergeIntervals {
    private static class Interval {
        int start;
        int end;

        private Interval() {
            start = 0;
            end = 0;
        }

        private Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    // 我的答案
//    public static List<Interval> merge(List<Interval> intervals) {
//        int length = intervals.size();
//        List<Interval> result = new LinkedList<>();
//        if (length < 2) return intervals;
//        intervals.sort((left, right) -> Integer.compare(left.start, right.start));
//        if (intervals.get(0).end < intervals.get(1).start) {    //首先比较第一个与第二个，防止漏掉
//            result.add(intervals.get(0));
//        }
//        int i = 1;
//        while (i < length) {
//            if (intervals.get(i - 1).end >= intervals.get(i).start) {   //比较第i-1个与第i个
//                if (intervals.get(i - 1).end <= intervals.get(i).end) {
//                    result.add(new Interval(intervals.get(i - 1).start, intervals.get(i).end));
//                } else {
//                    result.add(new Interval(intervals.get(i - 1).start, intervals.get(i - 1).end));
//                }
//            } else {
//                result.add(intervals.get(i));
//            }
//            i++;
//        }
//        return result;
//    }

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;
        // 通过比较每个interval对象的start排序
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        List<Interval> result = new LinkedList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) // 当interval的start比上一个interval中的end小时，将end替换为最大的值
                end = Math.max(end, interval.end);
            else {                     // 当interval的start比第一个interval中的end大时，它们无相交区间，重置start和end为当前interval对象
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        // 添加最后一个interval对象
        result.add(new Interval(start, end));
        return result;
    }

    private static void outPut (List<Interval> list) {
        System.out.print("[");
        int i = 0;
        while (i < list.size()){
            System.out.print(",[" + list.get(i).start + "," + list.get(i).end + "]");
            i++;
        }
        System.out.print("]\n");
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 3));
        input.add(new Interval(2, 6));
        input.add(new Interval(8, 10));
        input.add(new Interval(15, 19));
        System.out.println("我的答案：   集合：");
        List<Interval> result = merge(input);
        outPut(input);
        System.out.println("\n结果：");
        outPut(result);
    }
}
