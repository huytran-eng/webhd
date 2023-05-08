package D20PTIT.hoidap.controller;

import D20PTIT.hoidap.model.Answer;
import D20PTIT.hoidap.model.Question;
import D20PTIT.hoidap.model.User;
import D20PTIT.hoidap.repository.AnswerRepository;
import D20PTIT.hoidap.repository.QuestionRepository;
import D20PTIT.hoidap.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/answers")
@AllArgsConstructor
public class AnswerController {
    @Autowired
    private QuestionRepository questionRepo;

    @Autowired
    private AnswerRepository answerRepo;

    @Autowired
    private UserRepository userRepo;

    @PostMapping
    public String createAnswer(@Valid @ModelAttribute Answer answer, Principal principal){
        String questionId = answer.getQuestion().getQuestionId();
        Question question = questionRepo.getOne(questionId);
        answer.setQuestion(question);
        String user = principal.getName();
        User author = userRepo.getOne(user);
        answer.setUser(author);
        answerRepo.save(answer);

        return String.format("redirect:question/%s", questionId);
    }

    @GetMapping
    public String findAll(Model model){
        List<Answer> answers = answerRepo.findAll();
        model.addAttribute("answers",answers);
        return "answers/list";
    }
}
