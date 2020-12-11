package com.example.demo.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;


import com.example.demo.dto.ItemDTO;
import com.example.demo.persistence.domain.Item;
import com.example.demo.service.ItemService;

@SpringBootTest // spring boot test lets spring know this is a test file and treat as such
@ActiveProfiles("dev")
public class ItemDTOUnitTest {


	

}
