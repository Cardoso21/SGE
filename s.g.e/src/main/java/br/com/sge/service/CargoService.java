package br.com.sge.service;


import br.com.sge.repository.CargoRepository;
import br.com.sge.service.dto.SelectDTO;
import br.com.sge.service.mapper.CargoSelectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CargoService {

private final CargoRepository cargoRepository;
private final CargoSelectMapper cargoSelectMapper;


public List<SelectDTO> mostarCargos(){

    return cargoSelectMapper.toDto(cargoRepository.findAll());
}
}
