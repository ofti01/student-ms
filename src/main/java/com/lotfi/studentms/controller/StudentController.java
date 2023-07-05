package com.lotfi.studentms.controller;

import com.lotfi.studentms.dtos.StudentDto;
import com.lotfi.studentms.entities.Student;
import com.lotfi.studentms.services.StudentService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> students = studentService.gelAllStudent();
        if (students == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto studentDto){
        StudentDto st = studentService.saveStudent(studentDto);
        return new ResponseEntity<>(st,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getById(@PathVariable long id){
        StudentDto studentDto = studentService.getById(id);
        return new ResponseEntity<>(studentDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> update(@PathVariable long id,@RequestBody StudentDto studentDto){
        StudentDto st = studentService.update(id, studentDto);
        return new ResponseEntity<>(st, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping()
    public ResponseEntity<HttpStatus> deleteAll(){
        studentService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
