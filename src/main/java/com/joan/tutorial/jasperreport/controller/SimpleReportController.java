package com.joan.tutorial.jasperreport.controller;

import com.joan.tutorial.jasperreport.dto.SimpleDTO;
import com.joan.tutorial.jasperreport.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/reporte")
@RestController
public class SimpleReportController {

    private final ClienteService clienteService;

    @PostMapping("/simple")
    public ResponseEntity<?> generarReporteSimple(@RequestBody List<SimpleDTO> lista) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("filename", "simple-report.pdf");
        return new ResponseEntity(clienteService.generarReporte(lista), headers, HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("test");
    }
}
