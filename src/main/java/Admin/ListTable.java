package Admin;

import Config.HBaseConnection;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;

import java.io.IOException;


public class ListTable
{
    private  Connection connection;
    private  Configuration configuration;
    private  Admin admin;

    public ListTable(){
    }

    public ListTable(Connection connection){
        this.connection = connection;
    }

    public ListTable(HBaseConnection hBaseConnection){
        this.connection = hBaseConnection.getHbaseConnection();
    }

    public void printAllTables(){

        try {
            admin = connection.getAdmin();
            HTableDescriptor[] tableDescriptor = admin.listTables();

            // printing all the table names.
            for (HTableDescriptor hTableDescriptor : tableDescriptor) {
                System.out.println(hTableDescriptor.getNameAsString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
