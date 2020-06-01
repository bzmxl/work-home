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
     * /home/xxx/soft/jdk1.8.0_231/bin/java -agentlib:jdwp=transport=dt_socket,address=127.0.0.1:33439,suspend=y,server=n -javaagent:/home/xxx/.local/share/JetBrains/Toolbox/apps/IDEA-C/ch-0/192.7142.36/plugins/java/lib/rt/debugger-agent.jar -Dfile.encoding=UTF-8 -classpath /home/xxx/soft/jdk1.8.0_231/jre/lib/charsets.jar:/home/xxx/soft/jdk1.8.0_231/jre/lib/deploy.jar:/home/xxx/soft/jdk1.8.0_231/jre/lib/ext/cldrdata.jar:/home/xxx/soft/jdk1.8.0_231/jre/lib/ext/dnsns.jar:/home/xxx/soft/jdk1.8.0_231/jre/lib/ext/jaccess.jar:/home/xxx/soft/jdk1.8.0_231/jre/lib/ext/jfxrt.jar:/home/xxx/soft/jdk1.8.0_231/jre/lib/ext/localedata.jar:/home/xxx/soft/jdk1.8.0_231/jre/lib/ext/nashorn.jar:/home/xxx/soft/jdk1.8.0_231/jre/lib/ext/sunec.jar:/home/xxx/soft/jdk1.8.0_231/jre/lib/ext/sunjce_provider.jar:/home/xxx/soft/jdk1.8.0_231/jre/lib/ext/sunpkcs11.jar:/home/xxx/soft/jdk1.8.0_231/jre/lib/ext/zipfs.jar:/home/xxx/soft/jdk1.8.0_231/jre/lib/javaws.jar:/home/xxx/soft/jdk1.8.0_231/jre/lib/jce.jar:/home/xxx/soft/jdk1.8.0_231/jre/lib/jfr.jar:/home/xxx/soft/jdk1.8.0_231/jre/lib/jfxswt.jar:/home/xxx/soft/jdk1.8.0_231/jre/lib/jsse.jar:/home/xxx/soft/jdk1.8.0_231/jre/lib/management-agent.jar:/home/xxx/soft/jdk1.8.0_231/jre/lib/plugin.jar:/home/xxx/soft/jdk1.8.0_231/jre/lib/resources.jar:/home/xxx/soft/jdk1.8.0_231/jre/lib/rt.jar:/home/xxx/bzmxl/work-home/java-space/module-java-base/target/classes:/home/xxx/.local/share/JetBrains/Toolbox/apps/IDEA-C/ch-0/192.7142.36/lib/idea_rt.jar bzmxl.lang.StringBuilderTest
     * Connected to the target VM, address: '127.0.0.1:33439', transport: 'socket'
     * 0111100001
     * 1001111110
     * 1001111110
     * 0111111001
     * 1001111110
     * 0111111001
     * 0111111001
     * 1001111110
     * 0111111001
     * 1001111110
     * 0111111001
     * 1001111110
     * 0111111001
     */
}