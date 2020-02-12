package com.hospital.manage;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import com.hospital.*;

public class UserService {
	private static final Logger LOGGER = Logger.getInstance();

	private UserService() {
		throw new IllegalStateException("Utility class");
	}

	public static boolean login(Patients user) {
		try (Connection con = ConnectionUtil.getconnection();
				CallableStatement stmt = con.prepareCall("{call login_procedure(?,?,?)}")) {
			stmt.setString(1, user.getPatientName());
			stmt.setString(2, user.getPatientPassword());
			stmt.registerOutParameter(3, Types.VARCHAR);
			stmt.executeUpdate();
			String status = stmt.getString(3);
			LOGGER.info("Status = " + status);
			if (status.equals("Success")) {
				LOGGER.debug("Logged In");
				return true;
			} else {
				LOGGER.debug("Logged out");
				return false;
			}
		} catch (Exception e) {
			LOGGER.debug(e);
		}
		return false;

	}
	public static boolean login(Doctors user) {
		try (Connection con = ConnectionUtil.getconnection();
				CallableStatement stmt = con.prepareCall("{call login_procedure(?,?,?)}")) {
			stmt.setString(1, user.getDoctorName());
			stmt.setString(2, user.getDoctorPassword());
			stmt.registerOutParameter(3, Types.VARCHAR);
			stmt.executeUpdate();
			String status = stmt.getString(3);
			LOGGER.info("Status = " + status);
			if (status.equals("Success")) {
				LOGGER.debug("Logged In");
				return true;
			} else {
				LOGGER.debug("Logged out");
				return false;
			}
		} catch (Exception e) {
			LOGGER.debug(e);
		}
		return false;

	}
}
