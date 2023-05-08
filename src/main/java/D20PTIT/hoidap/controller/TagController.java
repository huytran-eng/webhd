package D20PTIT.hoidap.controller;


import D20PTIT.hoidap.model.Question;
import D20PTIT.hoidap.model.Tag;
import D20PTIT.hoidap.repository.TagRepository;
import D20PTIT.hoidap.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tag")
@AllArgsConstructor
public class TagController {
    private TagRepository tagRepo;


    @ModelAttribute("tag")
    public Tag tag() {
        return new Tag();
    }

    @GetMapping("/add")
    public String addTagForm() {
        return "tag/add";
    }

    @PostMapping("/add")
    public String saveTag(@Valid Tag tag, Errors errors) {
        System.out.println("tao tag");
        if (errors.hasErrors()) {
            System.out.println(errors);
            return "redirect:/tag/add";
        }
        System.out.println(tag);
        tagRepo.save(tag);
        return "redirect:/";
    }

    @GetMapping
    public String findAll(Model model,
                          @RequestParam(value = "sort", required = false) String sort,
                          @RequestParam(defaultValue = "0") int page
    ) {

        Pageable paging = null;

        if (sort == null) {
            paging = PageRequest.of(page == 0 ? page : page - 1, 5);
        }
            List<Tag> tags;
            Page<Tag> pageTag = tagRepo.findAll(paging);
            tags = pageTag.getContent();
            System.out.println(tags);
            System.out.println(pageTag);
            model.addAttribute("tags", tags);
            model.addAttribute("pagetags", pageTag);

            return "tag/list";
        }
    }
