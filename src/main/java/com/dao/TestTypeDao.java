package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.TestType;

public class TestTypeDao {

    private final Connection connection;

    public TestTypeDao(Connection connection) {
        this.connection = connection;
    }

    public boolean addTestType(TestType testType) {
        String query = "INSERT INTO test_types (test_name, test_price) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, testType.getTestName());
            preparedStatement.setDouble(2, testType.getTestPrice());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<TestType> getAllTestType() {
        List<TestType> testTypes = new ArrayList<>();
        String query = "SELECT * FROM test_types";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TestType testType = new TestType();
                testType.setId(rs.getInt("test_id"));
                testType.setTestName(rs.getString("test_name"));
                testType.setTestPrice(rs.getDouble("test_price"));
                testTypes.add(testType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return testTypes;
    }

    public TestType getTestTypeById(int testId) {
        TestType testType = null;
        String query = "SELECT * FROM test_types WHERE test_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, testId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    testType = new TestType();
                    testType.setId(resultSet.getInt("test_id"));
                    testType.setTestName(resultSet.getString("test_name"));
                    testType.setTestPrice(resultSet.getDouble("test_price"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return testType;
    }

    public boolean updateTestType(TestType testType) {
        String query = "UPDATE test_types SET test_name = ?, test_price = ? WHERE test_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, testType.getTestName());
            preparedStatement.setDouble(2, testType.getTestPrice());
            preparedStatement.setInt(3, testType.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteTestType(int testId) {
        String query = "DELETE FROM test_types WHERE test_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, testId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
