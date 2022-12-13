package repository;

import entity.Plane;
import util.ConnectDBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlaneRepository {

    private Connection connecttion;

    public PlaneRepository() {
        connecttion = ConnectDBUtil.openConnection();
    }

    public List<Plane> findAllPlane() {
        List<Plane> planeList = new ArrayList<>();
        String sql = "SELECT * FROM MAYBAY";
        Statement statement;
        Plane plane;
        try {
            statement = connecttion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                 plane = new Plane();
                plane.setIdPlane(resultSet.getInt(1));
                plane.setType(resultSet.getString(2));
                plane.setFlightRange(resultSet.getInt(3));
                planeList.add(plane);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planeList;
    }

    public List<Plane> findRange() {
        List<Plane> planeList = new ArrayList<>();
        String sql = "SELECT MaMB, Loai, TamBay\n" +
                "FROM MAYBAY WHERE TamBay > 1000";
        Statement statement;
        Plane plane;
        try {
            statement = connecttion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                 plane = new Plane();
                plane.setIdPlane(resultSet.getInt(1));
                plane.setType(resultSet.getString(2));
                plane.setFlightRange(resultSet.getInt(3));
                planeList.add(plane);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planeList;
    }

    public List<Plane> countBoeing() {
        List<Plane> planeList = new ArrayList<>();
        String sql = "SELECT MaMB, Loai, TamBay\n" +
                "FROM MAYBAY WHERE Loai LIKE '%Boeing%'";
        Statement statement;
        Plane plane;
        try {
            statement = connecttion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                 plane = new Plane();
                plane.setIdPlane(resultSet.getInt(1));
                plane.setType(resultSet.getString(2));
                plane.setFlightRange(resultSet.getInt(3));
                planeList.add(plane);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planeList;
    }

    public List<Plane> driverByNguyen() throws Exception {
        List<Plane> planeList = new ArrayList<>();
        String sql = "SELECT MB.MaMB\n" +
                "FROM NHANVIEN NV JOIN CHUNGNHAN CN ON NV.MaNV = CN.MaNV JOIN MAYBAY MB ON CN.MaMB = MB.MaMB\n" +
                "WHERE NV.Ten LIKE '%Nguyen%'";
        Statement statement;
        Plane plane;
        try {
            statement = connecttion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                 plane = new Plane();
                plane.setIdPlane(resultSet.getInt(1));
                planeList.add(plane);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return planeList;

    }

    public List<Plane> planeCanVN280() {
        List<Plane> planeList = new ArrayList<>();
        String sql = "SELECT MB.Loai\n" +
                "FROM CHUYENBAY CB JOIN MAYBAY MB ON CB.DoDai < MB.TamBay\n" +
                "WHERE CB.MaCB = 'VN280'";
        Statement statement;
        Plane plane;
        try {
            statement = connecttion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                 plane = new Plane();

                plane.setType(resultSet.getString(1));

                planeList.add(plane);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planeList;
    }

    public void planeHavePilot() throws SQLException {

        String sql = "SELECT MAYBAY.MaMB, MAYBAY.Loai, COUNT(CHUNGNHAN.MaNV) AS TOTAL\n" +
                "FROM MAYBAY INNER JOIN CHUNGNHAN \n" +
                "ON CHUNGNHAN.MaMB = MAYBAY.MaMB\n" +
                "GROUP BY MAYBAY.MaMB, MAYBAY.Loai";
        Statement statement;

        try {
            statement = connecttion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "   " +resultSet.getString(2));
                System.out.println(resultSet.getString(3));


            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            connecttion.close();
        }

    }
}
