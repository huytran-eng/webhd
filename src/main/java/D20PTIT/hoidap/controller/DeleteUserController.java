//package D20PTIT.hoidap.controller;
//
//
//import D20PTIT.hoidap.model.User;
//import D20PTIT.hoidap.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.server.EntityLinks;
//import org.springframework.web.ErrorResponseException;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping(path = "/user", produces = "application/json")
//@CrossOrigin(origins = "*")
//public class DeleteUserController {
//    private UserRepository userRepo;
//    @Autowired
//    EntityLinks entityLinks;
//    @Autowired
//    public DeleteUserController(UserRepository userRepo) {
//        this.userRepo = userRepo;
//    }
//
//    @DeleteMapping(value = "/{id}")
//    public String deletePost(@PathVariable String id) {
//        if(!userRepo.existsById(id)){
//            return "not found";
//        }
//        userRepo.deleteById(id);
//        return "user has been deleted";
//    }
//}

//
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@RequestMapping(method = RequestMethod.PUT,value="/edit/{id}")
//public String editQuestion(@PathVariable String id,@RequestParam("title") String title,@RequestParam("content") String content, BindingResult errors) {
//        if (errors.hasErrors()) {
//        System.out.println(errors);
//        return "/question/edit";
//        }
//
//        questionRepo
//        .update(id,title,content);
//        System.out.println(id);
//        return "redirect:/question/" + id;
//        }

//import org.springframework.data.repository.query.Param;Page<Question> searchWithTags(Pageable pageable,@Param(value = "content") String tagName);