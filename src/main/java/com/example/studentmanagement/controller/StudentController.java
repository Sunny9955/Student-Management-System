package com.example.studentmanagement.controller;

import com.example.studentmanagement.entity.Marks;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.service.MarksService;
import com.example.studentmanagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private final MarksService marksService;

    public StudentController(StudentService studentService,MarksService marksService){
        this.studentService=studentService; this.marksService=marksService;
    }

    @GetMapping
    public String list(@RequestParam(required=false) String keyword,Model model){
        model.addAttribute("students",studentService.findAll(keyword));
        model.addAttribute("keyword",keyword==null?"":keyword);
        return "students";
    }

    @GetMapping("/new")
    public String form(Model model){
        model.addAttribute("student",new Student());
        return "student-form";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute Student student){studentService.save(student);return "redirect:/students";}

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id,Model model){
        model.addAttribute("student",studentService.get(id)); return "student-form";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id,@Valid @ModelAttribute Student student){
        studentService.update(id,student); return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){studentService.delete(id);return "redirect:/students";}

    @GetMapping("/{id}/marks")
    public String marksForm(@PathVariable Long id,Model model){
        model.addAttribute("student",studentService.get(id));
        model.addAttribute("marks",marksService.getByStudent(id));
        return "marks-form";
    }

    @PostMapping("/{id}/marks")
    public String saveMarks(@PathVariable Long id,@ModelAttribute Marks marks){
        marksService.save(id,marks); return "redirect:/students/"+id+"/report";
    }

    @GetMapping("/{id}/report")
    public String report(@PathVariable Long id,Model model){
        model.addAttribute("student",studentService.get(id));
        model.addAttribute("marks",marksService.getByStudent(id));
        return "report";
    }
}
