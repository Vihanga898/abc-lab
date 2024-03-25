package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Technician;

public class TechnicianDao {

    private final Connection conn;

    public TechnicianDao(Connection conn) {
        this.conn = conn;
    }

    public boolean registerTechnician(Technician technician) {
        boolean success = false;

        try {
            String sql = "INSERT INTO technician(name, mobno, email, address, test_name, password) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, technician.getName());
                ps.setString(2, technician.getMobno());
                ps.setString(3, technician.getEmail());
                ps.setString(4, technician.getAddress());
                ps.setString(5, technician.getTestName());
                ps.setString(6, technician.getPassword());

                int rowsAffected = ps.executeUpdate();
                success = rowsAffected == 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

    public Technician login(String email, String password) {
        Technician technician = null;

        try {
            String sql = "SELECT * FROM technician WHERE email=? AND password=?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, email);
                ps.setString(2, password);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        technician = extractTechnicianFromResultSet(rs);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return technician;
    }

    public List<Technician> getAllTechnicians() {
        List<Technician> technicians = new ArrayList<>();

        try {
            String sql = "SELECT * FROM technician ORDER BY technician_id DESC";
            try (PreparedStatement ps = conn.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Technician technician = extractTechnicianFromResultSet(rs);
                    technicians.add(technician);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return technicians;
    }

    public Technician getTechnicianById(int id) {
        Technician technician = null;

        try {
            String sql = "SELECT * FROM technician WHERE technician_id=?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, id);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        technician = extractTechnicianFromResultSet(rs);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return technician;
    }

    public int getTechnicianIdByTestName(String testName) {
        int technicianId = 0;
        String sql = "SELECT technician_id FROM technician WHERE test_name = ?";

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, testName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    technicianId = resultSet.getInt("technician_id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return technicianId;
    }

    public boolean updateTechnician(Technician technician) {
        boolean success = false;

        String sql = "UPDATE technician SET name=?, mobno=?, email=?, address=?, test_name=?, password=? WHERE technician_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, technician.getName());
            ps.setString(2, technician.getMobno());
            ps.setString(3, technician.getEmail());
            ps.setString(4, technician.getAddress());
            ps.setString(5, technician.getTestName());
            ps.setString(6, technician.getPassword());
            ps.setInt(7, technician.getTechnicianId());

            int rowsAffected = ps.executeUpdate();
            success = rowsAffected == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

    public boolean deleteTechnician(int id) {
        boolean success = false;

        String sql = "DELETE FROM technician WHERE technician_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();
            success = rowsAffected == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

    public int countTechnicians() {
        int count = 0;

        try {
            String sql = "SELECT COUNT(*) AS count FROM technician";
            try (PreparedStatement ps = conn.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    count = rs.getInt("count");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    private Technician extractTechnicianFromResultSet(ResultSet rs) throws SQLException {
        Technician technician = new Technician();
        technician.setTechnicianId(rs.getInt("technician_id"));
        technician.setName(rs.getString("name"));
        technician.setMobno(rs.getString("mobno"));
        technician.setEmail(rs.getString("email"));
        technician.setAddress(rs.getString("address"));
        technician.setTestName(rs.getString("test_name"));
        technician.setPassword(rs.getString("password"));
        return technician;
    }
}
