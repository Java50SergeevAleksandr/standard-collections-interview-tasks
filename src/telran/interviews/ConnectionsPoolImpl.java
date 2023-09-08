package telran.interviews;

import java.util.LinkedHashMap;
import java.util.Map;

public class ConnectionsPoolImpl implements ConnectionsPool {
	private int poolLimit;

	public ConnectionsPoolImpl(int poolLimit) {
		this.poolLimit = poolLimit;
	}

	LinkedHashMap<Integer, Connection> pool = new LinkedHashMap<>(poolLimit, 0.75f, true) {
		@Override
		protected boolean removeEldestEntry(Map.Entry<Integer, Connection> entry) {
			return size() > poolLimit;		
		}
	};

	@Override
	public boolean addConnection(Connection connection) {
		return pool.putIfAbsent(connection.id, connection) == null ? true : false;
	}

	@Override
	public Connection getConnection(int id) {
		return pool.get(id);
		
	}

}