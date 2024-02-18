package sorting;

import java.util.Arrays;

//Q. You are given an integer n. There are n rooms numbered from 0 to n - 1.
//
//   You are given a 2D integer array meetings where meetings[i] = [starti, endi] means that a
//   meeting will be held during the half-closed time interval [starti, endi).
//   All the values of starti are unique.
//
//   Meetings are allocated to rooms in the following manner:
//
//   1. Each meeting will take place in the unused room with the lowest number.
//   2. If there are no available rooms, the meeting will be delayed until a room becomes free. The delayed meeting should have the same duration as the original meeting.
//   3. When a room becomes unused, meetings that have an earlier original start time should be given the room.
//     Return the number of the room that held the most meetings. If there are multiple rooms, return the room with the lowest number.
//
//    A half-closed interval [a, b) is the interval between a and b including a and not including b.
public class MeetingRoomIII {
    public int mostBooked(int n, int[][] meetings) {
        //to sort according to the start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0],b[0]));

        int[] countOfMeeting = new int[n];
        long[] meetingEndTime = new long[n];

        for (int[] meeting : meetings) {
            int startTime = meeting[0];
            int endTime = meeting[1];

            long minValue = Long.MAX_VALUE;
            int minInd = -1;
            boolean flag = false;

            for (int j = 0; j < n; j++) {
                if (meetingEndTime[j] < minValue) {
                    minValue = meetingEndTime[j];
                    minInd = j;
                }
                if (meetingEndTime[j] <= startTime) {
                    flag = true;
                    meetingEndTime[j] = endTime;
                    countOfMeeting[j]++;
                    break;
                }
            }
            if (!flag) {
                meetingEndTime[minInd] += (endTime - startTime);
                countOfMeeting[minInd]++;
            }
        }
        int max = -1;
        int ans = -1;
        for(int i = 0; i < n; i++){
            if(countOfMeeting[i] > max){
                max = countOfMeeting[i];
                ans = i;
            }
        }
        return ans;
    }
}
