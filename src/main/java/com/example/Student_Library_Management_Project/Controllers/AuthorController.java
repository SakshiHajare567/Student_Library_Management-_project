//package com.example.Student_Library_Management_Project.Controllers;

/*import com.example.Student_Library_Management_Project.Models.Author;
import com.example.Student_Library_Management_Project.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;*/

package com.example.Student_Library_Management_Project.Controllers;

import com.example.Student_Library_Management_Project.DTOs.AuthorEntryDto;
import com.example.Student_Library_Management_Project.Models.Author;
import com.example.Student_Library_Management_Project.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

  @Autowired
  private AuthorService authorService;

  @PostMapping("/add")
  public String addAuthor(@RequestBody AuthorEntryDto authorEntryDto) {

    return authorService.createAuthor(authorEntryDto);
  }
}
