package so;

public class Execute {
        public static void main(String[] args) {
                System.out.println("********** PROCESSO P1 **********");
                Process p1 = SystemOperation.systemCall(SystemCallType.CREATE_PROCESS, 130, ProcessPriority.LOW);
                SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p1);
                System.out.println();
                System.out.println("********** PROCESSO P2 **********");
                Process p2 = SystemOperation.systemCall(SystemCallType.CREATE_PROCESS, 90, ProcessPriority.MEDIUM);
                SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p2);
                System.out.println();
                System.out.println("********** PROCESSO P3 **********");
                Process p3 = SystemOperation.systemCall(SystemCallType.CREATE_PROCESS, 30, ProcessPriority.MAX);
                SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p3);
        }
}
