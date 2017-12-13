package ua.ali_x.studentshostel.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import ua.ali_x.studentshostel.model.Student;

import java.io.IOException;

public class StudentSerializer extends StdSerializer<Student> {

    public StudentSerializer(){
        this(null);
    }

    protected StudentSerializer(Class<Student> t) {
        super(t);
    }

    @Override
    public void serialize(Student student, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", student.getId());
        jsonGenerator.writeStringField("surname", student.getSurname());
        jsonGenerator.writeStringField("name", student.getName());
        jsonGenerator.writeStringField("patronymic", student.getPatronymic());
        jsonGenerator.writeStringField("passport", student.getPassport());
        jsonGenerator.writeStringField("bdate", student.getBdate().toString());
        jsonGenerator.writeStringField("phone", student.getPhone());
        jsonGenerator.writeObjectFieldStart("speciality");
        jsonGenerator.writeNumberField("id", student.getSpeciality().getId());
        jsonGenerator.writeStringField("name", student.getSpeciality().getName());
        jsonGenerator.writeStringField("institute", student.getSpeciality().getInstitute().getName());
        jsonGenerator.writeEndObject();
        jsonGenerator.writeNumberField("admisionYear", student.getAdmisionYear());
        jsonGenerator.writeObjectFieldStart("room");
        jsonGenerator.writeNumberField("roomNumber", student.getRoom().getRoomNumber());
        jsonGenerator.writeEndObject();
        jsonGenerator.writeStringField("notes", student.getNotes());
        jsonGenerator.writeEndObject();
    }
}
