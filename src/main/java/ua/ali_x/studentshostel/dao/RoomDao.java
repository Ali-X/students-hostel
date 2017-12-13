package ua.ali_x.studentshostel.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.ali_x.studentshostel.model.Room;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RoomDao extends CrudRepository<Room, Integer> {

    @Query("SELECT r FROM Room r WHERE r.id = :id")
    Room getRoomById(@Param("id") Integer id);

}
