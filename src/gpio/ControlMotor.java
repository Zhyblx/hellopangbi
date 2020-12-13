package gpio;

public class ControlMotor {
    public static void getControlMotor() throws Exception {
        StepperMotor stepperMotor = new StepperMotor();
        int i = 180;// 相当于旋转一圈
        while (i >= 0) {
            stepperMotor.getOpenGPIO();//启动：低电平
            Thread.sleep(500);
            if (i == 0) {
                break;

            }
            stepperMotor.getShutDownGPIO();//关闭：高电平
            i--;

        }
    }
}
