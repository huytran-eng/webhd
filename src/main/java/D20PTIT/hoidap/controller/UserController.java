package D20PTIT.hoidap.controller;

import D20PTIT.hoidap.model.User;
import D20PTIT.hoidap.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class UserController {
    private final UserRepository userRepo;

    private final PasswordEncoder passwordEncoder;

    @ModelAttribute("user")
    public User createForm() {
        return new User();
    }



    @GetMapping("/register")
    public String registerPage(Model model) {
        return "user/register";
    }

    @PostMapping("/register")
    public String finishRegister(Model model, @Valid User user) {
        System.out.println(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setPosition(User.Position.member);
        System.out.println(user);
        userRepo.save(user);
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String showLoginForm(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "user/login";
        }

        return "redirect:/";
    }
}
