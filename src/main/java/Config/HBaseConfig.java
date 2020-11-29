package Config;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;

import java.util.HashMap;

public class HBaseConfig {

    private Configuration configuration;

    public HBaseConfig(){
    this.configuration = HBaseConfiguration.create();
    }

    public HBaseConfig(HBaseConfiguration hBaseConfiguration){
        configuration = hBaseConfiguration;
    }

    public HBaseConfig(HashMap<String, String> hbaseConfig){
        Configuration hbaseConfiguration = HBaseConfiguration.create();
        hbaseConfig.forEach(hbaseConfiguration::set);

        this.configuration = hbaseConfiguration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setHBaseConfiguration(HashMap<String, String> hbaseConfig){
        Configuration hbaseConfiguration = HBaseConfiguration.create();
        hbaseConfig.forEach(hbaseConfiguration::set);

        this.configuration = hbaseConfiguration;
    }


}
