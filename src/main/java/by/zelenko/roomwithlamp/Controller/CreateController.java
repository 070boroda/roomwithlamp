package by.zelenko.roomwithlamp.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


@Controller
@Slf4j
public class CreateController {

    private final Map<Integer,Boolean> rooms;

    public CreateController(Map<Integer, Boolean> rooms) {
        this.rooms = rooms;
    }

    @RequestMapping("/")
    public ModelAndView showRoom() {
        log.info("Start showRoom view");
        ModelAndView modelAndView = new ModelAndView("index");
            modelAndView.addObject("rooms", rooms);
            return modelAndView;
    }


    @GetMapping("/editroom")
    public ModelAndView showRoom(@RequestParam(value = "key") Integer key){
        ModelAndView modelAndView = new ModelAndView("/room");
        modelAndView.addObject("key",key);
        modelAndView.addObject("status",rooms.get(key));
        log.info("doing /editroom");
        return modelAndView;
    }


    @GetMapping("/changestatus")
    public ModelAndView changeStatus(@RequestParam(value = "key") Integer key){
        ModelAndView modelAndView = new ModelAndView("/room");
        if (!rooms.get(key)) {
            rooms.put(key, true);
        } else {
            rooms.put(key, false);
        }
        modelAndView.addObject("key", key);
        modelAndView.addObject("status", rooms.get(key));
        log.info("doing /changestatus");
        return modelAndView;
    }
}
