package org.springboot_study.restful;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    // 创建线程安全的Map
    static Map<Integer, User> users = Collections.synchronizedMap(new HashMap<Integer, User>());//线程安全的HashMap

    @GetMapping("/")
    public List<User> getUserList() {
        List<User> list = new ArrayList<User>(users.values());
        return list;
    }

    @PostMapping("/")
    public String postUser(@ModelAttribute User user) {
        users.put(user.getId(), user);
        return "success";
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return users.get(id);
    }

    @PutMapping(value="/{id}")
    public String putUser(@PathVariable int id, @ModelAttribute User user) {
        User u = users.get(id);
        if(u!=null) {
            u.setName(user.getName());
            users.put(id, u);
        }else {
            users.put(id, user);
        }
        return "success";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable int id) {
        users.remove(id);
        return "success";
    }

}