import Admin.ListTable;
import Client.GetData;
import Config.HBaseConfig;
import Config.HBaseConnection;
import org.apache.hadoop.hbase.client.Connection;

import java.util.HashMap;

public class Main {


    public static void main(String... args){
        System.out.println("Tested. HBase Java Util");

        String tableName = "test";
        String rowKey = "row1";

        Main testMain = new Main();

        //create HBase config
        HBaseConfig hbaseConfig = new HBaseConfig(testMain.getConfig());

        //create connection
//        HBaseConnection hBaseConnection = testMain.CreateConnection(testMain.getConfig());
        HBaseConnection hBaseConnection = testMain.CreateConnection(hbaseConfig);

        testMain.listAllTablesMain(hBaseConnection);

        //scan
        testMain.scanTable(hBaseConnection, tableName);

        //get by row
        testMain.getByRowKey(hBaseConnection, tableName, rowKey);

        //close connection
        testMain.cloeConnection(hBaseConnection);
    }

    public Main(){
    }


    public HashMap<String, String> getConfig(){
        //Create config
        HashMap<String, String> localHbaseConfig = new HashMap<String, String>();
        localHbaseConfig.put("hbase.zookeeper.quorum","");
        localHbaseConfig.put("hbase.zookeeper.property.clientPort","2181");
        localHbaseConfig.put("hbase.master","");
        return localHbaseConfig;
    }

    public HBaseConnection CreateConnection(HashMap<String, String> config){

        // create config
        HBaseConfig hbaseConfig = new HBaseConfig();
        hbaseConfig.setHBaseConfiguration(config);

        //create connection
        HBaseConnection hBaseConnection = new HBaseConnection(hbaseConfig);
        hBaseConnection.createHBaseConnection();
//        hBaseConnection.createHBaseConnection(config);
        return  hBaseConnection;
    }

    public HBaseConnection CreateConnection(HBaseConfig hbaseConfig){

        //create connection
        HBaseConnection hBaseConnection = new HBaseConnection(hbaseConfig);
        hBaseConnection.createHBaseConnection();

        return  hBaseConnection;
    }


    public void cloeConnection(HBaseConnection hBaseConnection){
        hBaseConnection.closeConnection();
    }

    public void listAllTablesMain(HBaseConnection hbaseConnection){

        // List all tables
        ListTable listAllTables = new ListTable(hbaseConnection);
        listAllTables.printAllTables();
    }

    public void scanTable(HBaseConnection hBaseConnection, String tableName){
        GetData getData = new GetData(hBaseConnection);

        getData.getData(tableName);

    }

    public void getByRowKey(HBaseConnection hBaseConnection, String tableName, String rowKey){
        GetData getDataByRowKey = new GetData(hBaseConnection);
        getDataByRowKey.getData(tableName, rowKey);
    }

}
