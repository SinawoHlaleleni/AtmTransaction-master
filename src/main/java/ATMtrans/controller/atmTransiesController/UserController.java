package ATMtrans.controller.atmTransiesController;

import ATMtrans.domain.atmTransies.User;
import ATMtrans.service.atmTransiesService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/create")
    @ResponseBody
    public User create (User user){
        return service.create( user );
    }

    @PostMapping("/update")
    @ResponseBody
    public User update (User user){
        return service.update( user );
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete( id );
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public  User read(@PathVariable String id){
        return service.read( id );
    }

    @GetMapping("read/all")
    @ResponseBody
    public Set<User> getAll(){
        return service.getAll();
    }


}
