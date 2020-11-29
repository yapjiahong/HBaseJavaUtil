package Client;

import Config.HBaseConfig;
import Config.HBaseConnection;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetData {

    private Connection connection;
    private String tableName;

    public GetData() {
    }

    public GetData(HBaseConnection hBaseConnection) {
        this.connection = hBaseConnection.getHbaseConnection();
    }

    public GetData(Connection connection) {
        this.connection = connection;
    }

    public GetData(HBaseConnection hBaseConnection, String tableName) {
        this.connection = hBaseConnection.getHbaseConnection();
        this.tableName = tableName;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void getData() {

    }

    public void getData(String tableName) {
        try {
            Table table = connection.getTable(TableName.valueOf(tableName));

            Scan hbaseScan = new Scan();

            ResultScanner resultScanner = table.getScanner(hbaseScan);

            Result hbaseResult;
            while ((hbaseResult = resultScanner.next()) != null) {
                List<Cell> cells = new ArrayList<>();
                cells = hbaseResult.listCells();
                int cellCount = 0;
                for (Cell cell : cells) {
                    cellCount += 1;

                    byte[] rowByByteCopy = Bytes.copy(cell.getRowArray(), cell.getRowOffset(), cell.getRowLength());
                    byte[] columnByByteCopy = Bytes.copy(cell.getFamilyArray(), cell.getFamilyOffset(), cell.getFamilyLength());
                    byte[] qualifierByByteCopy = Bytes.copy(cell.getQualifierArray(), cell.getQualifierOffset(), cell.getQualifierLength());
                    byte[] valueByByteCopy = Bytes.copy(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength());
                    long timeStamp = cell.getTimestamp();


                    System.out.println(new String(rowByByteCopy, "utf-8") + "\tfamily=>" + new String(columnByByteCopy, "utf-8")
                            + "  qualifer=>" + new String(qualifierByByteCopy, "utf-8")
                            + "  timestamp=>" + timeStamp
                            + "  value=>" + new String(valueByByteCopy, "utf-8"));

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getData(String tableName, String rowKey) {
        try {
            TableName hbaseTableName = TableName.valueOf(tableName);

            Table table = connection.getTable(hbaseTableName);

            Get theGet = new Get(Bytes.toBytes(rowKey));

            Result result = table.get(theGet);

            for (Cell cell : result.listCells()) {
                byte[] columnByByteCopy = Bytes.copy(cell.getFamilyArray(), cell.getFamilyOffset(), cell.getFamilyLength());
                byte[] qualifierByByteCopy = Bytes.copy(cell.getQualifierArray(), cell.getQualifierOffset(), cell.getQualifierLength());
                byte[] valueByByteCopy = Bytes.copy(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength());
                long timeStamp = cell.getTimestamp();

                System.out.println("family=>" + new String(columnByByteCopy, "utf-8")
                        + "  qualifer=>" + new String(qualifierByByteCopy, "utf-8")
                        + "  timestamp=>" + timeStamp
                        + "  value=>" + new String(valueByByteCopy, "utf-8"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
