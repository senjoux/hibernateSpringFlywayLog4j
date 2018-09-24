 /***********************************************
 *                                              *
 *     Copyright (C) Azyrox Consulting          *
 *                                              *
 *             All rights reserved.             *
 *                                              *
 ***********************************************/
package db.migration;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

/**
 * <!-- Description -->
 *
 * @author  {Hamza Hedhly}
 * @createDate {2018-09-23}
 */
public class V2__Insert_User implements JdbcMigration {

	public void migrate(Connection connection) throws Exception {
		PreparedStatement statement = connection
				.prepareStatement("INSERT INTO utilisateur (id,prenom,nom) VALUES (1,'Hamza','Hedhly')");

		try {
			statement.execute();
		} finally {
			statement.close();
		}
	}

}
