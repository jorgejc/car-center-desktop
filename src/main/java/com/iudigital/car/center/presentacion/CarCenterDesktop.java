package com.iudigital.car.center.presentacion;

import com.iudigital.car.center.controller.CarroController;
import com.iudigital.car.center.domain.Carro;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CarCenterDesktop {

    public static void crear(CarroController carroController) {

        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Digite la marca: ");
            String marca = sc.nextLine();
            System.out.println("Marca es:" + marca);
            System.out.println("---------------------");

            System.out.println("Digite el modelo del vehiculo: ");
            String modelo = sc.nextLine();
            System.out.println("El modelo es: " + modelo);
            System.out.println("---------------------");

            System.out.println("Digite el año del vehiculo: ");
            String anho = sc.nextLine();
            System.out.println("El Año es: " + anho);
            System.out.println("---------------------");

            System.out.println("Digite el color del vehiculo: ");
            String color = sc.nextLine();
            System.out.println("El color del vehiculo es: " + color);
            System.out.println("---------------------");

            System.out.println("Digite el tipo Transmision del vehiculo: ");
            String transmision = sc.nextLine();
            System.out.println("El tipo de transmision es: " + transmision);
            System.out.println("---------------------");

            Carro carro = new Carro();
            carro.setMarca(marca);
            carro.setModelo(modelo);
            carro.setAnho(anho);
            carro.setColor(color);
            carro.setTransmision(transmision);
            carroController.crear(carro);
            System.out.println("Carro creado con exito");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void obtenerCarros(CarroController carroController) {
        try {
            List<Carro> carros = carroController.obtenerCarros();
            if(carros.isEmpty()){
                System.out.println("No hay carros");
            } else {
                carros.forEach( carro -> {
                    System.out.println("id: " +carro.getId());
                    System.out.println("Marca: " + carro.getMarca());
                    System.out.println("Modelo: " + carro.getModelo());
                    System.out.println("Anho: " + carro.getAnho());
                    System.out.println("Color: " + carro.getColor());
                    System.out.println("Transmision: " + carro.getTransmision());
                    System.out.println("---------------------------------");
                    System.out.println("---------------------------------");
                    System.out.println("---------------------------------");
                });
            }
            
        } catch (SQLException ex) {
           ex.printStackTrace();
        }  
    }
    
    public static void eliminar(CarroController carroController) {
        try {
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Digite el ID del carro a eliminar: " );
            int id = sc.nextInt();
            System.out.println("El ID del carro a eliminar es: " + id);
            Carro carroExiste = carroController.obtenerCarro(id);
            if (carroExiste == null) {
                System.out.println("No existe carro"); 
                return;
            }
            
            carroController.eliminarCarro(id);
            System.out.println("Carro eliminado con exito");
            obtenerCarros(carroController);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    } 

    public static void main(String[] args) { 
        
       // CarroController carroController = new CarroController();
       // crear(carroController);
       // obtenerCarros(carroController);
        
        var opcion = -1;
        var scanner = new Scanner(System.in);
        CarroController carroController = new CarroController();
        while(opcion != 0) {
            System.out.println("--------------------------");
            System.out.println("--------------------------");
            System.out.println("ELIJA UNA OPCION ");
            System.out.println("--------------------------");
            System.out.println("--------------------------");
            
            System.out.println("1. Listar Carros ");
            System.out.println("2. Crear Carro ");
            System.out.println("3. Eliminar Carro ");
            
            System.out.println("--------------------------");
            System.out.println("--------------------------");
            
            opcion = Integer.parseInt(scanner.nextLine());
            switch(opcion) {
                case 0:
                    System.out.println("Ha salido de la aplicacion ");
                    break;
                
                case 1:
                    obtenerCarros(carroController);
                    break;
                
                case 2:
                    crear(carroController);
                    break;
                
                case 3: 
                    eliminar(carroController);
                    break;
                default:
                    System.out.println("Opcion invalidad ");
            }
        }
    }
}
