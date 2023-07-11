package Zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;

/**
 * @Author: li wei kai
 * @Date: 2023/06/30/14:52
 * @Description:
 */
public class CuratorDemo {

    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework= CuratorFrameworkFactory.
                builder().connectString("127.0.0.1:2181").
                sessionTimeoutMs(4000).retryPolicy(new
                ExponentialBackoffRetry(1000,3)).
                namespace("").build();
        curatorFramework.start();
        Stat stat=new Stat();
        //查询节点数据
        byte[] bytes = curatorFramework.getData().storingStatIn(stat).forPath("/kai");
        System.out.println(new String(bytes));
        curatorFramework.close();
    }
}
