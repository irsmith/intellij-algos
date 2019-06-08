package logscan;

import org.junit.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 2019-05-23 11:05:54 [pool-2-thread-1] INFO gov.nasa.utm.uds.dmp.client.SQSExtendedDMPClient:79 Number of Message Received 1  ##after deque
 2019-05-23 11:05:54 [pool-2-thread-1] INFO gov.nasa.utm.uds.dmp.client.SQSExtendedDMPClient:99 Received Message from DMP for model uss-exchange operation POST
 2019-05-23 11:05:54 [pool-2-thread-1] INFO gov.nasa.utm.uds.dmp.client.SQSExtendedDMPClient:127 Processing model in UDS uss_exchange /rpc/submit_uss_exchange
 2019-05-23 11:05:54 [pool-2-thread-1] INFO gov.nasa.utm.uds.dmp.client.UDSDmpClient:67 Doing post request http://localhost:3001/rpc/submit_uss_exchange   ### before post
 2019-05-23 11:05:55 [pool-2-thread-1] INFO gov.nasa.utm.uds.dmp.client.SQSExtendedDMPClient:131 NUmber of records processed = ["ed1180a8-981e-4dd1-943a-964fe27c7865"]
 2019-05-23 11:05:55 [pool-2-thread-1] INFO gov.nasa.utm.uds.dmp.client.SQSExtendedDMPClient:107 Message Deleted  ### after sqs del
 */
public class GapAnalysis {
    final static SimpleDateFormat inFormat = new SimpleDateFormat("HH:mm:ss");

    static void process(String logfile) throws ParseException {

        List<String> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(logfile))) {
            list = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i=0;
        int stalled=0;
        while (i<list.size()) {
            if (list.get(i).contains("Message Deleted")) {
                String fullDate = list.get(i).substring(0,list.get(i).indexOf('['));
                String afterDelete = list.get(i).split(" ")[2];

                int N=-5;
                Assert.assertTrue(String.format("i:%d %s %n",i,list.get(i+1)),
                        list.get(i+N).contains("Number of Message Received"));
                String afterDeque = list.get(i+N).split(" ")[2];
                N=-1;
                Assert.assertTrue(list.get(i+N).contains("NUmber of records processed"));
                String afterPost = list.get(i+N).split(" ")[2];
                N=1;
                Assert.assertTrue(list.get(i+N).contains("Number of Message Received"));
                String afterNextDeque = list.get(i+N).split(" ")[2];

                long diff = inFormat.parse(afterDelete).getTime() - inFormat.parse(afterDeque).getTime();
                if (diff > 1000) {
                    stalled++;
                    long afterDeq2afterNextDeq = inFormat.parse(afterNextDeque).getTime() - inFormat.parse(afterDeque).getTime();
                    long afterDeque2afterPost =  inFormat.parse(afterPost).getTime() - inFormat.parse(afterDeque).getTime();
                    long afterPost2afterDel =  inFormat.parse(afterDelete).getTime() - inFormat.parse(afterPost).getTime();
                    long afterDel2afterNextDeque = inFormat.parse(afterNextDeque).getTime() - inFormat.parse(afterDelete).getTime();
                    System.out.printf("i:%10d " +
                                    "afterDeq2afterNextDeq:%04d afterDeque2afterPost:%04d, afterPost2afterDel:%04d afterDel2afterNextDeque:%04d  date:%s %n",
                         i,   afterDeq2afterNextDeq,   afterDeque2afterPost,    afterPost2afterDel,   afterDel2afterNextDeque, fullDate);
                }
            }
            i++;
        }
        System.out.printf("percentStalled: %f %s size:%d %n", ((float)stalled/list.size()), logfile, list.size());
    }

    public static void main (String args[]) throws IOException, ParseException {
        //process("/Users/issmith1/workspace/intellij-algos/src/main/resources/sqs.log_051522_20");
        process("src/main/resources/sqs_9001.log");
        process("src/main/resources/sqs1.log");
        process("src/main/resources/sqs2.log");
        process("src/main/resources/sqs3.log");
    }

}
