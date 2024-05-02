package chat;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* ConcurrentHashMap
 * 멀티 스레드 환경에서 사용
 * 여러 스레드가 안전하게 ConcurrentHashMap에 동시 접근 가능
 * 내부적으로 세분화된 잠금(locking) 메커니즘을 사용하여 스레드 간의 충돌을 방지
 */

public class WriterPool {
	/* 싱글톤 구현 */
	private static final Map<String, Writer> writerMap = new ConcurrentHashMap<>();

    public static void addWriter(String nickName, Writer writer) {
        writerMap.put(nickName, writer);
    }

    public static Writer getWriter(String nickName) {
        return writerMap.get(nickName);
    }

    public static void removeWriter(String nickName) {
        writerMap.remove(nickName);
    }
}
