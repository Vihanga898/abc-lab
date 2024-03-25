package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConnect;
import com.entity.Appointment;
import com.entity.Technician;

public class AppointmentDAO {

    private Connection conn;

    public AppointmentDAO(Connection conn) {
    	super();
        this.conn = conn;
    }

    public boolean addAppointment(Appointment ap) {
        boolean success = false;
        String sql = "INSERT INTO appointment (patient_id, fullname, gender, age, appoint_date, email, phno, test_id, test_name, address,technician_id,status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, ap.getPatientId());
            ps.setString(2, ap.getFullname());
            ps.setString(3, ap.getGender());
            ps.setString(4, ap.getAge());
            ps.setString(5, ap.getAppointDate());
            ps.setString(6, ap.getEmail());
            ps.setString(7, ap.getPhNo());
            ps.setInt(8, ap.getTestId());
            ps.setString(9, ap.getTestName());
            ps.setString(10, ap.getAddress());
            ps.setInt(11, ap.getTechnicianId());
            ps.setString(12, ap.getStatus());
           
            int rowsAffected = ps.executeUpdate();
            success = (rowsAffected == 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }


    public List<Appointment> getAllAppointmentByLoginPatient(int patientId) {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointment WHERE patient_id = ?";

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, patientId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Appointment appointment = extractAppointmentFromResultSet(resultSet);
                appointments.add(appointment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appointments;
    }

    public List<Appointment> getAllAppointmentByTechnicianLogin(int technicianId) {
		List<Appointment> list = new ArrayList<Appointment>();
		Appointment ap = null;

		try {

			String sql = "select * from appointment where technician_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, technicianId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setPatientId(rs.getInt(2));
				ap.setFullname(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));
				ap.setAppointDate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhNo(rs.getString(8));
				ap.setTestName(rs.getString(9));
				ap.setTechnicianId(rs.getInt(10));
				ap.setAddress(rs.getString(11));
				ap.setStatus(rs.getString(12));
				list.add(ap);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

    public Appointment getAppointmentById(int id) {
        Appointment appointment = null;
        String sql = "SELECT * FROM appointment WHERE id = ?";

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                appointment = extractAppointmentFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appointment;
    }

    public boolean setAppointmentStatus(int id, String status) {
        String sql = "UPDATE appointment SET status = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, id);

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Appointment extractAppointmentFromResultSet(ResultSet resultSet) throws SQLException {
        Appointment appointment = new Appointment();
        appointment.setPatientId(resultSet.getInt("patient_id"));
        appointment.setFullname(resultSet.getString("fullname"));
        appointment.setGender(resultSet.getString("gender"));
        appointment.setAge(resultSet.getString("age"));
        appointment.setAppointDate(resultSet.getString("appoint_date"));
        appointment.setEmail(resultSet.getString("email"));
        appointment.setPhNo(resultSet.getString("phno"));
        appointment.setTestId(resultSet.getInt("test_id"));
        appointment.setTestName(resultSet.getString("test_name"));
        appointment.setAddress(resultSet.getString("address"));
        appointment.setStatus(resultSet.getString("status"));
        return appointment;
    }

    public int getTechnicianIdByTestName(String testName) {
        int technicianId = 0;
        String sql = "SELECT technician_id FROM technician WHERE test_name = ?";

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, testName);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                technicianId = resultSet.getInt("technician_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return technicianId;
    }
    public boolean updateAppointmentStatus(int id, int technicianId, String time) {
        String query = "UPDATE appointment SET status = ?, time = ? WHERE id = ? AND technician_id = ?";

        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, "Completed");
            preparedStatement.setString(2, time);
            preparedStatement.setInt(3, id);
            preparedStatement.setInt(4, technicianId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}