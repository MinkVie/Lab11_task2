package repository;

import entity.Flight;
import util.ConnectDBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class FlightRepository {

    private Connection connection;

    public FlightRepository() {
        connection = ConnectDBUtil.openConnection();
    }

    public List<Flight> findAllFlight() throws SQLException {
        List<Flight> flightList = new ArrayList<>();
        String sql = "SELECT * FROM CHUYENBAY";
        Statement statement;
        Flight flight;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                flight = new Flight();
                flight.setIdFlight(resultSet.getString(1));
                flight.setGoStation(resultSet.getString(2));
                flight.setArrivalStation(resultSet.getString(3));
                flight.setLenght(resultSet.getInt(4));
                flight.setDepartureTime(resultSet.getTime(5));
                flight.setArriveTime(resultSet.getTime(6));
                flight.setCost(resultSet.getInt(7));
                flightList.add(flight);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            connection.close();
        }
        return flightList;
    }

    public List<Flight> findDADFlight() throws SQLException {
        List<Flight> flightList = new ArrayList<>();
        String sql = "SELECT MaCB, GaDi, GaDen, DoDai, GioDi, GioDen, ChiPhi\n" +
                "FROM CHUYENBAY WHERE GaDen = 'DAD'";
        Statement statement;
        Flight flight;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                 flight = new Flight();
                flight.setIdFlight(resultSet.getString(1));
                flight.setGoStation(resultSet.getString(2));
                flight.setArrivalStation(resultSet.getString(3));
                flight.setLenght(resultSet.getInt(4));
                flight.setDepartureTime(resultSet.getTime(5));
                flight.setArriveTime(resultSet.getTime(6));
                flight.setCost(resultSet.getInt(7));
                flightList.add(flight);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            connection.close();
        }
        return flightList;
    }

    public List<Flight> findLenght8and10() throws SQLException {
        List<Flight> flightList = new ArrayList<>();
        String sql = "SELECT MaCB, GaDi, GaDen, DoDai, GioDi, GioDen, ChiPhi\n" +
                "FROM CHUYENBAY WHERE DoDai< 10000 AND DoDai > 8000";
        Statement statement;
        Flight flight;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                 flight = new Flight();
                flight.setIdFlight(resultSet.getString(1));
                flight.setGoStation(resultSet.getString(2));
                flight.setArrivalStation(resultSet.getString(3));
                flight.setLenght(resultSet.getInt(4));
                flight.setDepartureTime(resultSet.getTime(5));
                flight.setArriveTime(resultSet.getTime(6));
                flight.setCost(resultSet.getInt(7));
                flightList.add(flight);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            connection.close();
        }
        return flightList;
    }


    public List<Flight> findSGNandBMV() throws SQLException {
        List<Flight> flightList = new ArrayList<>();
        String sql = "SELECT MaCB, GaDi, GaDen, DoDai, GioDi, GioDen, ChiPhi\n" +
                "FROM CHUYENBAY WHERE GaDi = 'SGN' and GaDen = 'BMV'";
        Statement statement;
        Flight flight;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                 flight = new Flight();
                flight.setIdFlight(resultSet.getString(1));
                flight.setGoStation(resultSet.getString(2));
                flight.setArrivalStation(resultSet.getString(3));
                flight.setLenght(resultSet.getInt(4));
                flight.setDepartureTime(resultSet.getTime(5));
                flight.setArriveTime(resultSet.getTime(6));
                flight.setCost(resultSet.getInt(7));
                flightList.add(flight);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            connection.close();
        }
        return flightList;
    }


    public List<Flight> findSGN() throws SQLException {
        List<Flight> flightList = new ArrayList<>();
        String sql = "SELECT MaCB, GaDi, GaDen, DoDai, GioDi, GioDen, ChiPhi\n" +
                "FROM CHUYENBAY WHERE GaDi = 'SGN'";
        Statement statement;
        Flight flight;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                 flight = new Flight();
                flight.setIdFlight(resultSet.getString(1));
                flight.setGoStation(resultSet.getString(2));
                flight.setArrivalStation(resultSet.getString(3));
                flight.setLenght(resultSet.getInt(4));
                flight.setDepartureTime(resultSet.getTime(5));
                flight.setArriveTime(resultSet.getTime(6));
                flight.setCost(resultSet.getInt(7));
                flightList.add(flight);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            connection.close();
        }
        return flightList;
    }

    public List<Flight> flyByAirbusA320() throws SQLException {
        List<Flight> flightList = new ArrayList<>();
        String sql = "SELECT MaCB, GaDi, GaDen, DoDai, GioDi, GioDen, ChiPhi\n" +
                "FROM CHUYENBAY CB JOIN MAYBAY MB ON CB.DoDai < MB.TamBay\n" +
                "WHERE MB.Loai LIKE '%Airbus A320%'";
        Statement statement;
        Flight flight;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                 flight = new Flight();
                flight.setIdFlight(resultSet.getString(1));
                flight.setGoStation(resultSet.getString(2));
                flight.setArrivalStation(resultSet.getString(3));
                flight.setLenght(resultSet.getInt(4));
                flight.setDepartureTime(resultSet.getTime(5));
                flight.setArriveTime(resultSet.getTime(6));
                flight.setCost(resultSet.getInt(7));
                flightList.add(flight);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            connection.close();
        }
        return flightList;
    }



    public List<Flight> flightRoute() throws SQLException {
        List<Flight> flightList = new ArrayList<>();
        String sql = "SELECT CHUYENBAY.GaDi, CHUYENBAY.GaDen  FROM CHUYENBAY as CHUYENBAY join CHUYENBAY as CB \n" +
                "on CHUYENBAY.GaDi = CB.GaDen AND CHUYENBAY.GaDen = CB.GaDi";
        Statement statement;
        Flight flight;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                flight = new Flight();
                flight.setGoStation(resultSet.getString(1));
                flight.setArrivalStation(resultSet.getString(2));
                flightList.add(flight);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            connection.close();
        }
        return flightList;
    }

    public void numberOfFlightsFromGoStation() throws SQLException {

        String sql = "SELECT GaDi, COUNT(MaCB) as SoChuyenBay \n" +
                "FROM CHUYENBAY \n" +
                "GROUP BY GaDi";
        Statement statement;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "   " +resultSet.getString(2));



            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            connection.close();
        }

    }


    public void theCostToPayForGoStation() throws SQLException {

        String sql = "SELECT GaDi,SUM(ChiPhi) as total \n" +
                "FROM CHUYENBAY \n" +
                "GROUP BY GaDi";
        Statement statement;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "   " + resultSet.getString(2));


            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public List<Flight> flightDepartureBefore12h() throws SQLException {
        List<Flight> flightList = new ArrayList<>();
        String sql = "SELECT MaCB,GaDi, GaDen, DoDai, GioDi, GioDen, ChiPhi \n" +
                "FROM CHUYENBAY \n" +
                "WHERE GioDi<'12:00'";
        Statement statement;
        Flight flight;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                flight = new Flight();
                flight.setIdFlight(resultSet.getString(1));
                flight.setGoStation(resultSet.getString(2));
                flight.setArrivalStation(resultSet.getString(3));
                flight.setLenght(resultSet.getInt(4));
                flight.setDepartureTime(resultSet.getTime(5));
                flight.setArriveTime(resultSet.getTime(6));
                flight.setCost(resultSet.getInt(7));
                flightList.add(flight);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            connection.close();
        }
        return flightList;
    }


    public void flightDepartureBefore12hFromGoStation() throws SQLException {
        String sql = "SELECT GaDi, COUNT(MaCB) as TOTAL_CHUYENBAY\n" +
                "FROM CHUYENBAY\n" +
                "WHERE GioDi<'12:00'\n" +
                "GROUP BY GaDi";
        Statement statement;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "   " + resultSet.getString(2));


            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }


    public List<Flight> flightsCanBeFlownByBoeing() throws SQLException {
        List<Flight> flightList = new ArrayList<>();
        String sql = "SELECT MaCB,GaDi, GaDen, DoDai, GioDi, GioDen, ChiPhi \n" +
                "FROM CHUYENBAY \n" +
                "WHERE CHUYENBAY.DoDai < (SELECT MAX(MAYBAY.TamBay) \n" +
                "\tFROM MAYBAY\n" +
                "\tWHERE MAYBAY.Loai LIKE('%Boeing%'))";
        Statement statement;
        Flight flight;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                flight = new Flight();
                flight.setIdFlight(resultSet.getString(1));
                flight.setGoStation(resultSet.getString(2));
                flight.setArrivalStation(resultSet.getString(3));
                flight.setLenght(resultSet.getInt(4));
                flight.setDepartureTime(resultSet.getTime(5));
                flight.setArriveTime(resultSet.getTime(6));
                flight.setCost(resultSet.getInt(7));
                flightList.add(flight);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            connection.close();
        }
        return flightList;
    }

}
