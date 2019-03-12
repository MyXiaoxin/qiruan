package AndroidDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ZipingDAO {
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	public void  zipingDAO(){
		String sql = "selct * from user";
		
	}

}
