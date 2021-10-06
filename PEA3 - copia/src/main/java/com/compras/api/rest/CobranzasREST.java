package com.compras.api.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.compras.api.repositorio.PagoRepositorio;
import com.compras.api.entidad.Pago;
import com.compras.api.repositorio.DeudaRepositorio;
import com.compras.api.entidad.Deuda;

@RestController
@RequestMapping("/cobranzas")
public class CobranzasREST {

	@Autowired
	private PagoRepositorio pagoRepositorio;
	
	@Autowired
	private DeudaRepositorio deudaRepositorio;
	
	// LISTAR DEUDA
		@RequestMapping(value = "listarDeuda",method = RequestMethod.GET)
		public ResponseEntity<List<Deuda>> getDeuda(){
			
			List<Deuda> deu = deudaRepositorio.findAll();
			return ResponseEntity.ok(deu);
		}
		
		// LISTAR DEUDA POR ID
		@RequestMapping(value = "listarDeuda/{deudaId}",method = RequestMethod.GET)
		public ResponseEntity<Deuda> getDeudaById(@PathVariable("deudaId") Long deudaId){
			
			Optional<Deuda> optionalDeuda = deudaRepositorio.findById(deudaId);
			
			if(optionalDeuda.isPresent()) {
				return ResponseEntity.ok(optionalDeuda.get());
			}else {
				return ResponseEntity.noContent().build();
			}

		}
		
		// GUARDAR DEUDA
		@PostMapping
		@RequestMapping(value = "saveDeuda",method = RequestMethod.POST)
		public ResponseEntity<Deuda> crearDeuda(@RequestBody Deuda deuda){
			Deuda nuevaDeuda = deudaRepositorio.save(deuda);
			return ResponseEntity.ok(nuevaDeuda);
		}
		
		// ELIMINAR DEUDA
		@PostMapping
		@RequestMapping(value = "deleteDeuda/{deudaId}",method = RequestMethod.DELETE)
		public ResponseEntity<Deuda> crearDeuda(@PathVariable("deudaId") Long deudaId){
			deudaRepositorio.deleteById(deudaId);
			return ResponseEntity.ok(null);
		}
		
	/* ------------------------------------------------------------------------ */
		
		// LISTAR PAGO
				@RequestMapping(value = "listarPago",method = RequestMethod.GET)
				public ResponseEntity<List<Pago>> getPago(){
					
					List<Pago> pa = pagoRepositorio.findAll();
					return ResponseEntity.ok(pa);
				}
		
				// LISTAR PAGO POR ID
				@RequestMapping(value = "listarPago/{pagoId}",method = RequestMethod.GET)
				public ResponseEntity<Pago> getPagoById(@PathVariable("pagoId") Long pagoId){
					
					Optional<Pago> optionalPago = pagoRepositorio.findById(pagoId);
					
					if(optionalPago.isPresent()) {
						return ResponseEntity.ok(optionalPago.get());
					}else {
						return ResponseEntity.noContent().build();
					}

				}
				
				// GUARDAR PAGO
				@PostMapping
				@RequestMapping(value = "savePago",method = RequestMethod.POST)
				public ResponseEntity<Pago> crearPago(@RequestBody Pago pago){
					Pago nuevaPago = pagoRepositorio.save(pago);
					return ResponseEntity.ok(nuevaPago);
				}
				
				// ELIMINAR PAGO
				@PostMapping
				@RequestMapping(value = "deletePago/{pagoId}",method = RequestMethod.DELETE)
				public ResponseEntity<Pago> crearPago(@PathVariable("pagoId") Long pagoId){
					pagoRepositorio.deleteById(pagoId);
					return ResponseEntity.ok(null);
				}			
}
