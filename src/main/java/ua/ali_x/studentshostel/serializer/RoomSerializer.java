package ua.ali_x.studentshostel.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import ua.ali_x.studentshostel.model.Room;
import ua.ali_x.studentshostel.model.Student;

import java.io.IOException;

public class RoomSerializer extends StdSerializer<Room> {

    public RoomSerializer() {
        this(null);
    }

    public RoomSerializer(Class<Room> t) {
        super(t);
    }

    @Override
    public void serialize(Room room, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", room.getId());
        jsonGenerator.writeNumberField("roomNumber", room.getRoomNumber());
        jsonGenerator.writeNumberField("studentMaxNumber", room.getStudentMaxNumber());
        jsonGenerator.writeNumberField("studentCurNumber", room.getStudents().size());
        jsonGenerator.writeNumberField("persentageLoading", room.getPersentageLoading());
        jsonGenerator.writeArrayFieldStart("students");
        for (Student student : room.getStudents()) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("id", student.getId());
            jsonGenerator.writeStringField("surname", student.getSurname());
            jsonGenerator.writeStringField("name", student.getName());
            jsonGenerator.writeStringField("patronymic", student.getPatronymic());
            jsonGenerator.writeStringField("passport", student.getPassport());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }
}
