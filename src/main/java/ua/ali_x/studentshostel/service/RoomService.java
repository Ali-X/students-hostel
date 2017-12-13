package ua.ali_x.studentshostel.service;

import ua.ali_x.studentshostel.model.Room;

import java.util.List;

public interface RoomService {

    Room getRoomById(Integer id);

    List<Room> getAllWithPercentage();
}
