package ua.ali_x.studentshostel.service;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ali_x.studentshostel.dao.RoomDao;
import ua.ali_x.studentshostel.model.Room;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomDao roomDao;

    @Override
    public Room getRoomById(Integer id) {
        Room room = roomDao.getRoomById(id);
        room.setPersentageLoading(findLoading(room));
        return room;
    }

    @Override
    public List<Room> getAllWithPercentage() {
        List<Room> list = Lists.newArrayList(roomDao.findAll());
        for (Room room: list) {
            room.setPersentageLoading(findLoading(room));
        }
        return list;
    }

    public int findLoading(Room room) {
        return (room.getStudentCurNumber()*100)/room.getStudentMaxNumber();
    }
}
