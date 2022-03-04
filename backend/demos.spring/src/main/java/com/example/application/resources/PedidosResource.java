package com.example.application.resources;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.application.dtos.PedidoDetailsDTO;
import com.example.application.dtos.PedidoEditDTO;
import com.example.application.dtos.PedidoShortDTO;
import com.example.application.dtos.PeliculaEditDTO;
import com.example.application.dtos.PeliculaShortDTO;
import com.example.domains.contracts.services.PedidosService;
import com.example.exceptions.DuplicateKeyException;
import com.example.exceptions.InvalidDataException;
import com.example.exceptions.NotFoundException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosResource {
	@Autowired
	private PedidosService srv;

	@Transactional
	@GetMapping
	@ApiOperation(value = "Listado de los alquileres")
	public List<PedidoShortDTO> getAll() {
		return srv.getAll().stream().map(rental -> PedidoShortDTO.from(rental)).toList();
	}
	
	@GetMapping(params = "page")
	@ApiOperation(value = "Listado de los alquileres paginados")
	public Page<PeliculaShortDTO> getAll(@ApiParam(required = true) Pageable page) {
		var content = srv.getAll(page);
		return new PageImpl(content.getContent().stream().map(item -> PedidoShortDTO.from(item)).toList(), 
				page, content.getTotalElements());
	}

	@GetMapping(path = "/{id}")
	@ApiOperation(value = "Detalles de alquiler")
	public PedidoDetailsDTO getOneDetails(@PathVariable int id, @RequestParam(required = false, defaultValue = "details") String mode)
			throws NotFoundException {
			return PedidoDetailsDTO.from(srv.getOne(id));
	}
	
	@GetMapping(path = "/{id}", params = "mode=edit")
	@ApiOperation(value = "Editar de alquiler")
	public PedidoEditDTO getOneEdit(@PathVariable int id, @RequestParam(required = true) String mode)
			throws NotFoundException {
			return PedidoEditDTO.from(srv.getOne(id));
	}


	
	@PostMapping
	@Transactional
	@ApiOperation(value = "Crear alquiler")
	public ResponseEntity<Object> create(@Valid @RequestBody PedidoEditDTO item)
			throws InvalidDataException, DuplicateKeyException, NotFoundException {
		var entity = PedidoEditDTO.from(item);
		if (entity.isInvalid())
			throw new InvalidDataException(entity.getErrorsMessage());
		entity = srv.add(entity);
		item.update(entity);
		srv.change(entity);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(entity.getRentalId()).toUri();
		return ResponseEntity.created(location).build();

	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	@Transactional
	@ApiOperation(value = "Actualizar alquiler")
	public void update(@PathVariable int id, @Valid @RequestBody PedidoEditDTO item)
			throws InvalidDataException, NotFoundException {
		if (id != item.getRentalId())
			throw new InvalidDataException("No coinciden los identificadores");
		var entity = srv.getOne(id);
		item.update(entity);
		if (entity.isInvalid())
			throw new InvalidDataException(entity.getErrorsMessage());
		srv.change(entity);
	}
	
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Borrar alquiler")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {
		srv.deleteById(id);
	}
}
