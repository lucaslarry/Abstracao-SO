package so;

public class Execute {
        public static void main(String[] args) {
                Process p1 = SystemOperation.systemCall(SystemCallType.CREATE_PROCESS, 50);
                SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p1, null);

                Process p2 = SystemOperation.systemCall(SystemCallType.CREATE_PROCESS, 22);
                SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p2, null);

                Process p3 = SystemOperation.systemCall(SystemCallType.CREATE_PROCESS, 25);
                SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p3, null);

                Process p4 = SystemOperation.systemCall(SystemCallType.CREATE_PROCESS, 28);
                SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p4, null);

                Process p5 = SystemOperation.systemCall(SystemCallType.CREATE_PROCESS, 2);
                SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p5, null);

        }
}
