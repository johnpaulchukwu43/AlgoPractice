package com.jworks.trees;

import java.util.*;

/**
 * @author Johnpaul Chukwu.
 * @since 11/03/2021
 */
public class TreePractice6 {

    private final List<RoomMeeting> roomMeetingList = new ArrayList<>();

    /*
        Given an array of meeting time intervals intervals where intervals[i] = [starti, endi]
        return the minimum number of conference rooms required.

        Input: intervals = [[0,30],[5,10],[15,20]]
        Output: 2
    */


    public int minMeetingRoomsNaiveApproach(int[][] intervals) {

        /*
        * Approach taken:
        *
        * 1. Sort the array intervals in ascending order of increasing start time.
        * 2. for each meeting check if there is an available room else create another
        * Time complexity  = O(nlog (n)) + O(n^2) = O(n^2)
        * Space complexity = O(n)
        * */

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));


        for (int[] interval : intervals) {
            int availableRoomPosition = getAvailableRoomPosition(interval[0]);
            if(availableRoomPosition == -1){
                roomMeetingList.add(new RoomMeeting(interval[0], interval[1]));
            }else {
                roomMeetingList.set(availableRoomPosition, new RoomMeeting(interval[0], interval[1]));
            }

        }

        return roomMeetingList.size();

    }

    private int getAvailableRoomPosition(int meetingStartTime){

        if(roomMeetingList.isEmpty()) return -1;

        for (int i = 0, roomListSize = roomMeetingList.size(); i < roomListSize; i++) {
            RoomMeeting roomMeeting = roomMeetingList.get(i);

            if (meetingStartTime > roomMeeting.meetingStartTime && meetingStartTime >= roomMeeting.meetingEndTime ) {
                return i;
            }
        }

        return -1;
    }

    public int minMeetingRoomPriorityQueue(int[][] intervals){
        /*
         * Approach taken:
         *
         * 1. Sort the array intervals in ascending order of increasing start time.
         * 2. Initialize a PriorityQueue (min heap), to keep track of the ending time,as that tells us when a meeting room will get free
         * 3. For every meeting room check if the minimum element of the PriorityQueue i.e. the room at the top of the heap is free or not.
         * 4. If its free remove from the heap
         * 5. Add new meeting room to PriorityQueue
         *
            Time complexity  = O(nlog (n)) + O(log(n)) = O(nlog (n))
        *   Space complexity = O(n)
         * */

        Arrays.sort(intervals,Comparator.comparingInt(a -> a[0]));

        PriorityQueue<RoomMeeting> roomMeetingAllocator = new PriorityQueue<>(intervals.length, new RoomMeetingComparator());
        for (int[] interval : intervals) {
            RoomMeeting roomMeetingWithEarliestClosingTime = roomMeetingAllocator.peek();
            int currentRoomMeetingStartTime = interval[0];
            int currentRoomMeetingEndTime = interval[1];

            if (roomMeetingWithEarliestClosingTime != null &&
                    currentRoomMeetingStartTime >= roomMeetingWithEarliestClosingTime.getMeetingEndTime()) {
               roomMeetingAllocator.remove();
            }
            roomMeetingAllocator.add(new RoomMeeting(currentRoomMeetingStartTime, currentRoomMeetingEndTime));

        }
        return roomMeetingAllocator.size();

    }



    public static class RoomMeeting {
        private final int meetingStartTime;
        private final int meetingEndTime;

        RoomMeeting(int meetingStartTime, int meetingEndTime) {
            this.meetingStartTime = meetingStartTime;
            this.meetingEndTime = meetingEndTime;
        }

        public int getMeetingStartTime() {
            return meetingStartTime;
        }

        public int getMeetingEndTime() {
            return meetingEndTime;
        }
    }


    public static class RoomMeetingComparator implements Comparator<RoomMeeting>{

        @Override
        public int compare(RoomMeeting r1, RoomMeeting r2) {
            return r1.meetingEndTime - r2.meetingEndTime;
        }
    }
}
