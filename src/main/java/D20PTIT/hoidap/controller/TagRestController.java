package D20PTIT.hoidap.controller;


import D20PTIT.hoidap.model.Tag;
import D20PTIT.hoidap.model.User;
import D20PTIT.hoidap.repository.TagRepository;
import D20PTIT.hoidap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/tag", produces = "application/json")
@CrossOrigin(origins = "*")
public class TagRestController {
    private TagRepository tagRepo;
    @Autowired
    EntityLinks entityLinks;
    @Autowired
    public TagRestController(TagRepository tagRepo) {
        this.tagRepo = tagRepo;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Tag>> searchProducts(  @RequestParam String input){
        System.out.println("dang o day");
        System.out.println(input);
        System.out.println(tagRepo.searchTags(input));
        return ResponseEntity.ok(tagRepo.searchTags(input));
    }
}
