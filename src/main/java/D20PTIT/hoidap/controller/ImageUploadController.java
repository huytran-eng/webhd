package D20PTIT.hoidap.controller;


import D20PTIT.hoidap.Service.StorageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@RequestMapping("/image")
@Controller
public class ImageUploadController {
    private StorageService storageService;

    @GetMapping("upload")
    public String uploadForm(){
        return "upload";
    }
    @PostMapping("/upload")
    public String handleUploadForm(Model model, String description,
                                   @RequestParam("file") MultipartFile multipart) {
        String fileName = multipart.getOriginalFilename();

        System.out.println("Description: " + description);
        System.out.println("filename: " + fileName);

        String message = "";

        try {
            storageService.uploadFile(multipart);
            System.out.println("Your file has been uploaded successfully!");
        } catch (Exception ex) {
            System.out.println( "Error uploading file: " + ex.getMessage());
        }

        model.addAttribute("message", message);

        return "redirect:/";
    }

}