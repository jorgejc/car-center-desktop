package com.iudigital.car.center.data;

import com.iudigital.car.center.domain.Carro;
import com.iudigital.car.center.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDao {

    private static final String GET_CARROS = "select * from carros";

    private static final String CREATE_CARROS = "insert into carros(marca, modelo, anho, color, transmision) "
            + "values(?, ?, ?, ?, ?)";

    private static final String GET_CARRO_BY_ID = "select * from carros where id = ? ";

    private static final String UPDATE_CARROS = "update carros set marca = ?,"
            + " modelo = ?, anho = ?, color = ?, transmision = ? where id = ? ";

    private static final String DELETE_CARROS = "delete from carros where id = ? ";

    public List<Carro> obtenerCarros() throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Carro> carros = new ArrayList<>();

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_CARROS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Carro carro = new Carro();
                carro.setId(resultSet.getInt("id"));
                carro.setMarca(resultSet.getString("marca"));
                carro.setModelo(resultSet.getString("modelo"));
                carro.setAnho(resultSet.getString("anho"));
                carro.setColor(resultSet.getString("color"));
                carro.setTransmision(resultSet.getString("transmision"));
                carros.add(carro);
            }
            return carros;

        } finally {

            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }
        }
    }

    public void crear(Carro carro) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(CREATE_CARROS);
            preparedStatement.setString(1, carro.getMarca());
            preparedStatement.setString(2, carro.getModelo());
            preparedStatement.setString(3, carro.getAnho());
            preparedStatement.setString(4, carro.getColor());
            preparedStatement.setString(5, carro.getTransmision());
            preparedStatement.executeUpdate();

        } finally {
            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public Carro obtenerCarro(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Carro carro = null;

        try {

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_CARRO_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                carro = new Carro();
                carro.setId(resultSet.getInt("id"));
                carro.setMarca(resultSet.getString("marca"));
                carro.setModelo(resultSet.getString("modelo"));
                carro.setAnho(resultSet.getString("anho"));
                carro.setColor(resultSet.getString("color"));
                carro.setTransmision(resultSet.getString("transmision"));

            }
            return carro;

        } finally {

            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }
        }
    }

    public void actualizarCarro(int id, Carro carro) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_CARROS);
            preparedStatement.setString(1, carro.getMarca());
            preparedStatement.setString(2, carro.getModelo());
            preparedStatement.setString(3, carro.getAnho());
            preparedStatement.setString(4, carro.getColor());
            preparedStatement.setString(5, carro.getTransmision());
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();

        } finally {
            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
    
    public void eliminarCarro(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_CARROS);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            
        } finally {
            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
}
