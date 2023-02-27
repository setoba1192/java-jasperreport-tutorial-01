package com.joan.tutorial.jasperreport.service;

import com.joan.tutorial.jasperreport.dto.SimpleDTO;
import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;
import java.util.List;

public interface ClienteService {

    public byte[] generarReporte(List<SimpleDTO> lista);
}
