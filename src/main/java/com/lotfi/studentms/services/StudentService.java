package com.lotfi.studentms.services;

import com.lotfi.studentms.dtos.AddressDto;
import com.lotfi.studentms.dtos.StudentDto;
import com.lotfi.studentms.entities.Address;
import com.lotfi.studentms.entities.Gender;
import com.lotfi.studentms.entities.Student;
import com.lotfi.studentms.exceptions.ResourceNotFoundException;
import com.lotfi.studentms.exceptions.StudentAlreadyExist;
import com.lotfi.studentms.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentDto saveStudent(StudentDto studentDto){
        log.debug("Request to create Student : {}", studentDto);
        Student student = studentRepository.findByPhone(studentDto.getPhone()).orElse(null);
        if(student == null)
            return mapToDto(studentRepository.save(mapFromDto(studentDto)));
        else
            throw new StudentAlreadyExist("student already exist");
    }

    public List<StudentDto> gelAllStudent(){
        log.debug("Request to get all Students");
        return studentRepository.findAll()
                .stream()
                .map(x-> mapToDto(x))
                .collect(Collectors.toList());
    }

    public StudentDto getById(long id){
        log.debug("Request to get Student : {}", id);
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Not found Student with id = " + id));
        return mapToDto(student);
    }

    public StudentDto update(long id,StudentDto studentDto){
        log.debug("Request to update Student : {}", id);
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("student Not found"));
        return mapToDto(studentRepository.save(mapFromDto(studentDto)));
    }

    public void deleteStudent(long id){
        log.debug("Request to delete Student : {}", id);
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("student not found"));
        studentRepository.deleteById(id);
    }

    public void deleteAll(){
        log.debug("Request to delete all students ");
        studentRepository.deleteAll();
    }
    public static Student mapFromDto(StudentDto studentDto){
        if (studentDto != null) {
            return Student.builder()
                    .name(studentDto.getName())
                    .address(mapFromDto(studentDto.getAddressDto()))
                    .phone(studentDto.getPhone())
                    .gender(studentDto.getGender() == "male" ? Gender.MALE:Gender.FEMALE)
                    .build();
        }
        else return  null;
    }

    public static Address mapFromDto(AddressDto addressDto){
        if(addressDto != null) {
            return Address.builder()
                    .pays(addressDto.getPays())
                    .street(addressDto.getStreet())
                    .town(addressDto.getTown())
                    .postCode(addressDto.getPostCode())
                    .build();
        }
        else return null;
    }

    public static AddressDto mapToDto(Address address){
        if(address != null) {
            return  AddressDto.builder()
                    .town(address.getTown())
                    .pays(address.getPays())
                    .postCode(address.getPostCode())
                    .street(address.getStreet())
                    .build();
        }
        else return null;
    }

    public static StudentDto mapToDto(Student student){
        if(student != null) {
            return StudentDto.builder()
                    .id(student.getId())
                    .addressDto(mapToDto(student.getAddress()))
                    .name(student.getName())
                    .phone(student.getPhone())
                    .gender(student.getGender().name())
                    .build();
        }
        else return null;
    }
}
