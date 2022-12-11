package repository;

import entity.Employee;
import util.ConnectDBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    private Connection connection;

    public EmployeeRepository() {
        connection = ConnectDBUtil.openConnection();
    }

    public List<Employee> findAllEmployee() throws Exception {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "SELECT * FROM NHANVIEN";
        Statement statement;
        Employee employee;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                employee = new Employee();
                employee.setIdEmployee(resultSet.getString(1));
                employee.setName(resultSet.getString(2));
                employee.setSalary(resultSet.getInt(3));
                employeeList.add(employee);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            connection.close();
        }
        return employeeList;

    }

    public void insertEmployee(String id, String name, int salary) throws SQLException {
        String sql = "INSERT INTO NHANVIEN (MaNV, Ten, Luong)"
                + "VALUES ('" +id+ "', '" +name+ "', " +salary+ ")";
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connection.close();
        }

    }
    public List<Employee> findSalaryEmployee10000() throws Exception {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "SELECT MaNV, Ten, Luong\n" +
                "FROM NHANVIEN WHERE Luong < 10000";
        Statement statement;
        Employee employee;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                employee = new Employee();
                employee.setIdEmployee(resultSet.getString(1));
                employee.setName(resultSet.getString(2));
                employee.setSalary(resultSet.getInt(3));
                employeeList.add(employee);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            connection.close();
        }
        return employeeList;

    }

    public void sumSalary() throws Exception {
        String sql = "SELECT SUM(Luong)\n" +
                "FROM NHANVIEN";
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            connection.close();
        }

    }

    public List<Employee> codePilotBoeing() throws Exception {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "SELECT MaNV\n" +
                "FROM CHUNGNHAN CN JOIN MAYBAY MB ON CN.MaMB = MB.MaMB\n" +
                "WHERE MB.Loai LIKE '%Boeing%'";
        Statement statement;
        Employee employee;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                employee = new Employee();
                employee.setIdEmployee(resultSet.getString(1));
                employeeList.add(employee);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            connection.close();
        }
        return employeeList;

    }


    public List<Employee> pilot747() throws Exception {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "SELECT NV.MaNV, NV.Ten, NV.Luong\n" +
                "FROM NHANVIEN NV JOIN CHUNGNHAN CN ON NV.MaNV = CN.MaNV JOIN MAYBAY MB ON CN.MaMB = MB.MaMB\n" +
                "WHERE MB.MaMB = 747";
        Statement statement;
        Employee employee;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                employee = new Employee();
                employee.setIdEmployee(resultSet.getString(1));
                employee.setName(resultSet.getString(2));
                employee.setSalary(resultSet.getInt(3));
                employeeList.add(employee);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            connection.close();
        }
        return employeeList;

    }

    public List<Employee> pilotBoeingAndAirbus() throws Exception {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "SELECT nhanvien.MaNV FROM nhanvien WHERE nhanvien.MaNV IN\n" +
                "(SELECT DISTINCT MaNV FROM chungnhan WHERE MaMB IN\n" +
                "(SELECT MaMB FROM maybay WHERE Loai LIKE'%Airbus%'))AND nhanvien.MaNV IN\n" +
                "(SELECT DISTINCT MaNV FROM chungnhan WHERE MaMB IN(SELECT MaMB FROM maybay WHERE Loai LIKE'%Boeing%'))";
        Statement statement;
        Employee employee;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                employee = new Employee();
                employee.setIdEmployee(resultSet.getString(1));
                employeeList.add(employee);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            connection.close();
        }
        return employeeList;

    }


    public List<Employee> pilotBoeing() throws Exception {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "SELECT NV.Ten\n" +
                "FROM NHANVIEN NV JOIN CHUNGNHAN CN ON NV.MaNV = CN.MaNV JOIN MAYBAY MB ON CN.MaMB = MB.MaMB\n" +
                "WHERE MB.Loai LIKE '%Boeing%'\n" +
                "GROUP BY NV.Ten";
        Statement statement;
        Employee employee;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                employee = new Employee();
                employee.setName(resultSet.getString(1));
                employeeList.add(employee);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            connection.close();
        }
        return employeeList;

    }

    public void pilotsCanFly3TypesOfPlanes() throws SQLException {
        String sql = "SELECT MaNV FROM chungnhan\n" +
                "GROUP BY MaNV\n" +
                "HAVING COUNT(MaMB)=3";
        Statement statement;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));


            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public void pilotsCanFlyMoreThan3TypesOfPlanes() throws SQLException {
        String sql = "SELECT chungnhan.MaNV , MAX(maybay.TamBay) as MaxTamBay FROM chungnhan INNER JOIN maybay \n" +
                "ON maybay.MaMB = chungnhan.MaMB\n" +
                "GROUP BY(chungnhan.MaNV) \n" +
                "HAVING COUNT(chungnhan.MaMB) > 3";
        Statement statement;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));



            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public void pilotsAndNumberOfAircraftPiloted() throws SQLException {
        String sql = "SELECT NHANVIEN.MaNV,COUNT(CHUNGNHAN.MaMB) as total FROM NHANVIEN LEFT JOIN CHUNGNHAN \n" +
                "ON CHUNGNHAN.MaNV=NHANVIEN.MaNV\n" +
                "GROUP BY NHANVIEN.MaNV";
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

    public List<Employee> notPilot() throws Exception {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "SELECT MaNV, Ten, Luong FROM NHANVIEN WHERE NHANVIEN.MaNV NOT IN\n" +
                "(SELECT CHUNGNHAN.MaNV FROM CHUNGNHAN\n" +
                "GROUP BY CHUNGNHAN.MaNV)";
        Statement statement;
        Employee employee;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                employee = new Employee();
                employee.setIdEmployee(resultSet.getString(1));
                employee.setName(resultSet.getString(2));
                employee.setSalary(resultSet.getInt(3));
                employeeList.add(employee);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            connection.close();
        }
        return employeeList;

    }


    public void sumSalaryPilot() throws SQLException {
        String sql = "SELECT Sum (NHANVIEN.Luong) as total\n" +
                "FROM NHANVIEN INNER JOIN CHUNGNHAN ON CHUNGNHAN.MaNV = NHANVIEN.MaNV ";
        Statement statement;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public void idEmployeeMaxLuong() throws SQLException {
        String sql = "SELECT nhanvien.MaNV FROM nhanvien \n" +
                "WHERE Luong = (SELECT MAX(Luong)\n" +
                "                 FROM NHANVIEN)";
        Statement statement;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }




}
