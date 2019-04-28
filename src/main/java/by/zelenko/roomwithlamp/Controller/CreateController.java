package by.zelenko.roomwithlamp.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.TreeMap;

@Controller
@Slf4j
public class CreateController {

    private final Map<Integer,Boolean> rooms = new TreeMap<>();

    @Bean
    private Map<Integer,Boolean> createRooms(){
        for (int i = 0; i < 5; i++) {
            rooms.put(i, false);
        }
        return rooms;
    }

    @RequestMapping("/")
    public ModelAndView showRoom() {
        log.info("Start showRoom view");
        ModelAndView modelAndView = new ModelAndView("index");
            log.info("Create rooms");
            modelAndView.addObject("rooms", rooms);

            return modelAndView;
    }


    @GetMapping("/editroom")
    public ModelAndView showRoom(@RequestParam(value = "key", required = true) Integer key){
        ModelAndView modelAndView = new ModelAndView("/room");
        modelAndView.addObject("key",key);
        modelAndView.addObject("status",rooms.get(key));
        return modelAndView;
    }


    @GetMapping("/changestatus")
    public ModelAndView changeStatus(@RequestParam(value = "key", required = true) Integer key){
        ModelAndView modelAndView = new ModelAndView("/room");
        if (rooms.get(key) == false) {
            rooms.put(key, true);
        } else {
            rooms.put(key, false);
        }
        modelAndView.addObject("key", key);
        modelAndView.addObject("status", rooms.get(key));
        return modelAndView;
    }
}
