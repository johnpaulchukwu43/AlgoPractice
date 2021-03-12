package com.jworks.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Johnpaul Chukwu.
 * @since 11/03/2021
 */
public class TreePractice6 {

    private List<Room> roomList = new ArrayList<>();

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
        *
        * */

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));


        for (int[] interval : intervals) {
            int availableRoomPosition = getAvailableRoomPosition(interval[0]);
            if(availableRoomPosition == -1){
                roomList.add(new Room(interval[0], interval[1]));
            }else {
                roomList.set(availableRoomPosition, new Room(interval[0], interval[1]));
            }

        }

        return roomList.size();

    }

    private int getAvailableRoomPosition(int meetingStartTime){

        if(roomList.isEmpty()) return -1;

        for (int i = 0, roomListSize = roomList.size(); i < roomListSize; i++) {
            Room room = roomList.get(i);

            if (meetingStartTime > room.meetingStartTime && meetingStartTime >= room.meetingEndTime ) {
                return i;
            }
        }

        return -1;
    }



    public class Room{
        private int meetingStartTime;
        private int meetingEndTime;

        Room(int meetingStartTime, int meetingEndTime) {
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
}
