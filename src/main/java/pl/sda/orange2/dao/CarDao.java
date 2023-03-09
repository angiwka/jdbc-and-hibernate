package pl.sda.orange2.dao;

import pl.sda.orange2.entity.Car;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// CRUD - Create Read Update Delete
public class CarDao implements DataAccess<Car, Long> {

    private final Connection dbConnection;

    public CarDao(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public void save(Car car) {

    }

    @Override
    public List<Car> findAll() {
        // var is the same as: List<Car> result = new ArrayList<>();
        var cars = new ArrayList<Car>();

        // TODO: validate query
        String allCarsQuery = """
                SELECT ID, COLOUR, BRAND, MODEL
                FROM CARS
                """;
        try {
            Statement queryStatement = dbConnection.createStatement();
            ResultSet queryResult = queryStatement.executeQuery(allCarsQuery);

            while (queryResult.next()) {
                Long id = queryResult.getLong(1);
                String colour = queryResult.getString(2);
                String brand = queryResult.getString(3);
                String model = queryResult.getString(4);

                Car carFromDb = new Car(id, colour, brand, model);
                cars.add(carFromDb);
            }
        } catch (SQLException e) {
            System.out.println("Unexpected sql exception occurred");
            e.printStackTrace();
        }
        return cars;
    }

    @Override
    public Car findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}