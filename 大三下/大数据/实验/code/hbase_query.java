import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;


public class hbase_query {

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
			getData("student","scofield","score","English");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         close();
	}
	  public static void getData(String tableName,String rowKey,String colFamily,
			  String col)throws  IOException{
          Table table = connection.getTable(TableName.valueOf(tableName));
          Get get = new Get(rowKey.getBytes());
          get.addColumn(colFamily.getBytes(),col.getBytes());
          Result result = table.get(get);
          showCell(result);
          table.close();
      }
	  public static void showCell(Result result){
          Cell[] cells = result.rawCells();
          for(Cell cell:cells){
              System.out.println("RowName:"+new String(CellUtil.cloneRow(cell))+" ");
              System.out.println("Timetamp:"+cell.getTimestamp()+" ");
              System.out.println("column Family:"+new String(CellUtil.cloneFamily(cell))+" ");
              System.out.println("row Name:"+new String(CellUtil.cloneQualifier(cell))+" ");
              System.out.println("value:"+new String(CellUtil.cloneValue(cell))+" ");
          }
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
