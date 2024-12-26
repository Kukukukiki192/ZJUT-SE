import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;


public class hbase_insert {

	/**
	 * @param args
	 */
	  public static Configuration configuration;
     public static Connection connection;
     public static Admin admin;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 configuration  = HBaseConfiguration.create();
        configuration.set("hbase.rootdir","hdfs://localhost:9000/hbase");
        try{
            connection = ConnectionFactory.createConnection(configuration);
            admin = connection.getAdmin();
        }catch (IOException e){
            e.printStackTrace();
        }
        try {
			insertRow("student","scofield","score","English","45");
			insertRow("student","scofield","score","Math","89");
			insertRow("student","scofield","score","Computer","100");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        close();
	}
	 public static void insertRow(String tableName,String rowKey,String colFamily,
			 String col,String val) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Put put = new Put(rowKey.getBytes());
        put.addColumn(colFamily.getBytes(), col.getBytes(), val.getBytes());
        table.put(put);
        table.close();
    }
	  public static void close(){
           try{
               if(admin != null){
                   admin.close();
               }
               if(null != connection){
                   connection.close();
               }
           }catch (IOException e){
               e.printStackTrace();
           }
       }
}
