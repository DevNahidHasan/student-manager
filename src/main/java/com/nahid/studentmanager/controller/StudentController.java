package com.nahid.studentmanager.controller;


import com.nahid.studentmanager.model.Student;
import com.nahid.studentmanager.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/")
    public String studentManager(){
        return "student-manager";
    }

    @GetMapping("/addStudent")
    public String showForm(Model model){
        model.addAttribute("student",new Student());
        model.addAttribute("departments", List.of("CSE","SWE","NFE","EEE","ENG"));
        return "add-student";
    }

    @PostMapping("/addStudent")
    public String submitForm(@Valid @ModelAttribute Student student, BindingResult result,
                             Model model, RedirectAttributes redirectAttributes){

        if(result.hasErrors()){
            model.addAttribute("departments", List.of("CSE","SWE","NFE","EEE","ENG"));
            return "redirect:/addStudent";
        }

        if(studentService.alreadyExist(student)){
            redirectAttributes.addFlashAttribute("alreadyExist","true");
            redirectAttributes.addFlashAttribute("message","Student with this id already exits");
//            model.addAttribute("alreadyExist","true");
//            model.addAttribute("message","This user already exists.");
            model.addAttribute("departments", List.of("CSE","SWE","NFE","EEE","ENG"));

            return "redirect:/addStudent";
//            return "add-student";
        }



        redirectAttributes.addFlashAttribute("student",student);
        return "redirect:/success";
    }

    @GetMapping("/success")
    public String showSuccess(@ModelAttribute Student student, Model model){

        studentService.addStudent(student);

        model.addAttribute("student",student);
        return "success";
    }

    @GetMapping("/allStudents")
    public String showAllStudents(Model model){
        model.addAttribute("studentList",studentService.getAllStudents());
        return "all-students";

    }

}
