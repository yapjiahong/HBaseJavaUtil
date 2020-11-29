package Admin;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.*;

import java.io.IOException;

public class ShutDown
{
    private static Configuration configuration;
    private static Connection connection;
    private static Admin admin;

//    public static void main(String[] args) throws IOException
//    {
//        System.out.println("Tested.");
//        configuration = HBaseConfiguration.create();
//        configuration.set("hbase.zookeeper.quorum","");
//        configuration.set("hbase.zookeeper.property.clientPort","2181");
//        configuration.set("hbase.master", "");
//
//        connection = ConnectionFactory.createConnection(configuration);
//        admin = connection.getAdmin();
//
//        // Shutting down HBase
//        System.out.println("Shutting down hbase");
//        admin.shutdown();
//        connection.close();
//    }

}
