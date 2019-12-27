import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import br.com.caelum.JpaConfigurator;

public class TestaPool {

	public static void main(String[] args) throws PropertyVetoException, SQLException {

		ComboPooledDataSource dataSource = (ComboPooledDataSource) new JpaConfigurator().getDataSource();
		
		
		for (int i = 1; i < 7; i++) {
			Connection connection = dataSource.getConnection();
			
			System.out.println("Conex�es disponiveis: " + dataSource.getNumBusyConnections());
			System.out.println("Conex�es ocupadas: " + dataSource.getNumIdleConnections());
		}
	}

}
