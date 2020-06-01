package bzmxl.lang;

public class StringBuilderTest {
    //可变长字符串，线程不安全
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("0000011111");
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                stringBuilder.reverse();
                if (!"0000011111".equals(stringBuilder.toString()) && !"1111100000".equals(stringBuilder.toString())) {
                    //会出现奇怪的数字
                    System.out.println(stringBuilder.toString());
                }
            }).start();
        }
    }
    /**
     * /home/xxx/.local/share/JetBrains/Toolbox/apps/IDEA-C/ch-0/192.7142.36/jbr/bin/java -agentlib:jdwp=transport=dt_socket,address=127.0.0.1:48045,suspend=y,server=n -javaagent:/home/xxx/.local/share/JetBrains/Toolbox/apps/IDEA-C/ch-0/192.7142.36/plugins/java/lib/rt/debugger-agent.jar -Dfile.encoding=UTF-8 -classpath /home/xxx/bzmxl/work-home/classes/production/module-java-base:/home/xxx/.local/share/JetBrains/Toolbox/apps/IDEA-C/ch-0/192.7142.36/lib/idea_rt.jar bzmxl.lang.StringBuilderTest
     * Connected to the target VM, address: '127.0.0.1:48045', transport: 'socket'
     * 0000011111
     * 1100011100
     * 0011100011
     * 0011100011
     * 1100011100
     * 1100011100
     */
}