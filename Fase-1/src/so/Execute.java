package so;

public class Execute {
    public static void main(String[] args) {

        Process p1 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS, null, 50);
        SystemOperation.SystemCall(SystemCallType.WRITE_PROCESS, p1, null);

        Process p2 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS, null, 22);
        SystemOperation.SystemCall(SystemCallType.WRITE_PROCESS, p2, null);

        Process p3 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS, null, 25);
        SystemOperation.SystemCall(SystemCallType.WRITE_PROCESS, p3, null);

        Process p4 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS, null, 28);
        SystemOperation.SystemCall(SystemCallType.WRITE_PROCESS, p4, null);

        Process p5 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS, null, 2);
        SystemOperation.SystemCall(SystemCallType.WRITE_PROCESS, p5, null);

        // Process p6 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS, null,
        // 2);
        // SystemOperation.SystemCall(SystemCallType.WRITE_PROCESS, p6, null);

        SystemOperation.SystemCall(SystemCallType.DELETE_PROCESS, p2, null);
        SystemOperation.SystemCall(SystemCallType.DELETE_PROCESS, p4, null);

        Process p7 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS, null,
                1);
        SystemOperation.SystemCall(SystemCallType.WRITE_PROCESS, p7, null);

        Process p8 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS, null,
                19);
        SystemOperation.SystemCall(SystemCallType.WRITE_PROCESS, p8, null);

        Process p9 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS, null,
                29);
        SystemOperation.SystemCall(SystemCallType.WRITE_PROCESS, p9, null);

        Process p10 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS, null,
                25);
        SystemOperation.SystemCall(SystemCallType.WRITE_PROCESS, p10, null);

        Process p11 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS, null,
                3);
        SystemOperation.SystemCall(SystemCallType.WRITE_PROCESS, p11, null);

        Process p12 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS, null,
                2);
        SystemOperation.SystemCall(SystemCallType.WRITE_PROCESS, p12, null);

        /*
         * WORST FIT TEST
         * 
         * Process p6 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS, null,
         * 1);
         * SystemOperation.SystemCall(SystemCallType.WRITE_PROCESS, p6, null);
         * 
         * Process p7 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS, null,
         * 1);
         * SystemOperation.SystemCall(SystemCallType.WRITE_PROCESS, p7, null);
         * 
         * Process p8 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS, null,
         * 18);
         * SystemOperation.SystemCall(SystemCallType.WRITE_PROCESS, p8, null);
         * 
         * Process p9 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS, null,
         * 17);
         * SystemOperation.SystemCall(SystemCallType.WRITE_PROCESS, p9, null);
         * 
         * Process p10 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS, null,
         * 5);
         * SystemOperation.SystemCall(SystemCallType.WRITE_PROCESS, p10, null);
         * 
         * Process p11 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS, null,
         * 3);
         * SystemOperation.SystemCall(SystemCallType.WRITE_PROCESS, p11, null);
         * 
         * Process p12 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS, null,
         * 2);
         * SystemOperation.SystemCall(SystemCallType.WRITE_PROCESS, p12, null);
         * 
         * Process p13 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS, null,
         * 1);
         * SystemOperation.SystemCall(SystemCallType.WRITE_PROCESS, p13, null);
         */

    }
}
