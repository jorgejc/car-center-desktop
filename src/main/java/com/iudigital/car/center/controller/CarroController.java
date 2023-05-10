package com.iudigital.car.center.controller;

import com.iudigital.car.center.data.CarroDao;
import com.iudigital.car.center.domain.Carro;
import java.sql.SQLException;
import java.util.List;

public class CarroController {
    
    private CarroDao carroDao;

    public CarroController() {
        
        carroDao = new CarroDao(); 
    }
    
    public List<Carro> obtenerCarros() throws SQLException {
        return carroDao.obtenerCarros();
    }
    
    public void crear(Carro carro) throws SQLException {
        carroDao.crear(carro);
    }
    
    public Carro obtenerCarro(int id) throws SQLException {
        return carroDao.obtenerCarro(id);
    }
    
    public void actualizarCarro(int id, Carro carro) throws SQLException {
        carroDao.actualizarCarro(id, carro);
    }
    
    public void eliminarCarro(int id) throws SQLException {
        carroDao.eliminarCarro(id);
    }
    
}
