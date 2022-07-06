package meetingrooms;

import java.util.ArrayList;
import java.util.List;

public class Office {

    private List<MeetingRoom> meetingRooms = new ArrayList<>();

    public void addMeetingRoom(String name, int width, int length) {
        MeetingRoom meetingRoom = new MeetingRoom(name, width, length);
        meetingRooms.add(meetingRoom);
    }

    public List<MeetingRoom> getMeetingRooms() {
        return meetingRooms;
    }

    public List<MeetingRoom> getMeetingRoomsInReverseOrder() {
        List<MeetingRoom> result = new ArrayList<>();
        for (int i = (meetingRooms.size() - 1); i >= 0; i--) {
            result.add(meetingRooms.get(i));
        }
        return result;
    }

    public List<MeetingRoom> getEverySecondMeetingRoom(int number) {
        List<MeetingRoom> result = new ArrayList<>();
        if (number == 1) {
            for (int i = 0; i < meetingRooms.size(); i = i + 2) {
                result.add(meetingRooms.get(i));
            }
        }
        if (number == 2) {
            for (int i = 1; i < meetingRooms.size(); i = i + 2) {
                result.add(meetingRooms.get(i));
            }
        }
        return result;
    }

    public MeetingRoom getMeetingRoomWithGivenName(String name) {
        for (MeetingRoom meetingRoom : meetingRooms) {
            if (meetingRoom.getName().equals(name)) {
                return meetingRoom;
            }
        }
        return null;
    }

    public List<MeetingRoom> getMeetingRoomsWithGivenNamePart(String namePart) {
        List<MeetingRoom> result = new ArrayList<>();
        for (MeetingRoom meetingRoom : meetingRooms) {
            if (meetingRoom.getName().indexOf(namePart) >= 0) {
                result.add(meetingRoom);
            }
        }
        return result;
    }

    public List<MeetingRoom> getMeetingRoomsWithAreaLargerThan(int area) {
        List<MeetingRoom> result = new ArrayList<>();
        for (MeetingRoom meetingRoom : meetingRooms) {
            if (meetingRoom.getArea() > area) {
                result.add(meetingRoom);
            }
        }
        return result;
    }
}
