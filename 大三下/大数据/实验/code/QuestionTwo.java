/**
 * Created by Ruanrc on 16/5/4.
 */
/**
 * Created by Ruanrc on 16/5/3.
 * 1.	编程实现以下指定功能，并用Hadoop提供的HBase Shell命令完成相同任务：
 *（1）	列出HBase所有的表的相关信息，例如表名、创建时间等；
 *（2）	在终端打印出指定的表的所有记录数据；
 *（3）	向已经创建好的表添加和删除指定的列族或列；
 *（4）	清空指定的表的所有记录数据；
 *（5）	统计表的行数。
 */

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;


import java.io.IOException;

public class QuestionTwo {
    public static Configuration configuration;
    public static Connection connection;
    public static Admin admin;

    public static void main(String[] args)throws IOException{
        scanColumn("s1","score");
    }
    //建立连接
    public static void init(){
        configuration  = HBaseConfiguration.create();
        configuration.set("hbase.rootdir","hdfs://localhost:9000/hbase");
        try{
            connection = ConnectionFactory.createConnection(configuration);
            admin = connection.getAdmin();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //关闭连接
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
    /*createTable(String tableName, String[] fields)
	创建表，参数tableName为表的名称，字符串数组fields为存储记录各个域名称的数组。
	要求当HBase已经存在名为tableName的表的时候，先删除原有的表，然后再创建新的表。
    */
    public static void createTable(String tableName,String[] fields) throws IOException {

        init();
        TableName tablename = TableName.valueOf(tableName);

        if(admin.tableExists(tablename)){
            System.out.println("table is exists!");
            admin.disableTable(tablename);
            admin.deleteTable(tablename);//删除原来的表
        }
        HTableDescriptor hTableDescriptor = new HTableDescriptor(tablename);
        for(String str:fields){
            HColumnDescriptor hColumnDescriptor = new HColumnDescriptor(str);
            hTableDescriptor.addFamily(hColumnDescriptor);
        }
        admin.createTable(hTableDescriptor);
        close();
    }
    /*addRecord(String tableName, String row, String[] fields, String[] values)
	向表tableName、行row（用S_Name表示）和字符串数组files指定的单元格中添加对应的数据values。
	其中fields中每个元素如果对应的列族下还有相应的列限定符的话，用“columnFamily:column”表示。
	例如，同时向“Math”、“Computer Science”、“English”三列添加成绩时，字符串数组
	fields为{“Score:Math”,”Score:Computer Science”,”Score:English”}，数组values存储这三门课的成绩。
    */
    public static void addRecord(String tableName,String row,String[] fields,String[] values) throws IOException {
        init();
        Table table = connection.getTable(TableName.valueOf(tableName));
        for(int i = 0;i != fields.length;i++){
            Put put = new Put(row.getBytes());
            String[] cols = fields[i].split(":");
            put.addColumn(cols[0].getBytes(), cols[1].getBytes(), values[i].getBytes());
            table.put(put);
        }
        table.close();
        close();
    }
    /*（3）scanColumn(String tableName, String column)
	浏览表tableName某一列的数据，如果某一行记录中该列数据不存在，则返回null。
	要求当参数column为某一列族名称时，如果底下有若干个列限定符，则要列出每个列限定符代表的列的数据；
	当参数column为某一列具体名称（例如“Score:Math”）时，只需要列出该列的数据。
    */
    public static void scanColumn(String tableName,String column)throws  IOException{
        init();
        Table table = connection.getTable(TableName.valueOf(tableName));
        Scan scan = new Scan();
        scan.addFamily(Bytes.toBytes(column));
        ResultScanner scanner = table.getScanner(scan);
        for (Result result = scanner.next(); result != null; result = scanner.next()){
            showCell(result);
        }
        table.close();
        close();
    }
    //格式化输出
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
    /*modifyData(String tableName, String row, String column)
	修改表tableName，行row（可以用学生姓名S_Name表示），列column指定的单元格的数据。*/
    public static void modifyData(String tableName,String row,String column,String val)throws IOException{
        init();
        Table table = connection.getTable(TableName.valueOf(tableName));
        Put put = new Put(row.getBytes());
        put.addColumn(column.getBytes(),null,val.getBytes());
        table.put(put);
        table.close();
        close();
    }
    /*（5）deleteRow(String tableName, String row)
	删除表tableName中row指定的行的记录。*/
    public static void deleteRow(String tableName,String row)throws IOException{
        init();
        Table table = connection.getTable(TableName.valueOf(tableName));
        Delete delete = new Delete(row.getBytes());
        //删除指定列族
        //delete.addFamily(Bytes.toBytes(colFamily));
        //删除指定列
        //delete.addColumn(Bytes.toBytes(colFamily),Bytes.toBytes(col));
        table.delete(delete);
        table.close();
        close();
    }
}

