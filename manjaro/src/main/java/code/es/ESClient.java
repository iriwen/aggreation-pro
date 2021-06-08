package code.es;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;

public class ESClient {

    private static  final String CLUSTER_NAME = "cluster.name";

    public static void main(String[] args) throws Exception {

        Settings setting = Settings.builder().put(ESClient.CLUSTER_NAME,"arch-elasticsearch").build();

        TransportClient  client = new  PreBuiltTransportClient(setting)
        //这里的端口号是9300，9200是暴露提供的http操作的端口号，集群及jar的通信是通过9300的
               .addTransportAddress(new TransportAddress(InetAddress.getByName("172.20.10.4"), 9300));

        GetResponse response = client.prepareGet("my_index", "article", "1").execute().actionGet();

        String sourceAsString = response.getSourceAsString();
        System.out.println(sourceAsString);

        Thread.sleep(10000);
        client.close();
    }


}
