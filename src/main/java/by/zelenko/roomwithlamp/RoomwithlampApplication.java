package by.zelenko.roomwithlamp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Map;
import java.util.TreeMap;

@Slf4j
@SpringBootApplication
public class RoomwithlampApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoomwithlampApplication.class, args);
    }

    @Bean
    public Map<Integer,Boolean> createRooms() {
        Map<Integer, Boolean> rooms = new TreeMap<>();
        for (int i = 0; i < 5; i++) {
            rooms.put(i, false);
        }
        log.info("create rooms");
        return rooms;
    }

}
