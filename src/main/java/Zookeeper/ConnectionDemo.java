package Zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @Author: li wei kai
 * @Date: 2023/06/30/10:44
 * @Description:
 */
public class ConnectionDemo {
    public static void main(String[] args) {

        try {
            final CountDownLatch countDownLatch=new CountDownLatch(1);
            ZooKeeper zooKeeper=
                    new ZooKeeper("127.0.0.1:2181",
                            4000, new Watcher() {

                        @Override
                        public void process(WatchedEvent event) {
                            if(Watcher.Event.KeeperState.SyncConnected==event.getState()){
                                //如果收到了服务端的响应事件，连接成功
                                countDownLatch.countDown();
                            }
                        }
                    });
            countDownLatch.await();
            //zooKeeper.create("/wei",new byte[5], ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
            //zooKeeper.create("/kai","0".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
            //CONNECTED
            System.out.println(zooKeeper.getState());
            System.out.println(zooKeeper.getChildren("/",true));

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}
