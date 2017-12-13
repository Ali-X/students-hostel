package ua.ali_x.studentshostel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.ali_x.studentshostel.model.Room;
import ua.ali_x.studentshostel.service.RoomService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Room getRoom(@RequestParam("r_id")Integer id) {
        return roomService.getRoomById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Room> getAllRooms() {
        return roomService.getAllWithPercentage();
    }

}
