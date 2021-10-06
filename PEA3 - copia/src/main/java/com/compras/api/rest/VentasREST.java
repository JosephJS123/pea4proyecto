package com.compras.api.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.compras.api.repositorio.DocventaRepositorio;
import com.compras.api.entidad.Cliente;
import com.compras.api.entidad.Empleado;
import com.compras.api.entidad.Docventa;
import com.compras.api.repositorio.ClienteRepositorio;
import com.compras.api.repositorio.EmpleadoRepositorio;

@RestController
@RequestMapping("/ventas")
public class VentasREST {

	@Autowired
	private DocventaRepositorio docventaRepositorio;
	
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	@Autowired
	private EmpleadoRepositorio empleadoRepositorio;
	
	// LISTAR CLIENTE
			@RequestMapping(value = "listarCliente",method = RequestMethod.GET)
			public ResponseEntity<List<Cliente>> getDeuda(){
				
				List<Cliente> cli = clienteRepositorio.findAll();
				return ResponseEntity.ok(cli);
			}
			
	// LISTAR CLIENTE POR ID
	@RequestMapping(value = "listarCliente/{clienteId}",method = RequestMethod.GET)
	public ResponseEntity<Cliente> getClienteById(@PathVariable("clienteId") Long clienteId){
				
		Optional<Cliente> optionalCliente = clienteRepositorio.findById(clienteId);
				
		if(optionalCliente.isPresent()) {
			return ResponseEntity.ok(optionalCliente.get());
		}else {
			return ResponseEntity.noContent().build();
		}

	}
	
	// GUARDAR CLIENTE
			@PostMapping
			@RequestMapping(value = "saveCliente",method = RequestMethod.POST)
			public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente){
				Cliente nuevaCliente = clienteRepositorio.save(cliente);
				return ResponseEntity.ok(nuevaCliente);
			}
			
	// ELIMINAR CLIENTE
	@PostMapping
	@RequestMapping(value = "deleteCliente/{clienteId}",method = RequestMethod.DELETE)
	public ResponseEntity<Cliente> crearCliente(@PathVariable("clienteId") Long clienteId){
		clienteRepositorio.deleteById(clienteId);
		return ResponseEntity.ok(null);
	}
	
	// ACTUALIZAR CLIENTE
			@PutMapping
			@RequestMapping(value = "editCliente",method = RequestMethod.PUT)
			public ResponseEntity<Cliente> actualizarCliente(@RequestBody Cliente cliente){
				
				Optional<Cliente> optionalCliente = clienteRepositorio.findById(cliente.getIdcliente());
				
				if(optionalCliente.isPresent()) {
					Cliente actualizarCliente = optionalCliente.get();
					actualizarCliente.setNombres(cliente.getNombres());
					actualizarCliente.setApellidos(cliente.getApellidos());
					actualizarCliente.setDireccion(cliente.getDireccion());
					actualizarCliente.setTelefono(cliente.getTelefono());
					actualizarCliente.setDni(cliente.getDni());
					
					clienteRepositorio.save(actualizarCliente);
					return ResponseEntity.ok(actualizarCliente);
				}else {
					return ResponseEntity.noContent().build();
				}
			}
			
	/* --------------------------------------------------------------------- */
	
			// LISTAR EMPLEADO
						@RequestMapping(value = "listarEmpleado",method = RequestMethod.GET)
						public ResponseEntity<List<Empleado>> getEmpleado(){
							
							List<Empleado> emp = empleadoRepositorio.findAll();
							return ResponseEntity.ok(emp);
						}
						
				// LISTAR EMPLEADO POR ID
				@RequestMapping(value = "listarEmpleado/{empleadoId}",method = RequestMethod.GET)
				public ResponseEntity<Empleado> getEmpleadoById(@PathVariable("empleadoId") Long empleadoId){
							
					Optional<Empleado> optionalEmpleado = empleadoRepositorio.findById(empleadoId);
							
					if(optionalEmpleado.isPresent()) {
						return ResponseEntity.ok(optionalEmpleado.get());
					}else {
						return ResponseEntity.noContent().build();
					}

				}
				
				// GUARDAR EMPLEADO
						@PostMapping
						@RequestMapping(value = "saveEmpleado",method = RequestMethod.POST)
						public ResponseEntity<Empleado> crearEmpleado(@RequestBody Empleado empleado){
							Empleado nuevaEmpleado = empleadoRepositorio.save(empleado);
							return ResponseEntity.ok(nuevaEmpleado);
						}
						
				// ELIMINAR EMPLEADO
				@PostMapping
				@RequestMapping(value = "deleteEmpleado/{empleadoId}",method = RequestMethod.DELETE)
				public ResponseEntity<Empleado> crearEmpleado(@PathVariable("empleadoId") Long empleadoId){
					empleadoRepositorio.deleteById(empleadoId);
					return ResponseEntity.ok(null);
				}
				
				// ACTUALIZAR EMPLEADO
						@PutMapping
						@RequestMapping(value = "editEmpleado",method = RequestMethod.PUT)
						public ResponseEntity<Empleado> actualizarEmpleado(@RequestBody Empleado empleado){
							
							Optional<Empleado> optionalEmpleado = empleadoRepositorio.findById(empleado.getIdempleado());
							
							if(optionalEmpleado.isPresent()) {
								Empleado actualizarEmpleado = optionalEmpleado.get();
								actualizarEmpleado.setNombres(empleado.getNombres());
								actualizarEmpleado.setApellidos(empleado.getApellidos());
								actualizarEmpleado.setDireccion(empleado.getDireccion());
								actualizarEmpleado.setTelefono(empleado.getTelefono());
								actualizarEmpleado.setDni(empleado.getDni());
								
								empleadoRepositorio.save(actualizarEmpleado);
								return ResponseEntity.ok(actualizarEmpleado);
							}else {
								return ResponseEntity.noContent().build();
							}											
						}
						/* ------------------------------------------------------------------------- */
						
						// LISTAR DOCVENTA
						@RequestMapping(value = "listarDocventa",method = RequestMethod.GET)
					    public ResponseEntity<List<Docventa>> getDocventa(){
									
							List<Docventa> dv = docventaRepositorio.findAll();
							return ResponseEntity.ok(dv);
						}
						
						// LISTAR DOCVENTA POR ID
						@RequestMapping(value = "listarDocventa/{docventaId}",method = RequestMethod.GET)
						public ResponseEntity<Docventa> getDocventaById(@PathVariable("docventaId") Long docventaId){
									
							Optional<Docventa> optionalDocventa = docventaRepositorio.findById(docventaId);
									
							if(optionalDocventa.isPresent()) {
								return ResponseEntity.ok(optionalDocventa.get());
							}else {
								return ResponseEntity.noContent().build();
							}

						}
						
				// GUARDAR DOCVENTA
				@PostMapping
				@RequestMapping(value = "saveDocventa",method = RequestMethod.POST)
				public ResponseEntity<Docventa> crearDocventa(@RequestBody Docventa docventa){
					Docventa nuevaDocventa = docventaRepositorio.save(docventa);
					return ResponseEntity.ok(nuevaDocventa);
				}
						
				// ELIMINAR DOCVENTA
				@PostMapping
				@RequestMapping(value = "deleteDocventa/{docventaId}",method = RequestMethod.DELETE)
				public ResponseEntity<Docventa> crearDocventa(@PathVariable("docventaId") Long docventaId){
					docventaRepositorio.deleteById(docventaId);
					return ResponseEntity.ok(null);
				}
}
