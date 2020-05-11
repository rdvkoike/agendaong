package br.com.koike.agendaong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.koike.agendaong.entity.User;
import br.com.koike.agendaong.repository.UserRepository;

@Controller
public class UserController {
//    IssueRepository issueRepository;
	@Autowired
	UserRepository userRepository;
/*
    public UserController(UserRepository userR) {
        this.userRepository = userR;
    }
*/
    /**
    @GetMapping("/user")
    public String getUserNew(Model model, @RequestParam(name = "submitted", required = false) boolean submitted) {
        model.addAttribute("submitted", submitted);
        model.addAttribute("user", new User());
        return "user/user_form";
    }
	*/
  
    @PostMapping("/user/save")
    public String save(User user, RedirectAttributes ra) {
        this.userRepository.save(user);
        ra.addAttribute("submitted", true);
        return "redirect:/user/list";
    }
    
    @GetMapping("/user/new")
    public String newU(Model model) {
       model.addAttribute("user", new User());
       return "user/user_form";
    }

    @GetMapping("/user/list")
    public String list(Model model) {
       model.addAttribute("users", this.userRepository.findAll());
       return "user/user_list";
    }
    

    @GetMapping("/user/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
       User user = this.userRepository.findById(id)
    		   .orElseThrow(() -> new IllegalArgumentException("ID Inválido:" + id));
       model.addAttribute("user", user);
       return "user/user_form";
    }
    @GetMapping("/user/delete/{id}")
    public String delete(@PathVariable long id, Model model) {
       this.userRepository.deleteById(id);
       model.addAttribute("users", this.userRepository.findAll());
       return "user/user_list";
    }
}