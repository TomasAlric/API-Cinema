package com.api.cinemamanagementsystem.services.validations;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;
import com.api.cinemamanagementsystem.dtos.UserDTO;
import com.api.cinemamanagementsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


public class CpfValid {

    @Autowired
    private UserRepository repository;

    UserDTO dto = new UserDTO();

    private String cpf;

    public CpfValid(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean validation() {

        CPFValidator validation = new CPFValidator();
        List<ValidationMessage> errors = validation.invalidMessagesFor(cpf);



        return errors.isEmpty();
    }
}