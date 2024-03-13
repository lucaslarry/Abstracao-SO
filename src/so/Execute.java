package so;

public class Execute {
    public static void main(String[] args) {

        Process p1 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS, null, 1);
        SystemOperation.SystemCall(SystemCallType.WRITE_PROCESS, p1, null);

        Process p2 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS, null, 110);
        SystemOperation.SystemCall(SystemCallType.WRITE_PROCESS, p2, null);

        SystemOperation.SystemCall(SystemCallType.DELETE_PROCESS, p1, null);

        Process p3 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS, null, 1);
        SystemOperation.SystemCall(SystemCallType.WRITE_PROCESS, p3, null);

    }
}
