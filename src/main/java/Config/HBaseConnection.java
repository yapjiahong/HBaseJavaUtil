package Config;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;
import java.util.HashMap;

public class HBaseConnection {

    private Connection hbaseConnection;
    private  Configuration hbaseConfiguration;

    public HBaseConnection(){
    }

    public HBaseConnection(Configuration configuration){
        this.hbaseConfiguration = configuration;
    }

    public HBaseConnection(HBaseConfig hbaseConfiguration){
        this.hbaseConfiguration = hbaseConfiguration.getConfiguration();
    }

    public Connection getHbaseConnection() {
        return hbaseConnection;
    }

    public void setHbaseConnection(Connection hbaseConnection) {
        this.hbaseConnection = hbaseConnection;
    }

    public void createHBaseConnection(Configuration hbaseConfig){
        try {
           this.hbaseConnection = ConnectionFactory.createConnection(hbaseConfig);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createHBaseConnection(){
        try {
            this.hbaseConnection = ConnectionFactory.createConnection(hbaseConfiguration);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createHBaseConnection(HashMap<String, String> config){
        try {
            Configuration localConfig = HBaseConfiguration.create();
            config.forEach(localConfig::set);

            this.hbaseConnection = ConnectionFactory.createConnection(localConfig);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection(){
        try {
            this.hbaseConnection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }}
