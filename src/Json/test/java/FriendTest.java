import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.Car;
import org.example.Friend;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class FriendTest {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
    private static Friend[] friends;
    private static Friend[] deserialized_friends;
    @Mock
    private Car car = new Car("blue", 20000, 4);

    @BeforeAll
    static void deserializeFile() throws IOException {
        friends = objectMapper.readValue(new File("main/resources/friends.json"), Friend[].class);
    }

    @Test
    @DisplayName("File that we are deserializing contains 5 Friend class objects, so it will return array of 5")
    void deserializing_shouldReturnArrayOfFiveElements() {
        assertEquals(5, friends.length);
    }

    @Test
    void whenDeserializing_ageOfFirstObjectShouldBe28() {
        assertEquals(28, friends[0].getAge());
    }

    @Test
    void totalAgeOfAllObjectsShouldBe174() { // does this method even make sense?
        /*int totalFriendsAge = 0;
        for (Friend friend : friends) {
            totalFriendsAge += friend.getAge();
        }
        assertEquals(174, totalFriendsAge);*/
        assertEquals(174, Arrays.stream(friends).mapToInt(Friend::getAge).sum()); // I am not so familiar with this approach
    }

    @Test
    void HeightFieldWillBeZeroAfterDeserialization() {
        assertTrue(friends[1].getHeight() == 0);
    }

    @Test
    void CarFieldWillBeNullAfterDeserialization() {
        assertNull(friends[3].getCar());
    }

    @Test
    void serializeFriendsArrayAndIgnoreHeightField() throws IOException {
        friends[0].setHeight(190);
        objectWriter.writeValue(new File("main/resources/serialized_friends.json"), friends);
        deserialized_friends = objectMapper.readValue(new File("main/resources/serialized_friends.json"), Friend[].class);
        assertEquals(0, deserialized_friends[0].getHeight());
    }

    @Test
    void serializationWillIgnoreCarField() throws IOException {
        friends[1].setCar(car);
        objectWriter.writeValue(new File("main/resources/serialized_friends.json"), friends);
        deserialized_friends = objectMapper.readValue(new File("main/resources/serialized_friends.json"), Friend[].class);
        assertNull(deserialized_friends[1].getCar());
    }

}
