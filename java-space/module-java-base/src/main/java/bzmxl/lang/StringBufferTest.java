package bzmxl.lang;

public class StringBufferTest {
    //可变长字符串，线程安全，通过synchronized实现
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("0000011111");
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                stringBuffer.reverse();
                if (!"0000011111".equals(stringBuffer.toString()) && !"1111100000".equals(stringBuffer.toString())) {
                    //必然是0000011111或者1111100000
                    System.out.println(stringBuffer.toString());
                }
            }).start();
        }
    }
    /**
     * /home/xxx/.local/share/JetBrains/Toolbox/apps/IDEA-C/ch-0/192.7142.36/jbr/bin/java -agentlib:jdwp=transport=dt_socket,address=127.0.0.1:34093,suspend=y,server=n -javaagent:/home/xxx/.local/share/JetBrains/Toolbox/apps/IDEA-C/ch-0/192.7142.36/plugins/java/lib/rt/debugger-agent.jar -Dfile.encoding=UTF-8 -classpath /home/xxx/bzmxl/work-home/classes/production/module-java-base:/home/xxx/.local/share/JetBrains/Toolbox/apps/IDEA-C/ch-0/192.7142.36/lib/idea_rt.jar bzmxl.lang.StringBufferTest
     * Connected to the target VM, address: '127.0.0.1:34093', transport: 'socket'
     * 0000011111
     * 0000011111
     * 0000011111
     * 0000011111
     * 0000011111
     * 0000011111
     * 0000011111
     * 0000011111
     * Disconnected from the target VM, address: '127.0.0.1:34093', transport: 'socket'
     *
     * Process finished with exit code 0
     */
}