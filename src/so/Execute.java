package so;

public class Execute {
    public static void main(String[] args) {
        Process p1 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS, null);
        SystemOperation.SystemCall(SystemCallType.WRITE_PROCESS, p1);
        Process p2 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS, null);
        SystemOperation.SystemCall(SystemCallType.WRITE_PROCESS, p2);

    }
}
