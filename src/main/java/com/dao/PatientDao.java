package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.entity.Patient;

public class PatientDao {

    private Connection conn;

    public PatientDao(Connection conn) {
        this.conn = conn;
    }

    public boolean register(Patient patient) {
        String sql = "INSERT INTO patient_dtls(patient_name, patient_age, address, email, password) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, patient.getFullName());
            ps.setString(2, patient.getAge());
            ps.setString(3, patient.getAddress());
            ps.setString(4, patient.getEmail());
            ps.setString(5, patient.getPassword());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Patient login(String email, String password) {
        String sql = "SELECT * FROM patient_dtls WHERE email=? AND password=?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Patient patient = new Patient();
                patient.setPatientId(rs.getInt("patient_id"));
                patient.setFullName(rs.getString("patient_name"));
                patient.setAge(rs.getString("patient_age"));
                patient.setAddress(rs.getString("address"));
                patient.setEmail(rs.getString("email"));
                patient.setPassword(rs.getString("password"));
                return patient;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    
    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM patient_dtls";
        
        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Patient patient = new Patient();
                patient.setPatientId(rs.getInt("patient_id"));
                patient.setFullName(rs.getString("patient_name"));
                patient.setAge(rs.getString("patient_age"));
                patient.setAddress(rs.getString("address"));
                patient.setEmail(rs.getString("email"));
                patient.setPassword(rs.getString("password"));
                patients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patients;
    }
    
    public boolean deletePatient(int patientId) {
        String sql = "DELETE FROM patient_dtls WHERE patient_id=?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, patientId);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Additional methods like checkOldPassword, changePassword, etc., can be added as needed.
}
