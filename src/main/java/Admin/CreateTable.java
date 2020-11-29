package Admin;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;

public class CreateTable
{
    public static Configuration configuration;
    public static Connection connection;
    public static Admin admin;

//    public static void main(String[] args) throws IOException
//    {
//
//        configuration = HBaseConfiguration.create();
//        //configuration.setConfiguration("hbase.rootdir","hdfs://:8010/hbase");
//        configuration.set("hbase.zookeeper.quorum","");
//        configuration.set("hbase.zookeeper.property.clientPort","2181");
//        configuration.set("hbase.master", "");
//
//        connection = ConnectionFactory.createConnection(configuration);
//        admin = connection.getAdmin();
//        TableName tableName = TableName.valueOf(args[0]);
//        HTableDescriptor hTableDescriptor = new HTableDescriptor(tableName);
//        HColumnDescriptor hColumnDescriptor = new HColumnDescriptor("personal data");
//        hTableDescriptor.addFamily(hColumnDescriptor);
//        hTableDescriptor.addFamily(new HColumnDescriptor("professional data"));
//        admin.createTable(hTableDescriptor);
//        System.out.println(" Table created ");
//        connection.close();
//
//    }
}
